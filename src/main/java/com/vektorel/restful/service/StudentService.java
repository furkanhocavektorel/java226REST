package com.vektorel.restful.service;

import com.vektorel.restful.dto.request.StudentCreateRQDTO;
import com.vektorel.restful.dto.response.StudentDTO;
import com.vektorel.restful.entity.Student;
import com.vektorel.restful.mapper.StudentMapper;
import com.vektorel.restful.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDTO create(StudentCreateRQDTO studentCreateRQDTO) {
        Optional<Student> studentOptional = studentRepository.findOptionalByEmail(studentCreateRQDTO.getEmail());

        if (studentOptional.isPresent()) {
            throw new RuntimeException("Student already exist with : " + studentOptional.get().getEmail());
        }
        Student student = studentRepository.save(
                Student.builder()
                        .name(studentCreateRQDTO.getName())
                        .surname(studentCreateRQDTO.getSurname())
                        .email(studentCreateRQDTO.getEmail())
                        .gender(studentCreateRQDTO.getGender())
                        .password(studentCreateRQDTO.getPassword())
                        .build()
        );

        return StudentMapper.INSTANCE.studentToStudentDTO(student);
    }
}






