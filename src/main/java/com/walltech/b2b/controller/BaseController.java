package com.walltech.b2b.controller;

import com.walltech.b2b.utils.GetStaticVariableUtil;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zeddwang on 2017/7/5.
 */
public class BaseController {
    protected ModelAndView getBasicData(HttpServletRequest request, String pageUrl){
        ModelAndView view = new ModelAndView(pageUrl);
        view.addObject("homeUrl", GetStaticVariableUtil.homeUrl);
        view.addObject("resourceUrl", GetStaticVariableUtil.resourceUrl);
        return view;
    }
}
