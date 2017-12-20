package com.community.jboss.contactgroups.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.community.jboss.contactgroups.data.entities.Contact;
import com.community.jboss.contactgroups.data.entities.ContactGroupJoin;
import com.community.jboss.contactgroups.data.entities.Group;

import java.util.List;

@Dao
public interface ContactGroupJoinDao {
    @Insert
    void insert(ContactGroupJoin contactGroupJoin);

    @Query("SELECT * FROM contact INNER JOIN contactgroupjoin ON contact.id = contactgroupjoin.contactId WHERE contactgroupjoin.groupId = :groupId")
    List<Contact> getContactsForGroup(String groupId);

    @Query("SELECT * FROM `group` INNER JOIN contactgroupjoin ON `group`.id = contactgroupjoin.groupId WHERE contactgroupjoin.contactId = :contactId")
    List<Group> getGroupsForContact(String contactId);
}
