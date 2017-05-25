package com.sam.repository;

import com.sam.entity.Pitch;
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
public class PitchRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pitch> findAll(){
        String sql = "Select * from tblPitch";
        return jdbcTemplate.query(sql, new RowMapper<Pitch>() {
            @Override
            public Pitch mapRow(ResultSet resultSet, int i) throws SQLException {
                Pitch pitch = new Pitch();
                pitch.setPitchId(resultSet.getInt("pitchId"));
                pitch.setPitchName(resultSet.getString("pitchName"));
                pitch.setPitchLength(resultSet.getFloat("pitchLength"));
                pitch.setPitchWidth(resultSet.getFloat("pitchWidth"));
                pitch.setStatus(resultSet.getBoolean("status"));
                return pitch;
            }
        });
    }

    public int add(Pitch pitch){
        String sql = "Insert into tblPitch (pitchName, pitchWidth, pitchLength, pitchTypeId, status) " +
                "Values(?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, pitch.getPitchName(), pitch.getPitchWidth(), pitch.getPitchLength(), pitch.getPitchTypeId(), pitch.isStatus());
    }

    public int update(Pitch pitch){
        String sql = "Update tblPitch " +
                "set pitchName = ?, pitchWidth = ?, pitchLength = ?, pitchTypeId = ?, status = ? " +
                "where pitchId = ?";
        return jdbcTemplate.update(sql, pitch.getPitchName(), pitch.getPitchWidth(), pitch.getPitchLength(), pitch.getPitchTypeId(), pitch.isStatus(),
                pitch.getPitchId());
    }

    public int delete(Pitch pitch){
        String sql = "Delete from tblPitch where pitchid = ?";
        return jdbcTemplate.update(sql, pitch.getPitchId());
    }

    public List<Pitch> getAvailablePitchs(){
        String sql = "Select * from tblPitch where status=true";
        return jdbcTemplate.query(sql, new RowMapper<Pitch>() {
            @Override
            public Pitch mapRow(ResultSet resultSet, int i) throws SQLException {
                Pitch pitch = new Pitch();
                pitch.setStatus(true);
                pitch.setPitchLength(resultSet.getFloat("pitchLength"));
                pitch.setPitchWidth(resultSet.getFloat("pitchWidth"));
                pitch.setPitchName(resultSet.getString("pitchName"));
                pitch.setPitchId(resultSet.getInt("pitchId"));
                pitch.setPitchTypeId(resultSet.getInt("pitchTypeId"));
                return pitch;
            }
        });
    }

}
