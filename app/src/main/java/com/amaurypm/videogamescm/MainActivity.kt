package com.amaurypm.videogamescm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amaurypm.videogamescm.ui.fragments.GamesListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            GamesListFragment()
        ).commit()

        /*val btnLoad = findViewById<Button>(R.id.btnLoad)

        btnLoad.setOnClickListener {

            //Generamos una instancia del api que consume los endpoints
            val gamesApi = RetrofitHelper.getRetrofit().create(GamesApi::class.java)

            lifecycleScope.launch(Dispatchers.IO) {

                try{
                    val games: List<GameDto> = gamesApi.getGames("cm/games/games_list.php")

                    Log.d(Constants.LOGTAG, games.toString())
                }catch (e: Exception){
                    //Manejamos la excepción
                }

                /*
                withContext(Dispatchers.Main){
                    btnLoad.text = "dfdfdfdf"
                }*/

            }


        }*/
    }
}