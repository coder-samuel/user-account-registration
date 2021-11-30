package br.com.spring.api.projectbrasilprev.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_client", uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid e-mail")
    @Column(unique = true, nullable = false)
    private String email;

    @CPF(message = "Invalid CPF")
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotBlank(message = "Birthday is required")
    private Date birthday;

    private String gender;
    
    @ManyToOne
    @JsonIgnoreProperties("client")
    private Address address;
    
    public Client(String name, String email, String cpf, Date birthday, String gender, Address address) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
    }

    public Client() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
	
	

}
