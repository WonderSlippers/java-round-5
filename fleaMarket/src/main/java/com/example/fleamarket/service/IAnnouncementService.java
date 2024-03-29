package com.example.fleamarket.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fleamarket.entity.Announcement;

public interface IAnnouncementService extends IService<Announcement> {
    Boolean insert(String context);
    Boolean remove(int announcementId);
    IPage<Announcement> findByPage(Page<Announcement> page, LambdaQueryWrapper<Announcement> userLambdaQueryWrapper);
}
