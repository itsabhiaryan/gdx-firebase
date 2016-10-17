package com.ng.gdxfirebase.auth;

import android.support.annotation.NonNull;

import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.ng.gdxfirebase.AndroidLauncher;
import com.ng.gdxfirebase.database.AndroidDatabase;
import com.ng.gdxfirebase.database.FirebaseDatabase;

import java.util.Arrays;

/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public class AndroidFirebaseAuth implements FirebaseAuth {

    public com.google.firebase.auth.FirebaseAuth mAuth;
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG=AndroidFirebaseAuth.class.getSimpleName();

    public AndroidFirebaseAuth androidFirebaseAuth;

    public AndroidFirebaseAuth(final AuthStateListener authStateListener){
        androidFirebaseAuth=this;
        mAuth= com.google.firebase.auth.FirebaseAuth.getInstance();
        mAuthListener = new com.google.firebase.auth.FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull com.google.firebase.auth.FirebaseAuth firebaseAuth) {
                authStateListener.onAuthStateChanged(androidFirebaseAuth);
                //com.google.firebase.auth.FirebaseUser user = firebaseAuth.getCurrentUser();
                //if (user != null) {
                    // User is signed in
                  //  Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                //} else {
                    // User is signed out
                  //  Log.d(TAG, "onAuthStateChanged:signed_out");
                //}
                // [START_EXCLUDE]
                //updateUI(user);
                //sdf();
                // [END_EXCLUDE]
            }
        };


    }


    public void onStart(){
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStop(){
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    public Task<AuthResult> signInWithCredential(AuthCredential authCredential){

        return mAuth.signInWithCredential(((AndroidAuthCredential) authCredential).getFirebaseAuthCredential());
    }


    @Override
    public FirebaseUser getCurrentUser() {
        if(mAuth.getCurrentUser() == null) {
            return null;
        }
        return new AndroidFirebaseUser(mAuth.getCurrentUser());
    }

    @Override
    public void login(){
        LoginManager.getInstance().logInWithReadPermissions(AndroidLauncher.androidLauncher,
                Arrays.asList("public_profile","email"));
    }

    @Override
    public FirebaseDatabase getDatabase(){
        return new AndroidDatabase();
    }

}
