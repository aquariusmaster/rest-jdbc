package com.anderb.dao;

import com.anderb.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andreb on 21.06.17.
 */
@Repository
public class ContactDaoJdbc implements ContactDao {

    private static final Logger log = LoggerFactory.getLogger(ContactDaoJdbc.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactDaoJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void save(Contact contact) {

        String insertionSql = "INSERT INTO contacts (name, phone) VALUES ";
        List<String> phones = Arrays.asList(contact.getPhones().split("\\s*,\\s*"));
        for (int i = 0; i < phones.size(); i++) {
            insertionSql += " ( '" + contact.getName() + "', '" + phones.get(i) + "')";
            if (i < phones.size() - 1){
                insertionSql += ", ";
            }
        }
        insertionSql += ";";
        log.debug("Insert query: " + insertionSql);
        int row = jdbcTemplate.update(insertionSql);
        log.debug(row + " rows inserted.");
    }

    @Override
    @Transactional
    public void update(Contact contact) {

        String getIdSql = "SELECT id FROM contacts WHERE name=?";
        List<Long> idList = jdbcTemplate.queryForList(
                getIdSql, new Object[]{contact.getName()}, Long.class);

        List<Object[]> params = new ArrayList<>();
        List<String> phones = Arrays.asList(contact.getPhones().split("\\s*,\\s*"));
        String sqlUpdate;
        if (idList.size() == phones.size()){
            sqlUpdate = "UPDATE contacts SET name=?, phone=? WHERE id=?";
            int i = 0;
            for (Long id: idList) {
                //UPDATE contacts SET username=?, phone=? WHERE id=?
                params.add(new Object[]{contact.getName(), phones.get(i++), id});
            }
            int[] updateCounts = jdbcTemplate.batchUpdate(sqlUpdate, params);
            log.debug("Rows updates: " + Arrays.toString(updateCounts));
        }else {
            log.debug("Update not equal");
            //TODO if idList.size <> phones.size
            throw new UnsupportedOperationException("Attempt update uncompatible data");
        }

    }

    @Override
    public Contact findByName(String name) {

        List<Contact> result = jdbcTemplate.query(
                "SELECT name, phone FROM contacts WHERE name=?", new Object[]{name},
                new ContactResultSetExtractor());
        if (result != null && !result.isEmpty()){
            return result.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Contact> findAll() {
        return jdbcTemplate.query("SELECT name, phone FROM contacts",
                new ContactResultSetExtractor());
    }

    @Override
    @Transactional
    public void delete(String name) {
        jdbcTemplate.update(
                "DELETE FROM contacts WHERE name=?", new Object[]{name});
    }
}
