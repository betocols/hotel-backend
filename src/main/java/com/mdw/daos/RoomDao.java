package com.mdw.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdw.entities.RoomEntity;

@Repository
public interface RoomDao extends JpaRepository<RoomEntity, Long> {
    public RoomEntity findById(long id);
}
