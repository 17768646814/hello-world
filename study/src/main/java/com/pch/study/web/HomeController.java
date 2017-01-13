package com.pch.study.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

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
    @ApiOperation(value = "默认页面", notes = "home.say")
    public String say(@ApiParam(name = "word",value = "语句",required = false) @RequestParam(required = false, defaultValue = "nothing") String word) {
        return String.format("you said => %s", word);
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    @ApiOperation(value = "默认页面", notes = "home.upload")
    public File upload(@ApiParam(name = "file",value = "文件",required = true) @RequestParam(required = true) MultipartFile file) {
        String userDir = System.getProperty("user.dir");
        File destFile = new File(userDir + File.separator + file.getOriginalFilename());
        try {
            FileCopyUtils.copy(file.getBytes(), destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }
}
