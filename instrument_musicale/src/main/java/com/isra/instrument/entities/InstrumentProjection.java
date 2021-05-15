package com.isra.instrument.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomInstr", types = { Instrument.class })
public interface InstrumentProjection {

	public String getNomInstrument();
}
