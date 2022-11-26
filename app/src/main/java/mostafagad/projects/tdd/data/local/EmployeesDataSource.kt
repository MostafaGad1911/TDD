package mostafagad.projects.tdd.data.local

class EmployeesDataSource(private val employeesDao: EmployeesDao) {
    suspend fun addEmployee(employee: Employee) = employeesDao.addEmployee(emp = employee)
    suspend fun getLast10Employees() = employeesDao.getLast10Emp()
}