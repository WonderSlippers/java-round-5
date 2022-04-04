package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.empty.Order;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/order")
public class OrderController {
    @Autowired
    IOrderService iOrderService;
    @ApiOperation("用户购买信息查询接口")
    @GetMapping("/buy")
    public ResultVo buy(int buyerId){
        return new ResultVo().setData(iOrderService.list(new LambdaQueryWrapper<Order>()
                .eq(Order::getBuyerId,buyerId))
        );
    }
    @ApiOperation("用户出售信息查询接口")
    @GetMapping("/sold")
    public ResultVo sold(int orderId){
        return new ResultVo().setData(iOrderService.list(new LambdaQueryWrapper<Order>()
                .eq(Order::getSolderId,orderId))
        );
    }
    @ApiOperation("用户取消订单接口")
    @GetMapping("/cancel")
    public ResultVo cancel(int userId){
        return new ResultVo().setData(iOrderService.remove(userId));
    }
    @ApiOperation("用户修改订单接口")
    @GetMapping("/baseUpdate")
    public ResultVo baseUpdate(String buyerName,String phoneNumber){
        return new ResultVo().setData(iOrderService.baseUpdate(buyerName,phoneNumber));
    }
    @ApiOperation("用户收货接口")
    @GetMapping("/update")
    public ResultVo statusUpdate(){
        return new ResultVo().setData(iOrderService.statusUpdate());
    }

}
