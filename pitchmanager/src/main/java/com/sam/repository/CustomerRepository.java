package com.sam.repository;

import com.sam.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by vieth on 5/25/2017.
 */
@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer findCustomerByPhone(String phone){
        String sql = "Select * from tblCustomer where phone = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                if(resultSet != null){
                    Customer customer = new Customer();
                    customer.setCustomerId(resultSet.getInt("customerId"));
                    customer.setFullname(resultSet.getString("fullname"));
                    customer.setPhone(resultSet.getString("phone"));
                    return customer;
                } else return null;
            }
        }, phone);
    }

    public int add(Customer customer){
        String insertCustomer = "Begin tran " +
                "IF EXISTS (SELECT * from tblCustomer where phone = ?) " +
                "begin " +
                "Update tblCustomer set fullname = ? where phone = ? " +
                "end " +
                "ELSE " +
                "begin " +
                "Insert into tblCustomer (fullname, phone) values(?, ?) " +
                "end " +
                "commit tran ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insertCustomer, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getPhone());
                ps.setString(2, customer.getFullname());
                ps.setString(3, customer.getPhone());
                ps.setString(4, customer.getFullname());
                ps.setString(5, customer.getPhone());
                return ps;
            }
        }, keyHolder);
        int customerId = -1;
        try{
            customerId = keyHolder.getKey().intValue();
        } catch(Exception e){
            customerId = findCustomerByPhone(customer.getPhone()).getCustomerId();
        }
        return customerId;
    }
}
