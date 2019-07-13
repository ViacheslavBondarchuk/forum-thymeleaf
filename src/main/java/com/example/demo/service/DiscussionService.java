package com.example.demo.service;

import com.example.demo.DTO.DiscussionDTO;
import com.example.demo.model.Discussion;
import com.example.demo.repository.DiscussionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    private DiscussionRepository discussionRepository;

    public List<Discussion> getAllDiscussion() {
        return discussionRepository.findAll();
    }

    public void addDiscussion(DiscussionDTO discussionDTO) {
        discussionRepository.save(new ModelMapper().map(discussionDTO, Discussion.class));
    }
}
