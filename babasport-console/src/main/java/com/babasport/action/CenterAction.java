package com.babasport.action;

import com.babasport.core.pojo.TestTb;
import com.babasport.core.service.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 后台管理 控制中心
 * Created by hwd on 2017/8/14.
 */
@Controller
public class CenterAction {

    @Autowired
    private TestTbService testTbService;

    @RequestMapping(value = "/test/index.do")
    public String index(Model model) {
        System.out.println("管理控制中心");

        // Dubbo调用测试
        TestTb testTb = new TestTb();
        testTb.setName("菲奥娜");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);

        return "index";
    }
}
