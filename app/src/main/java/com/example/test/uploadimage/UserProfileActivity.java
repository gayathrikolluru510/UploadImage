package com.example.test.uploadimage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

  private DatabaseReference mref;
    private EditText mname,maddress,mphoneNumber,memail,malternateEmail,mlandLine,mField;
    private Button msavebtn,muploadbtn;
    private String name,address,phoneNumber,email,alternateEmail,landLine,field1;
   // private
    private DatabaseReference mrefchild,mchildref,mchildref2;
    FirebaseStorage storage;
    StorageReference storageReference;
    private ImageView imageView;

    private Uri filePath;

    private final int PICK_IMAGE_REQUEST = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

      // FirebaseDatabase.getInstance().setPersistenceEnabled(false);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();



         // mref.getDatabase().setPersistenceEnabled(true);


        mname=(EditText)findViewById(R.id.enterName);
        maddress=(EditText)findViewById(R.id.enterAddress);
        mphoneNumber=(EditText)findViewById(R.id.enterPhone);
        memail=(EditText)findViewById(R.id.enterEmail);
        malternateEmail=(EditText)findViewById(R.id.enterAlternateEmail);
        mlandLine= (EditText)findViewById(R.id.enterLandline);
        mField=(EditText)findViewById(R.id.field1);

        mref = FirebaseDatabase.getInstance()
                .getReference();


        msavebtn=(Button)findViewById(R.id.savebtn);
       msavebtn.setOnClickListener((View.OnClickListener) this);
        // mrefchild = mref.child("Name");



        muploadbtn=(Button) findViewById(R.id.uploadPhoto);
        muploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserProfileActivity.this, UploadActivity.class));
            }
        });


    }

    @Override
    public void onClick(View view) {

        name=mname.getText().toString();
        address=maddress.getText().toString();
        phoneNumber=mphoneNumber.getText().toString();
        email=memail.getText().toString();
        alternateEmail=malternateEmail.getText().toString();
        landLine=mlandLine.getText().toString();
        field1=mField.getText().toString();

        Map<String, String> users = new HashMap<>();
        users.put("Name",name );
        users.put("Address",address );
        users.put("Mobile  Number",phoneNumber );
        users.put("Email",email );
        users.put("Alternate Email",alternateEmail );
        users.put("Landline",landLine);
        users.put("Field1",field1 );

        mchildref=mref.child("User");
        mchildref.setValue(phoneNumber);
        mchildref2=mchildref.child("User1");


        //mrefchild.push();

        mchildref2 .setValue(users);

    }

}
