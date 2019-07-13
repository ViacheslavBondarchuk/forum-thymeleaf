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
    @NotBlank(message = "Field is required")
    private String email;
    @Size(max = 20, message = "Юзернейм одлжен быть не больше 20 символов")
    @NotBlank(message = "Field is required")
    private String username;
    @Size(min = 4, max = 12, message = "Пароль должен быть от 4 до 12 символов")
    @NotBlank(message = "Field is required")
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private Set<Authority> authorities;
}
