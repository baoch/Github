package com.sam.repository;

import com.sam.entity.TimeFrame_PitchType;
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
public class TimeFrame_PitchTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TimeFrame_PitchType> getReferencePrice(){
        String sql = "Select tp.referencePrice, tp.pitchTypeId, tp.timeFrameId, p.pitchTypeName, t.fromTime, t.toTime " +
                "From (Select * from tblTimeFrame_PitchType) tp, tblPitchType p, tblTimeFrame t " +
                "Where tp.pitchTypeId = p.pitchTypeId AND tp.timeFrameId = t.timeFrameId";
        return jdbcTemplate.query(sql, new RowMapper<TimeFrame_PitchType>() {
            @Override
            public TimeFrame_PitchType mapRow(ResultSet resultSet, int i) throws SQLException {
                TimeFrame_PitchType tp = new TimeFrame_PitchType();
                tp.setPitchTypeName(resultSet.getString("pitchTypeName"));
                tp.setPitchTypeId(resultSet.getInt("pitchTypeId"));
                tp.setTimeFrameId(resultSet.getInt("timeFrameId"));
                tp.setFromTime(resultSet.getTime("fromTime"));
                tp.setToTime(resultSet.getTime("toTime"));
                tp.setReferencePrice(resultSet.getFloat("referencePrice"));
                return tp;
            }
        });
    }

}
