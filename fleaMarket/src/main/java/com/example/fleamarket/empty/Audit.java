package com.example.fleamarket.empty;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@TableName("audit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit extends AbstractAuditingEntity{
    @TableId
    @ApiModelProperty(" 审核记录id")
    int auditId;
    @ApiModelProperty("商品的id")
    int goodId;
    @ApiModelProperty("管理员id")
    int adminId;
    @ApiModelProperty("审核情况")
    Boolean status;
}
