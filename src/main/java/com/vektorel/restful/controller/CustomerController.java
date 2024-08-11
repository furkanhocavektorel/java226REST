package com.vektorel.restful.controller;

import com.vektorel.restful.dto.request.CustomerSaveRQ;
import com.vektorel.restful.service.CustomerService;
import com.vektorel.restful.util.JWTManager;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final JWTManager jwtManager;
    @PostMapping("save")
    public void saveCustomer(@RequestBody CustomerSaveRQ dto){
        customerService.saveCustomer(dto);
    }

    @GetMapping("token-test/{id}")
    public String tokenTest(@PathVariable Long id){
        return jwtManager.createToken(id).get();
    }


    @GetMapping("id-test/{token}")
    public Long IdTest(@PathVariable String token){
        return jwtManager.getIdByToken(token).get();
    }



}
