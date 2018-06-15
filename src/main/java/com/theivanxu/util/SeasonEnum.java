package com.theivanxu.util;

/**
 * Created by theivanxu on 2018/5/4.
 */
public enum SeasonEnum {

    SPRING(0, "春季"),
    SUMMER(1, "夏季"),
    AUTUMN(2, "秋季"),
    WINTER(3, "冬季");

    private SeasonEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private Integer value;

    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SeasonEnum parse(Integer value){
        for (SeasonEnum seasonEnum :
                SeasonEnum.values()) {
            if (seasonEnum.getValue().equals(value)) {
                return seasonEnum;
            }
        }

        return null;
    }
}
