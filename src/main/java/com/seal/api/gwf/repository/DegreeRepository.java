package com.seal.api.gwf.repository;

import com.seal.api.gwf.dto.create.DegreeName;
import com.seal.api.gwf.entity.DegreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeRepository extends JpaRepository<DegreeEntity, Integer> {

    @Query(value = "SELECT * FROM Degree", nativeQuery = true)
    List<DegreeEntity> getAllDegreeName();

}
