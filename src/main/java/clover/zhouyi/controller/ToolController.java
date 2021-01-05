package clover.zhouyi.controller;

import clover.zhouyi.model.excel.ColumnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import clover.zhouyi.service.ExcelHelper;

import java.util.List;

@RestController
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    private ExcelHelper excelHelper;

    //将excel转为Class文件
    @PostMapping("/excel-to-class")
    public void excelToClassFile(@RequestParam(value = "column", required = false) List<ColumnType> columns,
                                 @RequestPart(value = "files") MultipartFile[] multipartFiles) {
        excelHelper.excelsToClass(columns, multipartFiles);
    }
}
