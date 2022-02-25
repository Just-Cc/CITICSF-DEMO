package com.example.utils.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Cc
 * @Date: 2022/2/16 18:57
 */
public class Test14 {
    /**
     * 测试生成PDF
     * @param args
     */
    public static void main(String[] args) {
        String path = "C:\\Users\\lenovo\\Desktop\\test.pdf";
        File file = new File(path);
        try {
            //创建文件
            Document document = new Document();
            //建立一个书写器
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));

            //打开文件
            document.open();

            //中文字体,解决中文不能显示问题
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese);//正常字体
            Font fontBold = new Font(bfChinese, 12, Font.BOLD);//正常加粗字体
            Font fontBig = new Font(bfChinese, 20);//大字体
            Font fontBigBold = new Font(bfChinese, 20, Font.BOLD);//加粗大字体

            //添加主题
            Paragraph theme = new Paragraph("大连商品交易所标准仓单作为保证金", fontBigBold);
            theme.setAlignment(Element.ALIGN_CENTER);
            document.add(theme);

            //主题第二行标题
            Paragraph theme2 = new Paragraph("客户专项授权书", fontBigBold);
            theme2.setAlignment(Element.ALIGN_CENTER);
            document.add(theme2);

            //加入空行
            Paragraph blankRow = new Paragraph(18f, " ");

            StringBuilder thirdRow = new StringBuilder();
            thirdRow.append("大连商品交易所：");
            Paragraph thirdRowEle = new Paragraph(thirdRow.toString(), font);

            StringBuilder text = new StringBuilder();
            text.append("兹专项委托中信期货有限公司(会员号：0110)持本单位(客户交易编码：xxxxxxxx)的标准仓单(品种)豆油y数量为100手，");
            text.append("前来办理标准仓单作为保证金有关事宜，用于履行该会员在交易所的保证金和相关债务，与本授权书相应的协议编号授权会员");
            text.append("代为填写。请予以办理为盼！");
            Paragraph textEle = new Paragraph(text.toString(), font);

            StringBuilder mark = new StringBuilder();
            mark.append("备注：仓库 xxxx    数量(手) xxxx");
            Paragraph markEle = new Paragraph(mark.toString(), font);

            StringBuilder statement = new StringBuilder();
            statement.append("声明：本人(本单位)已仔细阅读《大连商品交易所结算管理办法》有关规定，了解并愿意承担本人(本单位)的相关责任。");
            Paragraph statementEle = new Paragraph(statement.toString(), font);

            StringBuilder unitSeal = new StringBuilder();
            unitSeal.append("单 位(公章)");
            Paragraph unitSealEle = new Paragraph(unitSeal.toString(), font);
            unitSealEle.setAlignment(Element.ALIGN_RIGHT);

            StringBuilder legalPerson = new StringBuilder();
            legalPerson.append("法定代表人(签字)");
            Paragraph legalPersonEle = new Paragraph(legalPerson.toString(), font);
            legalPersonEle.setAlignment(Element.ALIGN_RIGHT);

            StringBuilder date = new StringBuilder();
            date.append("  年  月  日");
            Paragraph dateEle = new Paragraph(date.toString(), font);
            dateEle.setAlignment(Element.ALIGN_RIGHT);

            document.add(thirdRowEle);
            document.add(blankRow);
            document.add(textEle);
            document.add(blankRow);
            document.add(markEle);
            document.add(blankRow);
            document.add(blankRow);
            document.add(blankRow);
            document.add(blankRow);
            document.add(blankRow);
            document.add(statementEle);
            document.add(blankRow);
            document.add(unitSealEle);
            document.add(blankRow);
            document.add(legalPersonEle);
            document.add(blankRow);
            document.add(dateEle);
            //关闭文档
            document.close();
            //关闭书写器
            writer.close();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            System.out.println(bytes.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}