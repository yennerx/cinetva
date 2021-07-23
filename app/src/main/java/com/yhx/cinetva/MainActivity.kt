package com.yhx.cinetva

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.yhx.cinetva.activities.CarteleraActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        title = "Menú"
        btIraCartelera.setOnClickListener{
            startActivity(Intent(this, CarteleraActivity::class.java))
        }
        */

         val toolbar: Toolbar = findViewById(R.id.toolbar_main)//revisar
         setSupportActionBar(toolbar)

         drawer = findViewById(R.id.drawer_layout)

         toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
         drawer.addDrawerListener(toggle)

         supportActionBar?.setDisplayHomeAsUpEnabled(true)
         supportActionBar?.setHomeButtonEnabled(true)

         val navigationView: NavigationView = findViewById(R.id.nav_view)
         navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one -> startActivity(Intent(this, CarteleraActivity::class.java))
            R.id.nav_item_two -> Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_item_three -> Toast.makeText(this,"Item 3", Toast.LENGTH_SHORT).show()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}