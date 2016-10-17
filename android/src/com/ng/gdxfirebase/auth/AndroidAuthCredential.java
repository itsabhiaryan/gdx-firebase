package com.ng.gdxfirebase.auth;

import com.ng.gdxfirebase.auth.AuthCredential;
/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public class AndroidAuthCredential implements AuthCredential {

    com.google.firebase.auth.AuthCredential authCredential;

    public AndroidAuthCredential(com.google.firebase.auth.AuthCredential authCredential) {
        this.authCredential = authCredential;
    }

    @Override
    public String getProvider() {
        return authCredential.getProvider();
    }

    public com.google.firebase.auth.AuthCredential getFirebaseAuthCredential(){
        return authCredential;
    }

}
