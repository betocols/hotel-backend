package com.mdw.daos;

import com.mdw.entities.HotelChainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelChainDao extends JpaRepository<HotelChainEntity, Long> {
}
