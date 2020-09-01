package com.gj.edu.controller;

import com.gj.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author GuoJun
 * @date 2020/8/31 21:18
 * @email 864350301@qq.com
 */
@RequestMapping("eudService/user")
@RestController
@CrossOrigin
public class LoginController {

    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
