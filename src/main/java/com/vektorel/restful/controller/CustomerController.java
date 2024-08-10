package com.vektorel.restful.controller;

import com.vektorel.restful.dto.request.CustomerSaveRQ;
import com.vektorel.restful.service.CustomerService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("save")
    public void saveCustomer(@RequestBody CustomerSaveRQ dto){
        customerService.saveCustomer(dto);
    }
}
