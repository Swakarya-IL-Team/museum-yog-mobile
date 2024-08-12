package com.swakarya.museumyog.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.swakarya.museumyog.data.local.entity.Museum
import com.swakarya.museumyog.data.local.room.EventInfoConverter
import com.swakarya.museumyog.data.local.room.FasilitasInfoConverter
import com.swakarya.museumyog.data.local.room.KoleksiItemConverter
import com.swakarya.museumyog.data.local.room.ListImageMuseumConverter
import com.swakarya.museumyog.data.local.room.MuseumDao
import com.swakarya.museumyog.data.local.room.ReviewConverter
import com.swakarya.museumyog.data.local.room.TransportInfoConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Museum::class], version = 1)
@TypeConverters(
    TransportInfoConverter::class,
    FasilitasInfoConverter::class,
    EventInfoConverter::class,
    ListImageMuseumConverter::class,
    KoleksiItemConverter::class,
    ReviewConverter::class
)
abstract class MuseumDatabase : RoomDatabase() {
    abstract fun museumDao(): MuseumDao

    private class MuseumDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.museumDao())
                }
            }
        }

        suspend fun populateDatabase(museumDao: MuseumDao) {
            // Add sample museums.
            museumDao.insertMuseums(MuseumData.initialMuseums)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: MuseumDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): MuseumDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MuseumDatabase::class.java,
                    "museum_database"
                )
                    .addCallback(MuseumDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}