package com.ng.gdxfirebase.auth;

import com.ng.gdxfirebase.database.FirebaseDatabase;

/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public interface FirebaseAuth {

    public FirebaseUser getCurrentUser();

    public void login();

    public FirebaseDatabase getDatabase();

}
