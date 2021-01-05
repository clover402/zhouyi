package clover.zhouyi.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TianGan {
    //         丙丁 （南）
    //  甲乙   戊己   庚辛
    //         壬癸 （北）
    JIA("甲", 0b1),
    YI("乙", 0b0),
    BING("丙", 0b1),
    DIN("丁", 0b0),
    WU("戊", 0b1),

    JI("己", 0b0),
    GENG("庚", 0b1),
    XIN("辛", 0b0),
    REN("壬", 0b1),
    GUI("癸", 0b0),
    ;


    public final String name;
    public final int code;
}
