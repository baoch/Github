package com.sam.repository;

import com.sam.entity.Account;
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
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addAccount(Account acc){
        String sql = "Insert into tblAccount (username,password, roleId, isDeleted, isDeactivated) Values (?,?,?, false, false)";
        jdbcTemplate.update(sql, acc.getUsername(), acc.getPassword(), acc.getRoleId());
    }

    public void updateAccount(Account acc){
        String sql = "Update tblAccount set username = ?, password = ?, roleId = ?, isDeleted = ?, isDeactivated = ? where accountId = ?";
        jdbcTemplate.update(sql, acc.getUsername(), acc.getPassword(), acc.getRoleId(), acc.getAccountId(), acc.isDeactivated(), acc.isDeleted());
    }

    public void deleteAccount(Account acc){
        String sql = "Delete from tblAccount where accountId = ?";
        jdbcTemplate.update(sql, acc.getAccountId());
    }

    public List<Account> findAll(){
        String sql = "Select * from tblAccount";
        return jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account acc = new Account();
                acc.setAccountId(resultSet.getInt("accountId"));
                acc.setUsername(resultSet.getString("username"));
                acc.setPassword(resultSet.getString("password"));
                acc.setRoleId(resultSet.getInt("roleId"));
                acc.setDeactivated(resultSet.getBoolean("isDeactivated"));
                acc.setDeleted(resultSet.getBoolean("isDeleted"));
                return acc;
            }
        });
    }

}
