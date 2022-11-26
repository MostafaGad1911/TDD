package mostafagad.projects.tdd.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee(
    val name: String ,
    val age:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = 0
}