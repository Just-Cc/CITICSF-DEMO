package com.example.utils.service.impl;

import com.example.utils.service.ExcelDownloadService;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Cc
 * @Date: 2021/6/24 16:12
 */
public class ExcelDownloadServiceImpl implements ExcelDownloadService {
    /*@Override
    public void downloadExcel(ApplyExcelDTO applyExcelDTO, HttpServletRequest request, HttpServletResponse response) {
        OutputStream out = null;
        try {
            SXSSFWorkbook workbook = new SXSSFWorkbook();
            //通用设置表头
            *//**
             * TODO 根据交易所和品种设置表头
             * --郑商所通用(仓库及编号/仓单类型/其他/注销数量(张))
             * 	--郑商所非通用(仓单号/注销数量(张))
             * 	--大商所玉米c品种(仓库/分库    /提货库区    /仓单类型   /注销数量(张))
             * 	--大商所豆a,豆b及其他(仓库/分库   /仓单类型   /注销数量(张))
             *//*
            Sheet sheet = getPublicWorkbookHead(workbook, applyExcelDTO);
            //通用样式
            CellStyle style = getStyle(workbook);
            int rowNum = 1;
            *//**
             * TODO 根据交易所和品种填充内容
             * --郑商所通用(仓库及编号/仓单类型/其他/注销数量(张))
             * 	--郑商所非通用(仓单号/注销数量(张))
             * 	--大商所玉米c品种(仓库/分库    /提货库区    /仓单类型   /注销数量(张))
             * 	--大商所豆a,豆b及其他(仓库/分库   /仓单类型   /注销数量(张))
             *//*
            for (ExcelDTO dto : applyExcelDTO.getExcelDTO()) {
                //第2行开始填充表格正文
                Row row = sheet.createRow(rowNum);
                Cell cell1 = row.createCell(0);
                cell1.setCellStyle(style);
                //仓单号
                cell1.setCellValue(dto.getReceiptNumber());

                Cell cell2 = row.createCell(1);
                cell2.setCellStyle(style);
                //转让数量
                cell2.setCellValue(dto.getTransferNum());

                Cell cell3 = row.createCell(2);
                cell3.setCellStyle(style);
                //转让价格
                cell3.setCellValue(dto.getTransferPrice());

                Cell cell4 = row.createCell(3);
                cell4.setCellStyle(style);
                //重量
                cell4.setCellValue(dto.getWeight());

                Cell cell5 = row.createCell(4);
                cell5.setCellStyle(style);
                //货款
                cell5.setCellValue(dto.getPrice());
                rowNum++;
            }


            response.setContentType("application/vnd..ms-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx\"");
            out = response.getOutputStream();
            //将创建的Excel对象利用二进制流的形式强制输出到客户端去
            workbook.write(out);
            //强制将数据从内存中保存
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("导出Excel文档失败！");
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭输出流失败！", e);
                }
            }
        }
    }

    *//**
     * 公共表头
     *//*
    public Sheet getPublicWorkbookHead(SXSSFWorkbook workbook, ApplyExcelDTO applyExcelDTO) {
        //创建工作薄对象
        CellStyle style = getStyle(workbook);
        //创建工作表对象
        Sheet sheet = workbook.createSheet();
        //设置表头
        Row row = sheet.createRow(0);
        Cell rowCell1 = row.createCell(0);
        Cell rowCell2 = row.createCell(1);
        Cell rowCell3 = row.createCell(2);
        Cell rowCell4 = row.createCell(3);
        Cell rowCell5 = row.createCell(4);
        rowCell1.setCellStyle(style);
        rowCell2.setCellStyle(style);
        rowCell3.setCellStyle(style);
        rowCell4.setCellStyle(style);
        rowCell5.setCellStyle(style);
        rowCell1.setCellValue(ExcelConstant.WAREHOUSE_NUM);
        rowCell2.setCellValue(ExcelConstant.TRANSFER_NUM);
        rowCell3.setCellValue(ExcelConstant.TRANSFER_PRICE_CONTRACT_UNIT);
        rowCell4.setCellValue(ExcelConstant.WEIGHT);
        rowCell5.setCellValue(ExcelConstant.CARGO_PRICE);
        return sheet;
        return sheet;
    }

    *//**
     * 样式
     *//*
    public CellStyle getStyle(SXSSFWorkbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 16);
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
    }*/

}
