package com.babasport.core.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器类
 * Created by hwd on 2017/8/27.
 */
public class MyConverter implements Converter<String,String> {
    @Override
    public String convert(String source) {
        // 去掉字符串前后空格
        if (source != null) {
            source = source.trim();
            if (!"".equals(source)) {
                return source;
            }
        }
        return null;
    }
}
