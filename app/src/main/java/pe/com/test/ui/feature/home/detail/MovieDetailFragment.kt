package pe.com.test.ui.feature.home.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import pe.com.test.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            textViewName.text = arguments?.getString("title", "")
            textViewDescription.text = arguments?.getString("overview", "")
            Glide.with(requireContext())
                .load("https://image.tmdb.org/t/p/w185/${arguments?.getString("posterPath")}")
                .into(binding.imageViewPoster)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}