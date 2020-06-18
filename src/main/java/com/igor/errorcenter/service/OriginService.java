package com.igor.errorcenter.service;

import com.igor.errorcenter.entity.Origin;
import com.igor.errorcenter.repository.OriginRepository;
import com.igor.errorcenter.service.interfaces.OriginServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OriginService implements UserDetailsService, OriginServiceInterface {

    @Autowired
    private OriginRepository originRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return originRepository.findByLogin(s)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));
    }

    @Override
    public Origin save(Origin origin) {
        return this.originRepository.save(origin);
    }

    @Override
    public Origin update(Origin origin) {
        return this.originRepository.save(origin);
    }

    @Override
    public void delete(Long id) {
        Origin origin = this.originRepository.findById(id).get();
        this.originRepository.delete(origin);
    }

    @Override
    public Origin findById(Long id) {
        return this.originRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Origin not found"));
    }

    @Override
    public Origin findByLogin(String login) {
        return this.originRepository.findByLogin(login).orElseThrow(
                () -> new UsernameNotFoundException("Login not found"));
    }
}
