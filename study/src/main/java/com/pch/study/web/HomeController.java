package com.pch.study.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "测试类",tags = "测试接口")
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

    @RequestMapping(value = "/say", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "默认页面", notes = "home")
    public String say(@ApiParam(name = "word",value = "语句",required = false) @RequestParam(required = false, defaultValue = "nothing") String word) {
        return String.format("you said => %s", word);
    }
}
