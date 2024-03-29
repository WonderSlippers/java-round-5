package com.example.fleamarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fleamarket.dao.IPostsDao;
import com.example.fleamarket.entity.Category;
import com.example.fleamarket.entity.Posts;
import com.example.fleamarket.service.IPostsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService extends ServiceImpl<IPostsDao, Posts> implements IPostsService {
    @Override
    public Posts queryById(int postId) {
        return getOne(new LambdaQueryWrapper<Posts>()
                .eq(Posts::getPostId,postId)

        );
    }

    @Override
    public boolean insert(int postId, int buyerId, String description) {
        Posts posts=new Posts();
        posts.setPostId(postId);
        posts.setBuyerId(buyerId);
        posts.setDescription(description);
        save(posts);
        return save(posts);
    }

    public Boolean remove(int postId) {
        LambdaQueryWrapper<Posts> lwq = Wrappers.lambdaQuery();
        lwq.eq(Posts::getPostId,postId);
        return remove(lwq);
    }

    @Override
    public List<Category> findCategorylist(int postId) {
        return getBaseMapper().getCategoryByPostId(postId);
    }

    @Override
    public boolean addCategory(int postID, List<Category> categoryList) {
        for (Category c : categoryList
        ) {
            getBaseMapper().addCategory(postID, c.getCategoryId());
        }
        ;
        return false;
    }


}
