package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Integer> {
    @Query(value = "SELECT * FROM Recruiter WHERE AccountID = ?1 AND Status = 1", nativeQuery = true)
    RecruiterEntity findByAccountID(int ID);
    RecruiterEntity findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE Recruiter\n" +
            "SET FirstName = ?2, LastName = ?3, Phone = ?4, Gender = ?5, Email = ?6, Description = ?7\n" +
            "WHERE AccountID = ?1", nativeQuery = true)
    @Transactional
    Integer updateRecruiter(int accountID, String firstName, String lastName, String phone, String gender, String email, String description);
}
