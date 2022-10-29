package com.seal.api.gwf.dao;

import com.seal.api.gwf.dto.get.AllJobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class JobApplication {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JobApplication(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<AllJobApplication> getAllJAByRecruiterID(int aid){
        String sql = """
            SELECT JA.ApplicationID, A.FirstName, A.LastName, JT.Name, B.BusinessName, B.Address, JO.Address 
            FROM JobOffer JO 
            INNER JOIN JobMapping JM on JO.OfferID = JM.OfferID
            INNER JOIN JobApplication JA on JM.ApplicationID = JA.ApplicationID
            INNER JOIN Applicant A on JA.AccountID = A.AccountID
            INNER JOIN Business B on JO.BusinessID = B.BusinessID
            INNER JOIN JobType JT on JO.TypeID = JT.TypeID
            WHERE JO.AccountID = 
            """ + aid;
        List<AllJobApplication> result = jdbcTemplate.query(sql, new RowMapper<AllJobApplication>(){
            @Override
            public AllJobApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
                AllJobApplication ja = new AllJobApplication();

                ja.setApplicationID(rs.getInt(1));
                ja.setFirstName(rs.getString(2));
                ja.setLastName(rs.getString(3));
                ja.setJobName(rs.getString(4));
                ja.setBusinessName(rs.getString(5));
                ja.setBusinessAddress(rs.getString(6));
                ja.setJoAddress(rs.getString(7));

                return ja;
            }
        });

        return result;
    }
}
