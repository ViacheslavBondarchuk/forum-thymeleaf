package com.example.demo.controller;

import com.example.demo.DTO.DiscussionDTO;
import com.example.demo.service.DiscussionService;
import com.example.demo.service.TopicService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;
    @Autowired
    private TopicService topicService;

    @GetMapping("/discussion")
    public String showPage(Model model) {
        model.addAttribute("discussions", discussionService.getAllDiscussion());
        return "discussion";
    }

    @PostMapping("/discussion")
    public String addDiscussion(@Validated @ModelAttribute DiscussionDTO discussionDTO) {
        discussionService.addDiscussion(discussionDTO);
        return "redirect:/discussion";
    }

    @GetMapping("/topic/{id}")
    public String showTopic(@PathVariable long id, Model model) throws NotFoundException {
        System.out.println(id);
        model.addAttribute("topic", topicService.getTopic(id));
        return "redirect:/topic";
    }


}
