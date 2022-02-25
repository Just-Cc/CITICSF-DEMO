package com.reptile.doubanhousereptile.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @Author: Cc
 * @Date: 2021/12/8 13:11
 */
@Data
public class HouseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;//帖子Title

    private String description;//帖子描述信息

    private LocalDateTime createTime;//帖子创建时间

    private ArrayList<byte[]> imageStreams;//图片Base64流

    private String houseUrl;//租房帖子URL
}
