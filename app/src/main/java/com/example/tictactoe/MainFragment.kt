package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToGameboard.setOnClickListener {
            val nameBundle = Bundle()
            //nameBundle.putStringArrayList("player_names", arrayListOf(playerOneText.text.toString(), playerTwoText.text.toString()))
            nameBundle.putString("player1_name", player1_name.text.toString())
            nameBundle.putString("player2_name", player2_name.text.toString())

            it.findNavController().navigate(R.id.action_mainFragment_to_gameBoardFragment, nameBundle)
        }

    }

}
