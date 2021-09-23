package com.appsalothelpgmail.workout.data;

import com.appsalothelpgmail.workout.model.Exercise;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercise")
    List<Exercise> loadAllExercises();

    @Insert
    Exercise addExercise();

    @Update
    Exercise updateExercise(int id, Exercise exercise);

    @Delete
    Exercise deleteExercise(int id);




}
