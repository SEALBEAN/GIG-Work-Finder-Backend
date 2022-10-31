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

    public List<AllJobOffer> getAllByApplicantID(int aid){
        String sql = """
            SELECT JO.OfferID AS OfferID, JO.AccountID AS AccountID, TypeID, LocationID, DegreeID, NumOfRecruit, OfferEndTime, Salary, Age, Visual, JobDescription, Other, StartTime, EndTime, Address, BusinessID, Status, State, ApplicationID
            FROM JobMapping JM
            INNER JOIN JobOffer JO ON JM.OfferID = JO.OfferID
            WHERE JM.ApplicationID IN
            	(SELECT ApplicationID FROM Applicant App
            	INNER JOIN JobApplication JApp ON App.AccountID = JApp.AccountID
            	WHERE App.AccountID =""" + aid + ")";
        List<AllJobOffer> result = jdbcTemplate.query(sql, new RowMapper<>() {
            @Override
            public AllJobOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
                AllJobOffer ja = new AllJobOffer();

                ja.setOfferID(rs.getInt(1));
                ja.setAccountID(rs.getInt(2));
                ja.setTypeID(rs.getInt(3));
                ja.setLocationID(rs.getInt(4));
                ja.setDegreeID(rs.getInt(5));
                ja.setNumOfRecruit(rs.getInt(6));
                ja.setOfferEndTime(rs.getDate(7));
                ja.setSalary(rs.getInt(8));
                ja.setAge(rs.getInt(9));
                ja.setVisual(rs.getInt(10));
                ja.setJobDescription(rs.getString(11));
                ja.setOther(rs.getString(12));
                ja.setStartTime(rs.getTime(13));
                ja.setEndTime(rs.getTime(14));
                ja.setAddress(rs.getString(15));
                ja.setBusinessID(rs.getInt(16));
                ja.setStatus(rs.getInt(17));
                ja.setState(rs.getInt(18));
                ja.setApplicationID(rs.getInt(19));
                return ja;
            }
        });

        return result;
    }
}
