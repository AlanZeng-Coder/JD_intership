package com.example.springbootmybatisdemo.param.get;

public class GetPointByStoreIdParam {
    private Long tenantId;
    private Long storeId;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return storeId;
    }
}
