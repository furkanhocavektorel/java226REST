package com.vektorel.restful.service;

import com.vektorel.restful.dto.request.AdminSaveRequestDto;
import com.vektorel.restful.dto.response.AdminResponseDto;
import com.vektorel.restful.entity.Admin;
import com.vektorel.restful.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;

    public void save(AdminSaveRequestDto dto){

        Optional<Admin> admin=  repository.findOptionalByEmail(dto.getEmail());

        if (admin.isPresent()){
            // normalde front-end 'e bu mail zaten kayıtlı diyen bir mesaj
            // ve bir hata kodu dönülmeli
            return;
        }

        repository.save(Admin.builder()
                        .name(dto.getName())
                        .surname(dto.getSurname())
                        .password(dto.getPassword())
                        .email(dto.getEmail())
                .build());

    }

    public List<AdminResponseDto> getAll(){
        List<Admin> admins=repository.findAll();

        List<AdminResponseDto> responseDtos= new ArrayList<>();

        admins.forEach(admin->
                responseDtos.add(AdminResponseDto.builder()
                                .id(admin.getId())
                                .name(admin.getName())
                                .surname(admin.getSurname())
                        .build()));

        return responseDtos;

    }

    public List<AdminResponseDto> getAdminByName(String name){
        List<Admin> admins=repository.findByName(name);

        List<AdminResponseDto> responseDtos= new ArrayList<>();

        admins.forEach(admin -> responseDtos.add(AdminResponseDto.builder()
                        .name(admin.getName())
                        .surname(admin.getSurname())
                        .id(admin.getId())
                .build()));

        return responseDtos;
    }

    public List<AdminResponseDto> getAdminBySurname(String surname){
        List<Admin> admins= repository.findBySurname(surname);
        List<AdminResponseDto> responses=new ArrayList<>();

        for (Admin admin: admins){
            responses.add(AdminResponseDto.builder()
                            .id(admin.getId())
                            .name(admin.getName())
                            .surname(admin.getSurname())
                    .build());
        }

        return responses;
    }


}
