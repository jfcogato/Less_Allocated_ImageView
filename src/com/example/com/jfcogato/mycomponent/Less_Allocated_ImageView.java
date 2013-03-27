package com.example.com.jfcogato.mycomponent;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class Less_Allocated_ImageView extends ImageView{
	
	public int src_resource = 0;
	public boolean cache;
	
	public Less_Allocated_ImageView(Context context){
		this(context, null);
	}
	
	public Less_Allocated_ImageView(Context context, AttributeSet attrs){
		this(context, attrs, 0);
	}
	
	public Less_Allocated_ImageView(Context context, AttributeSet attrs, int defStyle) {
		
		super(context, attrs, defStyle);
		
		if (attrs != null){
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Less_Allocated_ImageView, 0, 0);
			cache = a.getBoolean(R.styleable.Less_Allocated_ImageView_cache, false);
			Log.d("cache", String.valueOf(cache));
			src_resource = a.getResourceId(R.styleable.Less_Allocated_ImageView_src, 0);
			if (src_resource != 0){
				if (cache){
					setImageDrawable(MyApplication.setImage(src_resource, context));
				} else {
					setImageDrawable(getDrawable(getResources(), src_resource));
				}
				
			} else {
				src_resource = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
				if (src_resource != 0){
					setImageDrawable(getDrawable(getResources(), src_resource));
				}
				
			}
			if (a!=null){
				a.recycle();
			}
		}

	}
	
	public void setImage(Context context, Bitmap b){
		//In this first version, we ignore if the cache is true or false
		//and only make the setImageDrawable
		
		/*if (cache){
			setImageDrawable(MyApplication.setImage(R.drawable.ic_launcher, context));
		} else {
			setImageDrawable(getDrawable(getResources(), R.drawable.ic_launcher));
		}*/
		
		setImageDrawable(new BitmapDrawable(getResources(),b));
		
	}
	
	public static Drawable getDrawable(Resources res, int id){
    	return new BitmapDrawable(res, BitmapFactory.decodeStream(res.openRawResource(id)));
    }
	
	@Override
	public Parcelable onSaveInstanceState(){
		Bundle state = new Bundle();
		state.putParcelable("superstate", super.onSaveInstanceState());
		state.putBoolean("cache", cache);
		return(state);
	}
	
	@Override
	public void onRestoreInstanceState(Parcelable ss){
		Bundle state = (Bundle)ss;
		super.onRestoreInstanceState(state.getParcelable("superstate"));
		cache = state.getBoolean("cache");
	}
    
   
}
