package it.engineering.web.testwebapp.domain;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Manufacturer.findAll", query="SELECT m FROM Manufacturer m")
public class Manufacturer {
	@Id
	private int pib;
	private int matbr;
	private String adresa;
	
	//definisati vezu Manufacturer -> City
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="zipcode")
	private City city;

	public Manufacturer() {
		super();
	}

	public Manufacturer(int pib, int matbr, String adresa, City city) {
		super();
		this.pib = pib;
		this.matbr = matbr;
		this.adresa = adresa;
		this.city = city;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public int getMatbr() {
		return matbr;
	}

	public void setMatbr(int matbr) {
		this.matbr = matbr;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresa, city, matbr, pib);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(city, other.city) && matbr == other.matbr
				&& pib == other.pib;
	}

	@Override
	public String toString() {
		return "Manufacturer [pib=" + pib + ", matbr=" + matbr + ", adresa=" + adresa + ", city=" + city + "]";
	}
	
	
	
}