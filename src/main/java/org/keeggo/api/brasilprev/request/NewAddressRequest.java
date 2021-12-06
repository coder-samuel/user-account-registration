package org.keeggo.api.brasilprev.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewAddressRequest {
	
	@NotBlank(message = "CEP is required")
	@JsonProperty
	@Column(unique = true, nullable = false)
	private String cep;
	
	@NotNull(message = "Street is required")
	private String street;

	@NotNull(message = "City is required")
	private String city;

	@Size(min = 15, max = 140)
	private String complement;

	@NotNull(message = "Number is required")
	private String number;

	@NotNull(message = "District is required")
	private String district;

	@NotNull(message = "State is required")
	private String state;


	public NewAddressRequest() {
	    }

	public NewAddressRequest(String cep, String state, String number, String district, String complement, String city, String street) {
        this.cep = cep;
        this.state = state;
        this.number = number;
        this.district = district;
        this.complement = complement;
        this.city = city;
        this.street = street;
    }

	public String getCep() {
		return cep;
	}

}
