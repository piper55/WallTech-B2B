package com.walltech.b2b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zeddwang on 2017/7/5.
 */
@Controller
@RequestMapping(value = "fileanalysis")
public class FileAnalysisController extends BaseController {

    @RequestMapping("/")
    public ModelAndView  indexPageOfFileAnalysis(HttpServletRequest request){
        ModelAndView view = getBasicData(request, "pages/analysis/demo");



        return view;
    }
}
