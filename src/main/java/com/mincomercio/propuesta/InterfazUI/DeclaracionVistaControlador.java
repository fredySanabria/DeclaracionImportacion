package com.mincomercio.propuesta.InterfazUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeclaracionVistaControlador {
    @RequestMapping(path = "/vistaDeclaraciones",  method= RequestMethod.GET)
    public ModelAndView indexProfile (Model model, @RequestParam("id") int id) {

        ModelAndView modelAndView = new ModelAndView( );
        modelAndView.setViewName ("declaracion");
        modelAndView.addObject("id",id);
        return modelAndView;
    }
}
