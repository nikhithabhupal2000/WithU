package com.example.notify;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterVolunteer {
    Volunteer v;
    DatabaseReference mDatabase;
    public RegisterVolunteer(Volunteer v)
    {
        this.v=v;
        mDatabase = FirebaseDatabase.getInstance().getReference("Volunteers");
        addToDataBase();
    }
    private void addToDataBase()
    {
        mDatabase.child(v.Phno).setValue(v);
    }
}
