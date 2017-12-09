package com.community.jboss.contactgroups.data;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Associative entity for a many-to-many relationship
 * between a Contact and a Group
 */
@Table
public class ContactGroup extends SugarRecord {
    private Contact contact;
    private Group group;

    public ContactGroup() {
        this(null, null);
    }

    public ContactGroup(Contact contact, Group group) {
        this.contact = contact;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public Contact getContact() {
        return contact;
    }
}
