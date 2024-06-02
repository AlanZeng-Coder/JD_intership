package com.example.springbootmybatisdemo.param.set;

public class SetPointParam {
    private Long tenantId;
    private String user;
    private Long pickUpPointId;
    private Byte status;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getPickUpPointId() {
        return pickUpPointId;
    }

    public void setPickUpPointId(Long pickUpPointId) {
        this.pickUpPointId = pickUpPointId;
    }

}
