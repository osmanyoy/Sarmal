package com.example.customer.dao;

import com.example.customer.model.Role;

import java.util.List;

public interface IRoleDAO {
    boolean createRole(Role role) ;
    List<Role> getAllRoles();
}
