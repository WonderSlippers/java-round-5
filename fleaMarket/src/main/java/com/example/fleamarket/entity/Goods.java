package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@TableName("goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("商品类")
public class Goods extends AbstractAuditingEntity {
	@ApiModelProperty("商品id")
	int goodId;
	@ApiModelProperty("用户的id")
	int  userId;
	@ApiModelProperty("商品价格")
	double price;
	@ApiModelProperty("分类的id")
	int categoryId;
	@ApiModelProperty("名称")
	String goodName;
	@ApiModelProperty("简介")
	String summary;
	@ApiModelProperty("审核情况")
	Boolean approved;
	@ApiModelProperty("详情介绍")
	String detail;
	@ApiModelProperty("图片")
	String image;
	@ApiModelProperty("出售情况")
	Boolean isSold;
	@ApiModelProperty("点击数")
	int clickAmount;
	@ApiModelProperty("上架时间")
	String time;
	@ApiModelProperty("商品的类别")
	String goodSort;
	@ApiModelProperty("乘数，用于推荐排序，默认值为10000")
	int multiplier;
	@ApiModelProperty("加数，用于推荐排序，默认值为0。排序值为：推荐数*乘数+加数")
	int addend;
}
