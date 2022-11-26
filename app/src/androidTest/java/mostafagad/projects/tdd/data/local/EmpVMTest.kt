package mostafagad.projects.tdd.data.local

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import mostafagad.projects.tdd.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class EmpVMTest : TestCase() {

    private lateinit var employeesVM: EmpVM

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(
            context, EmpDB::class.java
        ).allowMainThreadQueries().build()
        val dataSource = EmployeesDataSource(db.getEmpDao())
        employeesVM = EmpVM(employeesDataSource = dataSource)
    }

    @Test
    fun testEmployeesVM(){
        employeesVM.addEmployee(employee = Employee(name= "Mostafa Gad" , age = 25))
        employeesVM.getLast10Employees()
        val result = employeesVM.last10Employees.getOrAwaitValue()?.find { it.name == "Mostafa Gad" && it.age == 25 }
        assertTrue(result != null)
    }

}