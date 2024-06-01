package com.example.springbootmybatisdemo.dto;
import java.math.BigDecimal;
import java.util.Date;

public class CreatePickUpPointParam {
    private Long id;
    private String userName;
    private PickUpPointInfoParam pickUpPointInfoParam;

    public Long getId(){
        return id;
}
    public String getUser(){
        return userName;
    }
    public PickUpPointInfoParam getPickUpPointInfoParam() {
        return pickUpPointInfoParam;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setUser(String user){
        this.userName = user;
    }
    public void setPickUpPointInfoParam(PickUpPointInfoParam pickUpPointInfoParam) {
        this.pickUpPointInfoParam = pickUpPointInfoParam;
    }


}
