package com.ng.gdxfirebase.auth;

import com.ng.gdxfirebase.auth.FirebaseUser;

/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public class AndroidFirebaseUser implements FirebaseUser {

    private com.google.firebase.auth.FirebaseUser firebaseUser;

    public AndroidFirebaseUser(com.google.firebase.auth.FirebaseUser firebaseUser){
        this.firebaseUser=firebaseUser;
    }

    @Override
    public String getDisplayName(){
        return firebaseUser.getDisplayName();
    }


    @Override
    public String getEmail(){
        return firebaseUser.getEmail();
    }

    @Override
    public String getUid() {
        return firebaseUser.getUid();
    }

    @Override
    public String getPhotoURL(){
        return firebaseUser.getPhotoUrl().toString();
    }

    @Override
    public String getProvider(){
        return firebaseUser.getProviderId();
    }



}
