package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.annotation.WebController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@WebController
public class IndexController
{
    @RequestMapping("/")
    public View index()
    {
        return new RedirectView("/discussion", true, false);
    }
}
