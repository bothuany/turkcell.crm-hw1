package com.turkcell.crm_hw1.services.abstracts;

import com.turkcell.crm_hw1.dtos.segment.CreateSegmentDto;
import com.turkcell.crm_hw1.dtos.segment.GetAllSegmentsDto;
import com.turkcell.crm_hw1.dtos.segment.UpdateSegmentDto;
import com.turkcell.crm_hw1.entity.Segment;

import java.util.List;
import java.util.Optional;

public interface ISegmentService {
    void add(CreateSegmentDto createSegmentDto);
    void update(UpdateSegmentDto updateSegmentDto);
    String delete(String id);
    List<GetAllSegmentsDto> getAll();
    Optional<Segment> findById(String id);
}
