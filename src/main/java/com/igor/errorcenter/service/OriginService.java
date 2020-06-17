package com.igor.errorcenter.service;

import com.igor.errorcenter.entity.Origin;
import com.igor.errorcenter.repository.OriginRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OriginService implements UserDetailsService {

    @Autowired
    private OriginRepository originRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return originRepository.findByLogin(s)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));
    }
}
