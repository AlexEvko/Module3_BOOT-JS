package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.model.Role;
import web.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public void removeRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

//    private final RoleDao roleDao;
//
//    public RoleServiceImpl(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }
//
//    @Override
//    public void save(Role role) {
//        roleDao.save(role);
//    }
//
//    @Override
//    public Role findById(Long id) {
//        return roleDao.findById(id);
//    }
//
//    @Override
//    public Role findByName(String name) {
//        return roleDao.findByName(name);
//    }
//
//    @Override
//    public List<Role> findAll() {
//        return roleDao.findAll();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        roleDao.deleteById(id);
//    }
//
//    @Override
//    public void update(Role role) {
//        roleDao.update(role);
//    }
}
