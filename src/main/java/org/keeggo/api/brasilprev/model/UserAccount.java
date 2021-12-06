package org.keeggo.api.brasilprev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_users", uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank
    @Email(message = "Invalid e-mail")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @CPF(message = "Invalid CPF")
    @Column(unique = true, nullable = false)
    @Size(min=11, max=11)
    private String cpf;

    private String gender;
    
    @NotBlank
    private String username;
    
    @NotBlank
	private String password;
    
    @ManyToOne
    @JsonIgnoreProperties("users")
    private Address address;
    
    public UserAccount(String name, String email, String cpf, String gender, String username, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
