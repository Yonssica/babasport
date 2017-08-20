package com.babasport.action;

import com.babasport.core.dictionary.Constants;
import com.babasport.core.tools.FastDFSTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 上传文件控制器
 * Created by hwd on 2017/8/16.
 */
@Controller
public class UploadAction {

    // 上传文件
    @RequestMapping(value = "/upload.do")
    @ResponseBody
    public HashMap<String,String> uploadFile(@RequestParam("pic") MultipartFile mpf) throws Exception {

        System.out.println("开始文件上传");
        System.out.println("执行文件上传：" + mpf.getOriginalFilename());
        // 将文件上传到分布式文件系统，并返回文件的存储路径及名称
        String uploadFile = FastDFSTool.uploadFile(mpf.getBytes(),mpf.getOriginalFilename());
        // 返回json格式的字符串（图片的绝对网络存放地址）
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("path", Constants.FDFS_SERVER + uploadFile);
        return hashMap;
    }

    // 同时上传多个文件
    @RequestMapping(value = "/uploadPics.do")
    @ResponseBody
    public List<String> uploadPics(@RequestParam("pics") MultipartFile[] multipartFiles) throws Exception {
        System.out.println("开始多文件上传");

        // 上传文件返回的路径集合
        List<String> list = new ArrayList<String>();
        for (MultipartFile multipartFile : multipartFiles) {
            // 将文件上传到分布式文件系统，并返回文件的存储路径和名称
            String uploadFile = FastDFSTool.uploadFile(multipartFile.getBytes(),multipartFile.getOriginalFilename());
            System.out.println("uploadFile:" + uploadFile);
            // 返回json格式的字符串（图片的绝对网络存放地址）
            list.add(Constants.FDFS_SERVER + uploadFile);
        }
        return list;
    }

    // 接收富文本编辑器传递的图片(无敌版：不考虑文件的name，强行接收)
    @RequestMapping(value = "/uploadFck.do")
    @ResponseBody
    public HashMap<String, Object> uploadFck(HttpServletRequest request, HttpServletResponse response)
            throws FileNotFoundException, IOException, Exception {

        // 将request强转为spring提供的MultipartRequest
        MultipartRequest mr = (MultipartRequest) request;

        // 获得MultipartRequest里面的所有文件
        Set<Map.Entry<String, MultipartFile>> entrySet = mr.getFileMap().entrySet();

        for (Map.Entry<String, MultipartFile> entry : entrySet) {
            MultipartFile mpf = entry.getValue();
            // 将文件上传到分布式文件系统，并返回文件的存储路径及名称
            String uploadFile = FastDFSTool.uploadFile(mpf.getBytes(),
                    mpf.getOriginalFilename());
            // 返回json格式的字符串（图片的绝对网络存放地址）
            HashMap<String, Object> hashMap = new HashMap<String, Object>();

            // error和url名字都是固定死的
            hashMap.put("error", 0);
            hashMap.put("url", Constants.FDFS_SERVER + uploadFile);
            return hashMap;
        }
        return null;
    }

}
