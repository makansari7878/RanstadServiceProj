package com.example.ranstadserviceproj

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyEntity() {


   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "id_column")
   var myid : Int = 0


   @ColumnInfo(name = "name_column")  // if u want to have seperate name for column else it wil tak var nam
   var myname : String = ""


   @ColumnInfo(name = "age_column")
   var age : Int = 0
}
