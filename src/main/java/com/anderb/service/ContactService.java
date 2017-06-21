package com.anderb.service;

import com.anderb.model.Contact;

import java.util.List;

/**
 * Created by andreb on 20.06.17.
 */
public interface ContactService {

    void save(Contact contact);
    void update(Contact contact);
    Contact findByName(String name);
    List<Contact> findAll();
    void delete(String name);
}
