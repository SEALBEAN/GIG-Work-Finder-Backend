package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.JobApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplicationEntity, Integer> {

    @Query(value = "SELECT * FROM JobApplication WHERE Status = 1 AND Available = 1", nativeQuery = true)
    List<JobApplicationEntity> getAll();

    @Query(value = """
            SELECT JA.ApplicationID AS ApplicationID, JA.AccountID AS AccountID, JA.CreatedDate AS CreatedDate, EndDate, JA.Salary AS Salary, JA.Visual AS Visual, JA.Other AS Other, JA.StartTime AS StartTime, JA.EndTime AS EndTime, JA.Status AS Status, JA.Age AS Age, Available
            FROM JobApplication  JA
            INNER JOIN JobMapping JM on JA.ApplicationID = JM.ApplicationID
            INNER JOIN JobOffer JO on JM.OfferID = JO.OfferID
            WHERE JM.OfferID = ?1
            """, nativeQuery = true)
    List<JobApplicationEntity> getAllByOfferID(int offerID);

    @Query(value = "SELECT * FROM JobApplication WHERE ApplicationID = ?1", nativeQuery = true)
    JobApplicationEntity findByApplicationId(int applicationID);

    @Modifying
    @Query(value = "INSERT INTO JobMapping(OfferID, ApplicationID, AccountID) " +
            "VALUES (:oid, :jaid, :aid)", nativeQuery = true)
    @Transactional
    Integer applyJA(Integer oid, int jaid, int aid);
    @Modifying
    @Query(value = """
            UPDATE JobApplication
            SET CreatedDate = GETDATE(), EndDate = GETDATE()+30, Other = :other, StartTime = :startTime, EndTime = :endTime, Available = :available
            WHERE AccountID = :accountID
            """, nativeQuery = true)
    @Transactional
    Integer updateJA(int accountID, String other, Time startTime, Time endTime, int available);



}
