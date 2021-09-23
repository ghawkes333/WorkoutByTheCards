package com.appsalothelpgmail.workout.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "program")


public class Program implements Parcelable {
    private String mName;
    private int[] mExerciseIds;

    @PrimaryKey (autoGenerate = true)
    public int mProgramID;
    private static String TAG = Program.class.getSimpleName();

    public Program(String name, int[] exerciseIds){
        mName = name;
        mExerciseIds = exerciseIds;
    }

    public Program(Parcel parcel){
        mProgramID = parcel.readInt();
        mName = parcel.readString();
        mExerciseIds = parcel.createIntArray();
    }

    public String getName() {
        return mName;
    }

    public int getProgramID(){
        return mProgramID;
    }


    public void setName(String name) {
        mName = name;
    }

    public int[] getExerciseIds() {
        return mExerciseIds;
    }

    public void setExerciseIds(int[] exerciseIds) {
        if(isValidExercises(exerciseIds)){
            mExerciseIds = exerciseIds;
        } else {
            Log.e(TAG, "Exercises are invalid");
        }
    }

    public static boolean isValidExercises(int[] exercises){
        return exercises.length == 4 || exercises.length == 8 || exercises.length == 12;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mProgramID);
        parcel.writeString(mName);
        parcel.writeIntArray(mExerciseIds);
    }

    public static final Parcelable.Creator<Program> CREATOR = new Creator<Program>() {
        @Override
        public Program createFromParcel(Parcel parcel) {
            return new Program(parcel);
        }

        @Override
        public Program[] newArray(int size) {
            return new Program[size];
        }
    };
}
