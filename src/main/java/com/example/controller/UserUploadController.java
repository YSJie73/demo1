package com.example.controller;



import com.example.config.MiniAppConfig;
import com.example.tools.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserUploadController extends BaseController {

    @PostMapping("/upload")
    public Object Upload(@RequestParam("file") MultipartFile mf){
        Map<String,Object> respMap=new HashMap<>();

        try{
            // 拿到上传文件的文件名
            String originalFilename = mf.getOriginalFilename();
            // 保存文件
            String uploadPath= MiniAppConfig.getUploadPath()+"/"+mf.getOriginalFilename();
            mf.transferTo(new File(uploadPath));

            respMap.put("upload_file",originalFilename);
        } catch (IOException e) {
            return e.getMessage();
        }

        return this.RespInfo(1,"",respMap);
    }


}
