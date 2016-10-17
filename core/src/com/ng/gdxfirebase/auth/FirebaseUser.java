package com.ng.gdxfirebase.auth;

/**
 * Created by itsabhiaryan on 16-10-2016.
 */

public interface FirebaseUser {

    public String getDisplayName();

    public String getEmail();

    public String getUid();

    public String getPhotoURL();

    public String getProvider();


}
