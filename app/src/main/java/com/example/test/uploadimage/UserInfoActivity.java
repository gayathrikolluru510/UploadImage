package com.example.test.uploadimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
//import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserInfoActivity extends AppCompatActivity {

    //private ListView mlistView;
   private TextView mListViewname,mListViewaddress,mListViewphoneno,mListViewemail,mListViewlandline;
    //ArrayList<SampleModel> list=new ArrayList<SampleModel>();
    //CustomAdapter<SampleModel>  adapter;

    private DatabaseReference mFirebaseDatabase;

   // private DatabaseReference mMessagesDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        //final ArrayList <SampleModel> itemList = new ArrayList<SampleModel>();
        // final CustomAdapter itemArrayAdapter = new CustomAdapter(this, R.layout.list_item, itemList);
       mListViewname = (TextView) findViewById(R.id.getNameValue);
       mListViewaddress= (TextView) findViewById(R.id.getAddressValue);
        mListViewphoneno= (TextView) findViewById(R.id.getPhoneValue);
        mListViewemail=(TextView) findViewById(R.id.getemailValue);
                mListViewlandline=(TextView) findViewById(R.id.getLandlineValue);
        // FirebaseDatabase.getInstance().setPersistenceEnabled(false);
        //mListView=(TextView) findViewById(R.id.listView);


        // adapter=new ArrayAdapter<SampleModel>(this,SampleModel.class,list);


        // Fetch the service account key JSON file contents
       // String file= "C:Users:Hari Priya:Desktop:serviceAccountCredentials.json";
       // FileInputStream serviceAccount = new FileInputStream//(file);

// Initialize the app with a service account, granting admin privileges
       /* FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://UploadImage.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
        */

        mFirebaseDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://uploadimage-3184d.firebaseio.com/");

        //mMessagesDatabaseReference = mFirebaseDatabase.child("madhurima");


//Finally you pass them to the constructor here:
      /*  Query query = FirebaseDatabase.getInstance().getReferenceFromUrl("https://uploadimage-3184d.firebaseio.com/madhurima");
        FirebaseListOptions.Builder<String> stringBuilder = new FirebaseListOptions.Builder<String>();
        stringBuilder.setQuery(query, SampleModel.class);
        stringBuilder.setLayout(android.R.layout.simple_list_item_1);
        FirebaseListOptions<String> options = stringBuilder.build();
        FirebaseListAdapter<SampleModel> adapter = new FirebaseListAdapter<SampleModel>(options) {

            @Override
            protected void populateView(View v, SampleModel model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView) v.findViewById(android.R.id.text1);

                // Set their text
                messageText.setText(model.getMname());
                // Format the date before showing it

            }


        }

                /

                //Finally you pass them to the constructor here:
               // FirebaseListAdapter < SampleModel > adapter = new FirebaseListAdapter<SampleModel>(options) {
            @Override
            //protected void populateView(View v, SampleModel model, int position) {
                // Get references to the views of message.xml
               // TextView messageText = (TextView) v.findViewById(android.R.id.text1);

                // Set their text
                //messageText.setText(model.getMname());
                // Format the date before showing it

            }
//

        };
       // mListView.setAdapter(adapter);
        //mListView.setAdapter(adapter);
        */

      mFirebaseDatabase.child("Name").addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              String value = dataSnapshot.getValue(String.class);
              mListViewname.setText(value);
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });

        mFirebaseDatabase.child("Address").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mListViewaddress.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mFirebaseDatabase.child("Email").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mListViewemail.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mFirebaseDatabase.child("Mobile Number").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mListViewphoneno.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mFirebaseDatabase.child("Landline").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mListViewlandline.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
