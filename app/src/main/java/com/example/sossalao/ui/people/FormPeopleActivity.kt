package com.example.sossalao.ui.people

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sossalao.R
import com.example.sossalao.repository.service.InventoryService
import com.example.sossalao.ui.Inventory
import kotlinx.android.synthetic.main.activity_form_inventory.*
import kotlinx.android.synthetic.main.activity_form_people.*
import kotlinx.android.synthetic.main.adapter_people.*
import kotlinx.android.synthetic.main.toolbar.*

class FormPeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_people)

        val args = intent.extras
        val title = args?.getString("view")

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Cadastrar $title"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        form_people_send.setOnClickListener {
            val people = People()
            people.name = form_people_name.editText?.text.toString()
            people.email = form_people_email.editText?.text.toString()
            people.phoneNumber = form_people_phone.editText?.text.toString()
            if (title == "Funcionário"){
                people.typePeople = 1
            }
            if (title == "Cliente"){
                people.typePeople = 0
            }

            taskSave(people)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true;
    }

    private fun taskSave(people: People) {
        Thread {
            PeopleService.save(people)
            runOnUiThread {
                finish()
            }
        }.start()
    }
}