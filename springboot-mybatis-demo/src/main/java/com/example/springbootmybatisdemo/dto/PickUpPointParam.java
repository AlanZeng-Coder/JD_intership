package com.example.springbootmybatisdemo.dto;

public class PickUpPointParam {
    private Long tenantId;
    private String userName;
    private PickUpPointInfoParam pickUpPointInfoParam;

    public Long getTenantId(){
        return tenantId;
}
    public String getUser(){
        return userName;
    }
    public PickUpPointInfoParam getPickUpPointInfoParam() {
        return pickUpPointInfoParam;
    }

    public void setTenantId(Long tenantId){
        this.tenantId = tenantId;
    }
    public void setUser(String user){
        this.userName = user;
    }
    public void setPickUpPointInfoParam(PickUpPointInfoParam pickUpPointInfoParam) {
        this.pickUpPointInfoParam = pickUpPointInfoParam;
    }


}
