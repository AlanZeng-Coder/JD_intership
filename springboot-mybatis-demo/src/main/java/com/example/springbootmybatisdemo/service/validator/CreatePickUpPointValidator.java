package com.example.springbootmybatisdemo.service.validator;

import com.example.springbootmybatisdemo.exception.InvalidPhoneNumberException;
import com.example.springbootmybatisdemo.exception.InvalidCityException;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
import org.springframework.stereotype.Component;

@Component
public class CreatePickUpPointValidator {

    public void validate(PickUpPointParam param) {
        String phoneNumber = param.getPickUpPointInfoParam().getPhoneNumber();
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new InvalidPhoneNumberException("Invalid phone number: " + phoneNumber);
        }

        String city = param.getPickUpPointInfoParam().getCity();
        if (!isValidCity(city)) {
            throw new InvalidCityException("Invalid city: " + city);
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.length() == 11;  // 电话号码长度为11
    }

    private boolean isValidCity(String city) {
        return city != null && !city.trim().isEmpty();
    }
}
