package com.seal.api.gwf.repository;

import com.seal.api.gwf.dto.create.City;
import com.seal.api.gwf.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
    @Query(value = "SELECT * FROM dbo.VW_Province",nativeQuery = true)
    List<String> getAllProvince();

    @Query(value = "SELECT * FROM dbo.FN_ListCity(?1)", nativeQuery = true)
    List<LocationEntity> getCitysByProvince(String province);
}
