package com.achords.model.dto.user;

import com.achords.model.entity.user.User;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@ToString
@Getter
public class UserDetailsImpl implements UserDetails {

    private final String nickname;
    private final String password;
    private boolean active;
    private String email;
    private final Date registration;
    private String avatar;
    private List<GrantedAuthority> authorityList;

    public UserDetailsImpl(User user){
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorityList = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRole()));
        this.email = user.getEmail();
        this.registration = user.getRegistration();
        this.avatar = user.getAvatar();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
