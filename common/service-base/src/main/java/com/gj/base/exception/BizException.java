package com.gj.base.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BizException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;
}
