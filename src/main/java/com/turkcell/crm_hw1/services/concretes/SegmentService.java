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
        Segment segment = new Segment();
        segment.setSegmentName(createSegmentDto.getName());
        segment.setCreatedDate(LocalDateTime.now());

        segmentRepository.save(segment);
    }

    @Override
    public void update(UpdateSegmentDto updateSegmentDto) {
        Segment segment = segmentRepository.findById(updateSegmentDto.getId())
                .orElse(null);

        if(segment == null) {
            throw new RuntimeException("Segment does not exist");
        }

        segment.setSegmentName(updateSegmentDto.getName());
        segment.setUpdatedDate(LocalDateTime.now());
        segmentRepository.save(segment);
    }

    @Override
    public String delete(String id) {
        Segment segment = segmentRepository.findById(id)
                .orElse(null);

        if(segment == null) {
            throw new RuntimeException("Segment does not exist");
        }
        segmentRepository.delete(segment);
        return id;
    }

    @Override
    public List<GetAllSegmentsDto> getAll() {
        List<GetAllSegmentsDto> getAllSegmentsDtos = segmentRepository
                .findAll()
                .stream()
                .map((segment) -> new GetAllSegmentsDto(segment.getSegmentName()))
                .toList();

        return getAllSegmentsDtos;
    }

    @Override
    public Optional<Segment> findById(String id) {
        Segment segment = segmentRepository.findById(id)
                .orElse(null);

        if(segment == null)
            throw new RuntimeException("Segment does not exist");
        return Optional.of(segment);
    }
}
