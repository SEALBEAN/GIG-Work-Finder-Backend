package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.JobMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JobMappingRepository extends JpaRepository<JobMappingEntity, Integer> {

    @Modifying
    @Query(value = """
            UPDATE JobMapping
            SET State = 1s
            WHERE MapID = ?1""" , nativeQuery = true)
    @Transactional
    Integer confirm(int mid);

    @Modifying
    @Query(value = """
            UPDATE JobMapping
            SET State = 2
            WHERE MapID = ?1""" , nativeQuery = true)
    @Transactional
    Integer finish(int mid);

    @Modifying
    @Query(value = """
            UPDATE JobMapping
            SET State = 3
            WHERE MapID = ?1""" , nativeQuery = true)
    @Transactional
    Integer cancel(int mid);
}
