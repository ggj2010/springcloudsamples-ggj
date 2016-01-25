package com.ggj.bean;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * author:gaoguangjin
 * Description:
 * Email:335424093@qq.com
 * Date 2016/1/25 15:07
 */
@Getter
@Setter
public class Message implements Serializable {
    private static final long serialVersionUID = 5586171996292263482L;
    private String message;
    private Map<Object,Object> data;
}
