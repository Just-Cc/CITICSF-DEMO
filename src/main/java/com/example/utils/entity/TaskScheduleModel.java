package com.example.utils.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: Cc
 * @Date: 2021/8/19 16:32
 */
@ApiModel(description = "cron表达体")
@Data
public class TaskScheduleModel{

    Integer jobType;

    /**一周的哪几天*/
    Integer[] dayOfWeeks;

    /**一个月的哪几天*/
    Integer[] dayOfMonths;

    /**秒  */
    Integer second;

    /**分  */
    Integer minute;

    /**时  */
    Integer hour;
}
