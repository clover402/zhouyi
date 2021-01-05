package clover.zhouyi.model;

import lombok.AllArgsConstructor;

//地支
@AllArgsConstructor
public enum DiZhi {
    ZI("子", "鼠"),
    CHOU("丑", "牛"),
    YIN("寅", "虎"),
    MAO("卯", "兔"),
    CHEN("辰", "龙"),
    SI("巳", "蛇"),

    WU("午", "马"),
    WEI("未", "羊"),
    SHEN("申", "猴"),
    YOU("酉", "鸡"),
    XU("戌", "狗"),
    HAI("亥", "猪"),

    ;

    public final String name;

    //生肖
    public final String cnZodiac;
}
