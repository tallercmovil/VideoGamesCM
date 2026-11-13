package com.amaurypm.videogamescm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaurypm.videogamescm.R
import com.amaurypm.videogamescm.data.remote.GamesApi
import com.amaurypm.videogamescm.data.remote.RetrofitHelper
import com.amaurypm.videogamescm.databinding.FragmentGameDetailBinding
import com.amaurypm.videogamescm.ui.adapters.GamesAdapter
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ARG_GAMEID = "gameId"

class GameDetailFragment : Fragment() {

    private var _binding: FragmentGameDetailBinding? = null
    private val binding get() = _binding!!

    private var gameId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gameId = it.getString(ARG_GAMEID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameDetailBinding.inflate(
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

                gameId?.let { id ->
                    val game = RetrofitHelper.getRetrofit().create(GamesApi::class.java)
                        .getGameDetail(id)

                    withContext(Dispatchers.Main){

                        binding.apply {
                            tvTitle.text = game.title

                            tvLongDesc.text = game.longDesc

                            Glide.with(requireContext())
                                .load(game.image)
                                .into(ivImage)
                        }

                    }
                }



            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        requireContext(),
                        "No hay conexión disponible: ${e.message}",
                        Toast.LENGTH_LONG
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

    companion object {
        @JvmStatic
        fun newInstance(gameId: String) =
            GameDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_GAMEID, gameId)
                }
            }
    }
}