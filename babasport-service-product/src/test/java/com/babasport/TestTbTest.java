package com.babasport;

import com.babasport.core.dao.TestTbDao;
import com.babasport.core.pojo.TestTb;
import com.babasport.core.service.TestTbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Junit + Spring
 * Created by hwd on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestTbTest {

    @Autowired
    private TestTbDao testTbDao;
    @Autowired
    private TestTbService testTbService;

    /**
     * 测试DAO
     */
    @Test
    public void testAdd1() {
        TestTb testTb = new TestTb();
        testTb.setName("维嘉");
        testTb.setBirthday(new Date());
        testTbDao.add(testTb);
    }

    /**
     * 测试Service
     */
    @Test
    public void testAdd2() {
        TestTb testTb = new TestTb();
        testTb.setName("Mr.mr");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);
    }
}
