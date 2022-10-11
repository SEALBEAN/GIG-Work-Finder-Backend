package com.seal.api.gwf.repository;

import com.seal.api.gwf.dto.create.BusinessAddress;
import com.seal.api.gwf.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, Integer> {
    @Query(value = "SELECT * FROM Business WHERE BusinessID = ?1", nativeQuery = true)
    BusinessEntity getByID(int id);

    @Query(value = "SELECT * FROM Business",nativeQuery = true)
    List<BusinessEntity> getAll();

    @Query(value = "SELECT * FROM Business WHERE AccountID = ?1", nativeQuery = true)
    List<BusinessEntity> getAllBusinessAddress(int id);
}
