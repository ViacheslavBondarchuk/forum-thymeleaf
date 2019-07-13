package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.DiscussionDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Discussion;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.DiscussionRepository;
import com.google.common.collect.ImmutableList;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private CommentRepository commentRepository;

    public Page<Discussion> getAllDiscussion(int page) {
        return discussionRepository.findAll(new PageRequest(page, 10));
    }

    public void addDiscussion(DiscussionDTO discussionDTO) {
        discussionRepository.save(new ModelMapper().map(discussionDTO, Discussion.class));
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public Discussion getTopic(long id) throws NotFoundException {
        return discussionRepository.findById(id).orElseThrow(() -> new NotFoundException("Topic not found"));
    }

    public List<Comment> getAllComents(long id) {
        return commentRepository.findAllByDiscussion_Id(id);
    }

    public void saveComment(long id, CommentDTO commentDTO) throws NotFoundException {
        Discussion discussion = discussionRepository.findById(id).orElseThrow(() -> new NotFoundException("Discussion was not found"));
        commentDTO.setDiscussion(discussion);
        commentDTO.setId(0);

        System.out.println(commentDTO.getId());

        commentRepository.save(new ModelMapper().map(commentDTO, Comment.class));
    }
}
