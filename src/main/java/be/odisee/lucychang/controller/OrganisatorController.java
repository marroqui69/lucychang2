package be.odisee.lucychang.controller;

import be.odisee.lucychang.domain.Rol;
import be.odisee.lucychang.service.BrainstormSessieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

// om deze controller te gebruiken, moet je uw rol gebruiken van Organisator
@Controller
@PostAuthorize("#model.get('rol').persoon.emailadres == authentication.principal.username")
@Secured({"Organisator"})
public class OrganisatorController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @RequestMapping(value={"/organisator/index.html", "/organisator/home.html"},method=RequestMethod.GET)
    public String index(@RequestParam("rolid") Integer id, ModelMap model){
        Rol deRol = brainstormSessieService.zoekRolMetId(id);
        model.addAttribute("rol", deRol);
        return "/organisator/index";
    }
    // je zal naar index.jsp gaan

}
