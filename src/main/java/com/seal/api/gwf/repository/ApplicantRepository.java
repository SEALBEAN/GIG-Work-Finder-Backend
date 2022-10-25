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
    public ApplicantEntity findByEmail(String email);

    @Query(value = "SELECT * FROM Applicant WHERE AccountID = ?1", nativeQuery = true)
    ApplicantEntity getByAccountID(int id);

    @Modifying
    @Query(value = "INSERT INTO Applicant(LocationID, DegreeID, FirstName, LastName, Phone, DOB, Gender, Email, Address, Verify, Status, Description) " +
            "VALUES (:locationID, :degreeID, :firstName, :lastName, :phone, :dob, :gender, :email, :address, 1, 1, :description)",nativeQuery = true)
    @Transactional
    Integer addApplicant(Integer locationID, Integer degreeID, String firstName, String lastName, String phone, Timestamp dob, String gender, String email, String address, String description);
}
