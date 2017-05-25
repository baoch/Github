package com.sam.repository;

import com.sam.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by vieth on 5/25/2017.
 */
@Repository
public class BillRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(Bill bill){
        String sql = "Insert into tblBill(customerId, isFullyPaid) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, bill.getCustomerId());
                ps.setBoolean(2, bill.isFullyPaid());
                return ps;
            }
        }, keyHolder);
        int billId = keyHolder.getKey().intValue();
        return billId;
    }

}
