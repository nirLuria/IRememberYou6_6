package com.example.nluria.irememberyou;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nluria.irememberyou.DB.DataBaseHelper;

/**
 * Created by nluria on 5/17/2017.
 */

public class AddSingle extends AppCompatActivity
{
    private static RadioGroup radioGroup;
    private static RadioButton radio_choose;
    private static Button submit;
    EditText ageET, firstNameET, lastNameET;

    DataBaseHelper myDb;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_single_layout);

        myDb = new DataBaseHelper(this);

        firstNameET = (EditText)findViewById(R.id.add_first_name);
        lastNameET = (EditText)findViewById(R.id.add_last_name);
        ageET = (EditText)findViewById(R.id.add_age);


        submit();
    }


    public void submit()
    {
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        submit= (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                int selected_id=radioGroup.getCheckedRadioButtonId();
                radio_choose = (RadioButton) findViewById(selected_id);
                String firstName=firstNameET.getText().toString();
                String lastName=lastNameET.getText().toString();
                String age=ageET.getText().toString();

                System.out.println("firstName: "+firstName+"|");
                System.out.println("age: "+age);

                if (!checkFirstName(firstName))
                {
                    printFNameError();
                }
                else if (!checkFirstName(lastName))
                {
                    printLNameError();
                }
                else if (!checkGender())
                {
                    printGenderError();
                }
                else if (!checkAge(age))
                {
                    printAgeError();
                }
                else
                {

                    boolean isInserted = myDb.insertNewPerson(firstName, lastName, age, radio_choose.getText().toString());
                    System.out.println(" isInserted is: " + isInserted);
                    System.out.println(" radio_choose is: " + radio_choose);
                    Toast.makeText(AddSingle.this,radio_choose.getText().toString()+", "+firstName+", "+lastName+", "+age, Toast.LENGTH_SHORT ).show();
                    ageET.setText("");
                    firstNameET.setText("");
                    lastNameET.setText("");

                }

            }
        });

    }



    public boolean checkFirstName(String firstName)
    {

        if (firstName==null)
            return false;
        if (firstName.length()==0)
            return false;

        return true;
    }


    public boolean checkGender()
    {
        if (radio_choose==null)
            return false;

        return true;
    }

    public boolean checkAge(String age)
    {
        if (age.equals(""))
            return false;
        if (!age.matches("[0-9]+"))
            return false;

        return true;
    }

    public void printFNameError()
    {
        Toast.makeText(AddSingle.this, "אנא הזן שם פרטי", Toast.LENGTH_SHORT ).show();

    }

    public void printLNameError()
    {
        Toast.makeText(AddSingle.this, "אנא הזן שם משפחה", Toast.LENGTH_SHORT ).show();

    }

    public void printGenderError()
    {
        Toast.makeText(AddSingle.this, "אנא בחר מין", Toast.LENGTH_SHORT ).show();

    }

    public void printAgeError()
    {
        Toast.makeText(AddSingle.this, "אנא הזן גיל", Toast.LENGTH_SHORT ).show();
    }


}
