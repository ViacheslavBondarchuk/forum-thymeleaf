package com.example.demo.service;

import com.example.demo.dto.DiscussionDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Discussion;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.DiscussionRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<Discussion> getAllDiscussion() {
        return discussionRepository.findAll();
    }

    public void addDiscussion(DiscussionDTO discussionDTO) {
        discussionRepository.save(new ModelMapper().map(discussionDTO, Discussion.class));
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public Discussion getTopic(long id) throws NotFoundException {
        return discussionRepository.findById(id).orElseThrow(() -> new NotFoundException("Topic not found"));
    }

    public List<Comment> getAllComents(long id){
        return commentRepository.findAllByDiscussion_Id(id);
    }
}
