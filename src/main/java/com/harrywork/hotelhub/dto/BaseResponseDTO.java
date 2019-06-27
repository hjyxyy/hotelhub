package com.harrywork.hotelhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 09:38
 * Desc: BaseResponseDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDTO {
    private Integer code;
    private String message;
    private Object data;

    public static BaseResponseDTO OK = new BaseResponseDTO(2000, "success", null);

    public static BaseResponseDTO OK(Object data) {
        return new BaseResponseDTO(2000, "success", data);
    }

    public static BaseResponseDTO CLIENT_ERROR(String message) {
        return new BaseResponseDTO(4000, message, null);
    }

    public static BaseResponseDTO FAILED = new BaseResponseDTO(5000, "Service unavailable.", null);


    public static BaseResponseDTO FAILED(String message) {
        return new BaseResponseDTO(5001, message, null);
    }
}
