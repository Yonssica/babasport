package com.babasport.core.service;

/**
 * Session服务类接口
 * 模拟官方Session功能，并将Session数据存放到redis中
 * Created by hwd on 2017/8/28.
 */
public interface SessionService {

    /**
     * 保存用户名到redis中
     * @param key
     * @param value
     */
    public void addUsernameToRedis(String key,String value);

    /**
     * 从redis中取出用户名
     * @param key
     * @return
     */
    public String getUsernameFromRedis(String key);
}
