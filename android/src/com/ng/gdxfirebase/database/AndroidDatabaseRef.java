package com.ng.gdxfirebase.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Map;

/**
 * Created by Personal on 10/17/2016.
 */

public class AndroidDatabaseRef extends AndroidQuery implements DatabaseReference {

    com.google.firebase.database.DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    public AndroidDatabaseRef(com.google.firebase.database.DatabaseReference databaseReference,FirebaseDatabase firebaseDatabase){
        super(databaseReference);
        this.databaseReference=databaseReference;
        this.firebaseDatabase=firebaseDatabase;
    }

    @Override
    public DatabaseReference child(String s) {
        return new AndroidDatabaseRef(databaseReference.child(s),firebaseDatabase);
    }

    @Override
    public DatabaseReference push() {
        return new AndroidDatabaseRef(databaseReference.push(),firebaseDatabase);
    }

    @Override
    public String getKey() {
        return databaseReference.getKey();
    }

    @Override
    public void updateChildren(Map<String, Object> update) {
        databaseReference.updateChildren(update);
    }


    @Override
    public void setValue(Object o) {
        databaseReference.setValue(o);
    }


    @Override
    public void removeValue() {
        databaseReference.removeValue();
    }
}
