package com.example.springbootmybatisdemo.param.insertOrUpdate;

public class PickUpPointParam {
    private Long tenantId;
    private String user;
    private PickUpPointInfoParam pickUpPointInfoParam;

    public Long getTenantId(){
        return tenantId;
}
    public String getUser(){
        return user;
    }
    public PickUpPointInfoParam getPickUpPointInfoParam() {
        return pickUpPointInfoParam;
    }

    public void setTenantId(Long tenantId){
        this.tenantId = tenantId;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setPickUpPointInfoParam(PickUpPointInfoParam pickUpPointInfoParam) {
        this.pickUpPointInfoParam = pickUpPointInfoParam;
    }


}
