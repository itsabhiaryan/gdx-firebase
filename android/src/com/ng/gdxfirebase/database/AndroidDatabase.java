package com.ng.gdxfirebase.database;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by Personal on 10/17/2016.
 */

public class AndroidDatabase implements FirebaseDatabase {

    com.google.firebase.database.DatabaseReference databaseReference;

    @Override
    public com.ng.gdxfirebase.database.DatabaseReference getReference() {
        DatabaseReference databaseReference= com.google.firebase.database.FirebaseDatabase.getInstance().getReference();
        return new AndroidDatabaseRef(databaseReference,this);
    }
}
