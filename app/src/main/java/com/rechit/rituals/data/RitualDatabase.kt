package com.rechit.rituals.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rechit.rituals.R
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.concurrent.Executors

@Database(entities = [Ritual::class], version = 1, exportSchema = false)
abstract class RitualDatabase: RoomDatabase() {

    abstract fun ritualDao(): RitualDao

    companion object {
        @Volatile
        private var INSTANCE: RitualDatabase ?= null
        fun getInstance(context: Context): RitualDatabase {
            // Use elvis operator : the expression on the right-hand :? side is evaluated only if the left-hand side is null
            // Make critical section work with synchronized
            // source
            // - critical section: https://en.wikipedia.org/wiki/Critical_section , keyword: a way
            // - lock : https://en.wikipedia.org/wiki/Lock_(computer_science) , keyword : mechanism
            //fallbackToDestructiveMigration -> Room jalanin migrasi database kalo versi database ga sesuai

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RitualDatabase::class.java,
                    "rituals.db",
                ).fallbackToDestructiveMigration().addCallback(object : Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        INSTANCE?.let { ritualDatabase ->
                            Executors.newSingleThreadExecutor().execute{
                                fillWithStartingData(context.applicationContext, ritualDatabase.ritualDao())
                            }
                        }
                        super.onCreate(db)
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }

        private fun fillWithStartingData(context: Context, dao: RitualDao) {
            val jsonArray = loadJsonArray(context)
            try {
                if(jsonArray != null) {
                    for(i in 0 until jsonArray.length()) {
                        val item = jsonArray.getJSONObject(i)
                        // complete DAO first
                        dao.insertAll(
                            Ritual(
                                item.getInt("id"),
                                item.getString("title"),
                                item.getString("minuteFocus"),
                                item.getString("startTime"),
                                item.getString("priorityLevel")
                            )
                        )

                    }
                }
            } catch (exception: JSONException){
                exception.printStackTrace()
            }
        }

        private fun loadJsonArray(context: Context): JSONArray? {
            var builder = StringBuilder()
            val `in` = context.resources.openRawResource(R.raw.ritual)
            val reader = BufferedReader(InputStreamReader(`in`))
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    builder.append(line)
                }
            } catch (exception: IOException) {
                exception.printStackTrace()
            } catch (exception: JSONException) {
                exception.printStackTrace()
            }
            return null
        }
    }

}