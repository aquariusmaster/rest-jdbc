package com.anderb.dao;

import com.anderb.model.Contact;

import java.util.List;

/**
 * Created by andreb on 21.06.17.
 */
public interface ContactDao {

    void save(Contact contact);
    void update(Contact contact);
    Contact findByName(String name);
    List<Contact> findAll();
    void delete(String name);
}
