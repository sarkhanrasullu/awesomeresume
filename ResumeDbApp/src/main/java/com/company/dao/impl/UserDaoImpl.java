package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarkhanrasullu Data Access Object
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDesc = rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        return new User(id, name, surname, phone, email, profileDesc, birthdate, nationality, birthplace);
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {

            String sql = "select "
                    + "  u.*,  "
                    + "  n.nationality, "
                    + "  c.name as birthplace  "
                    + "from user u "
                    + "left join country n on u.nationality_id = n.id "
                    + "left join country c on u.birthplace_id = c.id where 1=1 ";

            if(name!=null && !name.trim().isEmpty()){
                sql += " and u.name=? ";
            }

            if(surname!=null && !surname.trim().isEmpty()){
                sql += " and u.surname=? ";
            }

            if(nationalityId!=null){
                sql += " and u.nationality_id=? ";
            }


            PreparedStatement stmt = c.prepareStatement(sql);

            int i=1;
            if(name!=null && !name.trim().isEmpty()){
                stmt.setString(i, name);
                i++;//2
            }

            if(surname!=null && !surname.trim().isEmpty()){
                stmt.setString(i, surname);
                i++;//3
            }

            if(nationalityId!=null){
                stmt.setInt(i, nationalityId);
            }


            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);

                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,phone=?,email=?, profile_description=?, birthdate=?, birthplace_id=?  where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setDate(6, u.getBirthDate());
            stmt.setInt(7, u.getBirthPlace().getId());
            stmt.setInt(8, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select "
                    + "  u.*,  "
                    + "  n.nationality, "
                    + "  c.name as birthplace  "
                    + "from user u "
                    + "left join country n on u.nationality_id = n.id "
                    + "left join country c on u.birthplace_id = c.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,phone,email,profile_description) values(?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
