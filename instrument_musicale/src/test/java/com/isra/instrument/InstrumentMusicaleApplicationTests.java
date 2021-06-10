package com.isra.instrument;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.isra.instrument.entities.Instrument;
import com.isra.instrument.entities.TypeInstrument;
import com.isra.instrument.repos.InstrumentRepository;
import com.isra.instrument.repos.TypeInterfaceRep;
import com.isra.instrument.service.InstrumentService;



@SpringBootTest
class InstrumentMusicaleApplicationTests {


	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Autowired
	private TypeInterfaceRep typeInterfaceRep;
	
	@Autowired
	private InstrumentService instrumentService;
	
	@Test
	public void testCreateInstrument()
	{
		Instrument Instr=new Instrument("violon",250.0);
		instrumentRepository.save(Instr);
	}
	
	@Test
	public void testFindInstrument()
	{
		Instrument p=instrumentRepository.findById(1L).get();
		System.out.println(p);
	}
	
	
	@Test
	public void testUpdateInstrument()
	{
		Instrument p=instrumentRepository.findById(1L).get();
		p.setPrixInstrument(4500.0);
		instrumentRepository.save(p);
		System.out.println(p);
	}
	
	@Test
	public void testDeleteInstrumentById()
	{
		instrumentRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllInstrument()
	{
		List<Instrument> Instr= instrumentRepository.findAll();	
		for(Instrument p:Instr)
		System.out.println(p);
		
	}
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Instrument> instrs = instrumentService.getAllInstrumentsParPage(0,2);
	System.out.println(instrs.getSize());
	System.out.println(instrs.getTotalElements());
	System.out.println(instrs.getTotalPages());
	instrs.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Instrument p : instrs.getContent())
	{
	System.out.println(p);
	} */
	}
	
	@Test
	public void testFindByNomInstrument()
	{
	List<Instrument> instrs = instrumentRepository.findByNomInstrument("violon blanc");
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindByNomInstrumentContains ()
	{
	List<Instrument> instrs=instrumentRepository.findByNomInstrumentContains("G");
	for (Instrument p : instrs)
	{
	System.out.println(p);
	} }
	
	@Test
	public void testfindByNomPrix()
	{
	List<Instrument> instrs = instrumentRepository.findByNomPrix("violon blanc", 100.0);
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	//n'exécute pas
	@Test
	public void testfindByTypeInstrument()
	{
		TypeInstrument cat = new TypeInstrument();
	cat.setIdType(1L);
	List<Instrument> instrs = instrumentRepository.findByTypeInstrument(cat);
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByTypeInstrumentIdType()
	{
	List<Instrument> instrs = instrumentRepository.findByTypeInstrumentIdType(1L);
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	 }
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Instrument> instrs =
			instrumentRepository.findByOrderByNomInstrumentAsc();
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Instrument> instrs = instrumentRepository.trierInstrumentsNomsPrix();
	for (Instrument p : instrs)
	{
	System.out.println(p);
	}
	}
	
	
	///test Type desinstruments
	@Test
	public void testCreateTyepInstrument()
	{
		TypeInstrument Type=new TypeInstrument("Corde2",new Date());
		typeInterfaceRep.save(Type);
	}
	
	@Test
	public void testFindTypeInstrument()
	{
		TypeInstrument p=typeInterfaceRep.findById(1L).get();
		System.out.println(p);
	}
	
	@Test
	public void testUpdateTypeInstrument()
	{
		TypeInstrument p =typeInterfaceRep.findById(5L).get();
		p.setNomType("Cat2");
	//erreur d'exéction de fct update
		typeInterfaceRep.save(p);
		System.out.println(p);
	}
	
	@Test
	public void testDeleteTypeInstrumentById()
	{
		typeInterfaceRep.deleteById(6L);
	}
	
	@Test
	public void testFindAllTypeInstrument()
	{
		List<TypeInstrument> type= typeInterfaceRep.findAll();	
		for(TypeInstrument p:type)
		System.out.println(p);
		
	}
}
