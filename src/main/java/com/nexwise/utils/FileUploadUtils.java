package com.nexwise.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FileUploadUtils {

    @RequestMapping(value = "/upload")
    public String fileUpload(HttpServletRequest req, HttpServletResponse res) {
        System.out.println(req.getParameter("picker"));
        return "hello";
    }

}
