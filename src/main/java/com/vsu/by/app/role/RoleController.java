package com.vsu.by.app.role;

import com.vsu.by.app.role.dto.RoleDto;
import com.vsu.by.app.role.dto.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
@Transactional
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<List<RoleDto>> getRoles() {
        return new ResponseEntity<>(
                this.roleMapper.toRoleDto(this.roleService.findAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<RoleDto> getRoleByName(@PathVariable("name") String name) {
        Role role = this.roleService.getRole(name);
        return new ResponseEntity<>(this.roleMapper.toRoleDto(role), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto) {
        Role saved = this.roleService.saveRole(this.roleMapper.fromRoleDto(roleDto));
        return new ResponseEntity<>(this.roleMapper.toRoleDto(saved), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable("id") Long roleId,
                                              @RequestBody RoleDto roleDto) {
        Role saved = this.roleService.updateRole(this.roleMapper.fromRoleDto(roleDto));
        return new ResponseEntity<>(this.roleMapper.toRoleDto(saved), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long roleId) {
        this.roleService.deleteRole(roleId);
        return new ResponseEntity<>("redirect:/roles/", HttpStatus.ACCEPTED);
    }
}
