package mostafagad.projects.tdd.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Employee::class] , version = 1)
@TypeConverters(DateConverter::class)
abstract class EmpDB : RoomDatabase() {

    abstract fun getEmpDao():EmployeesDao

    companion object{
        private const val DB_NAME = "Employees-DataBase.db"
        @Volatile
        private var instance: EmpDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            EmpDB::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }

}