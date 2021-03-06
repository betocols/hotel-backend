package com.mdw.daos;

import com.mdw.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends JpaRepository<ReservationEntity, Long> {
}
