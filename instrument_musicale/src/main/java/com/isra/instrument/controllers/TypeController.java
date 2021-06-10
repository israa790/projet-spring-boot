package com.isra.instrument.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isra.instrument.entities.TypeInstrument;
import com.isra.instrument.service.TypeService;

@Controller
public class TypeController {
	
	@Autowired
	TypeService typeService;

	@RequestMapping("/showCreateType")
	public String showCreateType()
	{
	return "createInstrument";
	}
	
	@RequestMapping("/saveType")
	public String saveType(@ModelAttribute("typeInstr") TypeInstrument typeInstr,
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws
	ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
     typeInstr.setDateCreation(dateCreation);

	 TypeInstrument saveType = typeService.saveType(typeInstr);
	String msg ="type d'instrument enregistré avec Id "+saveType.getIdType();
	modelMap.addAttribute("msg", msg);
	return "createType";
	}
	
	@RequestMapping("/ListeTypes")
	public String listeProduits(ModelMap modelMap)
	{
	List<TypeInstrument> prods = typeService.getAllTypes();
	modelMap.addAttribute("types", prods);
	return "listeTypes";
	}
	
	@RequestMapping("/supprimerType")
	public String supprimerType(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
		typeService.deleteTypeById(id);
	List<TypeInstrument> prods = typeService.getAllTypes();
	modelMap.addAttribute("types", prods);
	return "listeTypes";
	}
	
	@RequestMapping("/modifierType")
	public String editerType(@RequestParam("id") Long id,ModelMap modelMap)
	{
		TypeInstrument p= typeService.getType(id);
	modelMap.addAttribute("type", p);
	return "editerType";
	}
	
	@RequestMapping("/updateType")
	public String updateType(@ModelAttribute("type") TypeInstrument type,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 type.setDateCreation(dateCreation);

	 typeService.updateType(type);
	 List<TypeInstrument> typeInstrs = typeService.getAllTypes();
	 modelMap.addAttribute("types", typeInstrs);
	return "listeTypes";
	}

}
