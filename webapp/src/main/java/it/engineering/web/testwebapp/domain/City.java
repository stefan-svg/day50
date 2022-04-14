package it.engineering.web.testwebapp.domain;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "zipcode")
	private int zipCode;
	
	@Column(name = "name")
	private String name;
	
	public City() {
	}
	
	public City(int zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}

	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(name, other.name) && zipCode == other.zipCode;
	}

	@Override
	public String toString() {
		return "City [zipCode=" + zipCode + ", name=" + name + "]";
	}
	
}