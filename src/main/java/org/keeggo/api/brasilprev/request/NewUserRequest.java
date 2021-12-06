package org.keeggo.api.brasilprev.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.keeggo.api.brasilprev.model.UserAccount;
import org.keeggo.api.brasilprev.validation.Unique;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewUserRequest {
	
    @Unique(entity = UserAccount.class, field = "username")
    @Size(max=20)
    @NotBlank
    @JsonProperty
    private final String username;

    @Unique(entity = UserAccount.class, field = "email")
    @NotBlank(message = "Invalid e-mail")
    @Email
    @JsonProperty
    private final String email;

    @NotNull(message = "Name is required")
    private String name;

    @Unique(entity = UserAccount.class, field = "cpf")
    @CPF(message = "Invalid CPF")
    @Size(min = 11, max = 11)
    private String cpf;
    
    private String gender;
    
    @Size(min=6)
    @NotEmpty(message = "Your password must be at least 6 characters long")
	private String password;
    
    

	public NewUserRequest(String name, String email, String cpf, String gender, String username, String password) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}

   public String getUsername() {
        return username;
    }
    
   public UserAccount toEntity() {
        return new UserAccount(name, email, cpf, gender, username, password);
    }
}
