package com.community.jboss.contactgroups.data;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
public class Contact extends SugarRecord {
    @Unique
    private final UUID uid;
    private String name;

    public Contact() {
        this(null);
    }

    public Contact(String name) {
        this(name, UUID.randomUUID());
    }

    private Contact(String name, UUID uid) {
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

    public List<ContactNumber> getContactNumbers() {
        return ContactNumber.find(ContactNumber.class,
                "contact_number = ?", this.getId().toString());
    }

    public List<Group> getGroups() {
        final List<ContactGroup> contactGroups = ContactGroup.find(ContactGroup.class,
                "contact = ?", this.getId().toString());
        final List<Group> groups = new ArrayList<>();
        for (ContactGroup contactGroup : contactGroups) {
            groups.add(contactGroup.getGroup());
        }
        return groups;
    }
}
