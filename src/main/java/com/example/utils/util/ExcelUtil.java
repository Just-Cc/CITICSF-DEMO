package com.example.utils.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Cc
 * @Date: 2021/5/20 9:38
 */
public class ExcelUtil {
    /**
     * 读取excel文件
     * @param args
     */

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(ExcelUtil.class);

        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;

        String filePath = "C:\\Users\\lenovo\\Desktop\\exchanges.xlsx";
        System.out.println("filePath========"+filePath);
        wb = readExcel(filePath);
        if (wb != null) {
            try {
                List<List<List<Object>>> list = new ArrayList<>();
                //System.err.println("页签数量：" + wb.getNumberOfSheets());
                //log.info("页签数量：" + wb.getNumberOfSheets());
                // 循环页签
                //循环sheet工作表
                for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
                    // 获取单个sheet
                    sheet = wb.getSheetAt(sheetNum);
                    // 存放当前sheet的List
                    List<List<Object>> sheetList = new ArrayList<>();

                    // 循环行
                    //循环行  rowNum从1开始，不读取表头数据
                    for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                        // 获取单行数据
                        row = sheet.getRow(rowNum);
                        if(null == row) {
                            continue;
                        }
                        // 定义存放一行数据的StringBuilder
                        //List<Object> rowList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder("INSERT INTO `t_futures` (`member_id`, `member_name`, `member_shortname`, `address`, `phone`, `region`, `postal_code`, `url`, `exchange_code`, `exchange_name`, `member_type`, `mark`, `create_time`, `update_time`) VALUES (");
                        // 循环列
                        /*for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {//循环单元格
                            Cell cell = sheet.getRow(rowNum).getCell(cellNum);
                            //rowList.add(getStringCellValue(cell));
                        }*/

                        /**
                         * 不循环列，这里只处理本次的表格，导入期货公司信息
                         */
                        //会员号
                        if(null!=(row.getCell(0))){
                            sb.append("'"+row.getCell(0).toString()+"', ");
                        }else{
                            System.err.println("第"+rowNum+"行会员号为空！！！");
                            return;
                        }
                        //会员名称
                        if(null!=(row.getCell(1))){
                            sb.append("'"+row.getCell(1).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //会员简称
                        if(null!=(row.getCell(2))){
                            sb.append("'"+row.getCell(2).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //地址
                        if(null!=(row.getCell(3))){
                            sb.append("'"+row.getCell(3).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //电话
                        if(null!=(row.getCell(4))){
                            sb.append("'"+row.getCell(4).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //地区
                        if(null!=(row.getCell(5))){
                            sb.append("'"+row.getCell(5).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //邮编
                        if(null!=(row.getCell(6))){
                            sb.append("'"+row.getCell(6).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //网址
                        if(null!=(row.getCell(7))){
                            sb.append("'"+row.getCell(7).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //交易所代码
                        if(null!=(row.getCell(11))){
                            sb.append("'"+row.getCell(11).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //交易所名称
                        if(null!=(row.getCell(8))){
                            sb.append("'"+row.getCell(8).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //会员类型
                        if(null!=(row.getCell(10))){
                            sb.append("'"+row.getCell(10).toString()+"', ");
                        }else{
                            sb.append("NULL, ");
                        }
                        //备注
                        sb.append("NULL, ");
                        //创建时间
                        sb.append("NULL, ");
                        //更新时间
                        sb.append("NULL);");

                        System.err.println(sb.toString());

                        //sheetList.add(rowList);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //判断文件格式
    private static Workbook readExcel(String filePath){
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));

        try {
            //@SuppressWarnings("resource")
            System.out.println("filePath====>>>>>"+filePath);
            InputStream is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return new XSSFWorkbook(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    //@SuppressWarnings("deprecation")
    public static String getStringCellValue(Cell cell) {
        String cellvalue = "";
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                cellvalue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = cell.getDateCellValue();
                    cellvalue = sdf.format(date);
                } else {
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellvalue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                cellvalue = "";
                break;
            default:
                cellvalue = "";
                break;
        }
        if (cellvalue == "") {
            return "";
        }
        return cellvalue;
    }
}
