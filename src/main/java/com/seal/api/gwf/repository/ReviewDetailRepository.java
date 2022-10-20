package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.ReviewDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDetailRepository extends JpaRepository<ReviewDetailEntity, Integer> {

    @Query(value = "SELECT * FROM ReviewDetail WHERE ReviewID = ?1 AND Status = 1", nativeQuery = true)
    ReviewDetailEntity findByID(int id);
    @Query(value = "SELECT * FROM ReviewDetail WHERE AccountID = ?1 AND Status = 1", nativeQuery = true)
    List<ReviewDetailEntity> findByAccountID(int id);
}
