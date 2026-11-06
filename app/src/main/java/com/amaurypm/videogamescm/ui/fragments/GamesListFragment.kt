package com.amaurypm.videogamescm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.amaurypm.videogamescm.R
import com.amaurypm.videogamescm.data.remote.GamesApi
import com.amaurypm.videogamescm.data.remote.RetrofitHelper
import com.amaurypm.videogamescm.databinding.FragmentGamesListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.MalformedURLException


class GamesListFragment : Fragment() {

    private var _binding: FragmentGamesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGamesListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            try {

                val games = RetrofitHelper.getRetrofit().create(GamesApi::class.java)
                    .getGames("cm/games/games_list.php")

            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        requireContext(),
                        "No hay conexión disponible",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            finally {
                binding.pbLoading.visibility = View.INVISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}