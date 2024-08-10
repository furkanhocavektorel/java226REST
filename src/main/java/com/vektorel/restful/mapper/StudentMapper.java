package com.vektorel.restful.mapper;

import com.vektorel.restful.dto.request.StudentCreateRQDTO;
import com.vektorel.restful.dto.response.StudentDTO;
import com.vektorel.restful.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    Student studentCreateDTOtoStudent(StudentCreateRQDTO studentCreateRQDTO);
    StudentDTO studentToStudentDTO(Student student);


}

