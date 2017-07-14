package com.ysw793377164.day01_qq;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Fragment_Game1 extends Fragment {
	private ImageView imv_wm;
	private AnimationDrawable anim_wm = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_game1, container, false);
		imv_wm = (ImageView) view.findViewById(R.id.wm);
		anim_wm = (AnimationDrawable) imv_wm.getBackground();
		anim_wm.start();
		imv_wm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), Game1_Main.class);
				startActivity(intent);
			}
		});
		return view;
	}
}
