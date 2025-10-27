package com.libin.findebeauty.presentation.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.libin.findebeauty.BuildConfig
import com.libin.findebeauty.R
import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.databinding.FragmentHomeBinding
import com.libin.findebeauty.domain.model.ActionButton
import com.libin.findebeauty.presentation.ui.adapter.ActionButtonsAdapter
import com.libin.findebeauty.presentation.ui.adapter.BannersAdapter
import com.libin.findebeauty.presentation.ui.adapter.NearbySalonsAdapter
import com.libin.findebeauty.presentation.ui.adapter.TopServicesAdapter
import com.libin.findebeauty.presentation.ui.adapter.TopTechsAdapter
import com.libin.findebeauty.presentation.ui.adapter.TrendingSalonsAdapter
import com.libin.findebeauty.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var bannersAdapter: BannersAdapter
    private lateinit var actionButtonsAdapter: ActionButtonsAdapter
    private lateinit var topServicesAdapter: TopServicesAdapter
    private lateinit var topTechsAdapter: TopTechsAdapter
    private lateinit var nearbySalonsAdapter: NearbySalonsAdapter
    private lateinit var trendingSalonsAdapter: TrendingSalonsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        observeViewModel()

        viewModel.fetchHomePageData(25.1815667, 55.2715100, lang = "en", cityId = -1, all = -1)
    }

    private fun setupRecyclerViews() {
        val imageBaseUrl = BuildConfig.IMAGE_BASE_URL
        // Banners
        bannersAdapter = BannersAdapter(imageBaseUrl)
        binding.bannersRecyclerView.apply {
            adapter = bannersAdapter
        }

        // Action Buttons
        val actionButtons = listOf(
            ActionButton(
                R.drawable.ic_deal_package,
                "Deals & Packages", "#FCE4EC".toColorInt()
            ),
            ActionButton(R.drawable.ic_refer_earn, "Refer & Earn", "#E3F2FD".toColorInt()),
            ActionButton(R.drawable.ic_my_favorite, "My Favorites", "#FFF8E1".toColorInt())
        )
        actionButtonsAdapter = ActionButtonsAdapter(actionButtons)
        binding.actionButtonsRecyclerView.apply {
            adapter = actionButtonsAdapter
        }

        // Top Services
        topServicesAdapter = TopServicesAdapter(imageBaseUrl)
        binding.topServicesRecyclerView.apply {
            adapter = topServicesAdapter
        }

        // Top Techs
        topTechsAdapter = TopTechsAdapter(imageBaseUrl)
        binding.topTechsRecyclerView.apply {
            adapter = topTechsAdapter
        }

        // Nearby Salons
        nearbySalonsAdapter = NearbySalonsAdapter(imageBaseUrl)
        binding.nearbySalonsRecyclerView.apply {
            adapter = nearbySalonsAdapter
        }

        // Trending Salons
        trendingSalonsAdapter = TrendingSalonsAdapter(imageBaseUrl)
        binding.trendingSalonsRecyclerView.apply {
            adapter = trendingSalonsAdapter

        }
    }

    private fun observeViewModel() {
        viewModel.homeData.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    // Show a loading indicator
                }

                is Resource.Success -> {
                    resource.data?.let {
                        bannersAdapter.submitList(listOf(it.homePageBanner))
                        topServicesAdapter.submitList(it.topServices)
                        topTechsAdapter.submitList(it.topTechs)
                        nearbySalonsAdapter.submitList(it.nearBySalons)
                        trendingSalonsAdapter.submitList(it.featuredSalons)
                    }
                }

                is Resource.Error -> {
                    Toast.makeText(context, resource.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
