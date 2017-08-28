package com.babasport.core.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.Map;

/**
 * 静态化页面服务器实现类
 * Created by hwd on 2017/8/25.
 */
@Service("staticPageService")
public class StaticPageServiceImpl implements StaticPageService,ServletContextAware {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void staticProductPage(Map<String, Object> map, String id) throws IOException, TemplateException {

        // 生成文件的位置
        String path = servletContext.getRealPath("html/product/" + id + ".html");
        System.out.println(path);

        // 获得最终的父文件（目录）
        File file = new File(path);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }

        // 使用Spring的FreeMarker配置获得标准的FreeMarker配置器
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        // 加载模板文件
        Template template = configuration.getTemplate("product.html");
        // 设置输出文件的位置
        // FileWriter fileWriter = new FileWriter(new File(path));
        Writer writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(new File(path)),"UTF-8"));
        // 开始输出
        template.process(map,writer);
    }

    private ServletContext servletContext;
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
