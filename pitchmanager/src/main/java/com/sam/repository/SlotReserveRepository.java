package com.sam.repository;

import com.sam.entity.Bill;
import com.sam.entity.Customer;
import com.sam.entity.SlotReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
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


}
