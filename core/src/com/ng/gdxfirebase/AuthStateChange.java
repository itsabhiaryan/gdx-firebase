package com.ng.gdxfirebase;

/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public class AuthStateChange  implements AuthStateListener {


    @Override
    public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        System.out.println("state changeed in core");
    }
}
