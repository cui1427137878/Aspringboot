package com.tedu.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

//接收浏览器上传的文件
@RestController
public class UploadController {
    //<input type=file name=myFiles>
    @RequestMapping("/upload.do")
    public String upload (
        @RequestParam MultipartFile[] myFiles,
        HttpServletRequest request
    )throws Throwable{
        for (MultipartFile file:myFiles){
            if (file.isEmpty()){
                System.out.println("上传文件为空");
            }else {
                System.out.println(file.getName());
                String path=request.getSession().getServletContext()
                        .getRealPath("/uploadFiles");
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                       new File(path,file.getOriginalFilename()));
                return path;

            }
        }
        return "error";
    }
}
