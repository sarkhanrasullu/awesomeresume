package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarkhanrasullu Data Access Object
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
 
    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
            String header = rs.getString("header");
            String jobDescription = rs.getString("job_description");
            Date beginDate = rs.getDate("begin_date");
            Date endDate= rs.getDate("end_date");
            int userId = rs.getInt("user_id");
            EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
            return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                EmploymentHistory emp = getEmploymentHistory(rs);
                result.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    
    

}
