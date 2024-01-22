package com.example.ticketestg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ticketestg.Admin.Menuadmin
import com.example.ticketestg.User.Menuuser

class login : AppCompatActivity() {
    private lateinit var loginbtn: Button
    private lateinit var voltarregisto: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: DBHelper
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbtn = findViewById(R.id.button5)
        voltarregisto = findViewById(R.id.button6)
        edituser = findViewById(R.id.editTextTextPersonName2)
        editpword = findViewById(R.id.editTextTextPassword3)
        dbh = DBHelper(this)
        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        loginbtn.setOnClickListener {
            val useredit = edituser.text.toString()
            val passedit = editpword.text.toString()

            if (TextUtils.isEmpty(useredit) || TextUtils.isEmpty(passedit)) {
                Toast.makeText(this, "Adicione Nome de utilizador e password!", Toast.LENGTH_SHORT).show()
            } else {
                val checkuser = dbh.checkuserpass(useredit, passedit)
                if (checkuser) {
                    // User Login
                    Toast.makeText(this, "Login com sucesso!", Toast.LENGTH_SHORT).show()

                    // Salva o nome de utilizador na SharedPreferences
                    sharedPreferences.edit().putString("usuario_logado", useredit).apply()

                    val intent = Intent(applicationContext, Menuuser::class.java)
                    startActivity(intent)
                    finish()
                } else if (useredit == "Admin" && passedit == "admin123") {
                    // Admin login
                    Toast.makeText(this, "Admin Login com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Menuadmin::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Utilizador ou Password Errados!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        voltarregisto.setOnClickListener{
            val intent = Intent(applicationContext, registo::class.java)
            startActivity(intent)
            finish()
        }
    }
}
