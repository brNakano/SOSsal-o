package com.example.sossalao.ui.schedule

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "schedule")
class Schedule : Serializable {

    @PrimaryKey
    var idScheduling:Long = 1
    var checkIn = ""
    var checkOut = ""
    var employeeId: Int? = 0
    var clientId: Int? = 0
    var procedureId = 1
    var status = 0


    fun toJsonPost(): String {
        val schedule = PostSchdule(
            checkIn = this.checkIn,
            checkOut = this.checkOut,
            employeeId = this.employeeId,
            clientId = this.clientId,
            procedureId = this.procedureId,
            status = this.status
        )
        return GsonBuilder().create().toJson(schedule)
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

    fun changeStatus(status: String){
        this.status = StatusSchedule.getScheduleNumber(status)
    }
}

data class PostSchdule(
    val checkIn: String,
    val checkOut: String,
    val employeeId: Int?,
    val clientId: Int?,
    val procedureId: Int,
    val status: Int
)