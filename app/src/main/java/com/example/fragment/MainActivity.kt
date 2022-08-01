package com.example.fragment

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var tvWelcomeToFragment: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlert.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("ALERT")
            alertDialog.setMessage("Choose Fragment Colour")
            alertDialog.setPositiveButton("RED") { p, q ->
                replaceFragment(FirstFragment())
            }
            alertDialog.setNegativeButton("YELLOW") { p, q ->
                replaceFragment(SecondFragment())
            }
            alertDialog.setNeutralButton("Green") { p, q ->
                replaceFragment(ThirdFragment())
            }
            alertDialog.show()


        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentview,fragment)
        fragmentTransaction.commit()



    }
}