package com.babasport.core.service;

import com.babasport.core.pojo.TestTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Junit + Spring
 * Created by hwd on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestTbServiceTest {

    @Autowired
    private TestTbService testTbService;

    @Test
    public void add() throws Exception {
        TestTb testTb = new TestTb();
        testTb.setName("崔丝塔娜");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);
    }

}