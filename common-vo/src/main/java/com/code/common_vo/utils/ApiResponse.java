package com.code.common_vo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean state;
    private String message;
    private Object data;
}
