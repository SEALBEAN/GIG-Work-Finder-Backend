package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Integer> {
    public ApplicantEntity findByEmail(String email);
}
