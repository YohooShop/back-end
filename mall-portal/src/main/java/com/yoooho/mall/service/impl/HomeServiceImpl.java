package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoooho.mall.domain.*;
import com.yoooho.mall.mapper.*;
import com.yoooho.mall.model.*;
import com.yoooho.mall.dao.HomeDao;
import com.yoooho.mall.dao.PmsProductCategoryDao;

import com.yoooho.mall.domain.*;
import com.yoooho.mall.service.HomeService;
import com.yoooho.mall.util.DateUtil;
import com.yoooho.mall.mapper.*;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 首页内容管理Service实现类
 * Created by yoooho on 2019/1/28.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private CmsSubjectMapper subjectMapper;
    @Autowired
    private PmsProductCategoryDao productCategoryDao;

    @Autowired
    private PmsProductSeckillMapper productSeckillMapper;

    @Autowired
    private  SmsHomeNavMapper navMapper;

    @Autowired
    SmsShopConfigMapper shopConfigMapper;

    @Autowired
    LandPagesMapper landPagesMapper;

    @Autowired
    PmsProductCombinationMapper productCombinationMapper;
    @Override
    public HomeConfigResult config() {
        SmsShopConfigExample example = new SmsShopConfigExample();
        List<SmsShopConfig> shopConfigs = shopConfigMapper.selectByExample(example);
        HomeConfigResult result = new HomeConfigResult();
        if (shopConfigs.size() == 0) {
           result.setUseLandPages(false);
        } else {
            SmsShopConfig shopConfig = shopConfigs.get(0);
            LandPages landPages = landPagesMapper.selectByPrimaryKey(shopConfig.getHomelandpageId());
            if (landPages == null) {
                result.setUseLandPages(false);
            }
            if (!landPages.getDeleteStatus() && landPages.getShowStatus()) {
                result.setUseLandPages(shopConfig.getStartUsing());
            }else {
                result.setUseLandPages(false);
            }
        }
        return result;
    }

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());

        //获取导航

        result.setNavList(getHomeNavList());
        //获取推荐类别
        result.setBrandList(productCategoryDao.selectBannerCategory());
        //获取秒杀信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取团购商品
        result.setHomeCombinations(homeDao.getCombinationProductList(0,4));
        //获取新品推荐
        result.setNewProductList(homeDao.getHomeNewProductList(0,4));
        //获取人气推荐
        result.setHotProductList(homeDao.getHomeHotProductList(0,4));
        //获取推荐专题
        result.setSubjectList(homeDao.getRecommendSubjectList(0,4));
        return result;
    }

    @Override
    public HomeNewContentResult newContent() {

        HomeNewContentResult result = new HomeNewContentResult();
        List  combinationProducts = homeDao.getCombinationProductList(0,4);
        List  newProducts =  homeDao.getHomeNewProductList(0,4);;
        List hotProducts = homeDao.getHomeHotProductList(0,4);
        List recommendSubject =  homeDao.getRecommendSubjectList(0,4);
        HomeFlashPromotion homeFlashPromotion =  getHomeFlashPromotion();
        List ads =  getHomeAdvertiseList();
        List pages = new ArrayList();

        List flashs = new ArrayList();
        flashs.add(homeFlashPromotion);
        List flashValues = new ArrayList();
        PagesCompoentValue flashValue = new PagesCompoentValue();
        flashValue.setType("micro_page_componet_seckill");
        flashValue.setName("热门秒杀");
        flashValue.setChildren(flashs);
        flashValues.add(flashValue);
        PagesCompoent flashCompoent = new PagesCompoent();
        flashCompoent.setName("micro_page_componet_seckill");
        flashCompoent.setValue(flashValues);

        //获取首页广告
        List adValues = new ArrayList();
        PagesCompoentValue adValue = new PagesCompoentValue();
        adValue.setType("micro_page_componet_slide");
        adValue.setName("广告图");
        adValue.setChildren(ads);
        adValues.add(adValue);
        PagesCompoent adCompoent = new PagesCompoent();
        adCompoent.setName("micro_page_componet_slide");
        adCompoent.setValue(adValues);


        //获取团购商品
        List combinationValues = new ArrayList();
        PagesCompoentValue combinationValue = new PagesCompoentValue();
        combinationValue.setType("micro_page_componet_goods_group");
        combinationValue.setName("热门团购");
        combinationValue.setChildren(combinationProducts);
        combinationValues.add(combinationValue);
        PagesCompoent combinationCompoent = new PagesCompoent();
        combinationCompoent.setName("micro_page_componet_goods_group");
        combinationCompoent.setValue(combinationValues);

        //获取新品推荐
        List newValues = new ArrayList();
        PagesCompoentValue newValue = new PagesCompoentValue();
        newValue.setType("micro_page_componet_goods_group");
        newValue.setName("新品推荐");
        newValue.setChildren(newProducts);
        newValues.add(newValue);
        PagesCompoent newCompoent = new PagesCompoent();
        newCompoent.setName("micro_page_componet_goods_group");
        newCompoent.setValue(newValues);
        //获取人气推荐
        List hotValues = new ArrayList();
        PagesCompoentValue hotValue = new PagesCompoentValue();
        hotValue.setType("micro_page_componet_goods_group");
        hotValue.setName("人气推荐");
        hotValue.setChildren(hotProducts);
        hotValues.add(hotValue);
        PagesCompoent hotCompoent = new PagesCompoent();
        hotCompoent.setName("micro_page_componet_goods_group");
        hotCompoent.setValue(hotValues);

        //获取专题推荐
        List subValues = new ArrayList();
        PagesCompoentValue subValue = new PagesCompoentValue();
        subValue.setType("micro_page_componet_subject");
        subValue.setName("专题推荐");
        subValue.setChildren(recommendSubject);
        subValues.add(subValue);
        PagesCompoent subCompoent = new PagesCompoent();
        subCompoent.setName("micro_page_componet_subject");
        subCompoent.setValue(subValues);

        //搜索组件
        PagesCompoent searchCompoent = new PagesCompoent();
        searchCompoent.setName("micro_page_componet_search");

        pages.add(searchCompoent);
        pages.add(adCompoent);
        pages.add(flashCompoent);
        pages.add(combinationCompoent);
        pages.add(newCompoent);
        pages.add(hotCompoent);
        pages.add(subCompoent);
        result.setPages(pages);
        return result;
    }

    @Override
    public LandPages getLandHomePages(){
        SmsShopConfigExample example = new SmsShopConfigExample();
        List<SmsShopConfig> shopConfigs = shopConfigMapper.selectByExample(example);

        if (shopConfigs.size() == 0) {
            return  null;
        }else {
            SmsShopConfig shopConfig = shopConfigs.get(0);
            LandPages landPages = landPagesMapper.selectByPrimaryKey(shopConfig.getHomelandpageId());
            if (landPages == null) {
                return  null;
            }else {
                if (!landPages.getDeleteStatus() && landPages.getShowStatus()) {
                    return landPages;
                }else {
                    return null;
                }
            }
        }
    }
    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        // TODO: 2019/1/29 暂时默认推荐所有商品
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria()
                .andDeleteStatusEqualTo(0)
                .andPublishStatusEqualTo(1);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> getProductCate() {
        return productCategoryDao.listWithChildren();
    }

    @Override
    public List<PmsProduct> getProductList(Long cateId, Integer pageSize, Integer pageNum, Integer type) {

        // type = 0 默认 type = 1 销量 type = 2 降价排序 type = 3 升价排序
        //setOrderByClause("start_time asc");
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        if (cateId == null) {
            example.createCriteria()
                    .andDeleteStatusEqualTo(0);
        }else {
            example.createCriteria()
                    .andDeleteStatusEqualTo(0)
                    .andProductCategoryIdEqualTo(cateId);
        }

        String orderStr = null;
        switch (type){
            case 0:{
                orderStr = "sort asc";
            }
            break;
            case 1:{
                orderStr = "sale desc";
            }
            break;
            case 2:{
                orderStr = "price desc";
            }
            break;
            case 3:{
                orderStr = "price asc";
            }
            break;
            default:
                break;
        }
        example.setOrderByClause(orderStr);

        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria()
                .andShowStatusEqualTo(1)
                .andParentIdEqualTo(parentId);
        example.setOrderByClause("sort desc");
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        if(cateId!=null){
            criteria.andCategoryIdEqualTo(cateId);
        }
        example.setOrderByClause("create_time desc");
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> getSubjectAllList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        example.setOrderByClause("create_time desc");
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List getHotProductList(Integer pageSize, Integer pageNum) {
        return  homeDao.getHotProductList(pageNum - 1,pageSize);
    }

    @Override
    public List getNewProductList(Integer pageSize, Integer pageNum) {
        return homeDao.getNewProductList(pageNum - 1,pageSize);
    }

    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();

        //获取当前时间秒杀的商品

          SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
//        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if ( flashPromotionSession != null) {
           List<PmsProductSeckill> productSeckills =  getProductSeckill(  flashPromotionSession.getId(), now);
            homeFlashPromotion.setProductList(productSeckills);
            homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
            homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
            //获取当前秒杀场次

//            if (flashPromotionSession != null) {
//                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
//                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
//                //获取下一个秒杀场次
//                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
//                if(nextSession!=null){
//                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
//                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
//                }
//                //获取秒杀商品
//                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
//                homeFlashPromotion.setProductList(flashProductList);
//            }
        }
        return homeFlashPromotion;
    }

    //获取下一个场次信息
    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeGreaterThan(date);
        sessionExample.setOrderByClause("start_time asc");
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    private List<SmsHomeNav> getHomeNavList() {
        SmsHomeNavExample example = new SmsHomeNavExample();
        example.createCriteria().andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return navMapper.selectByExample(example);
    }

    //根据时间获取秒杀活动
    private SmsFlashPromotion getFlashPromotion(Date date) {
        Date currDate = DateUtil.getDate(date);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(currDate)
                .andEndDateGreaterThanOrEqualTo(currDate);
        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotionList)) {
            return flashPromotionList.get(0);
        }
        return null;
    }

    //根据时间获取秒杀场次
    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeLessThanOrEqualTo(currTime)
                .andEndTimeGreaterThanOrEqualTo(currTime);
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    //根据timeId 和 时间获取秒杀商品

    public   List <PmsProductSeckill>  getProductSeckill(Long timeId, Date date) {
        PmsProductSeckillExample productSeckillExample = new PmsProductSeckillExample();
        productSeckillExample.createCriteria()
                .andStartTimeDateLessThan(date)
                .andEndTimeDateGreaterThan(date)
                .andTimeIdEqualTo(Math.toIntExact(timeId))
                .andDeleteStatusEqualTo(0)
                .andHotStatusEqualTo(1);
        List<PmsProductSeckill> pmsProductSeckills = productSeckillMapper.selectByExampleWithBLOBs(productSeckillExample);
        return pmsProductSeckills;
    }

    @Override
    public List<PmsProductCombination> getPinkProductList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCombinationExample example = new PmsProductCombinationExample();
        example.createCriteria().andDeleteStatusEqualTo(false);
        example.createCriteria().andEndTimeDateGreaterThan(new Date());
        example.createCriteria().andIsShowEqualTo(true);
        example.setOrderByClause("sort desc");
        PageInfo page = new PageInfo( productCombinationMapper.selectByExampleWithBLOBs(example));
        return page.getList();
    }
}
