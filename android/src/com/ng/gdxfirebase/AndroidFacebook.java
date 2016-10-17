package com.ng.gdxfirebase;

import com.facebook.login.LoginManager;

import java.util.Arrays;

/**
 * Created by Personal on 10/17/2016.
 */

public class AndroidFacebook implements FacebookLogin {

    @Override
    public void login() {
        LoginManager.getInstance().logInWithReadPermissions(AndroidLauncher.androidLauncher,
                Arrays.asList("public_profile","email"));
    }
}
