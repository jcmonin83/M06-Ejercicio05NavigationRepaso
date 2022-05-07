package pp.developer.ejercicio05_navigationrepaso.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import pp.developer.ejercicio05_navigationrepaso.NumeroRandom
import pp.developer.ejercicio05_navigationrepaso.R
import pp.developer.ejercicio05_navigationrepaso.databinding.FragmentHomeBinding
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val btnHomeGallery = root.findViewById<Button>(R.id.btn_Home_Gallery)
        val btnHomeSlide = root.findViewById<Button>(R.id.btn_Home_Slide)
        val btnWorkerMngr = root.findViewById<Button>(R.id.btn_Worker)
        btnHomeGallery.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_gallery)
        }
        btnHomeSlide.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_slideshow)
        }
        btnWorkerMngr.setOnClickListener {

//            for (i in 1..5) {
//                var seeker = NumeroRandom()
//                Log.d("Aleatorio","Numero: ${seeker.getAleatorio()}")
//                Thread.sleep(1000)
//            }
//
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_workerDemoActivity)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}