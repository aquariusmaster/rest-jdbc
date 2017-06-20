package com.anderb.controller;

import com.anderb.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andreb on 20.06.17.
 */
@RestController
public class ContactsController {

    private static final Logger log = LoggerFactory.getLogger(ContactsController.class);

    private final ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }


}
