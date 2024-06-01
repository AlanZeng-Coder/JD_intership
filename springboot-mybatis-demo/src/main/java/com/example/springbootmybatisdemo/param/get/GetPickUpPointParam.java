package com.example.springbootmybatisdemo.param.get;

public class GetPickUpPointParam {
    private Long tenantId;
    private String user;
    private PointNamesParam pointNamesParam;
    private PageParam pageParam;

    public PointNamesParam getPointNamesParam() {
        return pointNamesParam;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setPointNamesParam(PointNamesParam pointNamesParam) {
        this.pointNamesParam = pointNamesParam;
    }

    public String getUser() {
        return user;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public PageParam getPageParam() {
        return pageParam;
    }

    public void setPageParam(PageParam pageParam) {
        this.pageParam = pageParam;
    }
}
