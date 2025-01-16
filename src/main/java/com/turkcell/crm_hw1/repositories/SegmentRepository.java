package com.turkcell.crm_hw1.repositories;

import com.turkcell.crm_hw1.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SegmentRepository extends JpaRepository<Segment, String> {
}
