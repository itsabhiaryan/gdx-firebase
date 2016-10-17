package com.ng.gdxfirebase;

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


}
