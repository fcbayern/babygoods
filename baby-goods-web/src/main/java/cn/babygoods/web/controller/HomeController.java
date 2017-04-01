package cn.babygoods.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jj_zhu on 2017-03-13.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String index(){
        return "index";
    }
}
