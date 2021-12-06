package org.keeggo.api.brasilprev.response;

import org.keeggo.api.brasilprev.model.UserAccount;

import com.fasterxml.jackson.annotation.JsonProperty;

class UserResponse {

    @JsonProperty
    private final String username;

    @JsonProperty
    private final String email;

    @JsonProperty
    private String name;

    UserResponse(UserAccount userAccount) {
        this.username = userAccount.getUsername();
        this.email = userAccount.getEmail();
        this.name = userAccount.getName();
    }
}