package com.appsalothelpgmail.workout.data;

import android.content.Context;

import com.appsalothelpgmail.workout.model.Exercise;
import com.appsalothelpgmail.workout.model.Program;
import com.appsalothelpgmail.workout.utils.ExerciseIDsTypeConverter;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database (entities = {Program.class, Exercise.class}, version = 1, exportSchema = false)
@TypeConverters(ExerciseIDsTypeConverter.class)
public abstract class WorkoutDatabase extends RoomDatabase {
    private static final Object LOCK = new Object();
    private static final String DB_NAME = "workout_db";
    private static WorkoutDatabase sInstance;
    public abstract ProgramDao dao();

    public static WorkoutDatabase getInstance(Context context){
        if(sInstance == null){
            //Database has not been created yet
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        WorkoutDatabase.class,
                        WorkoutDatabase.DB_NAME)
                        .build();
            }
        }
        return sInstance;
    }
}
