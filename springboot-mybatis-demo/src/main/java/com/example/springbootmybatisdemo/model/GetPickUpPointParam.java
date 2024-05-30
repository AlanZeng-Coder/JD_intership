package com.example.springbootmybatisdemo.model;

import org.apache.catalina.session.StoreBase;

import java.awt.*;

public class GetPickUpPointParam {
    private Long tenantId;
    private String user;
    private PointNamesParam pointNamesParam;
    private PageParam pageParam;


    public PointNamesParam getPointNamesParam() {
        return pointNamesParam;
    }

    public PageParam getPageParam() {
        return pageParam;
    }
}
