package com.seal.api.gwf.repository;

import com.seal.api.gwf.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Integer> {

    RecruiterEntity findByAccountID(int ID);
    RecruiterEntity findByEmail(String email);


}
