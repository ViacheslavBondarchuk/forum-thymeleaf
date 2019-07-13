package com.example.demo.dto;

import com.example.demo.model.Authority;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@ToString
public class UserDTO {
    private long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 4, max = 20, message = "The number of characters must be from 4 to 20")
    private String username;
    @NotBlank
    @Size(min = 4, max = 12, message = "The number of characters must be from 4 to 12")
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private Set<Authority> authorities;
}
