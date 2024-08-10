package com.vektorel.restful.mapper;

import com.vektorel.restful.dto.request.AdminSaveRequestDto;
import com.vektorel.restful.dto.response.AdminResponseDto;
import com.vektorel.restful.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAdminMapper {

    IAdminMapper INSTANCE = Mappers.getMapper( IAdminMapper.class );

    Admin AdminSaveDtoToAdmin(AdminSaveRequestDto dto);

    AdminResponseDto toDto(Admin admin);
}







