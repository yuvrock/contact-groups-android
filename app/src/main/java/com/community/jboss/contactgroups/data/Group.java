package com.community.jboss.contactgroups.data;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
public class Group extends SugarRecord {
    @Unique
    private final UUID uid;
    private String name;

    public Group() {
        this(null);
    }

    public Group(String name) {
        this(name, UUID.randomUUID());
    }

    private Group(String name, UUID uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUid() {
        return uid;
    }

    public List<Contact> getContacts() {
        final List<ContactGroup> contactGroups = ContactGroup.find(ContactGroup.class,
                "contact = ?", this.getId().toString());
        final List<Contact> contacts = new ArrayList<>();
        for (ContactGroup contactGroup : contactGroups) {
            contacts.add(contactGroup.getContact());
        }
        return contacts;
    }
}
