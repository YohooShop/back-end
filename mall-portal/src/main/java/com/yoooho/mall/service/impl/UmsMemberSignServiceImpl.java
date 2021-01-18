package com.yoooho.mall.service.impl;

import com.yoooho.mall.domain.MemberSignData;
import com.yoooho.mall.mapper.UmsMemberSignContinueMapper;
import com.yoooho.mall.mapper.UmsMemberSignMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.service.UmsMemberSignService;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UmsMemberSignServiceImpl implements UmsMemberSignService {
    @Autowired
    UmsMemberSignMapper memberSignMapper;
    @Autowired
    UmsMemberService memberService;

    @Autowired
    UmsMemberSignContinueMapper memberSignContinueMapper;

    @Override
    public List<MemberSignData> getMemberSignData(String dStr) {


        String[] dates = dStr.split("-");
        List<MemberSignData> memberSignDataList = new ArrayList<>();
        int year = Integer.valueOf(dates[0]);
        int month =  Integer.valueOf(dates[1]);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        //一个月的天数
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //每一天进行循环加入
        Calendar nowCalendar =  Calendar.getInstance();
        nowCalendar.setTime(new Date());

        UmsMember member = memberService.getCurrentMember();
        for (int day = 1; day <= maxDay; day++) {
            calendar.set(Calendar.DATE, day);
            int weekDay=getWeekDay(calendar);
            String dateStr = calendar.get(Calendar.YEAR)+"-" + getValue( calendar.get(Calendar.MONTH)+1) + "-" + getValue(calendar.get(Calendar.DATE));
            String week = String.valueOf(weekDay);
            int res = calendar.compareTo(nowCalendar);
            MemberSignData signData = new MemberSignData();
            signData.setDay(day);
            signData.setWeek(week);
            signData.setDate(dateStr);
            if (res == -1) {
                signData.setCurrent("before");
            }
            if (res == 0) {
                signData.setCurrent("today");
            }
            if (res == 1) {
                signData.setCurrent("after");
            }
            Date date= null;
            try {
                date = simpleDateFormat.parse(dateStr);
                signData.setTime(date.getTime()/1000);
                signData.setSign(isSign(member.getId(),date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            memberSignDataList.add(signData);
        }

        //连续签到日期

        //判断昨天是否签到







        return memberSignDataList;
    }

    //连签天数

    public int signContinueDay(){
        Calendar nowCalendar =  Calendar.getInstance();
        nowCalendar.setTime(new Date());

        UmsMember member = memberService.getCurrentMember();

        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date yDate=cal.getTime();
        int continueDay = 0;
        if (isSign(member.getId(),yDate)) {
            UmsMemberSignContinueExample example = new UmsMemberSignContinueExample();
            example.createCriteria().andMemberIdEqualTo(member.getId());
            List<UmsMemberSignContinue> memberSignContinues = memberSignContinueMapper.selectByExample(example);
            if (memberSignContinues.size() == 0){
                return 0;
            }
            UmsMemberSignContinue memberSignContinue = memberSignContinues.get(0);
            continueDay =memberSignContinue.getContinueDay();
        }else {
            //今天是否签到了

            if (isSign(member.getId(),nowCalendar.getTime())) {
                continueDay = 1;
            }else {
                continueDay = 0;
            }
            //
        }
        return continueDay;
    }



    @Override
    public boolean sign() {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(nowDate);
        Date date = null;
        UmsMember member = memberService.getCurrentMember();
        try {
            date= simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if ( isSign(member.getId(),date)) {
            return false;
        }
       UmsMemberSign memberSign = new UmsMemberSign();
        memberSign.setMemberId(member.getId());
        memberSign.setSignDate(date);
        memberSignMapper.insert(memberSign);

        if (signContinueDay()==0) {
            //没有连签清空 到1
            UmsMemberSignContinueExample example = new UmsMemberSignContinueExample();
            example.createCriteria().andMemberIdEqualTo(member.getId());
            List<UmsMemberSignContinue> memberSignContinues = memberSignContinueMapper.selectByExample(example);
            if (memberSignContinues.size() == 0){
                //新用户
                UmsMemberSignContinue memberSignContinue = new UmsMemberSignContinue();
                memberSignContinue.setMemberId(member.getId());
                memberSignContinue.setContinueDay(1);
                memberSignContinueMapper.insertSelective(memberSignContinue);
            }else {
                UmsMemberSignContinue memberSignContinue = memberSignContinues.get(0);
                memberSignContinue.setContinueDay(1);
                memberSignContinueMapper.updateByExample(memberSignContinue,example);
            }
        }else {

            //有连签
            UmsMemberSignContinueExample example = new UmsMemberSignContinueExample();
            example.createCriteria().andMemberIdEqualTo(member.getId());
            List<UmsMemberSignContinue> memberSignContinues = memberSignContinueMapper.selectByExample(example);
            if (memberSignContinues.size() == 0){
                //新用户
                UmsMemberSignContinue memberSignContinue = new UmsMemberSignContinue();
                memberSignContinue.setMemberId(member.getId());
                memberSignContinue.setContinueDay(1);
                memberSignContinueMapper.insertSelective(memberSignContinue);
            }else {
                UmsMemberSignContinue memberSignContinue = memberSignContinues.get(0);
                memberSignContinue.setContinueDay(memberSignContinue.getContinueDay()+1);

                memberSignContinueMapper.updateByExample(memberSignContinue,example);
            }

        }
        return true;
    }

    static int getWeekDay(Calendar calendar){
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK)-1;
        return weekDay==0?7:weekDay;
    }

    boolean isSign(Long userId , Date date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);

        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        UmsMemberSignExample memberSignExample = new UmsMemberSignExample();
        memberSignExample.createCriteria().andMemberIdEqualTo(userId).andSignDateEqualTo(date);
        List list = memberSignMapper.selectByExample(memberSignExample);
        if (list.size() == 0) {
            return false;
        }
        return true;
    }

    /**
          * 十以下前补0
          * @param num
          * @return
          */
    private static String getValue(int num){
        return String.valueOf(num>9?num:("0"+num));
    }




}
