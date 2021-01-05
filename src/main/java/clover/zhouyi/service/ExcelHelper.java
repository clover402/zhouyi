package clover.zhouyi.service;

import clover.zhouyi.model.excel.ClassField;
import clover.zhouyi.model.excel.ColumnType;
import clover.zhouyi.model.excel.FieldType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExcelHelper {
    private String pathToSaveClass = System.getProperty("user.dir") + "\\src\\main\\java\\clover\\zhouyi\\generate\\";

    public void excelsToClass(List<ColumnType> columns, MultipartFile[] multipartFiles) {
        for (MultipartFile file: multipartFiles) {
            excelToClassFile(columns, file);
        }
    }

    private void excelToClassFile(List<ColumnType> columns, MultipartFile file) {
        if (file == null) {
            throw new IllegalArgumentException("excel file is null!");
        }

        try {
            InputStream inputStream = file.getInputStream();
            Workbook wb;
            if (file.getOriginalFilename().endsWith(".xlsx")) {
               wb  = new XSSFWorkbook(inputStream);
            }
            else if (file.getOriginalFilename().endsWith(".xls")) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                throw new IllegalArgumentException("file is not excel!");
            }

            //获取数据sheet
            Sheet dataSheet = wb.getSheetAt(0);
            List<ClassField> fields = parseClassFields(columns, dataSheet);
            String className = dataSheet.getSheetName();
            fieldsToClassFile(className, fields);

        } catch (IOException e) {
            throw new IllegalArgumentException("generate excel file fail!");
        }
    }


    public void fieldsToClassFile(String className, List<ClassField> fields) {
        String classFileTemplate = "package clover.zhouyi.generate;\n" +
                "\n" +
                "import lombok.Data;\n" +
                "%s" +
                "\n" +
                "@Data\n" +
                "public class %s {\n" +
                "%s\n" +
                "}";
        String dateImport = "import java.util.Date;\n";
        String fieldString = fields.stream().map(ClassField::toString).collect(Collectors.joining("\n\n"));
        String importString = "";
        if (fieldString.contains(" Date ")) {
            importString = dateImport;
        }
        String fileContent = String.format(classFileTemplate, importString, className, fieldString);

        //write to file
        String filePath = pathToSaveClass + className + ".java";
        writeToFile(filePath, fileContent);
    }

    public void writeToFile(String filePath, String fileContent) {
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //创建字符流（使用字节流比较麻烦）
            FileWriter fw = new FileWriter(file);
            //判断file是否存在
            if (!file.exists()) {
                //如果不存在file文件，则创建
                file.createNewFile();
            }
            fw.write(fileContent);
            fw.flush();
            fw.close();
        } catch (IOException ioe) {
            throw new RuntimeException("write file error:" + ioe.getMessage());
        }

    }

    public List<ClassField> parseClassFields(List<ColumnType> columns, Sheet dataSheet) {
        List<ClassField> fields = new ArrayList<>();

        int dataBeginRow = 0;
        if(CollectionUtils.isEmpty(columns)) {
            //获取excel文件中隐藏的驼峰字段名
            columns = new ArrayList<>();
            //获取属性名row
            Row titleRow = dataSheet.getRow(0);
            for (int i = 0; i < titleRow.getLastCellNum(); i++) {
                columns.add(ColumnType.valueOf(titleRow.getCell(i).getStringCellValue()));
            }
            dataBeginRow = 1;
        }


        for (int i = dataBeginRow; i < dataSheet.getPhysicalNumberOfRows(); i++) {
            //获取每一行的数据
            Row dataRow = dataSheet.getRow(i);

            //读取到数据没有数据的时候，结束读取
            if (dataRow == null) {
                break;
            }
            ClassField field = new ClassField();
            for (int j = 0; j < columns.size(); j++) {
                String value = dataRow.getCell(j).getStringCellValue();
                if (!StringUtils.hasLength(value)) {
                    continue;
                }
                value = value.trim();

                //获取字段列表
                switch(columns.get(j)) {
                    case COMMENT:
                        field.setComment(value.replace("\n", " "));
                        break;
                    case TYPE:
                        value = value.toLowerCase();

                        if (value.startsWith("string") || value.startsWith("varchar") || value.startsWith("char")) {
                            field.setFieldType(FieldType.String);
                        } else if (value.startsWith("date")) {
                            field.setFieldType(FieldType.Date);
                        } else if (value.startsWith("int")) {
                            field.setFieldType(FieldType.Integer);
                        }
                        break;
                    case NAME:
                        field.setFieldName(value);
                        break;
                    case MARK:
                        field.setMark(value.replace("\n", " "));
                        break;
                    case NOTNULL:
                        value = value.toLowerCase();
                        if ("y".equals(value) || value.startsWith("yes"))
                            field.setNotnull(true);
                    default:
                        break;
                }
            }
            if (StringUtils.hasLength(field.getFieldName()) && field.getFieldType() != null) {
                fields.add(field);
            }
        }
        return fields;
    }

}
