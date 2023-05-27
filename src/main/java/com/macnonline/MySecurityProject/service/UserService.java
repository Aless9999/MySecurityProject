package com.macnonline.MySecurityProject.service;

import com.macnonline.MySecurityProject.entity.Role;
import com.macnonline.MySecurityProject.entity.Users;
import com.macnonline.MySecurityProject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=usersRepository.findByUsername(username);
        return new User(users.getUsername(),users.getPassword(),mapAuthorities(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapAuthorities(List<Role> roles) {
        return roles.stream()
                .map(r->new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toList());
    }
}
