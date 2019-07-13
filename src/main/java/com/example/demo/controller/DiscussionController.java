package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.DiscussionDTO;
import com.example.demo.service.DiscussionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @GetMapping("/discussion")
    public String showPage(Model model, DiscussionDTO discussionDTO) {
        model.addAttribute("discussions", discussionService.getAllDiscussion());
        return "discussion";
    }

    @PostMapping("/discussion")
    public String addDiscussion(@Valid @ModelAttribute DiscussionDTO discussionDTO
            , BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/discussion";
        }
        discussionService.addDiscussion(discussionDTO);
        return "redirect:/discussion";
    }

    @GetMapping("/topic/{id}")
    public String showTopic(@PathVariable String id, CommentDTO commentDTO, Model model) throws NotFoundException {
        model.addAttribute("topic", discussionService.getTopic(Long.parseLong(id)));
        model.addAttribute("comments", discussionService.getAllComents(Long.parseLong(id)));
        return "topic";
    }

    @PostMapping("/topic/{id}")
    public String addComment(@Valid @ModelAttribute CommentDTO commentDTO, BindingResult result
            , @PathVariable String id) throws NotFoundException {
        if (result.hasErrors()) {
            return "redirect:/topic/" + id;
        } else {
            discussionService.saveComment(Long.parseLong(id), commentDTO);
            return "redirect:/topic/" + id;
        }
    }


}
