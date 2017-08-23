package com.babasport.action;

import com.babasport.core.pojo.Brand;
import com.babasport.core.pojo.Color;
import com.babasport.core.pojo.Product;
import com.babasport.core.service.BrandService;
import com.babasport.core.service.ProductService;
import com.babasport.core.tools.Encoding;
import com.babasport.core.tools.PageHelper.Page;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * 商品管理控制器
 * Created by hwd on 2017/8/17.
 */
@Controller
public class ProductAction {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    // 显示商品列表 条件查询
    @RequestMapping(value = "console/product/list.do")
    public String consoleProductShowList(Model model, Integer pageSize, Integer pageNum, String name, Long brandId,
                                         Integer isShow) {
        // 设置查询条件
        Product product = new Product();
        name = Encoding.encodeGetRequest(name);
        product.setName(name);
        product.setIsShow(isShow);
        product.setBrandId(brandId);

        Page<Product> pageProducts = productService.findByExample(product, pageNum, pageSize);
        System.out.println("pageProducts.size:" + pageProducts.getResult().size());
        // 将查询出的结果集返回给页面
        model.addAttribute("pageProducts", pageProducts);
        // 设置查询条件回显
        model.addAttribute("name", name);
        model.addAttribute("isShow", isShow);
        model.addAttribute("brandId", brandId);
        // 查询品牌结果集 返回给页面
        List<Brand> brands = brandService.findAllBrands();
        model.addAttribute("brands", brands);
        return "/product/list";
    }

    // 显示商品添加
    @RequestMapping(value = "/console/product/add.do")
    public String consoleProductShowAdd(Model model) {
        List<Brand> brands = brandService.findAllBrands();
        model.addAttribute("brands", brands);
        List<Color> colors = productService.findEnableColors();
        model.addAttribute("colors", colors);
        return "product/add";
    }

    // 执行商品添加
    @RequestMapping(value = "/console/product/doAdd.do")
    public String consoleProductDoAdd(Product product) {
        productService.add(product);
        return "redirect:/console/product/list.do";
    }

    // 修改商品上下架状态
    @RequestMapping(value = "console/product/isShow.do")
    public String consoleProductUpdateIsShow(String ids, Integer isShow) throws IOException, SolrServerException {
        System.out.println("ids:" + ids);
        System.out.println("isShow:" + isShow);

        // 设置修改结果，是否上架
        Product product = new Product();
        product.setIsShow(isShow);
        productService.updateIsShow(product, ids);

        return "redirect:/console/product/list.do";
    }
}
