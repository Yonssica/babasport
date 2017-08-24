package com.babasport.core.service;

import com.babasport.core.pojo.SuperPojo;
import com.babasport.core.tools.PageHelper.Page;
import org.apache.solr.client.solrj.SolrServerException;

/**
 * solr服务接口
 * Created by hwd on 2017/8/20.
 */
public interface SolrService {

    /**
     * 根据关键字搜索商品
     *
     * @param keyword
     * @param sort
     * @param pageNum
     * @param pageSize @return
     * @param pa
     *@param pb @throws SolrServerException
     */
    public Page<SuperPojo> findProductByKeyword(String keyword, String sort, Integer pageNum, Integer pageSize, Long
            brandId, Float pa, Float pb) throws SolrServerException;

    /**
     * 添加商品信息到solr服务器
     * @param ids
     */
    void addProduct(String ids);
}
