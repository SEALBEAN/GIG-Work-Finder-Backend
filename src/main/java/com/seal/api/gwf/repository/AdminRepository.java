package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.AdminEntity;
import com.seal.api.gwf.entity.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    public AdminEntity findByEmail(String email);
}
