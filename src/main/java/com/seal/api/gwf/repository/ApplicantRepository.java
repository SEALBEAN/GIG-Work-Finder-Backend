package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Integer> {

    @Query(value = "SELECT * FROM Applicant WHERE AccountID = ?1", nativeQuery = true)
    ApplicantEntity getByAccountID(int id);

    @Query(value = "SELECT * FROM Applicant WHERE Email = ?1", nativeQuery = true)
    ApplicantEntity findByEmail(String email);
    @Modifying
    @Query(value = "INSERT INTO Applicant(FirstName, LastName, Gender, Email, Verify, Status) " +
            "VALUES (:firstName, :lastName, :gender, :email, 1, 1)",nativeQuery = true)
    @Transactional
    Integer addApplicant(String firstName, String lastName, String gender, String email);

    @Modifying
    @Query(value = """
            UPDATE Applicant
            SET LocationID = ?2, DegreeID = ?3, FirstName = ?4, LastName = ?5, Phone = ?6, DOB = ?7, Gender = ?8, Address = ?9, Description = ?10
            WHERE AccountID = ?1""", nativeQuery = true)
    @Transactional
    int updateApp(int accountID, Integer locationID, Integer degreeID, String firstName, String lastName, String phone, Timestamp dob, String gender, String address, String description);
}
