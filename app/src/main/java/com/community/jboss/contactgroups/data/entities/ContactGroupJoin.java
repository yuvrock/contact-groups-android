package com.community.jboss.contactgroups.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

/**
 * Associative entity for a many-to-many relationship
 * between a Contact and a Group
 */
@Entity(primaryKeys = {
        "contactId",
        "groupId",
}, foreignKeys = {
        @ForeignKey(entity = Contact.class,
                parentColumns = "id",
                childColumns = "contactId"),
        @ForeignKey(entity = Group.class,
                parentColumns = "id",
                childColumns = "groupId"),
})
public class ContactGroupJoin {
    @NonNull
    private final String contactId;
    @NonNull
    private final String groupId;

    public ContactGroupJoin(@NonNull String contactId, @NonNull String groupId) {
        this.contactId = contactId;
        this.groupId = groupId;
    }

    @NonNull
    public String getContactId() {
        return contactId;
    }

    @NonNull
    public String getGroupId() {
        return groupId;
    }
}
