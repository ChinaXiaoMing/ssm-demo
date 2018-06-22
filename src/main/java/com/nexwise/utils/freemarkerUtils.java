package com.nexwise.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class freemarkerUtils {

    private static final String TEMPLATE_PATH = "src/main/webapp/static/template/";

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        Template template = configuration.getTemplate("hello.html");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", "我正在学习使用Freemarker生成静态文件！");
        Writer writer  = new OutputStreamWriter(new FileOutputStream("src/main/webapp/WEB-INF/pages/hello1.html"),"UTF-8");
        template.process(paramMap, writer);
        System.out.println("页面生成成功！");
    }

}
