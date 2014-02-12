/**
 * 
 */
package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;


/**
 * @author bqi
 *
 */
@SuppressLint("NewApi")
public class IntentReaderActivityTests extends ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	/**
	 * @param name
	 */
	public IntentReaderActivityTests()
	{

		super(IntentReaderActivity.class);
	}
	
	public void testSendText()
	{
		Intent intent = new Intent();
		String text = "HELLO!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get text from intent",text,activity.getText());
	}
	
	public void testDoubleText()
	{
		Intent intent = new Intent();
		String text = "HELLO!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get text from intent",text + text,activity.getText());
	}
	
	public void testDisplayText()
	{
		Intent intent = new Intent();
		String text = "HELLO!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
	
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity should display text",text,textView.getText().toString());
	}
	
	public void testReverseText()
	{
		Intent intent = new Intent();
		String text = "Bill is a ShaBi";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should reverse the text", "iBahS a si lliB", activity.getText());
		
	}
	
	public void testSentMessage()
	{
		Intent intent = new Intent();
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity should display text","No text is sent",textView.getText().toString());
	}

}
