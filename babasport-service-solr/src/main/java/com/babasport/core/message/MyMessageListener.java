package com.babasport.core.message;

import com.babasport.core.service.SolrService;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 自定义消息监听器类
 * Created by hwd on 2017/8/24.
 */
public class MyMessageListener implements MessageListener {

    @Autowired
    private SolrService solrService;

    /**
     * 当监听到消息后，会自动调用此方法
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage mqMessage = (ActiveMQTextMessage) message;
        try {
            String ids = mqMessage.getText();
            System.out.println("消息方接收到的消息：" + ids);
            // 添加商品信息到solr服务器
            solrService.addProduct(ids);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
