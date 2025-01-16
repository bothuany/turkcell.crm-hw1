package com.turkcell.crm_hw1.controllers;

import com.turkcell.crm_hw1.dtos.segment.CreateSegmentDto;
import com.turkcell.crm_hw1.dtos.segment.GetAllSegmentsDto;
import com.turkcell.crm_hw1.dtos.segment.UpdateSegmentDto;
import com.turkcell.crm_hw1.entity.Segment;
import com.turkcell.crm_hw1.services.concretes.SegmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/segments")
public class SegmentController {
    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @PostMapping
    public void add(@RequestBody CreateSegmentDto createSegmentDto)
    {
        this.segmentService.add(createSegmentDto);
    }

    @GetMapping
    public List<GetAllSegmentsDto> getAll() {
        return this.segmentService.getAll();
    }

    @PutMapping
    public void update(@RequestBody UpdateSegmentDto updateSegmentDto)
    {
        this.segmentService.update(updateSegmentDto);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        this.segmentService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<Segment> getById(@PathVariable String id) {
        return segmentService.findById(id);
    }
}
