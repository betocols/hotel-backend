package com.mdw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdw.entities.CuentaBancaria;


@Repository
public interface CuentaDao extends JpaRepository<CuentaBancaria, Long>{
    public List<CuentaBancaria> findAll();
}
