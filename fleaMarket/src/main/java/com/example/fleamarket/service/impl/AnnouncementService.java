package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IAnnouncementDao;
import com.example.fleamarket.entity.Announcement;
import com.example.fleamarket.service.IAnnouncementService;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService extends ServiceImpl<IAnnouncementDao, Announcement> implements IAnnouncementService {
    public Boolean insert(String context){
        Announcement announcement = new Announcement();
        announcement.setContext(context);
        return save(announcement);
    }
    public Boolean remove(int announcementId) {
        LambdaQueryWrapper<Announcement> lwq = Wrappers.lambdaQuery();
        lwq.eq(Announcement::getAnnouncementId,announcementId);
        return remove(lwq);
    }
    public IPage<Announcement> findByPage(Page<Announcement> page,LambdaQueryWrapper<Announcement> userLambdaQueryWrapper){
        return  baseMapper.selectPage(page,userLambdaQueryWrapper);
    }
}
