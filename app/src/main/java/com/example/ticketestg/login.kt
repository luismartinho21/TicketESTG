package com.example.ticketestg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ticketestg.User.Menuuser

class login : AppCompatActivity() {
    private lateinit var loginbtn:Button
    private lateinit var voltarregisto:Button
    private lateinit var edituser:EditText
    private lateinit var editpword:EditText
    private lateinit var dbh: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbtn = findViewById(R.id.button5)
        voltarregisto = findViewById(R.id.button6)
        edituser = findViewById(R.id.editTextTextPersonName2)
        editpword = findViewById(R.id.editTextTextPassword3)
        dbh = DBHelper(this)

        loginbtn.setOnClickListener{

            val useredit = edituser.text.toString()
            val passedit = editpword.text.toString()

            if (TextUtils.isEmpty(useredit)|| TextUtils.isEmpty(passedit)){
                Toast.makeText(this, "Adicione Nome de utilizador e password!", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(useredit,passedit)
                if (checkuser==true){
                    Toast.makeText(this, "Login com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Menuuser::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this,"Utilizador ou Passsword Errados!",Toast.LENGTH_SHORT).show()
                }
            }
        }
        voltarregisto.setOnClickListener{
            val intent = Intent(applicationContext,registo::class.java)
            startActivity(intent)
            finish()
        }

    }
}