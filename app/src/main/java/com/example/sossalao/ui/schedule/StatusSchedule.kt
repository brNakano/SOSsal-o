package com.example.sossalao.ui.schedule

import com.example.sossalao.R

object StatusSchedule {

    fun getSchedulevalue(id: Int): String {
        var value = "0"
        if(id == 0){
            value = "Adiado"
        }
        if(id == 1){
            value = "Atendido"
        }
        if(id == 2){
            value = "Cancelado"
        }
        if(id == 3){
            value = "Marcado"
        }
        return value
    }

    fun getScheduleNumber(status: String): Int{
        var value = 0
        if(status == "Adiado"){
            value = 0
        }
        if(status == "Atendido"){
            value = 1
        }
        if(status == "Cancelado"){
            value = 2
        }
        if(status == "Marcado"){
            value = 3
        }
        return value
    }

    fun getStatusColor(status: String): Int {
        var value = 0
        if(status == "Adiado"){
            value = R.color.adiado
        }
        if(status == "Atendido"){
            value = R.color.atendido
        }
        if(status == "Cancelado"){
            value = R.color.cancelado
        }
        if(status == "Marcado"){
            value = R.color.marcado
        }
        return value
    }
}