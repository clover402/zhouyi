package clover.zhouyi.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 八卦
 */
@AllArgsConstructor
public enum EightDiagrams {

    QIAN(0b111, "乾", "☰", "天", FiveElements.JIN),
    KUN(0b000, "坤", "☷", "地", FiveElements.TU),

    LI(0b101, "离", "☲", "日", FiveElements.HUO),
    KAN(0b010, "坎", "☵", "月", FiveElements.SHUI),

    ZHEN(0b001, "震", "☳", "雷", FiveElements.MU),
    XUN(0b110, "巽", "☴", "风", FiveElements.MU),

    GEN(0b100, "艮", "☶", "山", FiveElements.TU),
    DUI(0b011, "兑", "☱", "泽", FiveElements.JIN),
    ;

    public final int code;
    public final String name;
    public final String diagram;
    public final String description;
    public final FiveElements element;

    public final static int LENGTH = 8;
    /**
     * 伏羲八卦，先天八卦
     *            南
     *       DUI(2)  QIAN(1)  XUN(5)
     *       LI(3)     9      KAN(6)
     *       ZHEN(4)  KUN(8)  GEN(7)
     *             北
     */
    public final static List<EightDiagrams> FuxiEightDiagrams = Collections.unmodifiableList(Arrays.asList(QIAN, DUI, LI, ZHEN, XUN, KAN, GEN, KUN, null));
    public final static List<EightDiagrams> NatureEightDiagrams = FuxiEightDiagrams;

    /**
     * 文王八卦，后天八卦
     *          南
     *    XUN(4)   LI(9)  KUN(2)
     *    ZHEN(3)   5     DUI(7)
     *    GEN(8)  KAN(1)  QIAN(6)
     *          北
     */
    public final static List<EightDiagrams> WenwangEightDiagrams = Collections.unmodifiableList(Arrays.asList(KAN, KUN, ZHEN, XUN, null, QIAN, DUI, GEN, LI));
    public final static List<EightDiagrams> NurtureEightDiagrams = WenwangEightDiagrams;
}
