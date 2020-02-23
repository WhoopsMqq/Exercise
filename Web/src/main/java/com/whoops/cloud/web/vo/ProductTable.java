package com.whoops.cloud.web.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTable {
    private Integer code;

    private String msg;

    private Integer count;

    private Object data;

    public ProductTable(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
