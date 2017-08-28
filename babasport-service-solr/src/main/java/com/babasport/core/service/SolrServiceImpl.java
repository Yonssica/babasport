package com.babasport.core.service;

import com.babasport.core.dao.ProductDao;
import com.babasport.core.dao.SkuDao;
import com.babasport.core.pojo.Product;
import com.babasport.core.pojo.Sku;
import com.babasport.core.pojo.SuperPojo;
import com.babasport.core.tools.PageHelper;
import com.babasport.core.tools.PageHelper.Page;
import com.github.abel533.entity.Example;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * solr服务接口实现类
 * Created by hwd on 2017/8/20.
 */
@Service("solrService")
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrServer solrServer;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private SkuDao skuDao;

    @Override
    public Page<SuperPojo> findProductByKeyword(String keyword, String sort, Integer pageNum, Integer pageSize, Long
            brandId, Float pa, Float pb) throws SolrServerException {
        // 设置查询条件
        SolrQuery solrQuery = new SolrQuery("name_ik:" + keyword);

        // 设置过滤条件
        if (brandId != null) {
            solrQuery.addFilterQuery("brandId:" + brandId);  // 品牌
        }
        if (pa != null && pb != null) { // 价格
            if (pb == -1) {
                solrQuery.addFilterQuery("price:[" + pa + " TO *]");
            } else {
                solrQuery.addFilterQuery("price:[" + pa + " TO " + pb + "]");
            }
        }
        // 开始分页设置
        Page page = new Page(pageNum, pageSize);
        solrQuery.setStart(page.getStartRow());
        solrQuery.setRows(page.getPageSize());
        // 设置排序
        if (sort != null && sort.trim().length() > 0) {
            solrQuery.setSort(new SortClause(sort.split(" ")[0], sort.split(" ")[1]));
        }

        // 设置高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("name_ik");
        solrQuery.setHighlightSimplePre("<scan style='color:red;'>");
        solrQuery.setHighlightSimplePost("</scan>");
        // 开始查询
        QueryResponse response = solrServer.query(solrQuery);
        // 获取高亮数据集合
        Map<String, Map<String, List<String>>> highlightMap = response.getHighlighting();
        // 获取结果集
        SolrDocumentList results = response.getResults();
        // 获得总数量
        Long total = results.getNumFound();
        page.setTotal(total);

        // 将结果集中的信息封装到商品对象中
        List<SuperPojo> superProducts = new ArrayList<>();
        for (SolrDocument document : results) {
            // 创建商品对象
            SuperPojo product = new SuperPojo();
            // 商品id
            String id = (String) document.get("id");
            product.setProperty("id", id);
            // 商品名称
            Map<String, List<String>> map = highlightMap.get(id);
            String name = map.get("name_ik").get(0);
            product.setProperty("name", name);
            // 商品图片地址
            String url = (String) document.get("url");
            product.setProperty("url", url);
            // 商品的品牌id
            Long brandId2 = (Long) document.get("brandId");
            product.setProperty("brandId", brandId2);
            // 商品最低价格
            Float price = (Float) document.get("price");
            product.setProperty("price", price);
            // 将万能商品对象添加到集合中
            superProducts.add(product);
        }
        // 将结果集添加到分页对象中
        page.setResult(superProducts);
        return page;
    }

    @Override
    public void addProduct(String ids) throws IOException, SolrServerException {
        // 将ids的字符串转成集合
        String[] split = ids.split(",");
        List list = new ArrayList();
        for (String s : split) {
            list.add(s);
        }

        // 设置添加商品的id条件
        Example example = new Example(Sku.class);
        example.createCriteria().andIn("id",list);
        // 查询ids中的所有商品
        List<Product> products = productDao.selectByExample(example);
        // 遍历查询出的商品集合
        for (Product product : products) {
            // 将商品的各个信息，添加到文档集合
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",product.getId());
            document.addField("name_ik",product.getName());
            document.addField("url",product.getImgUrl());
            document.addField("brandId",product.getBrandId());

            Example example2 = new Example(Sku.class);
            example2.createCriteria().andEqualTo("productId",product.getId());
            example2.setOrderByClause("price asc");
            PageHelper.startPage(1,1);
            List<Sku> skus = skuDao.selectByExample(example2);
            PageHelper.endPage();

            document.addField("price",skus.get(0).getPrice());
            // 将文档对象添加到solr服务器中
            solrServer.add(document);
            solrServer.commit();
        }
    }
}
