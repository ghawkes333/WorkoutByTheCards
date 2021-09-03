package com.appsalothelpgmail.workout;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ProgramDao {
    @Query ("SELECT * FROM program")
    List<Program> loadAllPrograms();

    @Insert
    void addProgram(Program program);

    @Update (onConflict = OnConflictStrategy.IGNORE)
    void updateProgram(Program program);

    @Delete
    void deleteProgram(Program program);

}
