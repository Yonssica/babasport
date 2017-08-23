package com.babasport;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by hwd on 2017/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSolr {
    @Autowired
    private HttpSolrServer solrServer;

    @Test
    public void createIndex() throws IOException, SolrServerException {

        // 使用solr输入文档（SolrInputDocument） 创建文档对象
        SolrInputDocument document = new SolrInputDocument();
        // 添加字段到文档对象
        document.addField("id","1");
        document.addField("name_ik","楚尧杰怕不是个傻子吧");
        // 添加文档到solr服务器对象
        solrServer.add(document);
        // 提交
        solrServer.commit();
    }
}

