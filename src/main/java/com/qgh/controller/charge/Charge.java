package com.qgh.controller.charge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title:充值管理
 * @ClassName: Charge
 * @Description:
 * @Auther: 秦光泓
 * @date 2019/11/5
 * @time 17:39
 */
@Controller
public class Charge {
    @RequestMapping("/enter_chager")
    public String enterCharge(){
        return "charge";
    }
}
