package com.hbq.cms.common.controller;

import cn.hutool.core.util.ObjectUtil;
import com.hbq.cms.common.model.FileVo;
import com.hbq.cms.util.MinioUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 测试MinIO文件系统
 */
@Slf4j
@CrossOrigin
@Api(tags = "文件")
@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {

    @ApiOperation(value = "创建文件夹")
    @PostMapping("/createBucket")
    public void createBucket(String bucketName) {
        MinioUtil.createBucket(bucketName);
    }

    @ApiOperation(value = "上传文件返回url")
    @PostMapping("/upload")
    public String MinIOUpload(String bucketName, MultipartFile file) throws Exception {
        if (ObjectUtil.isEmpty(bucketName)) {
            bucketName = "file";
        }
        return MinioUtil.uploadPreview(bucketName, file);
    }

    @ApiOperation(value = "下载文件")
    @PostMapping("/download")
    public void download(String bucketName, String fileName, HttpServletResponse response) {
        MinioUtil.download(bucketName, fileName, response);
    }

    @ApiOperation(value = "删除文件")
    @PostMapping("/deleteFile")
    public void deleteFile(String bucketName, String fileName) {
        MinioUtil.remove(bucketName, fileName);
    }

    @ApiOperation(value = "获取当前文件夹下文件")
    @PostMapping("/list")
    public List<FileVo> list(String bucketName) {
        return MinioUtil.listObjectNames(bucketName);
    }

}

