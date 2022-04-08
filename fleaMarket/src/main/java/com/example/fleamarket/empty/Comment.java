package com.example.fleamarket.empty;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@TableName("comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户评价")
public class Comment extends AbstractAuditingEntity {
	@ApiModelProperty("主键，自增")
	int commentId;
	@ApiModelProperty("评价用户的id")
	int commentUserId;
	@ApiModelProperty("被评价用户的id")
	int beCommentedUserId;
	@ApiModelProperty("评论的内容")
	String content;
}
