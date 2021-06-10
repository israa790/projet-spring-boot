package com.isra.instrument.service;

import java.util.List;

import com.isra.instrument.entities.TypeInstrument;

public interface TypeService {

	
	TypeInstrument saveType(TypeInstrument p);
	TypeInstrument updateType(TypeInstrument p);
	void deleteType(TypeInstrument p);
	void deleteTypeById(Long id);
	TypeInstrument getType(Long id);
	List <TypeInstrument> getAllTypes();
	
}
