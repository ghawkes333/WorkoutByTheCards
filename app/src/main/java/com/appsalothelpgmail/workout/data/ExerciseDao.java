package com.appsalothelpgmail.workout;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercise")
    List<Exercise> loadAllExercises();




}
