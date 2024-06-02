package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.param.insert.PickUpPointParam;
import com.example.springbootmybatisdemo.mapper.*;
import com.example.springbootmybatisdemo.param.set.SetPointParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootmybatisdemo.dto.get.*;
import com.example.springbootmybatisdemo.param.get.*;

import java.util.List;

@Service
public class PickUpPointService {

    @Autowired
    private PickUpPointMapper pickUpPointMapper;

    public boolean insertPickUpPoint(PickUpPointParam param) {
        if(param.getUser().equals("AlanZeng")){
            return false;
        }else{
            return pickUpPointMapper.insertPickUpPoint(param) > 0;
        }
    }

    public PickUpPointInfoDTO getPickUpPoints(GetPickUpPointParam param) {
        List<PickUpPointDTO> pickUpPointDTOList = pickUpPointMapper.getPickUpPoints(param);

        PickUpPointInfoDTO pickUpPointInfoDTO = new PickUpPointInfoDTO();
        pickUpPointInfoDTO.setTenantId(param.getTenantId());
        pickUpPointInfoDTO.setUser(param.getUser());
        pickUpPointInfoDTO.setPickUpPointDTOList(pickUpPointDTOList);

        return pickUpPointInfoDTO;
    }

    public boolean setPickUpPointsStatus(SetPointParam param){
        return pickUpPointMapper.setPickUpPointStatus(param);
    }
}
