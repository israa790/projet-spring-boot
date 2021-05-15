package com.isra.instrument.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isra.instrument.entities.Instrument;
import com.isra.instrument.entities.TypeInstrument;



public interface InstrumentService {

	
	Instrument saveInstrument(Instrument p);
	Instrument updateInstrument(Instrument p);
	void deleteInstrument(Instrument p);
	void deleteInstrumentById(Long id);
	Instrument getInstrument(Long id);
	List <Instrument> getAllInstruments();
	
	List<Instrument> findByNomInstrument(String nom);
	 List<Instrument> findByNomInstrumentContains(String nom); 
	
	 List<Instrument> findByNomPrix ( String nom, Double prix);
	 
	 List<Instrument> findByTypeInstrument (TypeInstrument typeInstrument);
	 
	 List<Instrument> findByTypeInstrumentIdType(Long id);
	 
	 List<Instrument> findByOrderByNomInstrumentAsc();
	 
	 List<Instrument> trierInstrumentsNomsPrix ();

	Page<Instrument> getAllInstrumentsParPage(int page, int size);

	
	  List<TypeInstrument> findAllType(String keyword);
}
