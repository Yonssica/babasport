package com.babasport.core.action;

import com.babasport.core.pojo.Brand;
import com.babasport.core.pojo.Product;
import com.babasport.core.pojo.SuperPojo;
import com.babasport.core.service.BrandService;
import com.babasport.core.service.ProductService;
import com.babasport.core.service.SolrService;
import com.babasport.core.tools.Encoding;
import com.babasport.core.tools.PageHelper.Page;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * 前台首页控制中心
 * Created by hwd on 2017/8/20.
 */
@Controller
public class IndexAction {

    @Autowired
    private SolrService solrService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    // 显示前台首页
    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

    // 根据关键字查询
    @RequestMapping(value = "/search")
    public String search(Model model, String keyword, String sort, Integer pageNum, Integer pageSize, Long brandId,
                         Float pa, Float pb) throws SolrServerException {

        keyword = Encoding.encodeGetRequest(keyword);
        Page<SuperPojo> page = solrService.findProductByKeyword(keyword, sort, pageNum, pageSize, brandId, pa, pb);
        model.addAttribute("page", page);
        System.out.println("搜索到的商品数量" + page.getResult().size());
        // 将选择的品牌传给页面
        model.addAttribute("brandId", brandId);
        // 将选择的价格区间传给页面
        model.addAttribute("pa", pa);
        model.addAttribute("pb", pb);

        // 将反转前的sort传给界面
        model.addAttribute("sort2", sort);
        // 将sort进行反转
        if (sort != null && sort.equals("price asc")) {
            sort = "price desc";
        } else {
            sort = "price asc";
        }
        // 回显关键字
        model.addAttribute("keyword", keyword);
        model.addAttribute("sort", sort);

        // 将品牌的集合传递给页面
        List<Brand> brands = brandService.findAllBrandsFromRedis();
        model.addAttribute("brands", brands);

        // 构建已选条件的Map
        TreeMap<String, String> map = new TreeMap<>();
        if (brandId != null) {
            // 根据品牌id获取品牌名称
            for (Brand brand : brands) {
                if (brandId == brand.getId()) {
                    map.put("品牌", brand.getName());
                }
            }
        }
        if (pa != null && pb != null) {
            if (pb == -1) {
                map.put("价格", pa + "以上");
            } else {
                map.put("价格", pa + "-" + pb);
            }
        }
        model.addAttribute("map", map);

        return "search";
    }

    // 显示单个商品信息
    @RequestMapping(value = "product/detail")
    public String showSingleProduct(Model model, Long productId) {
        System.out.println("商品id:" + productId);

        SuperPojo superPojo = productService.findProductById(productId);
        Product product = (Product) superPojo.get("product");
        List skus = (List) superPojo.get("skus");

        // 去除颜色重复
        HashMap<Long, String> colors = new HashMap<>();
        for (Object o : skus) {
            SuperPojo sku = (SuperPojo) o;
            colors.put((Long) sku.get("color_id"), (String) sku.get("name"));
        }
        superPojo.setProperty("colors", colors);

        System.out.println("商品名称：" + product.getName());
        System.out.println("库存数量：" + skus.size());

        model.addAttribute("superPojo", superPojo);
        return "product";
    }
}
