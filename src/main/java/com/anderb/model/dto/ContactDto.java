package com.anderb.model.dto;

import java.util.List;

/**
 * Created by andreb on 20.06.17.
 */
public class ContactDto {

    private String name;
    private List<String> phones;

    public ContactDto() {
    }

    public ContactDto(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
