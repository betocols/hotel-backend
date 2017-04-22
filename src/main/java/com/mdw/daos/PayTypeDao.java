package com.mdw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdw.entities.PayTypeEntity;


public interface PayTypeDao extends JpaRepository<PayTypeEntity, String>{
    public List<PayTypeEntity> findAll();
}

