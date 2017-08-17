package com.babasport.core.tools;

import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * FastDFS工具类
 * Created by hwd on 2017/8/16.
 */
public class FastDFSTool {

    /**
     * 上传文件到FastDFS
     * @param bs 文件字节数组
     * @param filename 文件名
     * @return 上传成功后，存放在fastdfs中的文件位置及文件名
     * @throws Exception
     */
    public static String uploadFile(byte[] bs,String filename) throws Exception {
        // 获得classpath下文件的绝对路径
        ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
        // 初始化客户端
        ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
        // 创建老大客户端
        TrackerClient trackerClient = new TrackerClient();
        // 通过老大客户端取得连接
        TrackerServer connection = trackerClient.getConnection();
        // 创建小弟客户端
        StorageClient1 storageClient1 = new StorageClient1(connection,null);
        // 获得文件拓展名
        String extension = FilenameUtils.getExtension(filename);
        // 通过小弟客户端开始上传文件，并返回存放在fastdfs中的文件位置及文件名
        String upload_file1 = storageClient1.upload_file1(bs,extension,null);

        return upload_file1;
    }
}
