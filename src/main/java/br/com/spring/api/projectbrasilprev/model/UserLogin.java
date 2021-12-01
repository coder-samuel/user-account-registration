package br.com.spring.api.projectbrasilprev.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "")
    @Column(nullable = false, length = 25)
    private String username;
    
    @NotBlank(message = "")
    @Column(nullable = false, length = 35)
    private String email;

    @NotBlank(message = "")
    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, name = "actived")
    private boolean actived;

    public UserLogin() {
        super();
    }

    public UserLogin(int id, String username, String email, String password, boolean actived) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.actived = actived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        bCryptPasswordEncoder.encode(password);
	        this.password = bCryptPasswordEncoder.encode(password);
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}


}