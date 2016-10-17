package com.ng.gdxfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.ng.gdxfirebase.Main;

import java.util.Arrays;

public class AndroidLauncher extends AndroidApplication {

	AndroidFirebaseAuth firebaseAuth;

	private CallbackManager mCallbackManager;
	private static final String TAG=AndroidLauncher.class.getSimpleName();
	AndroidLauncher androidLauncher;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		androidLauncher=this;
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		firebaseAuth=new AndroidFirebaseAuth(new AuthStateChange());

		initialize(new Main(firebaseAuth), config);

		FacebookSdk.sdkInitialize(getApplicationContext());
		//mAuth = FirebaseAuth.getInstance();
		//FacebookActivity.
		//FacebookActivity.

		mCallbackManager = CallbackManager.Factory.create();
		LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {
				Log.d(TAG, "facebook:onSuccess:" + loginResult);
				handleFacebookAccessToken(loginResult.getAccessToken());
			}

			@Override
			public void onCancel() {
				Log.d(TAG, "facebook:onCancel");
				// [START_EXCLUDE]
				//updateUI(null);
				// [END_EXCLUDE]
			}

			@Override
			public void onError(FacebookException error) {
				Log.d(TAG, "facebook:onError", error);
				// [START_EXCLUDE]
				//updateUI(null);
				// [END_EXCLUDE]
			}
		});



		LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"));
		//LoginButton loginButton = (LoginButton) findViewById(R.id.button_facebook_login);
		//loginButton.setReadPermissions("email", "public_profile");
		/*loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {
				//Log.d(TAG, "facebook:onSuccess:" + loginResult);
				handleFacebookAccessToken(loginResult.getAccessToken());
			}

			@Override
			public void onCancel() {
				//Log.d(TAG, "facebook:onCancel");
				// [START_EXCLUDE]
				//updateUI(null);
				// [END_EXCLUDE]
			}

			@Override
			public void onError(FacebookException error) {
				//Log.d(TAG, "facebook:onError", error);
				// [START_EXCLUDE]
				//updateUI(null);
				// [END_EXCLUDE]
			}
		});
*/
	}

	private void handleFacebookAccessToken(AccessToken token) {
		Log.d(TAG, "handleFacebookAccessToken:" + token);
		// [START_EXCLUDE silent]
		//showProgressDialog();
		// [END_EXCLUDE]

		//AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());

		AndroidAuthCredential credential=new AndroidAuthCredential(FacebookAuthProvider.getCredential(token.getToken()));
		firebaseAuth.signInWithCredential(credential)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

						// If sign in fails, display a message to the user. If sign in succeeds
						// the auth state listener will be notified and logic to handle the
						// signed in user can be handled in the listener.
						if (!task.isSuccessful()) {
							Log.w(TAG, "signInWithCredential", task.getException());
							Toast.makeText(androidLauncher, "Authentication failed.", Toast.LENGTH_SHORT).show();
						}

						// [START_EXCLUDE]
						//hideProgressDialog();
						// [END_EXCLUDE]
					}
				});
	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		mCallbackManager.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onStop() {
		super.onStop();
		firebaseAuth.onStop();
	}

	@Override
	public void onStart() {
		super.onStart();
		firebaseAuth.onStart();
	}

	public void sdf(){

		System.out.println(FirebaseAuth.getInstance().getCurrentUser());
		//FirebaseApp.getInstance().
		//FirebaseDatabase.getInstance().

	}

}
