package com.oumayma.student_service.config;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String surname;
    private String studentId;
    private Collection<? extends GrantedAuthority> authorities;

    // overwriting required methods from UserDetails interface
    public boolean isAccountNonExpired() { return true; }
    public boolean isAccountNonLocked() { return true; }
    public boolean isCredentialsNonExpired() { return true; }
    public boolean isEnabled() { return true; }
}
