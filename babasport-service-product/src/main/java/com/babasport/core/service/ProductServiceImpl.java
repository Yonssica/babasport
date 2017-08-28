package com.babasport.core.service;

import com.babasport.core.dao.ColorDao;
import com.babasport.core.dao.ProductDao;
import com.babasport.core.dao.SkuDao;
import com.babasport.core.pojo.Color;
import com.babasport.core.pojo.Product;
import com.babasport.core.pojo.Sku;
import com.babasport.core.pojo.SuperPojo;
import com.babasport.core.tools.PageHelper;
import com.babasport.core.tools.PageHelper.Page;
import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品服务接口实现类
 * Created by hwd on 2017/8/17.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ColorDao colorDao;
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private Jedis jedis;
    @Autowired
    private SolrServer solrServer;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public Page<Product> findByExample(Product product, Integer pageNum, Integer pageSize) {

        Example example = new Example(Product.class);
        // 为了方便查看效果 按照创建时间倒序排列
        example.setOrderByClause("createTime desc");
        Criteria criteria = example.createCriteria();
        if (product.getName() != null) {
            criteria.andLike("name", "%" + product.getName() + "%");
        }
        if (product.getIsShow() != null) {
            criteria.andEqualTo("isShow", product.getIsShow());
        }
        if (product.getBrandId() != null) {
            criteria.andEqualTo("brandId", product.getBrandId());
        }

        // 开始分页
        PageHelper.startPage(pageNum, pageSize);
        productDao.selectByExample(example);
        // 结束分页
        Page<Product> endPage = PageHelper.endPage();
        return endPage;
    }

    @Override
    public List<Color> findEnableColors() {
        Example example = new Example(Color.class);
        example.createCriteria().andNotEqualTo("parentId", 0 + "");

        return colorDao.selectByExample(example);
    }

    @Override
    public void add(Product product) {
        if (product.getIsCommend() == null) {
            product.setIsCommend(0);
        }
        if (product.getIsHot() == null) {
            product.setIsHot(0);
        }
        if (product.getIsNew() == null) {
            product.setIsNew(0);
        }
        if (product.getIsShow() == null) {
            product.setIsShow(0);
        }
        if (product.getCreateTime() == null) {
            product.setCreateTime(new Date());
        }
        // 获得由redis分配的商品自动增长id
        Long pno = jedis.incr("pno");
        product.setId(pno);

        productDao.insert(product);
        System.out.println("productId:" + product.getId()); // 获得回显id

        // 将商品信息添加到库存表中
        // 遍历不同的颜色和尺码
        // 每一个不同的颜色或尺码，都应该插入库存表中，成为一条数据
        String[] colors = product.getColors().split(",");
        String[] sizes = product.getSizes().split(",");

        for (String color : colors) {
            for (String size : sizes) {
                Sku sku = new Sku();
                sku.setProductId(product.getId());
                sku.setColorId(Long.parseLong(color));
                sku.setSize(size);
                sku.setCreateTime(new Date());
                sku.setDeliveFee(10f);
                sku.setMarketPrice(1000f);
                sku.setPrice(800f);
                sku.setStock(300);
                sku.setUpperLimit(200);
                skuDao.insert(sku);
            }
        }
    }

    @Override
    public void updateIsShow(Product product, final String ids) throws IOException, SolrServerException {
        Example example = new Example(Product.class);
        // 将ids的字符串转成list集合
        List list = new ArrayList();
        String[] idList = ids.split(",");
        for (String s : idList) {
            list.add(s);
        }
        // 设置批量修改的id条件
        example.createCriteria().andIn("id", list);
        // 进行批量、选择性属性修改
        productDao.updateByExampleSelective(product, example);

        // 如果是商品上架，将商品信息添加到solr服务器中
        if (product.getIsShow() == 1) {
            // 采用消息服务模式
            // 将商品信息添加到solr服务器中（发送消息(ids)到ActiveMQ中）
            jmsTemplate.send("productIds", new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    // 使用session创建文本消息
                    return session.createTextMessage(ids);
                }
            });
        }
    }

    @Override
    public SuperPojo findProductById(Long productId) {
        // 先查询出单个商品对象
        Product product = productDao.selectByPrimaryKey(productId);

        // 根据商品id查出该商品的库存组合
        List<SuperPojo> skus = skuDao.findSkuAndColorByProductId(productId);

        // 将单个商品对象与其库存集合封装到万能pojo类中
        SuperPojo superPojo = new SuperPojo();
        superPojo.setProperty("product", product);
        superPojo.setProperty("skus", skus);
        return superPojo;
    }
}
