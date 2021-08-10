package com.example.utils.test;


import com.example.utils.service.impl.PdfReportServiceImpl;
import com.example.utils.service.impl.PdfServiceImpl;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
/**
 * @Author: Cc
 * @Date: 2021/7/29 15:37
 */
public class Test {
    public static void main(String[] args) throws Exception {

        // 1.新建document对象
        // 建立一个Document对象
        Document document = new Document(PageSize.A4);

        // 2.建立一个书写器(Writer)与document对象关联
        File file = new File("C:\\Users\\lenovo\\Desktop\\bbb.pdf");
        file.createNewFile();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // 水印
        //writer.setPageEvent(new Watermark("HELLO ITEXTPDF"));
        // 页眉/页脚
        //writer.setPageEvent(new MyHeaderFooter());

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
        //new PdfReportServiceImpl().generatePDF(document);
        new PdfServiceImpl().generatePDF(document);

        // 5.关闭文档
        document.close();
    }

}
