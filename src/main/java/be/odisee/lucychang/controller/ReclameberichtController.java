package be.odisee.lucychang.controller;

import be.odisee.lucychang.domain.Reclamebericht;
import be.odisee.lucychang.service.LucyChangService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")

public class ReclameberichtController {
	
	@Autowired
    protected LucyChangService lucychangSessieService=null; // ready for dependency injection
	
	@RequestMapping(value={"/", "/home.html", "/index.html", "/lijst.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Reclamebericht> Lijstreclamebericht = lucychangSessieService.geefReclameberichten();
        model.addAttribute("reclameberichten", Lijstreclamebericht);
        return "/index";
    }

	@RequestMapping(value={"/reclamebericht.html"},method=RequestMethod.GET)
    public String reclameDetail(@RequestParam("id") Integer id, ModelMap model){
        Reclamebericht reclamebericht = lucychangSessieService.zoekReclameberichtId(id);
        model.addAttribute("reclamebericht", reclamebericht);
        return "/reclamebericht";
    }
	
	@RequestMapping(value={"/deletereclambericht.html"},method=RequestMethod.GET)
    public String deleteReclameDetails(@RequestParam("id") Integer id, ModelMap model){
		lucychangSessieService.deleteReclamebericht(id);
        return "redirect:index.html";
    }
	
	@RequestMapping(value={"/reclameberichtUpdate.html"},method=RequestMethod.GET)
    public void Reclameberichtediten(@RequestParam("id") Integer id, ModelMap model){
		Reclamebericht updateReclame = lucychangSessieService.zoekReclameberichtId(id);
        model.addAttribute("updateReclame", updateReclame);
    }	

	@RequestMapping(value={"/update.html"},method=RequestMethod.POST)
	public String reclameberichteVeranderen(@ModelAttribute("updateReclame") Reclamebericht reclamebericht, ModelMap model){
		lucychangSessieService.updateReclamebericht(
				reclamebericht.getId(), 
				reclamebericht.getTitel(), 
				reclamebericht.getStatus(), 
				reclamebericht.getPrombleemOmschrijving(), 
				reclamebericht.getOplossing()
        );
        return "redirect:index.html";
    }
	
	@RequestMapping(value={"/nieuwReclamebericht.html"},method=RequestMethod.GET)
    public String Reclameberichtinvullen(ModelMap model){
        Reclamebericht reclamebericht = new Reclamebericht();
        model.addAttribute("reclameber", reclamebericht);
        return "/nieuwReclamebericht";
    }

    @RequestMapping(value={"/nieuwReclamebericht.html"},method=RequestMethod.POST)
    public String Reclameberichttoevoegen(@ModelAttribute("reclameber") Reclamebericht reclamebericht, ModelMap model){
        Reclamebericht Voegdereclamebericht = lucychangSessieService.voegReclameberichtToe(reclamebericht.getTitel(),
        		reclamebericht.getStatus(),
        		reclamebericht.getPrombleemOmschrijving(),
        		reclamebericht.getOplossing()
	    );
        return "redirect:reclamebericht.html?id="+Voegdereclamebericht.getId();
    }
}