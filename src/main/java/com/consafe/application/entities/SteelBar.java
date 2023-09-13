package com.consafe.application.entities;

import java.io.Serializable;
import java.util.Objects;

import com.consafe.application.entities.enums.SteelBarCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SteelBar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String name;
	private Double kgPerMeter;
	private SteelBarCategory steelBarCategory;
	

	public SteelBar() {
	}

	public SteelBar(Integer id, String name, Double kgPerMeter, SteelBarCategory steelBarCategory) {
		this.id = id;
		this.name = name;
		this.kgPerMeter = kgPerMeter;
		this.steelBarCategory = steelBarCategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getKgPerMeter() {
		return kgPerMeter;
	}

	public void setKgPerMeter(Double kgPerMeter) {
		this.kgPerMeter = kgPerMeter;
	}

	public SteelBarCategory getSteelBarCategory() {
		return steelBarCategory;
	}

	public void setSteelBarCategory(SteelBarCategory steelBarCategory) {
		this.steelBarCategory = steelBarCategory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SteelBar other = (SteelBar) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "SteelBar [id=" + id + ", name=" + name + ", kgPerMeter=" + kgPerMeter + ", steelBarCategory= "
				+ steelBarCategory.toString() + "]";
	}
}
