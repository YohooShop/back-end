package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.express.dao.ExpressInfo;
import com.yoooho.mall.express.service.OrderExpressService;
import com.yoooho.mall.service.LogisticService;
import com.yoooho.mall.express.domain.KDNExpressCompany;
import com.yoooho.mall.express.service.ShopExpressService;
import com.yoooho.mall.express.service.dto.KDNExpressCompanyQueryCriteria;
import com.yoooho.mall.vo.ExpressParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "LogisticController", description = "物流")
@RequestMapping("/logistic")
public class LogisticController {

    @Autowired
    LogisticService logisticService;

    @Autowired
    ShopExpressService shopExpressService;

    @Autowired
    OrderExpressService orderExpressService;

    @ApiOperation("物流快递公司列表")
    @RequestMapping(value = "/companyList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult homeData() {
        List list = logisticService.logisticCompanyList();
        return CommonResult.success(list);
    }

    @ApiOperation(value = "查询快递")
    @GetMapping(value = "/company")
//    @PreAuthorize("@el.check('admin','YXEXPRESS_ALL','YXEXPRESS_SELECT')")
    public CommonResult express(KDNExpressCompanyQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(shopExpressService.queryAll(criteria,pageable));
    }

    @ApiOperation(value = "新增快递")
    @PostMapping(value = "/company")
//    @PreAuthorize("@el.check('admin','YXEXPRESS_ALL','YXEXPRESS_CREATE')")
    public CommonResult create(@Validated @RequestBody KDNExpressCompany resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        shopExpressService.create(resources);
        return CommonResult.success("");
    }

    @ApiOperation(value = "修改快递")
    @PutMapping(value = "/company")
//    @PreAuthorize("@el.check('admin','YXEXPRESS_ALL','YXEXPRESS_EDIT')")
    public CommonResult update(@Validated @RequestBody KDNExpressCompany  resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        shopExpressService.update(resources);
        return CommonResult.success("");
    }

    @ApiOperation(value = "删除快递")
    @DeleteMapping(value = "/company/{id}")
    @PreAuthorize("@el.check('admin','YXEXPRESS_ALL','YXEXPRESS_DELETE')")
    public CommonResult delete(@PathVariable Integer id){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        shopExpressService.delete(id);
        return CommonResult.success("");
    }

    @ApiOperation("快递鸟电子面单")
    @RequestMapping(value = "/creatOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult creatOrder(@RequestParam("ShipperCode") String shipperCode,@RequestParam("ShipperCode") String logisticCode,
                                   @RequestParam("senderName") String senderName,  @RequestParam("senderProvinceName") String senderProvinceName,
                                   @RequestParam("senderCityName") String senderCityName,@RequestParam("senderExpAreaName") String senderExpAreaName,
                                   @RequestParam("senderAddress") String senderAddress, @RequestParam("senderTel")String senderTel, @RequestParam("senderMob") String senderMob,
                                   @RequestParam("receiverName") String receiverName,  @RequestParam("receiverProvinceName") String receiverProvinceName,
                                   @RequestParam("receiverCityName") String receiverCityName,@RequestParam("receiverExpAreaName") String receiverExpAreaName,
                                   @RequestParam("receiverAddress") String receiverAddress,@RequestParam("receiverTel") String receiverTel,@RequestParam("receiverMob") String receiverMob,
                                   @RequestParam("commodityName") String commodityName ,@RequestParam("expType") String expType, @RequestParam("payType")String payType, @RequestParam("orderId") Long orderId){
        return logisticService.creatOrder(shipperCode, logisticCode,
                senderName, senderProvinceName, senderCityName, senderExpAreaName, senderAddress,senderTel,senderMob,
                receiverName, receiverProvinceName, receiverCityName, receiverExpAreaName, receiverAddress,receiverTel,receiverMob,
                commodityName,expType,payType,orderId,"");
    }


    @ApiOperation("快递鸟物流订阅")
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult subscribeLogistic(@RequestParam("ShipperCode") String shipperCode,@RequestParam("ShipperCode") String logisticCode,
                                  @RequestParam("senderName") String senderName,  @RequestParam("senderProvinceName") String senderProvinceName,
                                  @RequestParam("senderCityName") String senderCityName,@RequestParam("senderExpAreaName") String senderExpAreaName,
                                  @RequestParam("senderAddress") String senderAddress, @RequestParam("senderTel")String senderTel, @RequestParam("senderMob") String senderMob,
                                  @RequestParam("receiverName") String receiverName,  @RequestParam("receiverProvinceName") String receiverProvinceName,
                                  @RequestParam("receiverCityName") String receiverCityName,@RequestParam("receiverExpAreaName") String receiverExpAreaName,
                                  @RequestParam("receiverAddress") String receiverAddress,@RequestParam("receiverTel") String receiverTel,@RequestParam("receiverMob") String receiverMob,
                                  @RequestParam("commodityName") String commodityName, @RequestParam("orderId") Long orderId) {
      return logisticService.subscribeLogistic(shipperCode, logisticCode,
              senderName, senderProvinceName, senderCityName, senderExpAreaName, senderAddress, senderTel,senderMob,
              receiverName, receiverProvinceName, receiverCityName, receiverExpAreaName, receiverAddress,receiverTel,receiverMob,
              commodityName,orderId,"");
    }



    @ApiOperation("快递鸟推送过来的数据")
    @RequestMapping(value="express")
    @ResponseBody
    public void tuisong(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        logisticService.analysisPushLogisticData(req, resp);
    }
    /**@Valid
     * 获取物流信息,根据传的订单编号 ShipperCode快递公司编号 和物流单号,
     */
    @PostMapping("/express")
    @ApiOperation(value = "获取物流信息",notes = "获取物流信息",response = ExpressParam.class)
    public CommonResult express(@RequestBody ExpressParam expressInfoDo){
        ExpressInfo expressInfo = orderExpressService.getExpressInfo(expressInfoDo.getOrderCode());
        return CommonResult.success(expressInfo);
    }


    @ApiOperation("获取快递信息")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult logisticstOrder(@RequestParam("id")Long id){
        return   logisticService.logisticstOrder(id);
    }





}
