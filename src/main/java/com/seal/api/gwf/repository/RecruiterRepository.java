package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Integer> {
    @Query(value = "SELECT * FROM Recruiter WHERE AccountID = ?1 AND Status = 1", nativeQuery = true)
    RecruiterEntity findByAccountID(int ID);


}
