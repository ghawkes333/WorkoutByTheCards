package com.appsalothelpgmail.workout;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercise")
public class Exercise implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int mExerciseId = 0;
    private String mExerciseName;
    private String[] mExerciseEquipment;

    public Exercise(String exerciseName, String[] exerciseEquipment){
        mExerciseName = exerciseName;
        mExerciseEquipment = exerciseEquipment;
    }

    public Exercise(Parcel in) {
        mExerciseId = in.readInt();
        mExerciseName = in.readString();
        mExerciseEquipment = in.createStringArray();
    }


    public int getExerciseId(){
        return mExerciseId;
    }

    public String getExerciseName(){
        return mExerciseName;
    }

    public String[] getExerciseEquipment(){
        return mExerciseEquipment;
    }

    public void setExerciseName(String name){
        mExerciseName = name;
    }

    public void setmExerciseEquipment(String[] equipment){
        mExerciseEquipment = equipment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mExerciseId);
        parcel.writeString(mExerciseName);
        parcel.writeStringArray(mExerciseEquipment);
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };
}
