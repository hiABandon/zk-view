package org.huifer.zkview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping("/index")
  public String index(){
    return "index";
  }

  @GetMapping("/index-hhs")
  public String index_hhs(){
    return "index-hhs";
  }
}
