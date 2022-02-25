package com.citicsf.consumer.service;

import com.citicsf.common.core.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Cc
 * @Date: 2021/11/30 9:28
 */
public interface UploadService {

    BaseResponse upload(String json, MultipartFile[] files) throws IOException;
}
