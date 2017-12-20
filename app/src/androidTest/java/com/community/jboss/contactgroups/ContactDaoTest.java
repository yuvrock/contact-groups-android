package com.community.jboss.contactgroups;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.community.jboss.contactgroups.data.ContactDatabase;
import com.community.jboss.contactgroups.data.entities.Contact;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class ContactDaoTest {
    private ContactDatabase mDatabase;

    @Before
    public void initDatabase() {
        mDatabase = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                ContactDatabase.class).build();
    }

    @After
    public void closeDatabase() {
        mDatabase.close();
    }

    @Test
    public void insertSavesData() {
        final Contact cachedContact = new Contact("Tom Chen");
        mDatabase.getContactDao().insert(cachedContact);

        final List<Contact> contacts = mDatabase.getContactDao().getContacts();
        assert (!contacts.isEmpty());
    }

    @Test
    public void updateUpdatesData() {
        final Contact cachedContact = new Contact("Li Ang");
        mDatabase.getContactDao().insert(cachedContact);

        cachedContact.setName("Lo Ang");
        mDatabase.getContactDao().update(cachedContact);

        final Contact retrievedContact = mDatabase.getContactDao().getContact(cachedContact.getId());
        assert (retrievedContact == cachedContact);
    }

    @Test
    public void deleteRemovesData() {
        final Contact cachedContact = new Contact("Jake Henderson");
        mDatabase.getContactDao().insert(cachedContact);

        mDatabase.getContactDao().delete(cachedContact);

        final List<Contact> contacts = mDatabase.getContactDao().getContacts();
        assert (contacts.isEmpty());
    }

    @Test
    public void getContactsRetrievesData() {
        final List<Contact> cachedContacts = new ArrayList<>();
        cachedContacts.add(new Contact("Jackie Chan"));
        cachedContacts.add(new Contact("John Cena"));
        cachedContacts.add(new Contact("Morgan Freeman"));

        for (Contact contact : cachedContacts) {
            mDatabase.getContactDao().insert(contact);
        }

        final List<Contact> retrievedContacts = mDatabase.getContactDao().getContacts();
        assert (cachedContacts == retrievedContacts);
    }

    @Test
    public void getContactRetrievesDataById() {
        final Contact cachedContact = new Contact("Irelia Ine");
        mDatabase.getContactDao().insert(cachedContact);

        final Contact retrievedContact = mDatabase.getContactDao().getContact(cachedContact.getId());
        assert cachedContact == retrievedContact;
    }
}
