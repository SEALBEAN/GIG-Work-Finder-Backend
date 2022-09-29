package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.JobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository <JobOfferEntity, Integer> {


    public List<JobOfferEntity> findByLocationID(int ID);

    public List<JobOfferEntity> findByAccountID(int ID);

    @Query(value = "SELECT * FROM JobOffer\n" +
            "Where OfferID = ?1"
            , nativeQuery = true)
    public JobOfferEntity findByOfferID(int ID);

}
