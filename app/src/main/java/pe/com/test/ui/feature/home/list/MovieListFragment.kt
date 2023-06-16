package pe.com.test.ui.feature.home.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import pe.com.test.databinding.FragmentMovieListBinding

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieListViewModel by viewModels()

    private lateinit var movieUpcomingAdapter: MovieUpcomingAdapter
    private lateinit var moviePopularAdapter: MoviePopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
        viewModel.getPopularMovies()
        viewModel.getUpcomingMovies()
    }

    private fun setupObservers() {
        viewModel.popularMovies.observe(viewLifecycleOwner) { moviePopularAdapter.submitList(it) }

        viewModel.upcomingMovies.observe(viewLifecycleOwner) { movieUpcomingAdapter.submitList(it) }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Snackbar.make(binding.baseView, getString(error), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun setupAdapter() {
        moviePopularAdapter = MoviePopularAdapter {
            findNavController().navigate(
                MovieListFragmentDirections.goToMovieDetail(
                    it.title,
                    it.posterPath,
                    it.backdropPath,
                    it.overview
                )
            )
        }

        movieUpcomingAdapter = MovieUpcomingAdapter {
            findNavController().navigate(
                MovieListFragmentDirections.goToMovieDetail(
                    it.title,
                    it.posterPath,
                    it.backdropPath,
                    it.overview
                )
            )
        }

        binding.apply {
            rvMoviePopular.layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvMoviePopular.adapter = moviePopularAdapter

            rvMovieUpcoming.layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvMovieUpcoming.adapter = movieUpcomingAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}