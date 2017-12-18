package com.community.jboss.contactgroups.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.community.jboss.contactgroups.data.daos.ContactDao;
import com.community.jboss.contactgroups.data.daos.ContactGroupJoinDao;
import com.community.jboss.contactgroups.data.daos.ContactNumberDao;
import com.community.jboss.contactgroups.data.daos.GroupDao;
import com.community.jboss.contactgroups.data.entities.Contact;
import com.community.jboss.contactgroups.data.entities.ContactGroupJoin;
import com.community.jboss.contactgroups.data.entities.ContactNumber;
import com.community.jboss.contactgroups.data.entities.Group;

@Database(entities = {
        Contact.class,
        ContactNumber.class,
        Group.class,
        ContactGroupJoin.class,
}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "contactgroups.db";

    private static volatile ContactDatabase sInstance;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return sInstance;
    }

    public abstract ContactDao getContactDao();

    public abstract ContactNumberDao getContactNumberDao();

    public abstract GroupDao getGroupDao();

    public abstract ContactGroupJoinDao getContactGroupJoinDao();
}
