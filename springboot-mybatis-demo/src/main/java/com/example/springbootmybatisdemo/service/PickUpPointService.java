package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.param.delete.DeletePointParam;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
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

    public boolean createPickUpPoint(PickUpPointParam param) {
        if(param.getUser().equals("AlanZeng")){
            return false;
        }else{
            return pickUpPointMapper.createPickUpPoint(param) > 0;
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

   public boolean updatePickPointInfo(PickUpPointParam param){
        return pickUpPointMapper.updatePickUpPointInfo(param);
   }

   public boolean deletePickUpPoint(DeletePointParam param){
        return pickUpPointMapper.deletePickUpPoint(param);
   }
}
