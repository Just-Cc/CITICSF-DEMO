package com.example.utils.util;

import cn.hutool.json.JSONUtil;
import com.example.utils.entity.ApplyExcel;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * @Author: Cc
 * @Date: 2021/5/21 8:56
 */
@RequestMapping("upload")
@RestController
@Logger
public class FileUtil {

    private final String EXCEL_XLSX = "xlsx ";
    private final String ERROR_FILE_TYPE = "不支持的文件格式，请重新上传！";

    /**
     * 机构线上化读取Excel
     */
    @PostMapping("templateFile")
    public String excel(@RequestParam("file") MultipartFile file) throws IOException {
        //TODO 校验文件大小 做成可配置化
        boolean sizeFlag = checkFileSize(file.getSize(), 100, "M");
        if(!sizeFlag){
            return "文件大小超出限制！限制100M！";
        }
        InputStream ins = null;
        //存每行的数据集合和总计的值
        HashMap<String, Object> map = new HashMap<>();
        //每行的数据集合
        ArrayList<ApplyExcel> list = new ArrayList<>();
        //结束行判断标识
        boolean endRow = false;
        try {
            //获取上传文件的名称
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase(Locale.ROOT);
            //SXSSFWorkbook的原因只支持xlsx，而且模板也是xlsx格式的
            if(!EXCEL_XLSX.equals(suffix)){
                return ERROR_FILE_TYPE;
            }
            //获取文件输入流
            ins = file.getInputStream();
            //转换成WorkBook 这里使用WorkBookFactory的方法，兼容xlsx和xls文件
            //TODO 写入Excel使用SXSSFWorkbook可以防止内存溢出
            Workbook wb = WorkbookFactory.create(ins);
            Sheet sheet = null;
            if(null!=wb){
                int sheetsNum = wb.getNumberOfSheets();
                if(0<sheetsNum){
                    //只获取第一个sheet
                    //TODO 模板不同，不能只取第一个sheet，读取当前选择的交易所，动态选取需要读取的sheet
                    //上期所，能源中心，郑商所(非通用)   ->  仓单号，转让价格(元/合约单位)
                    //大商所  ->  仓库，转让价格（元/吨）
                    //郑商所(通用)  ->  仓库，转让价格（元/吨）
                    sheet = wb.getSheetAt(0);
                }else {
                    return "sheet为空";
                }
            }else {
                return "WookBook为空";
            }
            //模板校验
            boolean flag = checkTemplate(sheet);
            if(!flag){
                return "不支持的文件模板";
            }
            //开始读取文件
            String errorNull = "第%d行,第%d个单元格不能为空！！！";
            System.out.println("总行数为："+sheet.getLastRowNum());
            //循环行,从文件头开始
            for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++){
                ApplyExcel apply = new ApplyExcel();
                //仓单号
                if(isCellEmpty(sheet.getRow(rowNum).getCell(0))){
                    sheet.getRow(rowNum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    if("总计".equals(sheet.getRow(rowNum).getCell(0).getStringCellValue())){
                        endRow = true;
                    }else{
                        //sheet.getRow(rowNum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setReceiptNumber(sheet.getRow(rowNum).getCell(0).getStringCellValue());
                    }
                }else {

                    //System.out.println(String.format(errorNull, rowNum+1, 1));
                    // String.format(errorNull, rowNum+1, 1);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(1))){//转让数量(张)
                    sheet.getRow(rowNum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("transferNumTotal",sheet.getRow(rowNum).getCell(1).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setTransferNum(sheet.getRow(rowNum).getCell(1).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 2));
                    //return String.format(errorNull, rowNum+1, 2);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(2))){//转让价格（元/合约单位）
                    sheet.getRow(rowNum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("transferPriceTotal",sheet.getRow(rowNum).getCell(2).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setTransferPrice(sheet.getRow(rowNum).getCell(2).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 3));
                    //return String.format(errorNull, rowNum+1, 3);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(3))){//重量
                    sheet.getRow(rowNum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("weightTotal",sheet.getRow(rowNum).getCell(3).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setWeight(sheet.getRow(rowNum).getCell(3).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 4));
                    //return String.format(errorNull, rowNum+1, 4);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(4))){//货款
                    sheet.getRow(rowNum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("priceTotal",sheet.getRow(rowNum).getCell(4).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setPrice(sheet.getRow(rowNum).getCell(4).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 5));
                    //return String.format(errorNull, rowNum+1, 5);
                }
                if(null != apply){//如果全为空则不存
                    list.add(apply);
                }
                if(endRow){
                    break;
                }
            }
            map.put("data",list);//存放每行数据
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ins.close();
        }
        String json = JSONUtil.toJsonStr(map);
        System.out.println(json);
        return json;
    }

    /**
     * 模板格式校验
     */
    public boolean checkTemplate(Sheet sheet){
        //TODO 根据不同交易所校验不同模板格式
        Boolean flag = true;
        if(!(null!=sheet.getRow(0).getCell(0) && "仓转信息".equals(sheet.getRow(0).getCell(0).toString()))){
            flag = false;
        }

        if(!(null!=sheet.getRow(1).getCell(0) && "仓单号".equals(sheet.getRow(1).getCell(0).toString()))){
            flag = false;
        }

        if(!(null!=sheet.getRow(1).getCell(0) && "转让数量（张）".equals(sheet.getRow(1).getCell(1).toString()))){
            flag = false;
        }

        if(!(null!=sheet.getRow(1).getCell(0) && "转让价格（元/合约单位）".equals(sheet.getRow(1).getCell(2).toString()))){
            flag = false;
        }

        if(!(null!=sheet.getRow(1).getCell(0) && "重量".equals(sheet.getRow(1).getCell(3).toString()))){
            flag = false;
        }

        if(!(null!=sheet.getRow(1).getCell(0) && "货款".equals(sheet.getRow(1).getCell(4).toString()))){
            flag = false;
        }
        return flag;
    }

    /**
     * 单元格空值校验
     */
    public boolean isCellEmpty(Cell cell) {
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            //为空时返回false
            return false;
        } else {
            //不为空时返回true
            return true;
        }
    }

    /**
     * 判断文件大小
     *
     * @param len
     *            文件长度
     * @param size
     *            限制大小
     * @param unit
     *            限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }

    /**
     * 校验是否为excel文件
     */
    public boolean isExcelFile(MultipartFile  file) {
        /*byte [] byteArr=file.getBytes();
        InputStream inputStream = new ByteArrayInputStream(byteArr);
        boolean result = false;
        try {
            FileMagic fileMagic = FileMagic.valueOf(inputStream);
            if (Objects.equals(fileMagic, FileMagic.OLE2)
                    || Objects.equals(fileMagic, FileMagic.OOXML)) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return false;
    }

    /**
     * 机构线上化读取Excel
     */
    /*@PostMapping("newTemplateFile")
    public String newExcel(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream ins = null;
        HashMap<String, Object> map = new HashMap<>();//存每行的数据集合和总计的值
        ArrayList<ApplyExcel> list = new ArrayList<>();//每行的数据集合
        boolean endRow = false;//结束行判断标识
        try {
            //获取上传文件的名称
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            if(!"xlsx".equals(suffix)){//SXSSFWorkbook的原因只支持xlsx，而且模板也是xlsx格式的
                return "不支持的文件格式，请重新上传！";
            }
            //获取文件输入流
            ins = file.getInputStream();
            //转换成WorkBook 这里使用WorkBookFactory的方法，兼容xlsx和xls文件
            Workbook wb = WorkbookFactory.create(ins);
            *//*ExcelXlsxReaderWithDefaultHandler defaultHandler = new ExcelXlsxReaderWithDefaultHandler();
            int process = defaultHandler.process(fileName);*//*

            Sheet sheet = null;
            if(null!=wb){
                int sheetsNum = wb.getNumberOfSheets();
                if(0<sheetsNum){
                    //只获取第一个sheet
                    //上期所，能源中心，郑商所(非通用)   ->  仓单号，转让价格(元/合约单位)
                    //大商所  ->  仓库，转让价格（元/吨）
                    //郑商所(通用)  ->  仓库，转让价格（元/吨）
                    sheet = wb.getSheetAt(0);
                }else {
                    return "sheet为空";
                }
            }else {
                return "WookBook为空";
            }
            //模板校验
            boolean flag = checkTemplate(sheet);
            if(!flag){
                return "不支持的文件模板";
            }
            //开始读取文件
            String errorNull = "第%d行,第%d个单元格不能为空！！！";
            System.out.println("总行数为："+sheet.getLastRowNum());
            for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++){//循环行,从文件头开始
                ApplyExcel apply = new ApplyExcel();
                if(isCellEmpty(sheet.getRow(rowNum).getCell(0))){//仓单号
                    sheet.getRow(rowNum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    if("总计".equals(sheet.getRow(rowNum).getCell(0).getStringCellValue())){
                        endRow = true;
                    }else{
                        //sheet.getRow(rowNum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setReceiptNumber(sheet.getRow(rowNum).getCell(0).getStringCellValue());
                    }
                }else {

                    //System.out.println(String.format(errorNull, rowNum+1, 1));
                    // String.format(errorNull, rowNum+1, 1);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(1))){//转让数量(张)
                    sheet.getRow(rowNum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("transferNumTotal",sheet.getRow(rowNum).getCell(1).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setTransferNum(sheet.getRow(rowNum).getCell(1).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 2));
                    //return String.format(errorNull, rowNum+1, 2);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(2))){//转让价格（元/合约单位）
                    sheet.getRow(rowNum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("transferPriceTotal",sheet.getRow(rowNum).getCell(2).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setTransferPrice(sheet.getRow(rowNum).getCell(2).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 3));
                    //return String.format(errorNull, rowNum+1, 3);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(3))){//重量
                    sheet.getRow(rowNum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("weightTotal",sheet.getRow(rowNum).getCell(3).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setWeight(sheet.getRow(rowNum).getCell(3).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 4));
                    //return String.format(errorNull, rowNum+1, 4);
                }

                if(isCellEmpty(sheet.getRow(rowNum).getCell(4))){//货款
                    sheet.getRow(rowNum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    if(endRow){
                        //sheet.getRow(rowNum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        map.put("priceTotal",sheet.getRow(rowNum).getCell(4).getStringCellValue());
                    }else {
                        //sheet.getRow(rowNum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        apply.setPrice(sheet.getRow(rowNum).getCell(4).getStringCellValue());
                    }
                }else {
                    //System.out.println(String.format(errorNull, rowNum+1, 5));
                    //return String.format(errorNull, rowNum+1, 5);
                }
                if(null != apply){//如果全为空则不存
                    list.add(apply);
                }
                if(endRow){
                    break;
                }
            }
            map.put("data",list);//存放每行数据
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ins.close();
        }
        String json = JSONUtil.toJsonStr(map);
        System.out.println(json);
        return json;
    }*/

}
