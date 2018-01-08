package com.example.test.uploadimage;

import com.firebase.ui.database.FirebaseListOptions;

public class SampleModel  {
    private String mName;
    private String mAddress;
    private String mPhoneno,mEmail,mLandline,malternateemail,mfield;

    public SampleModel(){

    }

    public SampleModel(String name,String address,String phoneno,String email,String landline,String alternate,String field){
        this.mName= name;
        this.mPhoneno=address;
        this.mPhoneno=phoneno;
        this.mEmail=email;
        this.mLandline=landline;
        this.malternateemail=alternate;
        this.mfield=field;


    }

    public String getMname() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmPhoneno() {
        return mPhoneno;
    }

    public String getmEmail() {
        return mEmail;
    }
    public String getmLandline() {
        return mLandline;
    }
    public String getmAlternateemail() {
        return malternateemail;
    }
    public String getmfield() {
        return mfield;
    }
}