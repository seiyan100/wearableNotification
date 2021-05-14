package com.example.wearablenotification.setup

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.wearablenotification.R
import kotlinx.android.synthetic.main.fragment_first_navigation.view.*


class FirstNavigationFragment : Fragment() {

    private lateinit var audioManager: AudioManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        audioManager = activity?.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        var ringerMode = audioManager.ringerMode
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_navigation, container, false)

        view.next_button_first_fragment.setOnClickListener {
            when(ringerMode) {
                AudioManager.RINGER_MODE_VIBRATE -> {
                    // manner
                    Toast.makeText(activity,
                            "マナーモードを解除してください．",
                            Toast.LENGTH_SHORT).show()

                }
                AudioManager.RINGER_MODE_SILENT -> {
                    // silent
                    Toast.makeText(activity,
                            "サイレントモードを解除してください．",
                            Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // normal
                    findNavController().navigate(R.id.action_firstNavigationFragment_to_secondNavigationFragment)
                }
            }
        }

        return view
    }

}