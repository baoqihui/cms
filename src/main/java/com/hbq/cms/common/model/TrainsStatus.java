package com.hbq.cms.common.model;

/**
 * @Author: huibq
 * @Date: 2022/5/7 15:47
 * @Description: 验证码类型
 */
public enum TrainsStatus {
    /**
     * 开始
     */
    START(0, "开始"),
    /**
     * 进行中
     * */
    STARTING(1, "进行中"),
    /**
     * 已完成
     */
    END(2, "已完成");

    private Integer code;
    private String desc;

    TrainsStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
