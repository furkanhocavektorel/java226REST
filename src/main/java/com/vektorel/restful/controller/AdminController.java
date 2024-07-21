package com.vektorel.restful.controller;

import com.vektorel.restful.dto.request.AdminSaveRequestDto;
import com.vektorel.restful.dto.response.AdminResponseDto;
import com.vektorel.restful.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @PostMapping("save")
    @CrossOrigin("*")
    public void create(@RequestBody AdminSaveRequestDto dto){
        adminService.save(dto);
    }

    @GetMapping("get-all")
    public List<AdminResponseDto> getAll(){
        return adminService.getAll();
    }

    @GetMapping("find-name")
    // localhost:80/admin/find-name?name=furkan
    public List<AdminResponseDto> getAdminByName(@RequestParam String name){
        return adminService.getAdminByName(name);
    }


}
