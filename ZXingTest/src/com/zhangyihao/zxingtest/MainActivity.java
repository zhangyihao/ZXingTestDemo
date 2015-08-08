package com.zhangyihao.zxingtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.zxing.activity.CaptureActivity;

public class MainActivity extends Activity {

	private Button takeBtn;
	private TextView resultTv;
	private static int REQUEST_SCAN = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		takeBtn = (Button)findViewById(R.id.main_takebtn);
		resultTv = (TextView)findViewById(R.id.resultTV);
		takeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode != RESULT_OK) 
			return;
		
		if(REQUEST_SCAN == requestCode) {
			String result = data.getExtras().getString("result");
			Log.i("result", result);
			resultTv.setText(result);
		}
	}
	
	

}
