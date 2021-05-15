package com.isra.instrument.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.isra.instrument.entities.Instrument;
import com.isra.instrument.entities.TypeInstrument;

@RepositoryRestResource(path = "rest")
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

	List<Instrument> findByNomInstrument(String nom);
	 List<Instrument> findByNomInstrumentContains(String nom); 
	 
	
	 @Query("select p from Instrument p where p.nomInstrument like %:nom and p.prixInstrument > :prix")
	 List<Instrument> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 
	 @Query("select p from Instrument p where p.typeInstrument = ?1")
	 List<Instrument> findByTypeInstrument (TypeInstrument typeInstrument);
	 

	 
	 List<Instrument> findByOrderByNomInstrumentAsc();
	 
	 @Query("select p from Instrument p order by p.nomInstrument ASC, p.prixInstrument DESC")
	 List<Instrument> trierInstrumentsNomsPrix ();

	 //type des instruments
	 @Query("select p from TypeInstrument p where p.nomType like %?1%")
	 public List<TypeInstrument> findAllType(String keyword);
	 
	@Query("select p from Instrument p where p.typeInstrument = ?1")
	 List<Instrument> findByTypeInstrumentIdType(Long keyword);
	 
/*	 @Query("select p from Instrument p where p.idType = ?1")
	 public List<Instrument> findAll(Long idType);*/
}
