package com.babasport.core.message;

import com.babasport.core.pojo.Color;
import com.babasport.core.pojo.Product;
import com.babasport.core.pojo.Sku;
import com.babasport.core.pojo.SuperPojo;
import com.babasport.core.service.ProductService;
import com.babasport.core.service.StaticPageService;
import freemarker.template.TemplateException;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 消息回调处理类
 * Created by hwd on 2017/8/25.
 */
public class MyMessageListener2 implements MessageListener {
    @Autowired
    private ProductService productService;
    @Autowired
    private StaticPageService staticPageService;

    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage mqTextMessage = (ActiveMQTextMessage) message;
        try {
            String ids = mqTextMessage.getText();
            System.out.println("cms ids:" + ids);

            String[] split = ids.split(",");
            for (String id : split) {
                // 根据ids查询出各个商品的复合信息
                SuperPojo superPojo = productService.findProductById(Long.parseLong(id));

                Product product = (Product) superPojo.get("product");
                List skus = (List) superPojo.get("skus");
                System.out.println("商品名称：" + product.getName());
                System.out.println("库存数量：" + skus.size());

                // 去除颜色重复，将原有的map变得可以支持FreeMarker
                Set<SuperPojo> colors = new HashSet<>();
                for (Object obj : skus) {
                    SuperPojo sku = (SuperPojo) obj;
                    // 定义颜色对象
                    SuperPojo color = new SuperPojo();
                    color.setProperty("id",sku.get("color_id"));
                    color.setProperty("name",sku.get("name"));
                    // 将颜色对象添加到hs集合中，利用hs集合来去除重复
                    colors.add(color);
                }
                // 将非重复的颜色集合也通过superpojo传递到页面
                superPojo.setProperty("colors",colors);

                HashMap hashMap = new HashMap();
                hashMap.put("superPojo",superPojo);

                // 开始静态化
                staticPageService.staticProductPage(hashMap,id);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
