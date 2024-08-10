package com.vektorel.restful.service;

import com.vektorel.restful.dto.request.AdminSaveRequestDto;
import com.vektorel.restful.dto.request.AdminUpdateRequestDto;
import com.vektorel.restful.dto.response.AdminResponseDto;
import com.vektorel.restful.entity.Admin;
import com.vektorel.restful.exception.AllException;
import com.vektorel.restful.exception.custom.AdminBulunamadiException;
import com.vektorel.restful.exception.custom.MailException;
import com.vektorel.restful.mapper.AdminMapper;
import com.vektorel.restful.mapper.IAdminMapper;
import com.vektorel.restful.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;
    // bizim olusturduğumuz mapper
    private final AdminMapper adminMapper;

    public AdminResponseDto save(AdminSaveRequestDto dto){

        Optional<Admin> admin=  repository.findOptionalByEmail(dto.getEmail());

        if (admin.isPresent()){
            // normalde front-end 'e bu mail zaten kayıtlı diyen bir mesaj
            // ve bir hata kodu dönülmeli

            /*RuntimeException r= new RuntimeException();
            throw r; */
            throw new MailException(AllException.ADMIN_ZATEN_KAYITLI);
        }
        // kontrolsüz unchecked hatalar
        // kontrollü checked hatalar

        // talep edilen admin
        // kaynak dto -> AdminSaveRequestDto
        Admin admin1=repository.save(IAdminMapper.INSTANCE.AdminSaveDtoToAdmin(dto));
        // talep edilen -> AdminREsponseDto
        // kaynak admin1-> Admin nesnesi
        return IAdminMapper.INSTANCE.toDto(admin1);
    }

    public List<AdminResponseDto> getAll(){
        List<Admin> admins=repository.findAll();

        List<AdminResponseDto> responseDtos= new ArrayList<>();

        admins.forEach(admin->
                responseDtos.add(AdminResponseDto.builder()
                                .id(admin.getId())
                                .name(admin.getName())
                                .surname(admin.getSurname())
                        .build()));

        return responseDtos;

    }

    public List<AdminResponseDto> getAdminByName(String name){

        List<Admin> admins=repository.findByName(name);

        if (admins.isEmpty()){
            throw new AdminBulunamadiException(AllException.ADMIN_BULUNAMADI);
        }


        List<AdminResponseDto> responseDtos= new ArrayList<>();

        admins.forEach(admin -> responseDtos.add(AdminResponseDto.builder()
                        .name(admin.getName())
                        .surname(admin.getSurname())
                        .id(admin.getId())
                .build()));

        return responseDtos;
    }

    public List<AdminResponseDto> getAdminBySurname(String surname){
        List<Admin> admins= repository.findBySurname(surname);
        List<AdminResponseDto> responses=new ArrayList<>();

        for (Admin admin: admins){
            responses.add(AdminResponseDto.builder()
                            .id(admin.getId())
                            .name(admin.getName())
                            .surname(admin.getSurname())
                    .build());
        }

        return responses;
    }

    // hard delete
    public void delete(Long id){
        // bu id ye ait admin var mı kontrolü ?
        // if kontrolü icin 2 yöntem kullanabilirsiniz
        // 1.yöntem
 /*       Optional<Admin> admin= repository.findById(id);
        if (admin.isEmpty()){
            throw new AdminBulunamadiException(AllException.ADMIN_BULUNUMADI_ID);
        }*/

        //2.yöntem

        if (!repository.existsById(id)){
            throw new AdminBulunamadiException(AllException.ADMIN_BULUNUMADI_ID);
        }

        repository.deleteById(id);
    }

    // soft Delete

    public void softDelete(Long id){
       Optional<Admin> admin= repository.findById(id);

       if (admin.isEmpty()){
           throw new AdminBulunamadiException(AllException.ADMIN_BULUNUMADI_ID);
       }
       admin.get().setDeleted((byte) 1);
       repository.save(admin.get());

    }

    public void update(AdminUpdateRequestDto dto){
        Optional<Admin> admin= repository.findById(dto.getId());
        if (admin.isEmpty()){
            throw new AdminBulunamadiException(AllException.ADMIN_BULUNUMADI_ID);
        }

        repository.save(adminMapper.admineCevirAdminUpdateDtoDan(admin.get(),dto));
    }

}
