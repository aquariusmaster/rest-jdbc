package com.anderb.dao;

import com.anderb.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreb on 21.06.17.
 */
public class ContactResultSetExtractor implements ResultSetExtractor<List<Contact>> {

    @Override
    public List<Contact> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        List<Contact> contacts = new ArrayList<>();
        List<String> names = new ArrayList<>();

        while (resultSet.next()){

            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            if (!names.contains(name)){
                Contact newContact = new Contact(name, phone);
                contacts.add(newContact);
                names.add(name);
            }else{
                int index = names.indexOf(name);
                Contact oldContact = contacts.get(index);
                oldContact.setPhones(oldContact.getPhones().concat(", " + phone));
            }
        }
        return contacts;
    }
}
