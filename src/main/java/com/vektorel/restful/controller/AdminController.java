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

    // 3 adet request tipi vardır
    // 1_ RequestBody
    // 2_ RequestParam
    // 3_ Pathvariable
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
    // localhost:80/admin/find-name?qt=furkan
    public List<AdminResponseDto> getAdminByName(@RequestParam(name = "qt") String name){
        return adminService.getAdminByName(name);
    }

    @GetMapping("find-surname/{q}")
    public List<AdminResponseDto> getAdminBySurname (@PathVariable(name = "q") String surname){
        return adminService.getAdminBySurname(surname);
    }



}
