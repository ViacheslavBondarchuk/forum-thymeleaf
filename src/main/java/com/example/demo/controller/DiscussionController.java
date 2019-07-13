package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.DiscussionDTO;
import com.example.demo.service.CommentService;
import com.example.demo.service.DiscussionService;
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
    public String showTopic(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute("topic", discussionService.getTopic(Long.parseLong(id)));
        model.addAttribute("comments", discussionService.getAllComents(Long.parseLong(id)));
        return "topic";
    }

    @PostMapping("/topic/{id}")
    public String addComment(@Validated @ModelAttribute CommentDTO commentDTO, @PathVariable String id) throws NotFoundException {
        discussionService.saveComment(Long.parseLong(id), commentDTO);
        System.out.println("HELLO");
        return "redirect:/topic/" + id;
    }


}
