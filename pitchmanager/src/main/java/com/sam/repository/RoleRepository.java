package com.sam.repository;

import com.sam.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by vieth on 5/25/2017.
 */
@Repository
public class RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addRole(Role role){
        String sql = "Insert into tblRole (roleName) values (?)";
        jdbcTemplate.update(sql, role.getRoleName());
    }

    public void updateRole(Role role){
        String sql = "Update tblRole set roleName = ? where roleId = ?";
        jdbcTemplate.update(sql, role.getRoleName(), role.getRoleId());
    }

    public void deleteRole(Role role){
        String sql = "Delete from tblRole where roleId = ?";
        jdbcTemplate.update(sql, role.getRoleId());
    }

    public List<Role> findAll(){
        String sql = "Select * from tblRole";
        return jdbcTemplate.query(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role role = new Role();
                role.setRoleId(resultSet.getInt("roleId"));
                role.setRoleName(resultSet.getString("roleName"));
                return role;
            }
        });
    }
}
