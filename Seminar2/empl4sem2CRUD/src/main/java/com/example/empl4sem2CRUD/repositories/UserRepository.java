package com.example.empl4sem2CRUD.repositories;

import com.example.empl4sem2CRUD.model.PropertiesSqlRequest;
import com.example.empl4sem2CRUD.model.User;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class UserRepository {


    private final JdbcTemplate jdbc;
    private final PropertiesSqlRequest propertiesSqlRequest;

    public List<User> findAll() {
        //String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(propertiesSqlRequest.getFindAll(), userRowMapper);
    }

    public User save(User user) {
       // String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(propertiesSqlRequest.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        //String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(propertiesSqlRequest.getDeleteById(), id);
    }

    public User update(User user) {
        //String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(propertiesSqlRequest.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}
