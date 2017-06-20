package com.anderb.controller;

import com.anderb.model.Contact;
import com.anderb.model.dto.ContactDto;
import com.anderb.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.anderb.converter.ContactsConverter.*;

/**
 * Created by andreb on 20.06.17.
 */
@RestController
public class ContactsFetchController {

    private static final Logger log = LoggerFactory.getLogger(ContactsFetchController.class);

    private final ContactService contactService;

    @Autowired
    public ContactsFetchController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<ContactDto> getAllContacts() {

        List<Contact> contacts = contactService.findAll();
        List<ContactDto> contactDtos = contacts.stream()
                .map(contact -> convertToDto(contact)).collect(Collectors.toList());

        return contactDtos;
    }

    @GetMapping("/contact/{name}")
    @ResponseBody
    public ContactDto getContact(@PathVariable String name){

        Contact contact = contactService.findByName(name);
        return convertToDto(contact);
    }
}
