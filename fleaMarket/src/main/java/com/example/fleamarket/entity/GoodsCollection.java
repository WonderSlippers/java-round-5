package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@TableName("goods_collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "收藏")
public class GoodsCollection {
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("用户的id")
	Integer userId;
	@ApiModelProperty("商品的id")
	Integer goodId;
}
