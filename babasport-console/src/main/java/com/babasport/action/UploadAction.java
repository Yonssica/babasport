package com.babasport.action;

import com.babasport.core.dictionary.Constants;
import com.babasport.core.tools.FastDFSTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
}
