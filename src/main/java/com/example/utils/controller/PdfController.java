package com.example.utils.controller;

import com.example.utils.service.impl.PdfReportServiceImpl;
import com.example.utils.test.MyHeaderFooter;
import com.example.utils.test.Watermark;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author: Cc
 * @Date: 2021/8/9 9:51
 */
@RestController
@RequestMapping("pdf")
public class PdfController {

    @Autowired
    PdfReportServiceImpl pdfReportService;

    @GetMapping("create")
    public void getPdf() throws Exception {
        // 1.新建document对象
        // 建立一个Document对象
        Document document = new Document(PageSize.A4);
        // 2.建立一个书写器(Writer)与document对象关联
        File file = new File("C:\\Users\\lenovo\\Desktop\\offset-test.pdf");
        file.createNewFile();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // 水印
        writer.setPageEvent(new Watermark("PDF TEST"));
        // 页眉/页脚
        writer.setPageEvent(new MyHeaderFooter());

        // 3.打开文档
        document.open();
        // 标题
        document.addTitle("Title@PDF-Java");
        // 作者
        document.addAuthor("Author@umiz");
        // 主题
        document.addSubject("Subject@iText pdf sample");
        // 关键字
        document.addKeywords("Keywords@iTextpdf");
        // 创建者
        document.addCreator("Creator@umiz`s");

        // 4.向文档中添加内容
        pdfReportService.generatePDF(document);

        // 5.关闭文档
        document.close();
    }

}
