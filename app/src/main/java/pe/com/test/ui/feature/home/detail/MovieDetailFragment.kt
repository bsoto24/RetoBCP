package pe.com.test.ui.feature.home.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import pe.com.test.common.BASE_URL_IMAGE
import pe.com.test.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()

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
            textViewName.text = args.title
            textViewDescription.text = args.overview
            Glide.with(requireContext())
                .load("$BASE_URL_IMAGE${args.posterPath}")
                .into(binding.imageViewPoster)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}