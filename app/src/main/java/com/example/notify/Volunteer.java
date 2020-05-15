package com.example.notify;

public class Volunteer {
    String Name,Email,Phno,Gender;

    public Volunteer(String name, String email, String phno,String gender) {
        Name = name;
        Email = email;
        Phno = phno;
        Gender = gender;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhno() {
        return Phno;
    }

    public void setPhno(String phno) {
        Phno = phno;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}

