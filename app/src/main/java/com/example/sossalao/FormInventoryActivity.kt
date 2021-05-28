package com.example.sossalao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form_inventory.*
import kotlinx.android.synthetic.main.toolbar.*
import org.json.JSONObject

class FormInventoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_inventory)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Cadastrar Produto"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        form_product_send.setOnClickListener {
            val product = Inventory()
            product.name = form_product_name.text.toString()
            product.make = form_product_make.text.toString()
            product.description = form_product_description.text.toString()

            taskSave(product)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true;
    }

    private fun taskSave(product: Inventory) {
        Thread {
            InventoryService.save(product)
            notificate(product)
            runOnUiThread {

                finish()
            }
        }.start()
    }

    fun notificate(product: Inventory){
/*        val url = "https://fcm.googleapis.com/fcm/send"
        val token = Prefs.getString("FB_TOKEN")
        val key = "AAAAeJXv0bU:APA91bHMVTPBRC-paw4S5yRsmAuU6E8wiBOl9XzgZh2Wwq2mPGwQ4Yl0BvDgGufDgePxEmDrzHg94SMsEZmu17pthUjsyvnWaDdnrxyOOclRlwoz0yImo-RsD5jvhznzu_kZfScU306X"
        var data = JSONObject("{'notification': {'body': '${product.name.toString()}','title': 'Produto Criado'}}")
        HttpHelper.post(url, data.toString(), key, "FB")*/
        NotificationUtil.create(1, intent, "Produto Criado", "${product.name.toString()}")

    }
}