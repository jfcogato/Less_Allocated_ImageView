package com.example.com.jfcogato.mycomponent;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.widget.RelativeLayout;

public class MyComponent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_component);
		
		Less_Allocated_ImageView image = (Less_Allocated_ImageView) findViewById(R.id.tAImageView1);
		//Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fake_the_faker);
		//image.setImage(this, bitmap);
		image.setImageResource(R.drawable.fake_the_faker);
		
	}

	
}
