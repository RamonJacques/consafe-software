package com.consafe.application.entities.enums;

public enum SteelBarCategory {

	FERRO_CHATO("Ferro chato"),
	FERRO_QUADRADO("Ferro quadrado"),
	FERRO_REDONDO("Ferro redondo"),
	CANTONEIRA("Cantoneira"),
	METALON("Metalon"),
	TUBO("Tubo"),
	PICA("Pica");
	
	private String description;
	
	private SteelBarCategory(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}
}
