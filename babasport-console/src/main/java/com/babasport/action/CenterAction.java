package com.babasport.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理 控制中心
 * Created by hwd on 2017/8/14.
 */
@Controller
public class CenterAction {

   /* @Autowired
    private TestTbService testTbService;

    @RequestMapping(value = "/test/index.do")
    public String index1(Model model) {
        System.out.println("管理控制中心");

        // Dubbo调用测试
        TestTb testTb = new TestTb();
        testTb.setName("菲奥娜");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);

        return "index";
    }*/

    /**
     * 将用户输入的url路径，取出关键部分，直接转发到指定的jsp页面
     *
     * @return
     */
    // 总
    @RequestMapping(value = "/console/{pageName}.do")
    public String consoleShow(@PathVariable(value = "pageName") String pageName) {
        return pageName;
    }

    // 框架页面
    @RequestMapping(value = "/console/frame/{pageName}.do")
    public String consoleFrameShow(@PathVariable(value = "pageName") String pageName) {
        return "frame/" + pageName;
    }

    // 商品
    @RequestMapping(value = "/console/product/{pageName}.do")
    public String consoleProductShow(@PathVariable(value = "pageName") String pageName) {
        return "product/" + pageName;
    }

}
