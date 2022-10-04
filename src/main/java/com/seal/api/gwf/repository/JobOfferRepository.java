package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.JobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository <JobOfferEntity, Integer> {


    @Query(value = "SELECT * FROM JobOffer\n" +
            "Where OfferID = ?1"
            , nativeQuery = true)
    JobOfferEntity findByOfferID(int ID);

    @Query(value = "SELECT * FROM dbo.FN_HurryJobOffer()", nativeQuery = true)
    List<JobOfferEntity> getHurryJobOffer();

    @Query(value = "SELECT dbo.FN_PopScoreJobOffer(?1)", nativeQuery = true)
    Float calPopularScore(int id);


}
