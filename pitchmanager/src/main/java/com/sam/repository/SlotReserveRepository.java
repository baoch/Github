package com.sam.repository;

import com.sam.entity.Bill;
import com.sam.entity.Customer;
import com.sam.entity.Slot;
import com.sam.entity.SlotReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vieth on 5/25/2017.
 */
@Repository
public class SlotReserveRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CustomerRepository customerRepository;

    public int addMutipleSlotReserve(List<SlotReserve> slotReserves){
        int affectedRow = 0;
        for(SlotReserve sr: slotReserves){
            String insertSlotReserve = "Insert into tblSlotReserve (slotId, pitchId, date, billId)" +
                    " values (?, ?, ?, ?)";
            affectedRow += jdbcTemplate.update(insertSlotReserve, sr.getSlotId(), sr.getPitchId(), sr.getDate(), sr.getBillId());
        }
        return affectedRow;
    }


    public boolean isAvailableAt(int pitchId, int fromSlotId, int toSlotId, Date date){
        String sql = "Select count(*) from tblSlotReserve t where (slotId = ? Or slotId = ?) and pitchId = ? and date = ?";
        boolean isExisted = false;
        int count = jdbcTemplate.queryForObject(sql, Integer.class, fromSlotId, toSlotId, pitchId, date);
        isExisted = count > 0? true: false;
        return isExisted;
    }

    public List<SlotReserve> findSlotReserveByBillId(int billId){
        String sql = "Select * from tblSlotReserve where billId = ?";
        return jdbcTemplate.query(sql, new RowMapper<SlotReserve>() {
            @Override
            public SlotReserve mapRow(ResultSet resultSet, int i) throws SQLException {
                SlotReserve sr = new SlotReserve();
                sr.setPitchId(resultSet.getInt("pitchId"));
                sr.setSlotId(resultSet.getInt("slotId"));
                sr.setDate(resultSet.getDate("date"));
                sr.setBillId(billId);
                sr.setPrice(resultSet.getFloat("price"));
                sr.setslotReserveId(resultSet.getInt("slotReserveId"));
                return sr;
            }
        }, billId);
    }

    public List<Slot> getFromTimeToTime(int billId){
        List<Slot> listSlot = new ArrayList<>();
        String sql = "Select sl.* " +
                "from tblSlot sl,(Select Min(t.slotId) As 'fromSlot', Max(t.slotId) As 'toSlot' " +
                "From (Select s.slotId from tblSlotReserve s where billId = ?) t) m  " +
                "where slotId = fromSlot Or slotId = toSlot ";
        listSlot = jdbcTemplate.query(sql, new RowMapper<Slot>() {
            @Override
            public Slot mapRow(ResultSet resultSet, int i) throws SQLException {
                Slot slot = new Slot();
                slot.setSlotId(resultSet.getInt("slotId"));
                slot.setFromTime(resultSet.getTime("fromTime"));
                slot.setToTime(resultSet.getTime("toTime"));
                return slot;
            }
        }, billId);
        return listSlot;
    }

}
