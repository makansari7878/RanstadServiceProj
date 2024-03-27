package com.example.ranstadserviceproj

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MyDAOInterface {
   @Insert (onConflict = OnConflictStrategy.IGNORE)
   fun saveData(myEntity : MyEntity)
   @Query("select * from MyEntity")
   fun readData() : List<MyEntity>


}
