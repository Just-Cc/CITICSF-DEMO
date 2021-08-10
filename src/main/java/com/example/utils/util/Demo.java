package com.example.utils.util;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Cc
 * @Date: 2021/6/1 9:40
 */
public class Demo {

    public static void main(String[] args) {
        FileOutputStream out = null;
        try {
            //创建工作薄对象
            SXSSFWorkbook workbook = new SXSSFWorkbook();
            CellStyle style = getStyle(workbook);
            //创建工作表对象
            Sheet sheet = workbook.createSheet();
            //创建工作表的行
            Row row1 = sheet.createRow(0);
            //第1行第1列
            Cell row1cell1 = row1.createCell(0);
            row1cell1.setCellStyle(style);
            row1cell1.setCellValue("仓转信息");
            //第2行第1列
            Row row2 = sheet.createRow(1);
            Cell row2Cell1 = row2.createCell(0);
            Cell row2Cell2 = row2.createCell(1);
            Cell row2Cell3 = row2.createCell(2);
            Cell row2Cell4 = row2.createCell(3);
            Cell row2Cell5 = row2.createCell(4);
            row2Cell1.setCellStyle(style);
            row2Cell2.setCellStyle(style);
            row2Cell3.setCellStyle(style);
            row2Cell4.setCellStyle(style);
            row2Cell5.setCellStyle(style);
            row2Cell1.setCellValue("仓单号");
            row2Cell2.setCellValue("转让数量（张）");
            row2Cell3.setCellValue("转让价格（元/合约单位）");
            row2Cell4.setCellValue("重量");
            row2Cell5.setCellValue("货款");
            //第3行第1列
            Row row3 = sheet.createRow(2);
            Cell row3Cell1 = row3.createCell(0);
            row3Cell1.setCellStyle(style);
            row3Cell1.setCellValue("总计");
            //workbook.setSheetName(0,"sheet的Name");
            //合并单元格 起始行 结束行 起始列 结束列
            CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);
            sheet.addMergedRegion(region);
            //文档输出
            out = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xlsx");
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            System.out.println("导出Excel文档失败！");
        }finally {
            if(null!=out){
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("关流失败！");
                }
            }
        }
    }

    /**
     * 样式
     */
    public static CellStyle getStyle(SXSSFWorkbook workbook) {

        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)16);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("等线");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //下边框
        style.setBorderBottom(CellStyle.BORDER_THIN);
        //左边框
        style.setBorderLeft(CellStyle.BORDER_THIN);
        //上边框
        style.setBorderTop(CellStyle.BORDER_THIN);
        //右边框
        style.setBorderRight(CellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return style;
    }

}
