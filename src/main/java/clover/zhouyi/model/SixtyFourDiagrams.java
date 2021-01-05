package clover.zhouyi.model;

import lombok.AllArgsConstructor;

import java.util.List;


/**
 * 64卦
 */
@AllArgsConstructor
public enum SixtyFourDiagrams {
    //乾一（金
    QIAN(0b111111, EightDiagrams.QIAN, EightDiagrams.QIAN, "乾", "☰☰", "乾为天"),
    GOU(0b111110, EightDiagrams.QIAN, EightDiagrams.XUN,  "姤", "☰☴", "天风姤"),//一爻变
    DUN(0b111100, EightDiagrams.QIAN, EightDiagrams.GEN, "遁", "☰☶", "天山遁"),//二爻变
    PI(0b111000, EightDiagrams.QIAN, EightDiagrams.KUN, "否", "☰☷", "天地否"),//三爻变
    GUAN(0b110000, EightDiagrams.XUN, EightDiagrams.KUN, "观", "☴☷", "风地观"),//四爻变
    BO(0b100000, EightDiagrams.GEN, EightDiagrams.KUN, "剥", "☶☷", "山地剥"),//五爻变

    JIN(0b101000, EightDiagrams.LI, EightDiagrams.KUN, "晋", "☲☷", "火地晋"),//外一爻变-游魂卦
    DAYOU(0b101111, EightDiagrams.LI, EightDiagrams.QIAN, "大有", "☲☰", "火天大有"),//内爻还原-归魂卦

    //兑二 （金
    ZE(0b011011, EightDiagrams.DUI, EightDiagrams.DUI, "泽", "☱☱", "兑为泽"),
    KUN(0b011010, EightDiagrams.DUI, EightDiagrams.KAN, "困", "☱☵", "泽水困"),
    CUI(0b011000, EightDiagrams.DUI, EightDiagrams.KUN, "萃", "☱☷", "泽地萃"),
    XIAN(0b011100, EightDiagrams.DUI, EightDiagrams.GEN, "咸", "☱☶", "泽山咸"),
    JIAN(0b010100, EightDiagrams.KAN, EightDiagrams.GEN, "蹇", "☵☶", "水山蹇"),
    QIAN1(0b000100, EightDiagrams.KUN, EightDiagrams.GEN, "谦", "☷☶", "地山谦"),

    XIAOGUO(0b001100, EightDiagrams.ZHEN, EightDiagrams.GEN, "小过", "☳☶", "雷山小过"),
    GUIMEI(0b001011, EightDiagrams.ZHEN, EightDiagrams.DUI, "归妹", "☳☱", "雷泽归妹"),

    //离三 （火
    HUO(0b101101, EightDiagrams.LI, EightDiagrams.LI, "火", "☲☲", "离为火"),
    LV(0b101100, EightDiagrams.LI, EightDiagrams.GEN, "旅", "☲☶", "火山旅"),
    DING(0b101110, EightDiagrams.LI, EightDiagrams.XUN, "鼎", "☲☴", "火风鼎"),
    WEIJI(0b101010, EightDiagrams.LI, EightDiagrams.KAN, "未济", "☲☵", "火水未济"),
    MENG(0b100010, EightDiagrams.GEN, EightDiagrams.KAN, "蒙", "☶☵", "山水蒙"),
    HUAN(0b110010, EightDiagrams.XUN, EightDiagrams.KAN, "涣", "☴☵", "风水涣"),

    SONG(0b111010, EightDiagrams.QIAN, EightDiagrams.KAN, "讼", "☰☵", "天水讼"),
    TONGREN(0b111101, EightDiagrams.QIAN, EightDiagrams.LI, "同人", "☰☲", "天火同人"),

    //震四 （木
    LEI(0b001001, EightDiagrams.ZHEN, EightDiagrams.ZHEN, "雷", "☳☳", "震为雷"),
    YU(0b001000, EightDiagrams.ZHEN, EightDiagrams.KUN, "豫", "☳☷", "雷地豫"),
    XIE(0b001010, EightDiagrams.ZHEN, EightDiagrams.KAN, "解", "☳☵", "雷水解"),
    HENG(0b001110, EightDiagrams.ZHEN, EightDiagrams.XUN, "恒", "☳☴", "震风恒"),
    SHENG(0b000110, EightDiagrams.KUN, EightDiagrams.XUN, "升", "☷☴", "地风升"),
    JING(0b010110, EightDiagrams.KAN, EightDiagrams.XUN, "井", "☵☴", "水风井"),

    DAGUO(0b011110, EightDiagrams.DUI, EightDiagrams.XUN, "大过", "☱☴", "泽风大过"),
    SUI(0b011001, EightDiagrams.DUI, EightDiagrams.ZHEN, "随", "☱☳", "泽雷随"),

    //巽五 （木
    FENG(0b110110, EightDiagrams.XUN, EightDiagrams.XUN, "风", "☴☴", "巽为风"),
    XIAOCHU(0b110111, EightDiagrams.XUN, EightDiagrams.QIAN, "小畜", "☴☰", "风天小畜"),
    JIAREN(0b110101, EightDiagrams.XUN, EightDiagrams.LI, "家人", "☴☲", "风火家人"),
    YI(0b110001, EightDiagrams.XUN, EightDiagrams.ZHEN, "益", "☴☳", "风雷益"),
    WUWANG(0b111001, EightDiagrams.QIAN, EightDiagrams.ZHEN, "无妄", "☰☳", "天雷无妄"),
    SHIHE(0b101001, EightDiagrams.LI, EightDiagrams.ZHEN, "噬嗑", "☲☳", "火雷噬嗑"),

    YI2(0b100001, EightDiagrams.GEN, EightDiagrams.ZHEN, "颐", "☶☳", "山雷颐"),
    GU(0b100110, EightDiagrams.GEN, EightDiagrams.XUN, "蛊", "☶☴", "山风蛊"),

    //坎六 (0b111111, 水
    SHUI(0b010010, EightDiagrams.KAN, EightDiagrams.KAN, "水", "☵☵", "坎为水"),
    JIE(0b010011, EightDiagrams.KAN, EightDiagrams.DUI, "节", "☵☱", "水泽节"),
    TUN(0b010001, EightDiagrams.KAN, EightDiagrams.ZHEN, "屯", "☵☳", "水雷屯"),
    JIJI(0b010101, EightDiagrams.KAN, EightDiagrams.LI, "既济", "☵☲", "水火既济"),
    GE(0b011101, EightDiagrams.DUI, EightDiagrams.LI, "革", "☱☲", "泽火革"),
    FENG1(0b001101, EightDiagrams.ZHEN, EightDiagrams.LI, "丰", "☳☲", "雷火丰"),

    MINGYI(0b000101, EightDiagrams.KUN, EightDiagrams.LI, "丰", "☷☲", "地火明夷"),
    SHI(0b000010, EightDiagrams.KUN, EightDiagrams.KAN, "师", "☷☵", "地水师"),

    // 艮七 （土
    SHAN(0b100100, EightDiagrams.GEN, EightDiagrams.GEN, "山", "☶☶", "艮为山"),
    BEN(0b100101, EightDiagrams.GEN, EightDiagrams.LI, "贲", "☶☲", "山火贲"),
    DACHU(0b100111, EightDiagrams.GEN, EightDiagrams.QIAN, "大畜", "☶☰", "山天大畜"),
    SUN(0b100011, EightDiagrams.GEN, EightDiagrams.DUI, "损", "☶☱", "山泽损"),
    KUI(0b101011, EightDiagrams.LI, EightDiagrams.DUI, "睽", "☲☱", "火泽睽"),
    LV3(0b111011, EightDiagrams.QIAN, EightDiagrams.DUI, "履", "☰☱", "天泽履"),

    ZHONGFU(0b110011, EightDiagrams.XUN, EightDiagrams.DUI, "中孚", "☴☱", "风泽中孚"),
    JIAN4(0b110100, EightDiagrams.XUN, EightDiagrams.GEN, "渐", "☴☶", "风山渐"),

    // 坤八  （土
    KUN1(0b000000, EightDiagrams.KUN, EightDiagrams.KUN, "坤", "☷☷", "坤为地"),
    FU(0b000001, EightDiagrams.KUN, EightDiagrams.ZHEN, "复", "☷☳", "地雷复"),
    LIN(0b000011, EightDiagrams.KUN, EightDiagrams.DUI, "临", "☷☱", "地泽临"),
    TAI(0b000111, EightDiagrams.KUN, EightDiagrams.QIAN, "泰", "☷☰", "地天泰"),
    DAZHUANG(0b001111, EightDiagrams.ZHEN, EightDiagrams.QIAN, "大壮", "☳☰", "雷天大壮"),
    JUE(0b011111, EightDiagrams.DUI, EightDiagrams.QIAN, "夬", "☱☰", "泽天夬"),

    XU(0b010111, EightDiagrams.KAN, EightDiagrams.QIAN, "需", "☵☰", "水天需"),
    BI(0b010000, EightDiagrams.KAN, EightDiagrams.KUN, "比", "☵☷", "水地比"),

    ;
    public final int code;
    public final EightDiagrams upDiagram;
    public final EightDiagrams downDiagram;

    public final String name;
    public final String diagram;
    public final String description;

    //获取综卦
    public SixtyFourDiagrams getZongDiagram()  {
        return null;
    }
    //获取错卦
    public SixtyFourDiagrams getCuoDiagram()  {
        return null;
    }
    //获取交互卦
    public SixtyFourDiagrams getJiaoHuDiagram()  {
        return null;
    }


    public static final int LENGTH = 64;

    public static SixtyFourDiagrams valueOf(EightDiagrams upDiagram, EightDiagrams downDiagram) {
        for (SixtyFourDiagrams diagram : SixtyFourDiagrams.values()) {
            if (diagram.upDiagram == upDiagram && diagram.downDiagram == downDiagram) {
                return diagram;
            }
        }

        return null;
    }

    public static SixtyFourDiagrams valueOf(int code) {
        for (SixtyFourDiagrams diagram : SixtyFourDiagrams.values()) {
            if (diagram.code == code) {
                return diagram;
            }
        }

        return null;
    }

    //方圆图之方图【空间】
    public final static SixtyFourDiagrams[][] SquareDiagrams = new SixtyFourDiagrams[EightDiagrams.LENGTH][EightDiagrams.LENGTH];
    static {
        List<EightDiagrams> fuxi = EightDiagrams.FuxiEightDiagrams;
        for( int i = EightDiagrams.LENGTH; i > 0; i--) {
            for (int j = EightDiagrams.LENGTH; j > 0; j--) {
                SquareDiagrams[i - 1][j - 1] = valueOf(fuxi.get(EightDiagrams.LENGTH - j), fuxi.get(EightDiagrams.LENGTH - i));
            }
        }
    }

    //方圆图之圆图【时间】
    public final static SixtyFourDiagrams[] CircleDiagrams = new SixtyFourDiagrams[LENGTH];
    static {
        int i = 0;
        for (int left = EightDiagrams.LENGTH; left > 4; left--) {
            for (int column = EightDiagrams.LENGTH; column > 0; column--) {
                CircleDiagrams[i] = SquareDiagrams[left - 1][column - 1];
                i++;
            }
        }

        for (int right = 1; right <= 4; right++) {
            for (int column = 1; column <= EightDiagrams.LENGTH; column++) {
                CircleDiagrams[i] = SquareDiagrams[right - 1][column - 1];
                i++;
            }
        }
    }
}
