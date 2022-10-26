package com.seal.api.gwf.repository;

import com.seal.api.gwf.dto.JobOffer;
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

    @Query(value = "SELECT * FROM JobOffer " +
            "WHERE Status = 1" +
            "ORDER BY OfferEndTime", nativeQuery = true)
    List<JobOfferEntity> getHurryJobOffer();

    @Query(value = "SELECT dbo.FN_PopScoreJobOffer(?1)", nativeQuery = true)
    Float calPopularScore(int id);


    @Query(value = "SELECT * FROM JobOffer WHERE AccountID = ?1", nativeQuery = true)
    List<JobOfferEntity> getByAccountID(int aid);

    @Query(value = "SELECT * FROM JobOffer WHERE AccountID = ?1 AND Status = ?2", nativeQuery = true)
    List<JobOfferEntity> getByAccountID(int aid, int status);

    @Modifying
    @Query(value = "INSERT INTO JobOffer (AccountID, TypeID, LocationID, DegreeID, NumOfRecruit, OfferEndTime, CreatedDate, Salary, Age, Visual, JobDescription, Other, StartTime, EndTime, Address, BusinessID, PopularScore)" +
            "VALUES (:accountID, :jobType, :location, :degree, :numOfRecruit, :offerEndTime, :createdDate, :salary, :age, 0, :jobDescription, :other, :startTime, :endTime, :address, :business, :popularScore)", nativeQuery = true)
    @Transactional
    int addJobOffer(int accountID, Integer jobType, Integer location, Integer degree, int numOfRecruit, Timestamp offerEndTime, Timestamp createdDate, Integer salary, Integer age, String jobDescription, String other, Time startTime, Time endTime, String address, Integer business, Integer popularScore);

    @Modifying
    @Query(value = """
            UPDATE JobOffer
            SET TypeID = ?2, LocationID = ?3, DegreeID = ?4, NumOfRecruit = ?5, OfferEndTIme = ?6, CreatedDate = ?7, Salary = ?8, Age = ?9, JobDescription = ?10, Other = ?11, StartTime = ?12, EndTime = ?13, Address = ?14, BusinessID = ?15
            WHERE OfferID = ?1""", nativeQuery = true)
    @Transactional
    int updateJobOffer(Integer offerID, Integer jobType, Integer location, Integer degree, Integer numOfRecruit, Object offerEndTime, Timestamp createdDate, Integer salary, Integer age, String jobDescription, String other, Time startTime, Time endTime, String address, Integer business);

    @Modifying
    @Query(value = """
            UPDATE JobOffer
            SET Status = 0
            WHERE OfferID = ?1""", nativeQuery = true)
    @Transactional
    Integer deleteByID(int id);


}
