package com.seal.api.gwf.dao;

import com.seal.api.gwf.dto.get.AllJobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class JobOffer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JobOffer(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Lấy những JA mà mình xin ứng tuyển (State 0 và 3 only)
    public List<AllJobOffer> getAllJAByApplicantID(int aid, int state){
        String sql = """
            SELECT JO.OfferID AS OfferID, JT.Name AS JobName, B.BusinessName AS BuName, B.BusinessLogo AS BuLogo, B.Address AS BuAddress, JO.Address AS JOAddress, B.BusinessID AS BusinessID, State, ApplicationID, MapID
            FROM JobMapping JM
            INNER JOIN JobOffer JO ON JM.OfferID = JO.OfferID
            INNER JOIN JobType JT on JO.TypeID = JT.TypeID
            INNER JOIN Business B on JO.BusinessID = B.BusinessID
            WHERE JM.ApplicationID IN
            	(SELECT ApplicationID FROM Applicant App
            	INNER JOIN JobApplication JApp ON App.AccountID = JApp.AccountID
            	WHERE App.AccountID =""" + aid + ") AND State = " + state + " AND JM.AccountID IS NULL";
        List<AllJobOffer> result = jdbcTemplate.query(sql, new RowMapper<>() {
            @Override
            public AllJobOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
                AllJobOffer ja = new AllJobOffer();
                ja.setOfferID(rs.getInt(1));
                ja.setJobName(rs.getString(2));
                ja.setBuName(rs.getString(3));
                ja.setBuLogo(rs.getString(4));
                ja.setBuAddress(rs.getString(5));
                ja.setJOAddress(rs.getString(6));
                ja.setBusinessID(rs.getInt(7));
                ja.setState(rs.getInt(8));
                ja.setApplicationID(rs.getInt(9));
                ja.setMapID(rs.getInt(10));
                return ja;
            }
        });

        return result;
    }

    //Lấy những JO mà mình được đề xuất (State = 0) only
    public List<AllJobOffer> getAllJOOfferedByApplicantID(int aid, int state){
        String sql = """
            SELECT JO.OfferID AS OfferID, JT.Name AS JobName, B.BusinessName AS BuName, B.BusinessLogo AS BuLogo, B.Address AS BuAddress, JO.Address AS JOAddress, B.BusinessID AS BusinessID, State, ApplicationID, MapID
            FROM JobMapping JM
            INNER JOIN JobOffer JO ON JM.OfferID = JO.OfferID
            INNER JOIN JobType JT on JO.TypeID = JT.TypeID
            INNER JOIN Business B on JO.BusinessID = B.BusinessID
            WHERE JM.ApplicationID IN
            	(SELECT ApplicationID FROM Applicant App
            	INNER JOIN JobApplication JApp ON App.AccountID = JApp.AccountID
            	WHERE App.AccountID =""" + aid + ") AND State = " + state + " AND JM.AccountID IS NOT NULL";
        List<AllJobOffer> result = jdbcTemplate.query(sql, new RowMapper<>() {
            @Override
            public AllJobOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
                AllJobOffer ja = new AllJobOffer();
                ja.setOfferID(rs.getInt(1));
                ja.setJobName(rs.getString(2));
                ja.setBuName(rs.getString(3));
                ja.setBuLogo(rs.getString(4));
                ja.setBuAddress(rs.getString(5));
                ja.setJOAddress(rs.getString(6));
                ja.setBusinessID(rs.getInt(7));
                ja.setState(rs.getInt(8));
                ja.setApplicationID(rs.getInt(9));
                ja.setMapID(rs.getInt(10));
                return ja;
            }
        });

        return result;
    }

    //Lấy các JO mình đang làm và đã hoàn thành (State 1 và 2)
    public List<AllJobOffer> getAllJOValidAndFinishByApplicantID(int aid, int state){
        String sql = """
            SELECT JO.OfferID AS OfferID, JT.Name AS JobName, B.BusinessName AS BuName, B.BusinessLogo AS BuLogo, B.Address AS BuAddress, JO.Address AS JOAddress, B.BusinessID AS BusinessID, State, ApplicationID, MapID
            FROM JobMapping JM
            INNER JOIN JobOffer JO ON JM.OfferID = JO.OfferID
            INNER JOIN JobType JT on JO.TypeID = JT.TypeID
            INNER JOIN Business B on JO.BusinessID = B.BusinessID
            WHERE JM.ApplicationID IN
            	(SELECT ApplicationID FROM Applicant App
            	INNER JOIN JobApplication JApp ON App.AccountID = JApp.AccountID
            	WHERE App.AccountID =""" + aid + ") AND State = " + state;
        List<AllJobOffer> result = jdbcTemplate.query(sql, new RowMapper<>() {
            @Override
            public AllJobOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
                AllJobOffer ja = new AllJobOffer();
                ja.setOfferID(rs.getInt(1));
                ja.setJobName(rs.getString(2));
                ja.setBuName(rs.getString(3));
                ja.setBuLogo(rs.getString(4));
                ja.setBuAddress(rs.getString(5));
                ja.setJOAddress(rs.getString(6));
                ja.setBusinessID(rs.getInt(7));
                ja.setState(rs.getInt(8));
                ja.setApplicationID(rs.getInt(9));
                ja.setMapID(rs.getInt(10));
                return ja;
            }
        });

        return result;
    }
}
