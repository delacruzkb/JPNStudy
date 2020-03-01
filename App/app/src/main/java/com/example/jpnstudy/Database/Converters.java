package com.example.jpnstudy.Database;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static boolean fromInt(int value){
        return (value == 1);
    }

    @TypeConverter
    public static int booleanToInt(boolean value)
    {
        int rtnval =0;
        if(value)
        {
            rtnval = 1;
        }
        return rtnval;
    }
}
