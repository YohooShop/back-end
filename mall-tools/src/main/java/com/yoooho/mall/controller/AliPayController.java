package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.AlipayConfig;
import com.yoooho.mall.service.AlipayService;
import com.yoooho.mall.utils.AlipayUtils;
import com.yoooho.mall.vo.TradeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zheng Jie
 * @date 2019-12-31
 */
@Slf4j
@RestController
@RequestMapping("/api/aliPay")
@Api(tags = "工具：支付宝管理")
public class AliPayController {
    private final AlipayUtils alipayUtils;

    private final AlipayService alipayService;

    public AliPayController(AlipayUtils alipayUtils, AlipayService alipayService) {
        this.alipayUtils = alipayUtils;
        this.alipayService = alipayService;
    }

    @GetMapping
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('tools:alipay:config')")
    public CommonResult get(){
        return  CommonResult.success(alipayService.find());
    }

    @ApiOperation("配置支付宝")
    @PreAuthorize("hasAuthority('tools:alipay:config')")
    @PutMapping
    @ResponseBody
    public CommonResult payConfig(@Validated @RequestBody AlipayConfig alipayConfig){
        alipayConfig.setId(1L);
        alipayService.update(alipayConfig);
        return CommonResult.success("");
    }


    @ApiOperation("PC网页支付")
    @PostMapping(value = "/toPayAsPC")
    @ResponseBody
    public CommonResult toPayAsPc(@Validated@RequestBody TradeVo trade) throws Exception{
        AlipayConfig aliPay = alipayService.find();
        trade.setOutTradeNo(alipayUtils.getOrderCode());
        String payUrl = alipayService.toPayAsPc(aliPay,trade);
        return CommonResult.success(payUrl);
    }


    @ApiOperation("手机网页支付")
    @PostMapping(value = "/toPayAsWeb")
    @ResponseBody
    public CommonResult toPayAsWeb(@Validated @RequestBody TradeVo trade) throws Exception{
        AlipayConfig alipay = alipayService.find();
        trade.setOutTradeNo(alipayUtils.getOrderCode());
        String payUrl = alipayService.toPayAsWeb(alipay,trade);
        return CommonResult.success(payUrl);
    }

//    @ApiIgnore
//    @GetMapping("/return")
//    @AnonymousAccess
//    @ApiOperation("支付之后跳转的链接")
//    public CommonResult returnPage(HttpServletRequest request, HttpServletResponse response){
//        AlipayConfig alipay = alipayService.find();
//        response.setContentType("text/html;charset=" + alipay.getCharset());
//        //内容验签，防止黑客篡改参数
//        if(alipayUtils.rsaCheck(request,alipay)){
//            //商户订单号
//            String outTradeNo = new String(request.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            //支付宝交易号
//            String tradeNo = new String(request.getParameter("trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            System.out.println("商户订单号"+outTradeNo+"  "+"第三方交易号"+tradeNo);
//
//            // 根据业务需要返回数据，这里统一返回OK
//            return  CommonResult.success("payment successful");
//        }else{
//            // 根据业务需要返回数据
//            return CommonResult.success(BAD_REQUEST);
//        }
//    }
//
//    @ApiIgnore
//    @RequestMapping("/notify")
//    @AnonymousAccess
//    @SuppressWarnings("all")
//    @ApiOperation("支付异步通知(要公网访问)，接收异步通知，检查通知内容app_id、out_trade_no、total_amount是否与请求中的一致，根据trade_status进行后续业务处理")
//    public ResponseEntity<Object> notify(HttpServletRequest request){
//        AlipayConfig alipay = alipayService.find();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        //内容验签，防止黑客篡改参数
//        if (alipayUtils.rsaCheck(request,alipay)) {
//            //交易状态
//            String tradeStatus = new String(request.getParameter("trade_status").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            // 商户订单号
//            String outTradeNo = new String(request.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            //支付宝交易号
//            String tradeNo = new String(request.getParameter("trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            //付款金额
//            String totalAmount = new String(request.getParameter("total_amount").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            //验证
//            if(tradeStatus.equals(AliPayStatusEnum.SUCCESS.getValue())||tradeStatus.equals(AliPayStatusEnum.FINISHED.getValue())){
//               // 验证通过后应该根据业务需要处理订单
//            }
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
}
