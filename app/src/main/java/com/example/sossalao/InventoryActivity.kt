package com.example.sossalao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.lateral_menu_header.view.*
import kotlinx.android.synthetic.main.toolbar.*

class InventoryActivity : ScheduleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

    }

    private fun configuraMenuLateral() {
        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(this, drawerMenuLateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawerMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val header = lateral_menu.getHeaderView(0)
        header.appHeaderTittle.text = "Agenda"

        lateral_menu.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_schedule -> {
                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_people -> {
                Toast.makeText(this, "Clicou Mensagens", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_products -> {
                startActivity(Intent(this, InventoryActivity::class.java))
            }

            R.id.nav_products -> {
                Toast.makeText(this, "Clicou Localização", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_config -> {
                Toast.makeText(this, "Clicou Config", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Clicou Sair", Toast.LENGTH_SHORT).show()
            }
        }

        drawerMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item?.itemId

        when (id) {
            R.id.action_logout -> {
                finish()
            }
            R.id.action_refresh -> {
                Toast.makeText(context, "Botão de atualizar", Toast.LENGTH_LONG).show()
            }
            R.id.action_config -> {
                Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()
            }
            R.id.action_search -> {
                Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}