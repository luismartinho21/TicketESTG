package com.example.ticketestg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registo : AppCompatActivity() {

    private lateinit var uname:EditText
    private lateinit var pword:EditText
    private lateinit var cpword:EditText
    private lateinit var registobtn:Button
    private lateinit var voltarlogin:Button
    private lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        uname = findViewById(R.id.editTextTextPersonName)
        pword = findViewById(R.id.editTextTextPassword)
        cpword = findViewById(R.id.editTextTextPassword2)
        registobtn = findViewById(R.id.button3)
        voltarlogin = findViewById(R.id.button4)
        db = DBHelper(this)

        registobtn.setOnClickListener {
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val savedata = db.insertdata(unametext, pwordtext)

            if(TextUtils.isEmpty(unametext)|| TextUtils.isEmpty(pwordtext)|| TextUtils.isEmpty(cpwordtext)){
                Toast.makeText(this, "Adicione o nome de utilizador, a password e confirme a mesma!", Toast.LENGTH_SHORT).show()
            }
            else{
                if (pwordtext.equals(cpwordtext)){
                    if (savedata==true){
                        Toast.makeText(this, "Registo concluido com sucesso!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext,login::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Utilizador existente!",Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Password não corresponde!", Toast.LENGTH_SHORT).show()
                }

            }
        }

        voltarlogin.setOnClickListener {
            val intent = Intent(applicationContext,login::class.java)
            startActivity(intent)
            finish()
        }
    }
}

