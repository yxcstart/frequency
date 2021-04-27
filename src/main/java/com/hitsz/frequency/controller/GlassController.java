package com.hitsz.frequency.controller;

import com.hitsz.frequency.entity.Glass;
import com.hitsz.frequency.service.GlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yang
 * @create 2021-04-15 10:04
 */
@Controller
public class GlassController {
    @Autowired
    private GlassService glassService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndex(){
        return "/index";
    }
    @RequestMapping(path = "/index",method =RequestMethod.POST)
    public String query(Model model,Glass glassPara){
        Glass glass = glassService.findGlass(glassPara.getWidth(), glassPara.getHeight(), glassPara.getThick());
        model.addAttribute("glass", glass);
        return "/index";
    }

}
