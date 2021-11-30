package br.com.spring.api.projectbrasilprev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tb_address")
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;
    
    @Size(min = 15, max = 140)
    private String complement;

    @NotNull(message = "Number is required")
    @Column(unique = true, nullable = false)
    private String number;

    @NotBlank(message = "District is required")
    private String district;
    
    @NotBlank(message = "State is required")
    private String state;
    
    @NotBlank(message = "CEP is required")
    private String cep;

    
    public Address (int id, String cep, String state, String number,
    	String district, String complement, String city, String street) {
    	this.id = id;
    	this.cep = cep;
    	this.state = state;
    	this.number = number;
    	this.district = district;
    	this.complement = complement;
    	this.city = city;
    	this.street = street;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


}
