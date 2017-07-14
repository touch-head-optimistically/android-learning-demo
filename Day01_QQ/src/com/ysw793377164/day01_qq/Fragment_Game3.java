package com.ysw793377164.day01_qq;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Fragment_Game3 extends Fragment {
	private Button btn_enter3;
	private ImageView imv_dog;
	private AnimationDrawable anim_dog = null;
   
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_game3, container, false);
		btn_enter3 = (Button) view.findViewById(R.id.game3_enter);
		imv_dog = (ImageView) view.findViewById(R.id.catdog);
		anim_dog = (AnimationDrawable) imv_dog.getBackground();
		btn_enter3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity().getApplication(), Game3_Main.class);
				startActivity(intent);
			}
		});
		imv_dog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (anim_dog.isRunning())
				{
					anim_dog.stop();
					btn_enter3.setVisibility(View.INVISIBLE);
				}
				else
				{
					anim_dog.start();
					btn_enter3.setVisibility(View.VISIBLE);
				}
			}
		});
		return view;
	}
}
