package com.vsu.by.app.role;

import com.vsu.by.app.role.Role;
import com.vsu.by.app.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Optional<Role> getRole(Long id) {
        return this.roleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Role> getRole(String name) {
        return this.roleRepository.findByName(name);
    }

    @Transactional
    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(Long id) {
        this.roleRepository.deleteById(id);
    }

    @Transactional
    public Role updateRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
