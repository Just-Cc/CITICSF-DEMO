package com.example.utils.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;

/**
 * @Author: Cc
 * @Date: 2021/8/9 13:27
 */
@Service
public class PdfServiceImpl {

    // 定义全局的字体静态变量
    private static Font titlefont;
    private static Font headfont;
    private static Font keyfont;
    private static Font textfont;
    // 最大宽度
    private static int maxWidth = 520;
    // 静态代码块
    static {
        try {
            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            titlefont = new Font(bfChinese, 16, Font.BOLD);
            headfont = new Font(bfChinese, 14, Font.BOLD);
            keyfont = new Font(bfChinese, 10, Font.BOLD);
            textfont = new Font(bfChinese, 10, Font.NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成PDF
     */
    public void generatePDF(Document document) throws Exception {

        // 段落
        Paragraph titleParagraph = new Paragraph("大连商品交易所标准仓单作为保证金客户专项授权书", titlefont);
        setFormat(titleParagraph);
        Paragraph textParagraph1 = new Paragraph("大连商品交易所：", textfont);
        setFormat(textParagraph1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("兹专项委托中信期货有限公司(会员号：0110)：持本单位(客户交易编码：").append("xxxxxx").append(")的标准仓单(品种)").append("xxx").append("数量为").append("xxx")
                .append("手，前来办理标准仓单作为保证金有关事项，用于履行该会员在交易所的保证金和相关债务。与本授权书相应的协议编号授权会员代为填写。请予以办理为盼！");
        Paragraph textParagraph2 = new Paragraph(sb2.toString(), textfont);
        setFormat(textParagraph2);
        Paragraph textParagraph3 = new Paragraph("备注：仓库 xxx 数量(手) xxx",textfont);
        setFormat(textParagraph3);
        Paragraph textParagraph4 = new Paragraph("声明：本人(本单位)已仔细阅读《大连商品交易所结算管理办法》有关规定，了解并愿意承担本人(本单位)的相关责任",textfont);
        setFormat(textParagraph4);
        Paragraph textParagraph5 = new Paragraph("单   位(公章)",textfont);
        setFormat(textParagraph5);
        Paragraph textParagraph6 = new Paragraph("法定代表人(签字)",textfont);
        setFormat(textParagraph6);
        Paragraph textParagraph7 = new Paragraph("年  月  日",textfont);
        setFormat(textParagraph7);

        // 点线
        Paragraph lineParagraph = new Paragraph();
        lineParagraph.add(new Chunk(new DottedLineSeparator()));

        Paragraph textParagraph8 = new Paragraph("以下为会员填写：",textfont);
        setFormat(textParagraph8);
        Paragraph textParagraph9 = new Paragraph("此授权书作为《大连商品交易所标准仓单作为保证金协议书》（协议编号：xxxxxx）授权。",textfont);
        setFormat(textParagraph9);
        Paragraph textParagraph10 = new Paragraph("会员经办人签章：",textfont);
        setFormat(textParagraph10);
        Paragraph textParagraph11 = new Paragraph("年  月  日",textfont);
        setFormat(textParagraph11);

        // 添加图片
        Image image = Image.getInstance("C:\\Users\\lenovo\\Desktop\\word-seal.jpg");
        // 图片浮在文字上方
        image.setAlignment(Image.UNDERLYING);
        // 以左上角为中心设置x,y轴坐标，确定图片位置
        image.setAbsolutePosition(400,500);
        // 依照比例缩放
        image.scalePercent(25);

        document.add(titleParagraph);
        document.add(textParagraph1);
        document.add(textParagraph2);
        document.add(textParagraph3);
        document.add(textParagraph4);
        document.add(textParagraph5);
        document.add(textParagraph6);
        document.add(textParagraph7);
        document.add(lineParagraph);
        document.add(textParagraph8);
        document.add(textParagraph9);
        document.add(textParagraph10);
        document.add(textParagraph11);
        document.add(image);
    }

    public void setFormat(Paragraph paragraph){
        paragraph.setAlignment(1);
        paragraph.setIndentationLeft(12);
        paragraph.setIndentationRight(12);
        paragraph.setFirstLineIndent(24);
        paragraph.setLeading(20f);
        paragraph.setSpacingBefore(5f);
        paragraph.setSpacingAfter(10f);
    }
}
