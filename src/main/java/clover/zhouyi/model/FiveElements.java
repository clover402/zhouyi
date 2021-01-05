package clover.zhouyi.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FiveElements {
    //       火 (南）
    // 木    土     金
    //       水（北）
    JIN("金", "坚固", "肺"),
    MU("木", "生", "肝"),
    SHUI("水", "流动", "肾"),
    HUO("火", "热能", "心"),
    TU("土", "地球", "脾"),
    ;

    private final String name;

    private final String description;

    public final String viscus;//内脏


    //生
    public FiveElements getBirth() {
        switch(this) {
            case JIN:
                return TU;
            case MU:
                return SHUI;
            case SHUI:
                return JIN;
            case HUO:
                return MU;
            case TU:
                return HUO;
            default:
                return null;
        }
    }

    //克
    public FiveElements getRestrain() {
        switch(this) {
            case JIN:
                return MU;
            case MU:
                return TU;
            case SHUI:
                return HUO;
            case HUO:
                return JIN;
            case TU:
                return SHUI;
            default:
                return null;
        }
    }
}
