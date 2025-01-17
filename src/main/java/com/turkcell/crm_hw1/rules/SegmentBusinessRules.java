package com.turkcell.crm_hw1.rules;

import com.turkcell.crm_hw1.repositories.SegmentRepository;
import org.springframework.stereotype.Service;

@Service
public class SegmentBusinessRules {
    private final SegmentRepository segmentRepository;

    public SegmentBusinessRules(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public void checkIfSegmentExists(String id) {
        if (!segmentRepository.existsById(id)) {
            throw new RuntimeException("Segment does not exist");
        }
    }

    public void checkIfSegmentNameExists(String name) {
        if (segmentRepository.findByNameIgnoreCase(name).isPresent()) {
            throw new RuntimeException("Segment with name '" + name + "' already exists");
        }
    }
}
