package com.anderb.service;

import com.anderb.dao.ContactDao;
import com.anderb.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andreb on 20.06.17.
 */
@Service("contactService")
public class ContactServiceJdbc implements ContactService {

    private final ContactDao contactDao;

    @Autowired
    public ContactServiceJdbc(ContactDao contactDao){
        this.contactDao = contactDao;
    }

    @Override
    public void save(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDao.update(contact);
    }

    @Override
    public Contact findByName(String name) {
        return contactDao.findByName(name);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public void delete(Contact contact) {
        contactDao.delete(contact);
    }
}
