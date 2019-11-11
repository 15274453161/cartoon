package com.qgh.controller.charge;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.qgh.ServiceImpl.PayRecordServiceImpl;
import com.qgh.ServiceImpl.WalletServiceImpl;
import com.qgh.config.AlipayProperties;
import com.qgh.pojo.Wallet;
import com.qgh.util.UUIDUtil;
import com.qgh.util.result.Result;
import com.qgh.util.user.UserInfor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;


/**
 * @title:充值管理
 * @ClassName: Charge
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/5
 * @time 17:39
 */
@Slf4j
@Controller
public class Charge {

    @Autowired
    private UserInfor userInfor;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayProperties aliPayProperties;


    @Autowired
    private PayRecordServiceImpl payRecordService;

    @Autowired
    private WalletServiceImpl walletService;

    /**
     * 进入到充值界面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/enter_chager")
    public String enterCharge(Model model , HttpSession session){
        //1、查询出当前登录用户的账户额度

        model.addAttribute("dongNum", walletService.getDongNum(payRecordService.getUserId(session)));
        userInfor.user(model,session);
        return "charge";
    }


    /**
     * 会员充值
     * @param userId
     * @param payMoney
     * @param dongNum
     * @throws AlipayApiException
     * @throws IOException
     */
    @PostMapping("alipay/page/gotoPayPage")
    public void gotoPayPage(String userId,String payMoney,String dongNum,HttpServletResponse response) throws AlipayApiException, IOException {
        // 订单模型

        System.out.println(userId+"  "+payMoney+"  "+dongNum);
        String productCode = "FAST_INSTANT_TRADE_PAY";
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        String outTradeNo= UUIDUtil.randomUUID();

        model.setOutTradeNo(outTradeNo);//订单编号必须唯一
        model.setSubject("会员充值");
        model.setTotalAmount(payMoney);
        model.setBody("支付测试，共"+payMoney+"元");
        model.setProductCode(productCode);



        AlipayTradePagePayRequest pagePayRequest = new AlipayTradePagePayRequest();
        pagePayRequest.setReturnUrl(aliPayProperties.getReturnUrl());
        pagePayRequest.setNotifyUrl(aliPayProperties.getNotifyUrl());
        pagePayRequest.setBizModel(model);

        // 调用SDK生成表单, 并直接将完整的表单html输出到页面
        String form = alipayClient.pageExecute(pagePayRequest).getBody();
        response.setContentType("text/html;charset=" + aliPayProperties.getCharset());
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }


    /**
     * 支付成功后的回调函数 可以做一些逻辑处理
     * @param request
     * @return
     */
    @RequestMapping("alipay-callback-return-sult")
    public String successResult(HttpServletRequest request,Model model , HttpSession session){
        //可以根据request.getParameterMap()获得到调用接口时传递的一些参数去做后续的业务处理
        Map<String, String[]> parameterMap = request.getParameterMap();
         //获得唯一订单号
        String[] out_trade_nos = parameterMap.get("out_trade_no");
        System.out.println("订单编号："+out_trade_nos);
        String id = out_trade_nos[0];
        //获得支付金额
        String[] moneys=  parameterMap.get("total_amount");
        double money=Double.parseDouble(moneys[0]);
        //数据库操作
        payRecordService.addPayRecord(id,money,payRecordService.getUserId(session));
        walletService.addWallet(payRecordService.getUserId(session),payRecordService.getDongNum(money));
        System.out.println(id+","+money);
        //设置用户id返回到前端
        userInfor.user(model,session);

        return "charge";
    }


    @RequestMapping("/record")
    public String record(int pageNo,HttpSession session,Model model){

        Result record= payRecordService.searchAllByUserId(payRecordService.getUserId(session),pageNo);
        userInfor.user(model,session);
        System.out.println(record);
        model.addAttribute("record",record);
        return  "record";
    }
}
