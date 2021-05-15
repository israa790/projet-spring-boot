package com.isra.instrument.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Instrument {

	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private Long idInstrument;
	
	@NotNull
	@Size (min = 4,max = 20)
	private String nomInstrument;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixInstrument;
	
	@ManyToOne
	private TypeInstrument typeInstrument;
	
	public Instrument() {
		super();
	}
	
	
	public Instrument(String nomInstrument, Double prixInstrument) {
	
		this.nomInstrument = nomInstrument;
		this.prixInstrument = prixInstrument;
	}


	public Long getIdInstrument() {
		return idInstrument;
	}
	public void setIdInstrument(Long idInstrument) {
		this.idInstrument = idInstrument;
	}
	public String getNomInstrument() {
		return nomInstrument;
	}
	public void setNomInstrument(String nomInstrument) {
		this.nomInstrument = nomInstrument;
	}
	public Double getPrixInstrument() {
		return prixInstrument;
	}
	public void setPrixInstrument(Double prixInstrument) {
		this.prixInstrument = prixInstrument;
	}


	@Override
	public String toString() {
		return "Instrument [idInstrument=" + idInstrument + ", nomInstrument=" + nomInstrument + ", prixInstrument="
				+ prixInstrument + "]";
	}


	public TypeInstrument getTypeInstrument() {
		return typeInstrument;
	}


	public void setTypeInstrument(TypeInstrument typeInstrument) {
		this.typeInstrument = typeInstrument;
	}
	
	
	
}
