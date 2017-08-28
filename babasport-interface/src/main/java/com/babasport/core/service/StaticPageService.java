package com.babasport.core.service;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * 静态化页面服务接口
 * Created by hwd on 2017/8/25.
 */
public interface StaticPageService {

    /**
     * 静态化商品详情页面
     *
     * @param map
     * @param id
     */
    public void staticProductPage(Map<String, Object> map, String id) throws IOException, TemplateException;
}
