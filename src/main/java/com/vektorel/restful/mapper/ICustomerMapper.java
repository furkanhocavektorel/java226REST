package com.vektorel.restful.mapper;

import com.vektorel.restful.dto.request.CustomerSaveRQ;
import com.vektorel.restful.entity.Admin;
import com.vektorel.restful.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper( ICustomerMapper.class );

    Customer toCustomer(CustomerSaveRQ dto);
}
