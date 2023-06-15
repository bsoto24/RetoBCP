package pe.com.test.ui.feature.home.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import pe.com.test.R
import pe.com.test.databinding.FragmentMovieListBinding

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
                R.id.goToMovieDetail, bundleOf(
                    "title" to it.title,
                    "posterPath" to it.posterPath,
                    "overview" to it.overview
                )
            )
        }

        movieUpcomingAdapter = MovieUpcomingAdapter {
            findNavController().navigate(
                R.id.goToMovieDetail, bundleOf(
                    "title" to it.title,
                    "posterPath" to it.posterPath,
                    "overview" to it.overview
                )
            )
        }

        binding.apply {
            moviePopularRecyclerView.layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            moviePopularRecyclerView.adapter = moviePopularAdapter

            movieUpcomingRecyclerView.layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            movieUpcomingRecyclerView.adapter = movieUpcomingAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}