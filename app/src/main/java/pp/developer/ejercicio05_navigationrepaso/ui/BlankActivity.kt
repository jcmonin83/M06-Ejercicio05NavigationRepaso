package pp.developer.ejercicio05_navigationrepaso.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import pp.developer.ejercicio05_navigationrepaso.R
import pp.developer.ejercicio05_navigationrepaso.databinding.FragmentBlankBinding
import pp.developer.ejercicio05_navigationrepaso.databinding.FragmentHomeBinding
import pp.developer.ejercicio05_navigationrepaso.ui.home.HomeViewModel

class BlankActivity: Fragment() {
    private var _binding: FragmentBlankBinding? = null

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

        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val btnBlankHome = root.findViewById<Button>(R.id.btn_Blank_Home)
        btnBlankHome.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_blankActivity_to_nav_home)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}