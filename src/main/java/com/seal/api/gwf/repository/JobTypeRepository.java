package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.entity.JobTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTypeRepository extends JpaRepository<JobTypeEntity, Integer> {

    @Query(value = "SELECT * FROM dbo.FN_PopularJobType()", nativeQuery = true)
    public List<JobTypeEntity> getPopularJobType();


}
