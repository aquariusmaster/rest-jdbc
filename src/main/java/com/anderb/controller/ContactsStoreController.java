package com.anderb.controller;

import com.anderb.model.Contact;
import com.anderb.model.dto.ContactDto;
import com.anderb.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static com.anderb.converter.ContactsConverter.*;

/**
 * Created by andreb on 20.06.17.
 */
@RestController
public class ContactsStoreController {

    private static final Logger log = LoggerFactory.getLogger(ContactsStoreController.class);

    private final ContactService contactService;

    @Autowired
    public ContactsStoreController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createContact(@RequestBody ContactDto contactDto){

        Contact contact = convertToEntity(contactDto);
        contactService.save(contact);
        log.debug("Saved contact: " + contact);
    }

    @PutMapping("/contact/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void updateContact(@RequestBody ContactDto contactDto){

        Contact contact = convertToEntity(contactDto);
        contactService.update(contact);
        log.debug("Update contact: " + contact);
    }

    @DeleteMapping("/contact/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteContact(@PathVariable String name){

        contactService.delete(name);
        log.debug("Delete contact with name: " + name);
    }
}
