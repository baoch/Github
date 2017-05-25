package com.sam.repository;

import com.sam.entity.PitchType;
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
public class PitchTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PitchType> getListPitchType(){
        String sql = "Select * from tblPitchType";
        return jdbcTemplate.query(sql, new RowMapper<PitchType>() {
            @Override
            public PitchType mapRow(ResultSet resultSet, int i) throws SQLException {
                PitchType pitchType = new PitchType();
                pitchType.setPitchTypeId(resultSet.getInt("pitchTypeId"));
                pitchType.setPitchTypeName(resultSet.getString("pitchTypeName"));
                pitchType.setMaxPlayers(resultSet.getInt("maxPlayers"));
                pitchType.setRoundSlot(resultSet.getInt("roundSlot"));
                return pitchType;
            }
        });
    }
}
