package com.company.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @PreAuthorize("hasRole('ADMIN')")//ROLE_USER, ROLE_ADMIN
    public void foo(){
        System.out.println("foo method");
    }
}
