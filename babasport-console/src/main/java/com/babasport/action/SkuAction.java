package com.babasport.action;

import com.babasport.core.pojo.Sku;
import com.babasport.core.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 库存管理服务
 * Created by hwd on 2017/8/19.
 */
@Controller
public class SkuAction {

    @Autowired
    private SkuService skuService;

    // 显示库存
    @RequestMapping(value = "console/sku/list.do")
    public String consoleSkuShowList(Model model, Long productId) {
        System.out.println("productId:" + productId);
        List<Sku> skus = skuService.findByProductId(productId);
        System.out.println("库存数量:" + skus.size());
        model.addAttribute("skus", skus);

        return "/sku/list";
    }

    // 修改库存数据
    @RequestMapping(value = "console/sku/update.do")
    @ResponseBody
    public String consoleSkuDoUpdate(Sku sku) {
        System.out.println("执行修改库存");
        System.out.println("sku:" + sku);
        skuService.update(sku);
        return null;
    }

}
