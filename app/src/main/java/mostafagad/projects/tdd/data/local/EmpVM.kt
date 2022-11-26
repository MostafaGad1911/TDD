package mostafagad.projects.tdd.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EmpVM(private val employeesDataSource: EmployeesDataSource): ViewModel() {

    private val  _last10Employees = MutableLiveData<List<Employee>>()
    val last10Employees:LiveData<List<Employee>> get() = _last10Employees

    fun addEmployee(employee: Employee) = viewModelScope.launch {
        employeesDataSource.addEmployee(employee = employee)
    }

    fun getLast10Employees() = viewModelScope.launch {
        _last10Employees.value = employeesDataSource.getLast10Employees()
    }
}