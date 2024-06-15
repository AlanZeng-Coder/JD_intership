package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.dto.Response;
import com.example.springbootmybatisdemo.param.delete.DeletePointParam;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
import com.example.springbootmybatisdemo.mapper.*;
import com.example.springbootmybatisdemo.param.set.SetPointParam;
import com.example.springbootmybatisdemo.service.validator.CreatePickUpPointValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootmybatisdemo.dto.get.*;
import com.example.springbootmybatisdemo.dto.Page;
import com.example.springbootmybatisdemo.param.get.*;

import java.util.List;
import java.util.UUID;

@Service
public class PickUpPointService {

    @Autowired
    private PickUpPointMapper pickUpPointMapper;
    @Autowired
    private CreatePickUpPointValidator createPickUpPointValidator;
    public Response<Boolean> createPickUpPoint(PickUpPointParam param) {
        createPickUpPointValidator.validate(param);

        try{
            boolean result = pickUpPointMapper.createPickUpPoint(param);
            if (result){
                return new Response<>(200, "Success", UUID.randomUUID().toString(), true);
            }else{
                return new Response<>(400, "Failed to create pick-up point", UUID.randomUUID().toString(), false);
            }
        } catch (Exception e){
            return new Response<>(500, "Internal server error", UUID.randomUUID().toString(), null);
        }
    }

    public Response<Page<PickUpPointInfoDTO>> getPickUpPoints(GetPickUpPointParam param) {
        List<PickUpPointDTO> pickUpPointDTOList = pickUpPointMapper.getPickUpPoints(param);

        int page = param.getPageParam().getPage();
        int pageSize = param.getPageParam().getPageSize();

        int totalItems = pickUpPointDTOList.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        if (page > totalPages || page < 1) {
            return new Response<>(404, "No pick-up points found", UUID.randomUUID().toString(), null);
        }
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalItems);

        List<PickUpPointDTO> pickUpPointDTOListInPage = pickUpPointDTOList.subList(startIndex, endIndex);

        PickUpPointInfoDTO pickUpPointInfoDTO = new PickUpPointInfoDTO();
        pickUpPointInfoDTO.setTenantId(param.getTenantId());
        pickUpPointInfoDTO.setUser(param.getUser());
        pickUpPointInfoDTO.setPickUpPointDTOList(pickUpPointDTOListInPage);

        Page<PickUpPointInfoDTO> pageObject = new Page<>(pageSize, page, totalItems, pickUpPointInfoDTO, totalPages);

        try {
            if (pickUpPointInfoDTO.getPickUpPointDTOList().isEmpty()) {
                return new Response<>(404, "No pick-up points found", UUID.randomUUID().toString(), null);
            } else {
                return new Response<>(200, "Success", UUID.randomUUID().toString(), pageObject);
            }
        } catch (Exception e) {
            // Handle exception and return an error response
            return new Response<>(500, "Internal server error", UUID.randomUUID().toString(), null);
        }
    }

    public Response<Boolean> setPickUpPointStatus(SetPointParam param){
        try{
            boolean result = pickUpPointMapper.setPickUpPointStatus(param);
            if (result){
                return new Response<>(200, "Success", UUID.randomUUID().toString(), true);
            }else{
                return new Response<>(400, "Failed to set pick-up point status", UUID.randomUUID().toString(), false);
            }
        } catch (Exception e){
            return new Response<>(500, "Internal server error", UUID.randomUUID().toString(), null);
        }
    }

   public Response<Boolean> updatePickPointInfo(PickUpPointParam param){
       try{
           boolean result = pickUpPointMapper.updatePickUpPointInfo(param);
           if (result){
               return new Response<>(200, "Success", UUID.randomUUID().toString(), true);
           }else{
               return new Response<>(400, "Failed to update pick-up point", UUID.randomUUID().toString(), false);
           }
       } catch (Exception e){
           return new Response<>(500, "Internal server error", UUID.randomUUID().toString(), null);
       }
   }

   public Response<Boolean> deletePickUpPoint(DeletePointParam param){
       try{
           boolean result = pickUpPointMapper.deletePickUpPoint(param);
           if (result){
               return new Response<>(200, "Success", UUID.randomUUID().toString(), true);
           }else{
               return new Response<>(400, "Failed to delete pick-up point", UUID.randomUUID().toString(), false);
           }
       } catch (Exception e){
           return new Response<>(500, "Internal server error", UUID.randomUUID().toString(), null);
       }
   }

    public Response<PickUpPointInfoDTO> getPickUpPointByStoreId(GetPointByStoreIdParam param) {
        List<PickUpPointDTO> pickUpPointDTOList = pickUpPointMapper.getPickUpPointByStoreId(param);

        PickUpPointInfoDTO pickUpPointInfoDTO = new PickUpPointInfoDTO();
        pickUpPointInfoDTO.setTenantId(param.getTenantId());
        pickUpPointInfoDTO.setPickUpPointDTOList(pickUpPointDTOList);

        try {
            if (pickUpPointInfoDTO.getPickUpPointDTOList().isEmpty()) {
                return new Response<>(404, "No pick-up points found", UUID.randomUUID().toString(), pickUpPointInfoDTO);
            } else {
                return new Response<>(200, "Success", UUID.randomUUID().toString(), pickUpPointInfoDTO);
            }
        } catch (Exception e) {
            // Handle exception and return an error response
            return new Response<>(500, "Internal server error", UUID.randomUUID().toString(), null);
        }
    }
}
