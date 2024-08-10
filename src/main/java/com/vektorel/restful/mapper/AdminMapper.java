package com.vektorel.restful.mapper;

import com.vektorel.restful.dto.request.AdminSaveRequestDto;
import com.vektorel.restful.dto.request.AdminUpdateRequestDto;
import com.vektorel.restful.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public Admin admineCevirAdminUpdateDtoDan(Admin admin, AdminUpdateRequestDto dto){
        admin.setName(dto.getName());
        admin.setAdress(dto.getAdress());
        admin.setPassword(dto.getSifre());
        admin.setSurname(dto.getSoyadi());
        return admin;
    }

    public Admin admineCevirAdminSaveDto(Admin admin, AdminSaveRequestDto dto){
        return Admin.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }
}
