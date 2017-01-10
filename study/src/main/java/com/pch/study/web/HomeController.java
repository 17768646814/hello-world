package com.pch.study.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView hello(@RequestParam(required = false, defaultValue = "") String params, @RequestParam(required = false, defaultValue = "") String jsonParams,RedirectAttributes attr) {
        String url = "redirect:/index.html";
        if(!params.isEmpty()) {
            url+=params;
        }
        ModelAndView modelAndView = new ModelAndView(url);
        if(!jsonParams.isEmpty()) {
            modelAndView.addObject("jsonParams", jsonParams);
        }
        return modelAndView;
    }
}
