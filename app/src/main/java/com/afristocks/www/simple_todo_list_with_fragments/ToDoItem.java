package com.afristocks.www.simple_todo_list_with_fragments;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by danne on 10/8/2017.
 */


public class ToDoItem implements Parcelable {

    private String text;
    private Date dateCreated;
    private boolean urgent;

    public ToDoItem(Parcel in){
        text = in.readString();
        dateCreated = (Date) in.readSerializable();
        urgent = (in.readInt() == 1) ;

    }

    public ToDoItem(String text, boolean urgent){
        this.text = text;
        this.urgent = urgent;
        dateCreated = new Date();


    }
    public String getText(){
        return text;


    }

    public void setText(String text){
        this.text = text;


    }

    public Date getDateCreated(){
        return dateCreated;

    }
    public void setDateCreated(Date dateCreated){
        this.dateCreated = dateCreated;

    }

    public boolean isUrgent(){
        return urgent;


    }

    public void setUrgent(boolean urgent){
        this.urgent = urgent;


    }

   @Override
    public String toString(){
       return text + " " + dateCreated.toString() + "is urgent? " + urgent;


   }

   //Code requred by the Parcebable interface. if ToDo Item is praceble, can send as can Extra between Fragments/Activities

    static final Parcelable.Creator<ToDoItem> CREATOR = new Parcelable.Creator<ToDoItem>(){
        public ToDoItem createFromParcel(Parcel in){
            return new ToDoItem(in);

        }

        @Override
        public ToDoItem[] newArray(int size){
            return new ToDoItem[size];

        }
    };

    public int describeContents(){
        return 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags){

            dest.writeString(text);
            dest.writeSerializable(dateCreated);
            // Write 0 for false, 1 for ture
        int urg = urgent ? 1 : 0;
            dest.writeInt(urg);
    }

}
