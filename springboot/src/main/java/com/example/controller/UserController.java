package com.example.controller;

import com.example.common.Result;
import com.example.pojo.Params;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

/*    @GetMapping("/getUser")
    public Result getUser() {
        List<User> list = userService.getUser();
        return Result.success(list);
    }*/

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User loginUser = userService.login(user);
        return Result.success(loginUser);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.add(user);
        return Result.success();
    }

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        PageInfo<User> info = userService.findBySearch(params);
        return Result.success(info);
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody User user) {
        User changePasswordUser = userService.changePassword(user);
        return Result.success(changePasswordUser);
    }

    @PostMapping("/changeEmail")
    public Result changeEmail(@RequestBody User user) {
        User changeEmailUser = userService.changeEmail(user);
        return Result.success(changeEmailUser);
    }

}
