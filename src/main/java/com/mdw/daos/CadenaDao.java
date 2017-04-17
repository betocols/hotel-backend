package com.mdw.daos;

import com.mdw.entities.CadenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadenaDao extends JpaRepository<CadenaEntity, Long> {
}
