package com.ng.gdxfirebase;

import com.google.firebase.auth.*;
import com.google.firebase.auth.FirebaseAuth;
import com.ng.gdxfirebase.AuthCredential;
/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public class AndroidAuthCredential implements AuthCredential {

    com.google.firebase.auth.AuthCredential authCredential;

    AndroidAuthCredential(com.google.firebase.auth.AuthCredential authCredential) {
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
