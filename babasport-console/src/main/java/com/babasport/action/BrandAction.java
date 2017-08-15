package com.babasport.action;

import com.babasport.core.pojo.Brand;
import com.babasport.core.service.BrandService;
import com.babasport.core.tools.Encoding;
import com.babasport.core.tools.PageHelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 品牌管理控制器
 * Created by hwd on 2017/8/15.
 */
@Controller
public class BrandAction {

    @Autowired
    private BrandService brandService;

    // 品牌通用
    @RequestMapping(value = "/console/brand/{pageName}.do")
    public String consoleBrandShow(@PathVariable(value = "pageName") String pageName, Model model, String name, Integer
            isDisplay, Integer pageSize, Integer pageNum) {

        if (pageName.equals("list")) {
            // 将条件查询语句封装成Brand对象
            Brand brand = new Brand();
            brand.setName(Encoding.encodeGetRequest(name));
            brand.setIsDisplay(isDisplay);
            // 查询数据库中所有品牌
            Page<Brand> pageBrands = brandService.findByExample(brand, pageSize, pageNum);
            System.out.println("pageBrands.size:" + pageBrands.getResult().size());

            // 将查询结果交给页面显示
            model.addAttribute("pageBrands", pageBrands);
            // 设置查询界面回显
            model.addAttribute("name", Encoding.encodeGetRequest(name));
            model.addAttribute("isDisplay", isDisplay);
        }

        return "brand/" + pageName;
    }

    // 修改品牌界面跳转
    @RequestMapping(value = "console/brand/edit.do")
    public String consoleBrandShowEdit(Long brandId,Model model) {
        System.out.println("brandId:" + brandId);
        // 设置修改的数据回显
        Brand brand = brandService.findById(brandId);
        model.addAttribute("brand",brand);
        return "brand/edit";
    }

    // 执行品牌修改
    @RequestMapping(value = "console/brand/doEdit.do")
    public String consoleBrandDoEdit(Brand brand) {
        // 获得要修改的品牌内容
        System.out.println(brand);
        brandService.updateById(brand);
        return "redirect:/console/brand/list.do";
    }
}
