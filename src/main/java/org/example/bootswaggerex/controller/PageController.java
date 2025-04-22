package org.example.bootswaggerex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "파일 업로드");
        return "index";
    }
}
