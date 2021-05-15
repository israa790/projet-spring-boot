package com.isra.instrument.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isra.instrument.entities.Instrument;
import com.isra.instrument.entities.TypeInstrument;
import com.isra.instrument.service.InstrumentService;

@Controller
public class InstrumentController {


		@Autowired
		InstrumentService instrumentService;
		
		@RequestMapping("/showCreate")
		public String showCreate(ModelMap modelMap)
    	{
			modelMap.addAttribute("instrument", new Instrument());
			modelMap.addAttribute("mode", "new");
			
		return "formInstrument";
		}
		
		@RequestMapping("/ListeInstruments")
		public String listeInstruments(ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{
		Page<Instrument> instrs = instrumentService.getAllInstrumentsParPage(page,size);
		modelMap.addAttribute("instruments", instrs);
		modelMap.addAttribute("pages", new int[instrs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeInstruments";
		}	
		
		@RequestMapping("/searchInstrument")
		public String listeInstruments2(ModelMap modelMap, @Param("keyword")Long keyword)
		{
			
		List<Instrument> instrs = instrumentService.findByTypeInstrumentIdType(keyword);
		modelMap.addAttribute("instruments", instrs);
	
		return "searchInstrument";
		}	
		
		@RequestMapping("/supprimerInstrument")
		public String supprimerProduit(@RequestParam("id") Long id,
		                                ModelMap modelMap,
		                                @RequestParam (name="page",defaultValue = "0") int page,
		                                @RequestParam (name="size", defaultValue = "2") int size)
		{
			instrumentService.deleteInstrumentById(id);
			Page<Instrument> instrs = instrumentService.getAllInstrumentsParPage(page,size);
		modelMap.addAttribute("instruments", instrs);
		modelMap.addAttribute("pages", new int[instrs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeInstruments";
		}
		
		

		
		@RequestMapping("/saveInstrument")
		public String saveInstrument(@Valid Instrument instrument,
				                     BindingResult bindingResult)
		                           // , @RequestParam("date") String date,
		                             // ModelMap modelMap) throws	ParseException
		{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		// Date dateCreation = dateformat.parse(String.valueOf(date));
		// instrument.setDateCreation(dateCreation);
		
			
		 if (bindingResult.hasErrors()) return "formInstrument";

		 instrumentService.saveInstrument(instrument);
		return "formInstrument";
		}
		
		@RequestMapping("/modifierInstrument")
		public String editerInstrument(@RequestParam("id") Long id,ModelMap modelMap)
		{
			Instrument p= instrumentService.getInstrument(id);
			modelMap.addAttribute("instrument", p);
			modelMap.addAttribute("mode", "edit");

		return "formInstrument";
		}
		
		@RequestMapping("/updateInstrument")
		public String updateInstrument(@ModelAttribute("instrument") Instrument instrument,
	//	@RequestParam("date") String date,
		ModelMap modelMap) throws ParseException 
		{
			//conversion de la date
			// SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			// Date dateCreation = dateformat.parse(String.valueOf(date));
			// instrument.setDateCreation(dateCreation);

			 instrumentService.updateInstrument(instrument);
			 List<Instrument> Instrs = instrumentService.getAllInstruments();
			 modelMap.addAttribute("instruments", Instrs);
			return "listeInstruments";
			}
		
//recherche 
		/*
		@RequestMapping("/SearchInstruments")
		public String  findByTypeInstrumentIdType (@RequestParam("id") Long id,ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{
		Page<Instrument> instrs = instrumentService.getAllInstrumentsParPage(page,size);
		modelMap.addAttribute("instruments", instrs);
		modelMap.addAttribute("pages", new int[instrs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "SearchInstruments";
		}	*/
	/*	@RequestMapping("/ListeInstruments")
		public String listeTypeInstruments(ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{
		Page<Instrument> instrs = instrumentService.getAllInstrumentsParPage(page,size);
		modelMap.addAttribute("instruments", instrs);
		modelMap.addAttribute("pages", new int[instrs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeInstruments";
		}	*/
}
