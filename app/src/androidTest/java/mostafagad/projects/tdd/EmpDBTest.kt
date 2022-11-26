package mostafagad.projects.tdd

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import mostafagad.projects.tdd.data.local.EmpDB
import mostafagad.projects.tdd.data.local.Employee
import mostafagad.projects.tdd.data.local.EmployeesDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class EmpDBTest: TestCase() {

    private lateinit var empDao: EmployeesDao
    private lateinit var db: EmpDB

    @Before // setUp function should be public , try change modifier and run tests to check
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, EmpDB::class.java
        ).build()
        empDao = db.getEmpDao()
    }

    @Test
    fun writeAndReadEmployees() = runBlocking {
        val emp = Employee(name = "Mostafa" , age = 28)
        empDao.addEmployee(emp = emp)
        val employees = empDao.getLast10Emp()
        for (emp in employees){
            print("$emp")
        }
        assertTrue(employees.contains(emp))
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

}