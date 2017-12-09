package com.community.jboss.contactgroups.data;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.UUID;

@Table
public class ContactNumber extends SugarRecord {
    @Unique
    private final UUID uid;
    private int number;
    private Contact contact;

    public ContactNumber() {
        this(-1, null);
    }

    public ContactNumber(int number, Contact contact) {
        this(number, contact, UUID.randomUUID());
    }

    private ContactNumber(int number, Contact contact, UUID uid) {
        this.number = number;
        this.contact = contact;
        this.uid = uid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
