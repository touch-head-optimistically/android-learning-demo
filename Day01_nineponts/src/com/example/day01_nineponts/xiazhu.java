package com.example.day01_nineponts;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class xiazhu extends Activity {
	  private  ListView listView;
	  private Button  btn_fanhui;
	  private  String  name[]={"EXO","吴亦凡","皮卡丘","小新","基德","恐龙","哆啦A梦","西瓜"};
	  Intent intent=getIntent();	
	  private int images[]={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
              R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8} ;
      private String   sign[]={"wo1","wo2","wo3","wo4","wo5","wo6","wo7","wo8"};
      private String  namex,duzhux;
      private EditText edi_duzhu;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.xiazhubiao2);
	 listView=(ListView) findViewById(R.id.listview);
	 adapter adapter=new adapter(name, xiazhu.this,  sign,images);
	 btn_fanhui=(Button) findViewById(R.id.queding);
	 edi_duzhu=(EditText) findViewById(R.id.ediduzhu);
     listView.setAdapter(adapter);
    //买定离手
     btn_fanhui.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 String duzhux=edi_duzhu.getText().toString().trim(); 
			Intent intent=new Intent();   //新建intent对象
			   intent.putExtra("name", namex);
			   intent.putExtra("duzhu",duzhux);
            setResult(2000, intent); //设置结果码
           finish();   //finish
			
		}
	});
    //点listview反馈
    listView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
	        Toast.makeText(xiazhu.this, "你下注了"+name[arg2], Toast.LENGTH_SHORT).show();
	       namex=name[arg2];
		}
	});
	
}
}
