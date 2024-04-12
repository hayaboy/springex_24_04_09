package com.green.springex.controller;

import com.green.springex.dto.TodoDTO;
import com.green.springex.service.TodoService;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list --- GET ----");

        model.addAttribute("dtoList", todoService.getAll());

    }
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register.......");
    }


    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POSt todo register.......");

        log.info(bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            //log.info(bindingResult.hasErrors()+"" + bindingResult+redirectAttributes);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        todoService.register(todoDTO);

        log.info("todoDTO : " + todoDTO);
        return "redirect:/todo/list";
    }
}
