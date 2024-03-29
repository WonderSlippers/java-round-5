package com.example.fleamarket.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.User;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserService iUserService;


    @ApiOperation("登录接口")
    @PostMapping("/login")
    public ResultVo login(@ApiParam("用户名") String username, @ApiParam("密码") String password) {
        log.info("登录接口");
        Subject subject = SecurityUtils.getSubject();
        User us = iUserService.queryById(username);
        if (us != null) {
            String salt = us.getSalt();
            password = new SimpleHash("md5", password, salt, 2).toString();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            System.out.println("认证状态："+subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态："+subject.isAuthenticated());
            System.out.println("user:"+subject.hasRole("user"));
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new ResultVo().setMessage("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new ResultVo().setMessage("密码错误");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("user", us);
        map.put("token", token);
        return new ResultVo().setCode(200).setMessage("登录成功").setData(map);
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public ResultVo register(@ApiParam("用户名")String username,@ApiParam("密码") String password) {
        log.info("注册接口");
        if (username == null || username.equals("")) {
            return new ResultVo().setMessage("用户名不能为空");
        } else if (password == null || password.equals("")) {
            return new ResultVo().setMessage("密码不能为空");
        } else if (iUserService.queryById(username) != null) {
            return new ResultVo().setMessage("用户名已被占用");
        } else {
            return new ResultVo().setData(iUserService.insertUser(username, password));
        }
    }

    @ApiOperation("登出接口")
    @GetMapping("/logout")
    public ResultVo logout() {
        log.info("登出接口");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultVo().setMessage("退出成功");
    }
    @ApiOperation("用户信息查询接口")
    @GetMapping("/select")
    public ResultVo select(@ApiParam("用户名") String username) {
        log.info("用户信息查询");
        Subject subject = SecurityUtils.getSubject();
        User us = iUserService.queryById(username);
        Map<String, Object> map = new HashMap<>();
        map.put("user", us);
        return new ResultVo().setCode(200).setMessage("登录成功").setData(map);
    }
    @ApiOperation("用户基础信息修改接口")
    @GetMapping("/baseMessageUpdate")
    public ResultVo baseUpdate(@ApiParam("用户id")int userId,@ApiParam("昵称")String nickname, @ApiParam("电话")String phone, @ApiParam("年龄")String age, @ApiParam("qq")String qq) {
        log.info("用户基础信息修改接口");
        return new ResultVo().setData(iUserService.updateUer(userId,nickname, phone, age, qq));
    }

    @ApiOperation("用户图片修改接口")
    @GetMapping("/photoUpdate")
    public ResultVo photoUpdate(@ApiParam("照片")MultipartFile file,@ApiParam("用户id") int userId) {
        return new ResultVo().setData(iUserService.updatePhoto(file, userId));
    }
    @RequiresRoles("admin")
    @ApiOperation("修改审核未通过用户不合格商品数接口")
    @GetMapping("/unqualifiedGoodsUpdate")
    public ResultVo photoUpdate(@ApiParam("用户名")String userName) {
        return new ResultVo().setData(iUserService.unqualifiedGoodsUpdate(userName));
    }
    @RequiresRoles("admin")
    @ApiOperation("查询不合规商品过多的用户")
    @GetMapping("/get")
    public ResultVo all(@ApiParam("当前页")int current,@ApiParam("大小")int size){
        Page<User> page = new Page<>(current, size);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.ge(User::getUnqualifiedGoods,10);
        return new ResultVo().setData(iUserService.findByPage(page,userLambdaQueryWrapper));
    }
    @RequiresRoles("admin")
    @ApiOperation("修改审核未通过用户不合格商品数接口")
    @GetMapping("/scoreUpdate")
    public ResultVo scoreUpdate(@ApiParam("用户名")String userName,double score) {
        return new ResultVo().setData(iUserService.scoreUpdate(userName,score));
    }
}
