package com.example.pojo;

public class Params {

    private String username;
    private int pageNum;
    private int pageSize;

    public Params() {
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = username;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
