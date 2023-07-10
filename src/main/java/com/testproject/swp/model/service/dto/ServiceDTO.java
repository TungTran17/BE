package com.testproject.swp.model.service.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class ServiceDTO {

    public ServiceDTO() {
        // Default constructor without arguments
    }

    public int contPage; // số lượng page của trang
    public List<GetMyService> listServices; // danh sách service

    /*
     * thông báo trạng thái thành công hay ko
     * 202 là ok
     * 200 
     * 404 là thất bại
     */
    public int status;

}
