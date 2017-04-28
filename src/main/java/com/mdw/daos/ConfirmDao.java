package com.mdw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdw.entities.ConfirmEntity;


public interface ConfirmDao extends JpaRepository<ConfirmEntity, Long>{
    List<ConfirmEntity> findAll();

}
