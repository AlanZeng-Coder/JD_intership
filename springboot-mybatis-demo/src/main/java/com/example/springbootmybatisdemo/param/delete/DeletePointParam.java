package com.example.springbootmybatisdemo.param.delete;

public class DeletePointParam {
    private Long tenantId;
    private String user;
    private Long pickUpPointId;

    public Long getPickUpPointId() {
        return pickUpPointId;
    }

    public void setPickUpPointId(Long pickUpPointId) {
        this.pickUpPointId = pickUpPointId;
    }

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
}
