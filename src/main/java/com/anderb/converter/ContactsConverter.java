package com.anderb.converter;

import com.anderb.model.Contact;
import com.anderb.model.dto.ContactDto;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by andreb on 20.06.17.
 */
public class ContactsConverter {

    public static Contact convertToEntity(ContactDto dto){
        if (dto == null) return null;
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setPhones(dto.getPhones().stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")));

        return contact;
    }

    public static ContactDto convertToDto(Contact contact){
        if (contact == null) return null;
        ContactDto dto = new ContactDto();
        dto.setName(contact.getName());
        dto.setPhones(Arrays.asList(contact.getPhones().split("\\s*,\\s*")));

        return dto;
    }
}
