package com.codingtask.datasnapshot.repository;

import com.codingtask.datasnapshot.entity.CorruptData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorruptDataRepository extends JpaRepository<CorruptData,Integer> {
}
