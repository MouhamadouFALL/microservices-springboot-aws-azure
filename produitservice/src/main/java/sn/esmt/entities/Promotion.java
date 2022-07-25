package sn.esmt.entities;

import java.io.Serializable;


public class Promotion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;      // identifiant promotion
	private String code;  // code promotion 
	private float tauxr;  // Taux de réduction
	
	public Promotion() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getTauxr() {
		return tauxr;
	}

	public void setTauxr(float tauxr) {
		this.tauxr = tauxr;
	}
	
}
