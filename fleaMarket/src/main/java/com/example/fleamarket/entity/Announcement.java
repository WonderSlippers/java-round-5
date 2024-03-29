package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@TableName("announcement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement{
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("公告id")
    int announcementId;
    @ApiModelProperty("公告内容")
    String context;

}
