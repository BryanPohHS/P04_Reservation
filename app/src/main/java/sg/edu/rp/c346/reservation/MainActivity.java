package sg.edu.rp.c346.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  public static final String sendName = "sg.edu.rp.c346.reservation.sendName";
  public static final String sendContact = "sg.edu.rp.c346.reservation.sendContact";
  public static final String sendGroup = "sg.edu.rp.c346.reservation.sendGroup";
  public static final String sendTable = "sg.edu.rp.c346.reservation.sendTable";
  public static final String sendDate = "sg.edu.rp.c346.reservation.sendDate";
  public static final String sendTime = "sg.edu.rp.c346.reservation.sendTime";

  //Declare fields
  EditText etContact, etName, groupSize;
  CheckBox cbNonSmoking, cbSmoking;
  DatePicker datePicker;
  TimePicker timePicker;
  Button btnReset, btnSubmit;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    etName = findViewById(R.id.et_Name);
    etContact = findViewById(R.id.et_Contact);
    groupSize = findViewById(R.id.et_GroupSize);
    cbNonSmoking = findViewById(R.id.cb_NoSmoking);
    cbSmoking = findViewById(R.id.cb_Smoking);
    datePicker = findViewById(R.id.datePicker);
    timePicker = findViewById(R.id.timePicker);
    btnReset = findViewById(R.id.btn_Reset);
    btnSubmit = findViewById(R.id.btn_Submit);

    btnSubmit.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        Toast.makeText(MainActivity.this, "Successfully confirmed booking!", Toast.LENGTH_LONG).show();
        gotoConfirmation();

      }
    });

    btnReset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        timePicker.setCurrentHour(19);
        timePicker.setCurrentMinute(30);
        datePicker.updateDate(2019,5,1 );
        etName.setText("");
        etContact.setText("");
        groupSize.setText("");
        cbNonSmoking.setChecked(false);
        cbSmoking.setChecked(false);
      }
    });
  }

  public void gotoConfirmation()
  {

    String name          = etName.getText().toString();
    String contactNumber = etContact.getText().toString();
    int noOfPpl          = Integer.parseInt(groupSize.getText().toString());
    String tableChoice   = "";
    if (cbSmoking.isChecked())
    {
      tableChoice = "Smoking table";
    }
    else {
      tableChoice = "Non-Smoking table";
    }
    String reservationDate = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();
    String reservationTime = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();

    Intent intent = new Intent(this, submissionPage.class);
    intent.putExtra(sendName, name);
    intent.putExtra(sendContact, contactNumber);
    intent.putExtra(sendGroup, noOfPpl);
    intent.putExtra(sendTable, tableChoice);
    intent.putExtra(sendDate, reservationDate);
    intent.putExtra(sendTime, reservationTime);
    startActivity(intent);
  }
}

