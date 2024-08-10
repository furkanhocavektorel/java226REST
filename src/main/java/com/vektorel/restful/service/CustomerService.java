package com.vektorel.restful.service;

import com.vektorel.restful.dto.request.CustomerSaveRQ;
import com.vektorel.restful.entity.Customer;
import com.vektorel.restful.exception.custom.KullaniciBulunamadiException;
import com.vektorel.restful.mapper.ICustomerMapper;
import com.vektorel.restful.repository.CustomerRepository;
import com.vektorel.restful.util.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repository) {
        super(repository);
        this.customerRepository=repository;
    }

    public void saveCustomer(CustomerSaveRQ dto){
        if (customerRepository.findOptionalByEmail(dto.getEmail()).isPresent()){
            throw new KullaniciBulunamadiException("kullanici zaten kayitli");
        }

        // TODO CustomerMapper nesnesi oluşturulamıyor.

        Customer c= ICustomerMapper.INSTANCE.toCustomer(dto);

        save(c);
    }
}
