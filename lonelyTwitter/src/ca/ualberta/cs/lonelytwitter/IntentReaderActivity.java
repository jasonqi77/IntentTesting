package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

public class IntentReaderActivity extends Activity {

	public static final String TEXT_KEY = "TEXT";
	public static final String TRANSFORM_KEY = "TRANSFORM";

	public static final int NORMAL = 1;
	public static final int REVERSE = 2;
	public static final int DOUBLE = 3;
	
	private String text,text2;
	private int mode, mode2;
	
	public String getText() {
		return text;
	}
	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_reader);
		
		Intent intent = getIntent();
		TextView textView = (TextView)findViewById(R.id.intentText);
		mode = intent.getIntExtra(TRANSFORM_KEY, NORMAL);
		if (mode==1 && !intent.hasExtra(TEXT_KEY))
		{
			
			textView.setText("No text is sent");
		}		
		else
		{			
			text = transformText(intent.getStringExtra(TEXT_KEY));			
			textView.setText(text);
		}
		
	}
	
	public String transformText(String text) {
		switch (mode) {
			case REVERSE:
				char[] string =  text.toCharArray();
				for (int i = 0; i < string.length / 2; i++) {
					char tmp = string[i];
					string[i] = string[string.length - i -1];
					string[string.length - i - 1] = tmp;
				}
				return new String(string);
			case DOUBLE:
				return text + text;
		}
		return text;
	}
	
	
}
