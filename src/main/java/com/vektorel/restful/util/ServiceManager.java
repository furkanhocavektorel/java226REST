package com.vektorel.restful.util;

import com.vektorel.restful.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ServiceManager<T extends BaseEntity,ID> implements IServiceManager<T,ID> {

    private final JpaRepository<T,ID> jpaRepository;

    public ServiceManager(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(T t) {
        t.setCreateDate(LocalDateTime.now().toString());
        t.setDeleted((byte) 0);
        jpaRepository.save(t);
    }

    @Override
    public void deleteByID(ID id) {
        jpaRepository.deleteById(id);
    }

    // bu soft delete yerine geçecek
    // burada t entity sinde ki
    // deleted alanı 1'e cekilmeli
    @Override
    public void delete(T t) {
        t.setDeleted((byte) 1);
        update(t);
    }

    @Override
    public void update(T t) {
        t.setUpdateDate(LocalDateTime.now().toString());
        jpaRepository.save(t);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> getAll() {
        return jpaRepository.findAll();
    }
}
