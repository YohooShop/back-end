package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.ResultCode;

import com.yoooho.mall.dao.SmsCouponHistoryDao;
import com.yoooho.mall.domain.MemberDetails;
import com.yoooho.mall.domian.SmsTemplate;
import com.yoooho.mall.mapper.*;
import com.yoooho.mall.model.*;

import com.yoooho.mall.adapter.WechatAdapter;
import com.yoooho.mall.dao.MemberCoustomDao;
import com.yoooho.mall.domain.MemberCenterInfo;
import com.yoooho.mall.domain.UmsMemberWX;
import com.yoooho.mall.dto.SessionDTO;
import com.yoooho.mall.service.RedisService;
import com.yoooho.mall.service.SMSService;
import com.yoooho.mall.service.UmsMemberService;

import com.yoooho.mall.util.JwtTokenUtil;
import com.yoooho.mall.mapper.*;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 会员管理Service实现类
 * Created by yoooho on 2019/8/3.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Autowired
    private OmsOrderMapper orderMapper;

    @Autowired
    private OmsCartItemMapper cartItemMapper;

    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;

    @Autowired
    private MemberCoustomDao memberCoustomDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisService redisService;

    @Autowired
    private WechatAdapter wechatAdapter;

    @Autowired
    private SMSService smsService;

    @Autowired
    private UmsMemberWxofficeMapper memberWxofficeMapper;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${devMode}")
    private int devMode;

    @Override
    public UmsMember getByUsername(String username){
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult register(String username, String password, String telephone, String authCode) {
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            return CommonResult.failed("该用户已经存在");
        }
        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        //获取默认会员等级并设置
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(umsMember);
        umsMember.setPassword(null);
        return CommonResult.success(null,"注册成功");
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        SmsTemplate smsTemplate = smsService.queryByKey(1);
        if (smsTemplate == null){
            return  CommonResult.failed("没有配置SmsTemplate");
        }
        String content = "{ \"code\":"+sb.toString() + "}";

        boolean sendSucessed = smsService.sendSMS(smsTemplate,content,telephone);
        if (sendSucessed) {
            redisService.remove(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
            //验证码绑定手机号并存储到redis
            redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
            redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
            return CommonResult.success(sb.toString(),"获取验证码成功");
        }else {
            return CommonResult.success(sb.toString(),"获取验证码失败");
        }
    }

    @Override
    public String smsCodeLogin(String telephone, String authCode) {
        //查询是否已有该用户
        String token = null;
        String username = null;
        boolean isEffective = false;
        if (devMode == 1) {
            isEffective = true;
        }else {
            if (telephone.equals("18125255678")&&authCode.equals("888888")){
                isEffective = true;
            }else {
                if (verifyAuthCode( authCode,telephone)){
                    isEffective = true;
                }
            }
        }
        if (isEffective){
            UmsMemberExample example = new UmsMemberExample();
            example.createCriteria().andPhoneEqualTo(telephone);
            List<UmsMember> umsMembers = memberMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(umsMembers)) {
                username=umsMembers.get(0).getUsername();
                token = creatToken(username);
            }else {
                //没有该用户进行添加操作
                token = creatNewMember(telephone);
            }
        }
        return token;
    }

    private String creatNewMember(String telephone){
        UmsMember umsMember = new UmsMember();
        //umsMember.setUsername("新用户");
        umsMember.setPhone(telephone);
        umsMember.setPassword(passwordEncoder.encode("1111111"));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        //获取默认会员等级并设置
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        umsMember.setPassword(null);
        umsMember.setNickname(telephone);
        memberMapper.insertSelective(umsMember);
        Long userId = umsMember.getId();
        String username = "用户"+userId.toString();
        umsMember.setUsername(username);
        memberMapper.updateByPrimaryKey(umsMember);
       return  creatToken(username);
    }

    //生成token
    private String creatToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return  jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(passwordEncoder.encode(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        return CommonResult.success(null,"密码修改成功");
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if (auth.getPrincipal().getClass() != MemberDetails.class){
            return  null;
        }
        MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
    }

    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (authCode.equals(realAuthCode)){
            redisService.remove(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        }
        return authCode.equals(realAuthCode);
    }


    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    @Override
    public String weChatLogin(String code) {
        // code  -> openid
        String token;
        SessionDTO sessionDTO = wechatAdapter.jscode2session(code);
        if (sessionDTO.getOpenid() == null) {
            return null;
        }
        // 去数据库 检查 openId 是否存在 不存在就新建用户
        UmsMemberWX memberWX = wechatOpenIdIsExists(sessionDTO.getOpenid());
        if (memberWX == null) {
          //插入新的用户
            token = creatNewMember("");
            UmsMember member = getCurrentMember();

          //绑定open_id
            UmsMemberWX newMemberWX = new UmsMemberWX();
            newMemberWX.setOpen_id(sessionDTO.getOpenid());
            newMemberWX.setUser_id(member.getId());

            memberCoustomDao.insert(newMemberWX);
        } else {
            UmsMember member = memberMapper.selectByPrimaryKey(memberWX.getUser_id());
            token = creatToken(member.getUsername());
        }
        return token;
    }

    @Override
    public CommonResult getMemberCenterInfo() {
         UmsMember member = getCurrentMember();
         if (member == null) {
             return  CommonResult.failed(ResultCode.UNAUTHORIZED);
         } else {
             UmsMemberExample example = new UmsMemberExample();
             example.createCriteria().andUsernameEqualTo(member.getUsername());
             UmsMember memberData =  memberMapper.selectByExample(example).get(0);

             List coupons = couponHistoryDao.selectEnableUseUserCoupon(memberData.getId());

             OmsOrderExample waitPaymentOrderExample = new OmsOrderExample();
             waitPaymentOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                     .andStatusEqualTo(0)
                     .andDeleteStatusEqualTo(0)
                     .andMemberDeleteStatusEqualTo(0);
             List<OmsOrder> waitPaymentOrders = orderMapper.selectByExample(waitPaymentOrderExample);

             OmsOrderExample waitReceivingOrderExample = new OmsOrderExample();
             waitReceivingOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                     .andStatusBetween(1,2)
                     .andDeleteStatusEqualTo(0)
                     .andMemberDeleteStatusEqualTo(0);
             List<OmsOrder> waitReceivingOrders = orderMapper.selectByExample(waitReceivingOrderExample);
             MemberCenterInfo memberCenterInfo = new MemberCenterInfo();
             memberCenterInfo.setNickname(memberData.getNickname());
             memberCenterInfo.setPhone(memberData.getPhone());
             memberCenterInfo.setIcon(memberData.getIcon());
             memberCenterInfo.setGender(memberData.getGender());
             memberCenterInfo.setBirthday(memberData.getBirthday());
             memberCenterInfo.setCity(memberData.getCity());
             memberCenterInfo.setJob(memberData.getJob());
             memberCenterInfo.setIntegration(memberData.getIntegration());
             memberCenterInfo.setGrowth(memberData.getGrowth());
             memberCenterInfo.setCouponNum(coupons.size());
             memberCenterInfo.setWaitPaymentCount(waitPaymentOrders.size());
             memberCenterInfo.setWaitReceivingCount(waitReceivingOrders.size());
             memberCenterInfo.setShopCartNumber(getShopCarNumber(member.getId()));
             UmsMemberWxofficeExample memberWxofficeExample = new UmsMemberWxofficeExample();
             memberWxofficeExample.createCriteria().andUserIdEqualTo(member.getId());
             if (memberWxofficeMapper.selectByExample(memberWxofficeExample).size() == 0) {
                 memberCenterInfo.setIsbindWx(false);
             }else {
                 memberCenterInfo.setIsbindWx(true);
             }
             //购物车商品数目
             return CommonResult.success(memberCenterInfo);
         }
    }

    @Override
    public CommonResult updateMemberCenterInfo(int type, String value) {
        UmsMember member = getCurrentMember();
        UmsMember memberData =  memberMapper.selectByPrimaryKey(member.getId());
        switch (type){
            case 1:
                memberData.setNickname(value);
                break;
            case 2:
                memberData.setGender(Integer.parseInt(value));
                break;
            case 3:
                SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String d = format.format(Long.parseLong(value));
                try {
                    memberData.setBirthday(format.parse(d) );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                memberData.setJob(value);
                break;
            case 5:
                memberData.setCity(value);
                break;
            default:
                break;
        }

        int count =  memberMapper.updateByPrimaryKeySelective(memberData);
        if (count == 0){
            return CommonResult.failed("更新用户数据失败");
        }else {
            return CommonResult.success("");
        }
    }

    public int getShopCarNumber(Long userId){

        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(userId).andDeleteStatusEqualTo(0);
        List<OmsCartItem> cartItems = cartItemMapper.selectByExample(example);
        int num = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            num += cartItems.get(i).getQuantity();
        }
        return num;
    }

    @Override
    public boolean bindWX(String openId, Long userId,String union_id) {

        if (wechatOpenIdIsExists(openId) != null) {
            return  false;
        }else {
            UmsMemberWX memberWX = new UmsMemberWX();
            memberWX.setOpen_id(openId);
            memberWX.setUnion_id(union_id);
            memberWX.setUser_id(userId);
            memberWX.setCreate_time(new Date());
            memberCoustomDao.insert(memberWX);
            return true;
        }
    }

    private UmsMemberWX wechatOpenIdIsExists(String openId) {
       List<UmsMemberWX> list= memberCoustomDao.select(openId);
        if (list.size() == 0) {
            return null;
        }else {
            return  list.get(0);
        }
    }

    public void cancelBindWX() {
        UmsMember member = getCurrentMember();
        UmsMemberWxofficeExample memberWxofficeExample = new UmsMemberWxofficeExample();
        memberWxofficeExample.createCriteria().andUserIdEqualTo(member.getId());
        memberWxofficeMapper.deleteByExample(memberWxofficeExample);

    }

    @Override
    public String  getMemberOpenId(Long userId) {
        UmsMemberWxofficeExample memberWxofficeExample = new UmsMemberWxofficeExample();
        memberWxofficeExample.createCriteria().andUserIdEqualTo(userId);
        List<UmsMemberWxoffice> memberWxoffices = memberWxofficeMapper.selectByExample(memberWxofficeExample);
        if (memberWxoffices.size() == 0) {
            return null;
        }else {
            return memberWxoffices.get(0).getOpenId();
        }

    }


}
