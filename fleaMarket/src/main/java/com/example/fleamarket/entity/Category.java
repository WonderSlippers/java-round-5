package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "商品分类")
public class Category{
	@TableId(type = IdType.AUTO)
	@ApiModelProperty("主键，自增")
	int CategoryId;
	@ApiModelProperty("名称")
	String goodSort;
	@ApiModelProperty("描述")
	String goodDescribe;
	/*@ApiModelProperty("分类级别，1是一级分类，2是二级分类")
	Integer rank;
	@ApiModelProperty("父分类的id，若无父分类，则为0")
	Integer parentId;*/
}
