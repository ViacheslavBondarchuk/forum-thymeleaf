package com.example.demo.service;

import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic getTopic(long id) throws NotFoundException {
        return topicRepository.findById(id).orElseThrow(() -> new NotFoundException("Topic not found"));
    }
}
