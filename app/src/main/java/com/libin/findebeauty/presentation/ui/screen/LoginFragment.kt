package com.libin.findebeauty.presentation.ui.screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.libin.findebeauty.R
import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.databinding.FragmentLoginBinding
import com.libin.findebeauty.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private companion object {
        private const val DUMMY_TOKEN = "" //PASTE YOUR TOKEN HERE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveTokenButton.setOnClickListener {
            if (DUMMY_TOKEN.isNotEmpty()) {
                viewModel.saveToken(DUMMY_TOKEN)

            } else {
                Toast.makeText(context, "Please enter a token", Toast.LENGTH_SHORT).show()
            }
        }
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.onSaveToken.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.saveTokenButton.isEnabled = false
                }

                is Resource.Success -> {
                    binding.saveTokenButton.isEnabled = true
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.loginFragment, true)
                        .build()
                    findNavController().navigate(
                        R.id.action_loginFragment_to_HomeFragment,
                        null,
                        navOptions
                    )
                }

                is Resource.Error -> {
                    binding.saveTokenButton.isEnabled = true
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
