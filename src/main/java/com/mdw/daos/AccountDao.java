package com.mdw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdw.entities.AccountEntity;


@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Long>{
    public List<AccountEntity> findAll();
}
