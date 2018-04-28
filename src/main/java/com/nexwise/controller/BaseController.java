package com.nexwise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi() {
        return "hello";
    }

    @GetMapping("login")
    public String toLoginPage() {
        return "login";
    }

    @PostMapping(value = "loginSubmit")
    @ResponseBody
    public String loginMethod() {

        return null;
    }

}
