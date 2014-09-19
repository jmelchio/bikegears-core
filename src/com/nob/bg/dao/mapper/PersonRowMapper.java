/*
 * PersonRowMapper.java
 *
 * Created on August 26, 2006, 8:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import com.nob.bg.model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jorismelchior
 */
public class PersonRowMapper implements RowMapper {
    
    /** Creates a new instance of PersonRowMapper */
    public PersonRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        person.setInitials(rs.getString("initials"));
        
        return person;
    }
    
}
