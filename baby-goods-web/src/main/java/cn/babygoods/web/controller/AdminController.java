package cn.babygoods.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vincent on 2017/3/21.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("/")
    public String index(){
        return "admin/index";
    }
}
