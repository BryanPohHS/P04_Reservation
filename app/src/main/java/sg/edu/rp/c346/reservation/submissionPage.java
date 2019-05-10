package sg.edu.rp.c346.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class submissionPage extends AppCompatActivity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_submission_page);

    Intent intent = getIntent();

    String name = intent.getStringExtra(MainActivity.sendName);
    TextView confirm_Name = findViewById(R.id.confirm_Name);

    String contact = intent.getStringExtra(MainActivity.sendContact);
    TextView confirm_Contact = findViewById(R.id.confirm_Contact);

    String groupSize = intent.getStringExtra(MainActivity.sendGroup);
    TextView confirm_groupSize = findViewById(R.id.confirm_groupSize);

    String tableChoice = intent.getStringExtra(MainActivity.sendTable);
    TextView confirm_table = findViewById(R.id.confirm_table);

    String date = intent.getStringExtra(MainActivity.sendDate);
    TextView confirm_Date = findViewById(R.id.confirm_Date);

    String time = intent.getStringExtra(MainActivity.sendTime);
    TextView confirm_Time = findViewById(R.id.confirm_Time);


    confirm_Name.setText(name);
    confirm_Contact.setText(contact);
    confirm_groupSize.setText(groupSize);
    confirm_table.setText(tableChoice);
    confirm_Date.setText(date);
    confirm_Time.setText(time);


  }
}
