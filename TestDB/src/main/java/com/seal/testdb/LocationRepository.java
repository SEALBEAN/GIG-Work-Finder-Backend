package com.seal.testdb;

import com.seal.testdb.Entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
    public List<LocationEntity> findByCity(String s);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Admin(UserName, password, name) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public int insertAdmin(String user, String password, String name);
}
