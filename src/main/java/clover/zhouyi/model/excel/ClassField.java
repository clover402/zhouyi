package clover.zhouyi.model.excel;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class ClassField {
    private String comment;

    private FieldType fieldType;

    private String fieldName;

    private String mark;

    private boolean notnull;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.hasLength(comment)) {
            sb.append("    //").append(comment);
            if (StringUtils.hasLength(mark)) {
                sb.append("(").append(mark).append(")");
            }
        } else if (StringUtils.hasLength(mark)) {
            sb.append("    //").append(mark);
        }

        if(sb.length() > 0) {
            sb.append("\n");
        }

        sb.append("    private ").append(fieldType.name()).append(" ").append(fieldName).append(";");

        return sb.toString();
    }
}
