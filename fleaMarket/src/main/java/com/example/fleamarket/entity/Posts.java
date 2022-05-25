package com.example.fleamarket.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@TableName("posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("帖子")
public class Posts{
    @TableId
    @ApiModelProperty("帖子id")
    int postId;
    @ApiModelProperty("寻物用户的id")
    int buyerId;
    @ApiModelProperty("求物描述")
    String description;
    @ApiModelProperty("话题分类")
    @TableField(exist = false)
    List<Category> categoryList;
    @ApiModelProperty("回复列表")
    @TableField(exist = false)
    List<Reply>replyList;



}
