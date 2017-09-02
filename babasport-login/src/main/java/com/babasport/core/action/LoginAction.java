package com.babasport.core.action;

import com.babasport.core.pojo.Buyer;
import com.babasport.core.service.BuyerService;
import com.babasport.core.service.SessionService;
import com.babasport.core.tools.Entryption;
import com.babasport.core.tools.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录管理控制器
 * Created by hwd on 2017/8/27.
 */
@Controller
public class LoginAction {

    @Autowired
    private BuyerService buyerService;
    @Autowired
    private SessionService sessionService;

    // 显示登录页面
    @RequestMapping(value = "/login.aspx", method = RequestMethod.GET)
    public String showLogin() {
        System.out.println("显示登录页面");
        return "login";
    }

    // 执行登录
    @RequestMapping(value = "/login.aspx", method = RequestMethod.POST)
    public String doLogin(Model model, String username, String password, String returnUrl, HttpServletRequest
            request, HttpServletResponse response) {
        System.out.println("执行登录");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("returnUrl:" + returnUrl);

        // 用户名不为空时
        if (username != null) {
            // 密码不为空时
            if (password != null) {
                Buyer buyer = buyerService.findByUsername(username);
                System.out.println(buyer);

                // 当用户存在时
                if (buyer != null) {
                    // 判断密码是否正确
                    if (buyer.getPassword().equals(Entryption.entrypt(password))) {
                        System.out.println("用户名与密码都正确");
                        // 将用户名保存到自定义session中
                        sessionService.addUsernameToRedis(SessionTool.getSessionId(request, response), username);
                        // 如果用户直接打开登录界面，则登录后返回首页
                        if (returnUrl == null || returnUrl.length() < 1) {
                            returnUrl = "http://localhost:8083";
                        }
                        return "redirect:" + returnUrl;
                    } else {
                        model.addAttribute("error", "密码不正确");
                    }
                } else {
                    model.addAttribute("error", "用户不存在");
                }
            } else {
                model.addAttribute("error", "密码不能为空");
            }
        } else {
            model.addAttribute("error", "用户名不能为空");
        }
        return "login";
    }

    // 判断用户是否登录
    @RequestMapping(value = "/isLogin.aspx")
    @ResponseBody
    public MappingJacksonValue isLogin(HttpServletRequest request, HttpServletResponse response, String callback) {
        String username = sessionService.getUsernameFromRedis(SessionTool.getSessionId(request, response));
        System.out.println(SessionTool.getSessionId(request, response));
        System.out.println("username:" + username);
        // 将要传回给页面的数据，封装到以callback命名的js方法中
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(username);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
