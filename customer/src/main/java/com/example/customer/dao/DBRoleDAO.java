package com.example.customer.dao;

import com.example.customer.model.Role;
import com.example.customer.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DBRoleDAO implements IRoleDAO {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public boolean createRole(Role role) {
        Role roleFromDB = roleRepository.save(role);
        if (roleFromDB != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = new ArrayList<>();
        Iterable<Role> roles = roleRepository.findAll();
        roles.forEach(roleList::add);
        return roleList;
    }
}
