package com.sam.repository;

import com.sam.entity.BillPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by vieth on 5/25/2017.
 */
@Repository
public class BillPaymentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(BillPayment billPayment){
        String sql = "Insert into tblBillPayment (billId, payoutNum, payoutValue, payoutDate) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql ,billPayment.getBillId(),billPayment.getPayoutNum(), billPayment.getPayoutValue(), billPayment.getPayoutDate());
    }

    public int update(BillPayment billPayment){
        String sql = "Update tblBillPayment " +
                "set billId = ?, payoutNum = ?, payoutValue = ?, payoutDate = ? " +
                "where paymentId = ?";
        return jdbcTemplate.update(sql,
                billPayment.getBillId(), billPayment.getPayoutNum(), billPayment.getPayoutValue(), billPayment.getPayoutDate(),
                billPayment.getPaymentId());
    }
}
