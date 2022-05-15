package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@TableName("goodReport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodReport {
    @ApiModelProperty("审核记录id")
    int reportId;
    @ApiModelProperty("商品的id")
    int goodId;
    @ApiModelProperty("举报理由")
    String context;
    @ApiModelProperty("审核情况")
    String status;
}
