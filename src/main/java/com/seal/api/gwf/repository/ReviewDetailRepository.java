package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.ReviewDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDetailRepository extends JpaRepository<ReviewDetailEntity, Integer> {
}
