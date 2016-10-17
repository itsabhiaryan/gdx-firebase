package com.ng.gdxfirebase.auth;

import com.badlogic.gdx.Gdx;

/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public class AuthStateChange implements AuthStateListener {

    private static final String TAG=AuthStateChange.class.getSimpleName();

    @Override
    public void onAuthStateChanged(FirebaseAuth firebaseAuth) {

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Gdx.app.log(TAG, "onAuthStateChanged:signed_in:" + firebaseUser.getUid());
            Gdx.app.log(TAG, "onAuthStateChanged:signed_in:" + firebaseUser.getEmail());
            Gdx.app.log(TAG, "onAuthStateChanged:signed_in:" + firebaseUser.getDisplayName());
            Gdx.app.log(TAG, "onAuthStateChanged:signed_in:" + firebaseUser.getPhotoURL());
            Gdx.app.log(TAG, "onAuthStateChanged:signed_in:" + firebaseUser.getProvider());


        }else {
            Gdx.app.log(TAG,"onAuthStateChanged:signed_out");
        }
    }
}
