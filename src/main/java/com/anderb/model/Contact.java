package com.anderb.model;

/**
 * Created by andreb on 20.06.17.
 */
public class Contact {

    private String name;
    private String phones;

    public Contact() {
    }

    public Contact(String name, String phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Contact{" +
                ", name='" + name + '\'' +
                ", phones='" + phones + '\'' +
                '}';
    }
}
