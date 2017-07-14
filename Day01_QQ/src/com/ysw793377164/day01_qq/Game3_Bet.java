package com.ysw793377164.day01_qq;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Game3_Bet extends Activity {

	private ListView list;
	private int icons[] = {R.drawable.a2, R.drawable.a3, R.drawable.a6, R.drawable.a9, 
			               R.drawable.a8, R.drawable.a7, R.drawable.a4, R.drawable.a1 };
    private String names[] = {"»úÆ÷ÈË","ÎüÑª¹í","½£¼§","ÑÇË÷","Ö©Öë","°¢Àê","»Æ¼¦","·¢Ìõ"};
    private EditText money;
    private Button sure;
    private String str_name = null, str_money = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bet);
		list = (ListView) findViewById(R.id.bet_list);
		money = (EditText) findViewById(R.id.bet_money);
		sure = (Button) findViewById(R.id.bet_sure);
		
		
        MyAdapter_Bet ad_bet = new MyAdapter_Bet(icons, names, Game3_Bet.this);
        list.setAdapter(ad_bet);
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				arg1.setBackgroundColor(Color.RED);
				str_name = names[arg2];
				list.setEnabled(false);
			}
		});
        
        sure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				str_money = money.getText().toString().trim();
				if (str_name == null || str_money.equals(""))
				{
					Toast.makeText(Game3_Bet.this, "ÇëÑ¡ÔñÓ¢ÐÛ»òÊäÈë½ð±Ò£¡", Toast.LENGTH_LONG).show();
				}
				else
				{
					Intent intent = new Intent();
					intent.putExtra("Ó¢ÐÛ", str_name);	
					intent.putExtra("½ð±Ò", str_money);
				//	Toast.makeText(BetActivity.this, str_name + " " + str_money, Toast.LENGTH_SHORT).show();
					setResult(2000, intent);
					finish();
				}
			}
		});
	}
}
