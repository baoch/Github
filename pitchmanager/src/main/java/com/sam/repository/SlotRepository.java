package com.sam.repository;

import com.sam.entity.Slot;
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
public class SlotRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Slot> findAll(){
        String sql = "Select * from tblSlot";
        return jdbcTemplate.query(sql, new RowMapper<Slot>() {
            @Override
            public Slot mapRow(ResultSet resultSet, int i) throws SQLException {
                Slot slot = new Slot();
                slot.setToTime(resultSet.getTime("toTime"));
                slot.setFromTime(resultSet.getTime("fromTime"));
                slot.setSlotId(resultSet.getInt("slotId"));
                return slot;
            }
        });
    }
}
