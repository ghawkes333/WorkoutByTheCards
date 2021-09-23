package com.appsalothelpgmail.workout.utils;

import androidx.room.TypeConverter;

public class ExerciseIDsTypeConverter {
    public final static String SPLICER = "~";

    @TypeConverter
    public static int[] toExerciseIDs(String idsString){
        String[] idsStrArr = idsString.split(SPLICER);

        //Convert to int array
        int[] idsArr = new int[idsStrArr.length];
        for(int i = 0; i < idsStrArr.length; i++){
            String idStr = idsStrArr[i];
            int id = Integer.parseInt(idStr);
            idsArr[i] = id;
        }

        return idsArr;
    }

    @TypeConverter
    public static String fromExerciseIDs(int[] ids){
        StringBuilder builder = new StringBuilder();
        for(int id : ids){
            builder.append(id).append(SPLICER);
        }
        return builder.toString();
    }

    @TypeConverter
    public static String fromEquipmentStringArray(String[] exerciseEquipment){
        StringBuilder builder = new StringBuilder();
        for(String equipName: exerciseEquipment){
            builder.append(equipName).append(SPLICER);
        }

        return builder.toString();
    }

    @TypeConverter
    public static String[] toEquipmentStringArray(String equipStr){
        return equipStr.split(SPLICER);
    }
}
