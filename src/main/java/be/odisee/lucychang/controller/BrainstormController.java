package be.odisee.lucychang.controller;

import be.odisee.lucychang.domain.*;
import be.odisee.lucychang.service.BrainstormSessieService;
import be.odisee.lucychang.service.UserContextService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

// om deze controller te gebruiken, moet je uw rol gebruiken van Facilitator, Deelnemer, Observator of Verslaggever
// als Organisator of Administrator mag je deze controller niet gebruiken
@Controller
@PostAuthorize("#model.get('rol').persoon.emailadres == authentication.principal.username")
@Secured({"Facilitator","Deelnemer","Observator","Verslaggever"})
public class BrainstormController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @Autowired
    protected UserContextService userContextService=null;

    @RequestMapping(value={"/brainstorm/index.html", "/brainstorm/home.html"},method=RequestMethod.GET)
    public String index(@RequestParam("rolid") Integer id, ModelMap model){
        Persoon dePersoon = userContextService.getAuthenticatedPersoon();
        Rol deRol = brainstormSessieService.zoekRolMetId(id);
        model.addAttribute("rol", deRol);
        return "/brainstorm/index";
    }
    // je zal naar index.jsp gaan

}
