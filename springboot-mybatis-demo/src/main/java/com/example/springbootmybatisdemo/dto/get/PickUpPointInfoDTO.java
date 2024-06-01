package com.example.springbootmybatisdemo.dto.get;

import com.example.springbootmybatisdemo.dto.get.PickUpPointDTO;

import java.util.List;

public class PickUpPointInfoDTO {
    private Long tenantId;
    private String user;
    private List<PickUpPointDTO> pickUpPointDTOList;

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public List<PickUpPointDTO> getPickUpPointDTOList() {
        return pickUpPointDTOList;
    }

    public void setPickUpPointDTOList(List<PickUpPointDTO> pickUpPointDTOList) {
        this.pickUpPointDTOList = pickUpPointDTOList;
    }
}
