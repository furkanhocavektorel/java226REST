package com.vektorel.restful.controller;

import com.vektorel.restful.dto.request.AdminSaveRequestDto;
import com.vektorel.restful.dto.request.AdminUpdateRequestDto;
import com.vektorel.restful.dto.request.StudentCreateRQDTO;
import com.vektorel.restful.dto.response.AdminResponseDto;
import com.vektorel.restful.dto.response.StudentDTO;
import com.vektorel.restful.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AdminResponseDto> create(@RequestBody AdminSaveRequestDto dto){
        return ResponseEntity.ok(adminService.save(dto));
    }

    @GetMapping("get-all")
    public ResponseEntity<List<AdminResponseDto>> getAll(){
        return ResponseEntity.ok(adminService.getAll());
    }

    @GetMapping("find-name")
    // localhost:80/admin/find-name?qt=furkan
    public ResponseEntity<List<AdminResponseDto>> getAdminByName(@RequestParam(name = "qt") String name){
        return ResponseEntity.ok(adminService.getAdminByName(name));
    }

    @GetMapping("find-surname/{q}")
    public ResponseEntity<List<AdminResponseDto>> getAdminBySurname (@PathVariable(name = "q") String surname){
        return ResponseEntity.ok(adminService.getAdminBySurname(surname));
    }

    @DeleteMapping("hard-delete/{id}")
    public void hardDelete(@PathVariable Long id){
        adminService.delete(id);
    }
    @PostMapping("soft-delete")
    public void softDelete(@RequestBody Long id){
        adminService.softDelete(id);
    }
    @PutMapping("update")
    public void update(@RequestBody AdminUpdateRequestDto dto){
        adminService.update(dto);
    }


    @PostMapping("save-student")
    public StudentDTO saveStudent(@RequestBody StudentCreateRQDTO dto){
        return saveStudent(dto);
    }

}
