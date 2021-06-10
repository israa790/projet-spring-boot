package com.isra.instrument.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isra.instrument.entities.TypeInstrument;
import com.isra.instrument.repos.TypeInterfaceRep;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
    TypeInterfaceRep typeInterfaceRep;
	
	@Override
	public TypeInstrument saveType(TypeInstrument p) {
		
		return typeInterfaceRep.save(p); 
	}

	@Override
	public TypeInstrument updateType(TypeInstrument p) {
		return typeInterfaceRep.save(p);
	}

	@Override
	public void deleteType(TypeInstrument p) {
		typeInterfaceRep.delete(p);
		
	}

	@Override
	public void deleteTypeById(Long id) {
		typeInterfaceRep.deleteById(id);
	}

	@Override
	public TypeInstrument getType(Long id) {
	
		return typeInterfaceRep.findById(id).get();
	}

	@Override
	public List<TypeInstrument> getAllTypes() {
	
		return typeInterfaceRep.findAll();
	}

}
