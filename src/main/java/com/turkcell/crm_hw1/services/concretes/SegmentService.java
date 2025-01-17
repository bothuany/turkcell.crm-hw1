package com.turkcell.crm_hw1.services.concretes;

import com.turkcell.crm_hw1.dtos.segment.CreateSegmentDto;
import com.turkcell.crm_hw1.dtos.segment.GetAllSegmentsDto;
import com.turkcell.crm_hw1.dtos.segment.UpdateSegmentDto;
import com.turkcell.crm_hw1.entity.Segment;
import com.turkcell.crm_hw1.repositories.SegmentRepository;
import com.turkcell.crm_hw1.rules.SegmentBusinessRules;
import com.turkcell.crm_hw1.services.abstracts.ISegmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SegmentService implements ISegmentService {
    private final SegmentBusinessRules segmentBusinessRules;
    private final SegmentRepository segmentRepository;

    public SegmentService(SegmentBusinessRules segmentBusinessRules, SegmentRepository segmentRepository) {
        this.segmentBusinessRules = segmentBusinessRules;
        this.segmentRepository = segmentRepository;
    }

    @Override
    public void add(CreateSegmentDto createSegmentDto) {
        segmentBusinessRules.checkIfSegmentNameExists(createSegmentDto.getName());

        Segment segment = Segment.builder()
                .name(createSegmentDto.getName())
                .build();

        segmentRepository.save(segment);
    }

    @Override
    public void update(UpdateSegmentDto updateSegmentDto) {
        segmentBusinessRules.checkIfSegmentExists(updateSegmentDto.getId());
        
        Segment segment = segmentRepository.findById(updateSegmentDto.getId()).get();

        // Check if new name exists but ignore if it's the same segment
        segmentRepository.findByNameIgnoreCase(updateSegmentDto.getName())
                .ifPresent(existingSegment -> {
                    if (!existingSegment.getId().equals(updateSegmentDto.getId())) {
                        throw new RuntimeException("Segment with name '" + updateSegmentDto.getName() + "' already exists");
                    }
                });

        segment = Segment.builder()
                .id(segment.getId())
                .name(updateSegmentDto.getName())
                .createdDate(segment.getCreatedDate())
                .updatedDate(LocalDateTime.now())
                .build();

        segmentRepository.save(segment);
    }

    @Override
    public String delete(String id) {
        segmentBusinessRules.checkIfSegmentExists(id);
        
        Segment segment = segmentRepository.findById(id).get();
        segmentRepository.delete(segment);
        return id;
    }

    @Override
    public List<GetAllSegmentsDto> getAll() {
        return segmentRepository
                .findAll()
                .stream()
                .map(segment -> GetAllSegmentsDto.builder()
                        .id(segment.getId())
                        .name(segment.getName())
                        .build())
                .toList();
    }

    @Override
    public Optional<Segment> findById(String id) {
        segmentBusinessRules.checkIfSegmentExists(id);
        return segmentRepository.findById(id);
    }
}
