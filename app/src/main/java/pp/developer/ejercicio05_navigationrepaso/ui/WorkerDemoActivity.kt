package pp.developer.ejercicio05_navigationrepaso.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import pp.developer.ejercicio05_navigationrepaso.NumeroRandom
import pp.developer.ejercicio05_navigationrepaso.R
import pp.developer.ejercicio05_navigationrepaso.databinding.FragmentBlankBinding
import pp.developer.ejercicio05_navigationrepaso.databinding.FragmentWorkerBinding
import pp.developer.ejercicio05_navigationrepaso.ui.home.HomeViewModel
import java.util.concurrent.TimeUnit

class WorkerDemoActivity:Fragment() {
    private var _binding: FragmentWorkerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var wr:WorkRequest

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentWorkerBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val btnStart = root.findViewById<Button>(R.id.btn_Start)
        val btnStop = root.findViewById<Button>(R.id.btn_Stop)
        btnStart.setOnClickListener {
            wr = PeriodicWorkRequestBuilder<NumeroRandom>(15,TimeUnit.MINUTES).build()
            WorkManager.getInstance(requireActivity().baseContext).enqueue(wr)
            Log.d("Worker","Wroker iniciado: ID ${wr.id}")
        }
        btnStop.setOnClickListener {
            if(wr != null){
                WorkManager.getInstance(requireActivity().baseContext).cancelWorkById(wr.id)
                Log.d("Worker","Wroker detenido: ID ${wr.id}")
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}