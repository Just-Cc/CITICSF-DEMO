package com.example.utils.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Cc
 * @Date: 2021/9/9 13:28
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        String json = "{\n" +
                "    \"request_id\": \"DtDftwftniEskd3fekTZ42RGc5esiicF\",\n" +
                "    \"timestamp\": \"1634610131183\",\n" +
                "    \"sign\": \"\",\n" +
                "    \"token_key\": \"\",\n" +
                "    \"data\": {\n" +
                "        \"business_type\": \"2\",\n" +
                "        \"completion_explain\": \"gsdg\",\n" +
                "        \"customer_name\": \"gdssg\",\n" +
                "        \"customer_number\": \"gdsgsg\",\n" +
                "        \"handover_requirements\": \"dsgsd\",\n" +
                "        \"handover_type\": \"17\",\n" +
                "        \"id\": \"\",\n" +
                "        \"if_day_night_handover\": \"1\",\n" +
                "        \"if_report\": \"0\",\n" +
                "        \"mark\": \"dgsg\",\n" +
                "        \"night_market_turnover\": \"\",\n" +
                "        \"remind_date\": \"2021-10-28 00:00:00\",\n" +
                "        \"remind_frequency\": \"180\",\n" +
                "        \"mission_processDTOS\": [\n" +
                "            {\n" +
                "                \"biz_type\": \"2\",\n" +
                "                \"employee_number\": \"041738\",\n" +
                "                \"id\": \"\",\n" +
                "                \"process_type\": \"1\",\n" +
                "                \"status\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"biz_type\": \"2\",\n" +
                "                \"employee_number\": \"018056\",\n" +
                "                \"id\": \"\",\n" +
                "                \"process_type\": \"1\",\n" +
                "                \"status\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"biz_type\": \"2\",\n" +
                "                \"employee_number\": \"005133\",\n" +
                "                \"id\": \"\",\n" +
                "                \"process_type\": \"1\",\n" +
                "                \"status\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"biz_type\": \"2\",\n" +
                "                \"employee_number\": \"015523\",\n" +
                "                \"id\": \"\",\n" +
                "                \"process_type\": \"4\",\n" +
                "                \"status\": \"\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        String s = lineToCamelCase(json);
        System.out.println(s);
    }
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static String lineToCamelCase(String json){
        Matcher matcher = linePattern.matcher(json);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
