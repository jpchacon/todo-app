package com.chacon.todoapp.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Juanpa on 7/12/2017.
 */

public class TypeTransmogrifiers {
    @TypeConverter
    public static Long fromDate(Date date) {
        if (date==null) {
            return(null);
        }

        return(date.getTime());
    }

    @TypeConverter
    public static Date toDate(Long millisSinceEpoch) {
        if (millisSinceEpoch==null) {
            return(null);
        }

        return(new Date(millisSinceEpoch));
    }
}
