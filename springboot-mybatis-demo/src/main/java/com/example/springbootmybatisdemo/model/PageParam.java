package com.example.springbootmybatisdemo.model;

public class PageParam {
    private Integer pageSize;
    private Integer page;

    public int getOffset() {
        return (page - 1) * pageSize;
    }
}
