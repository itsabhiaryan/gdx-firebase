package com.ng.gdxfirebase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ng.gdxfirebase.auth.FirebaseAuth;
import com.ng.gdxfirebase.database.DatabaseReference;
import com.ng.gdxfirebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public static final String TAG=Main.class.getSimpleName();

	FirebaseAuth firebaseAuth;
	public Stage stage;

	BitmapFont bitmapFont;

	public Main(FirebaseAuth firebaseAuth){
		this.firebaseAuth=firebaseAuth;
	}

	@Override
	public void create () {


		Image login=new Image(new Texture("download.png"));
		Image logout=new Image(new Texture("logout.png"));

		login.setSize(200,100);
		logout.setSize(200,100);

		login.setPosition(0,400);
		logout.setPosition(0,500);

		bitmapFont=new BitmapFont();
		bitmapFont.getData().scale(2);

		stage=new Stage();
		Gdx.input.setInputProcessor(stage);
		Image image=new Image(new Texture("badlogic.jpg"));
		image.setPosition(200,200);
		stage.addActor(image);
		Gdx.app.log(TAG,firebaseAuth.getDatabase().getReference().toString());

		stage.addActor(login);
		stage.addActor(logout);

		DatabaseReference databaseReference=firebaseAuth.getDatabase().getReference().child("users").child(firebaseAuth.getCurrentUser().getUid());

		Map<String, Object> childUpdates = new HashMap();
		childUpdates.put("levels","1");

		databaseReference.updateChildren(childUpdates);

		DatabaseReference di=firebaseAuth.getDatabase().getReference().child("users").child(firebaseAuth.getCurrentUser().getUid());
		System.out.println("Key is ksdfhsdfhsdbnkjsdkfsd"+di.getKey());





		//databaseReference.updateChildren();

		login.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				firebaseAuth.login();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();


		stage.draw();
		stage.getBatch().begin();
		bitmapFont.draw(stage.getBatch(),firebaseAuth.getCurrentUser().getDisplayName(),Gdx.graphics.getWidth()/3f,Gdx.graphics.getHeight()*.9f);
		bitmapFont.draw(stage.getBatch(),firebaseAuth.getCurrentUser().getEmail(),Gdx.graphics.getWidth()/3f,Gdx.graphics.getHeight()*.8f);
		bitmapFont.draw(stage.getBatch(),firebaseAuth.getCurrentUser().getPhotoURL(),Gdx.graphics.getWidth()/3f,Gdx.graphics.getHeight()*.7f);
		bitmapFont.draw(stage.getBatch(),firebaseAuth.getCurrentUser().getProvider(),Gdx.graphics.getWidth()/3f,Gdx.graphics.getHeight()*.6f);
		stage.getBatch().end();

		stage.act();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		stage.dispose();
	}
}
