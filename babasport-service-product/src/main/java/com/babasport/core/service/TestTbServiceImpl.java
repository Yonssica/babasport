package com.babasport.core.service;

import com.babasport.core.dao.TestTbDao;
import com.babasport.core.pojo.TestTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 测试服务类
 * Created by hwd on 2017/8/14.
 */
@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {

    @Autowired
    private TestTbDao testTbDao;

    @Override
    public void add(TestTb testTb) {
        testTbDao.add(testTb);

//        int a = 8/0;
        TestTb testTb2 = new TestTb();
        testTb2.setName("泰达米尔");
        testTb2.setBirthday(new Date());
        testTbDao.add(testTb2);
    }
}
