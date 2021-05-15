package com.isra.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.isra.instrument.entities.Instrument;
import com.isra.instrument.service.InstrumentService;

@SpringBootApplication
public class InstrumentMusicaleApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	InstrumentService instrumentService;
	
	public static void main(String[] args) {
		SpringApplication.run(InstrumentMusicaleApplication.class, args);
	

	}

	@Override
	public void run(String... args) throws Exception {
	/*instrumentService.saveInstrument(new Instrument("Piano noir", 6600.0));
	instrumentService.saveInstrument(new Instrument("Gitarre ", 300.0));
	*/
		repositoryRestConfiguration.exposeIdsFor(Instrument.class);
	}
}
