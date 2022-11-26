package mostafagad.projects.tdd.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeesDao {
    @Insert
    suspend fun addEmployee(emp:Employee)

    @Query("SELECT * FROM employees ORDER BY id DESC LIMIT 10")
    suspend fun getLast10Emp():List<Employee>
}