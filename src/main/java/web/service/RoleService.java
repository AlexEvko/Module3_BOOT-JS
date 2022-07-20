package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    void removeRoleById(Long id);
    void updateRole(Role role);

}
