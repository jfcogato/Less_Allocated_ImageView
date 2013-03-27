package com.example.com.jfcogato.mycomponent;

import java.util.HashMap;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;


public class MyApplication extends Application {
	
	
	
	public static HashMap<Integer, Drawable> maphash;

	@Override
	public void onCreate() {
		maphash=new HashMap<Integer, Drawable>();


				
	}
	
	
	public static Drawable setImage(int drawInt,Context c){
		if (!maphash.containsKey(new Integer(drawInt))){
			maphash.put(new Integer(drawInt), getDrawable(c.getResources(), drawInt));
		}
		return maphash.get(new Integer(drawInt));
		
		
	}
	
	public static Drawable getDrawable(Resources res, int id){
    	return new BitmapDrawable(res, BitmapFactory.decodeStream(res.openRawResource(id)));
    }
	
	
	
}
