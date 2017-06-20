package com.anderb.service;

import com.anderb.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andreb on 20.06.17.
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {


    @Override
    public void save(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public Contact findOne(Contact contact) {
        return null;
    }

    @Override
    public Contact findByName(String name) {
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public void delete(Contact contact) {

    }
}
