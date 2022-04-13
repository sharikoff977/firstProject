package com.sharikoff977.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String index() {
    // For common model sharing only. See: CommonModelAdvice
    return "index";
  }

}
