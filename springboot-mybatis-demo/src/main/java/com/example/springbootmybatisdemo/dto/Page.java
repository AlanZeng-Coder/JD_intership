package com.example.springbootmybatisdemo.dto;

import java.util.List;

public class Page<T> {
    private int pageSize;
    private int currentPageNumber;
    private long totalElements;
    private int totalPages;
    private List<T> content;

    public Page(int pageSize, int currentPageNumber, long totalElements, List<T> content, int totalPages){
        this.content = content;
        this.currentPageNumber = currentPageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
