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
import java.util.List;

/**
 * Created by vieth on 5/25/2017.
 */
@Repository
public class BillRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(Bill bill){
        String sql = "Insert into tblBill(customerId, isFullyPaid, totalPrice, currentlyDebt, currentlyPaid) values(?,?, 0, 0, 0)";
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


    public List<Bill> findAll(){
        String sql = "Select * from tblBill";
        return jdbcTemplate.query(sql, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill();
                bill.setFullyPaid(resultSet.getBoolean("isFullyPaid"));
                bill.setBillId(resultSet.getInt("billId"));
                bill.setCustomerId(resultSet.getInt("customerId"));
                Date date = resultSet.getDate("lastPayoutDate");
                if(date != null){
                    bill.setLastPayoutDate(date);
                }
                bill.setCurrentlyDebt(resultSet.getFloat("currentlyDebt"));
                bill.setCurrentlyPaid(resultSet.getFloat("currentlyPaid"));
                bill.setTotalPrice(resultSet.getFloat("totalPrice"));
                return bill;
            }
        });
    }

    public void updateBillTotalPrice(Bill bill){
        String sql = "Update tblBill set totalPrice = ?, currentlyDebt = ?, currentlyPaid = 0 where billId = ?";
        jdbcTemplate.update(sql, bill.getTotalPrice(), bill.getTotalPrice(), bill.getBillId());
        String getNumOfSlot = "Select count(*) from tblSlotReserve where billId=?";
        int numOfSlot = jdbcTemplate.queryForObject(getNumOfSlot, Integer.class, bill.getBillId());
        float slotPrice = bill.getTotalPrice()/numOfSlot;
        String updateSlotPrice = "Update tblSlotReserve set price = ? where billId = ?";
        jdbcTemplate.update(updateSlotPrice, slotPrice, bill.getBillId());
    }

    public Bill getBillById(int billId){
        String sql = "Select * from tblBill where billId = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill();
                bill.setFullyPaid(resultSet.getBoolean("isFullyPaid"));
                bill.setBillId(resultSet.getInt("billId"));
                bill.setCustomerId(resultSet.getInt("customerId"));
                Date date = resultSet.getDate("lastPayoutDate");
                if(date != null){
                    bill.setLastPayoutDate(date);
                }
                bill.setCurrentlyDebt(resultSet.getFloat("currentlyDebt"));
                bill.setCurrentlyPaid(resultSet.getFloat("currentlyPaid"));
                bill.setTotalPrice(resultSet.getFloat("totalPrice"));
                return bill;
            }
        }, billId);
    }

}
