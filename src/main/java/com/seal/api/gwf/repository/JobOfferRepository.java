package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.JobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository <JobOfferEntity, Integer> {

    @Query(value = "SELECT * FROM JobOffer WHERE Status = 1" ,nativeQuery = true)
    List<JobOfferEntity> getAll();

    @Query(value = "SELECT * FROM JobOffer\n" +
            "Where OfferID = ?1"
            , nativeQuery = true)
    JobOfferEntity findByOfferID(int ID);

    @Query(value = "SELECT * FROM JobOffer WHERE BusinessID = ?1 AND Status = 1", nativeQuery = true)
    List<JobOfferEntity> findByBusinessID(int id);

    @Query(value = "SELECT * FROM dbo.FN_HurryJobOffer()", nativeQuery = true)
    List<JobOfferEntity> getHurryJobOffer();

    @Query(value = "SELECT dbo.FN_PopScoreJobOffer(?1)", nativeQuery = true)
    Float calPopularScore(int id);

    @Modifying
    @Query(value = "INSERT INTO JobOffer VALUES (:accountID, :jobType, :location, :degree, :numOfRecruit, :offerEndTime, :createdDate, 0, :salary, :age, 0, :jobDescription, :other, :startTime, :endTime, :address, :business, :popularScore)", nativeQuery = true)
    @Transactional
    int addJobOffer(int accountID, int jobType, Integer location, Integer degree, int numOfRecruit, Timestamp offerEndTime, Timestamp createdDate, Integer salary, Integer age, String jobDescription, String other, Time startTime, Time endTime, String address, Integer business, Integer popularScore);

}
