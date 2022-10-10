package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Integer> {

    @Query(value = "SELECT * FROM Applicant WHERE AccountID = ?1", nativeQuery = true)
    ApplicantEntity getByAccountID(int id);
}
