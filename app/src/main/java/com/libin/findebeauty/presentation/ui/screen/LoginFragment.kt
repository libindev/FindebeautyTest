package com.libin.findebeauty.presentation.ui.screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
            val token =
                "5zvql-wdk3APxb5uuWOZJcxHDEjnwzc78ex288SFAMm1Pg-CFm9w9kTAx3m6ZCv02lLm7RkgMidXL-mT8q9xsE_wLP1RbDz4hOt8DSMCC187MaJIzH-KO02EFoqhcZ_hcMY273X7HC1CBcFNCVencasSyNT9SY38C3o4vm4XIgN0ceAMQAG9YbnT0xiep_IhKQyXBZeQNlXX7xy8CVQXTPZgxYEMEBhu7QQd-k95yzTBtCsg5Ax7OvZ9kQiKIrJ69Ll7CPuewEm8dMBZknGZeXHCrDoOKzB2Z8vkTF4Fq-PTRiNDo9rnQmeWjTvhBTEnCRAZkF0n6T44L7HyDoyysj4iD5V9lAgSy2PORviKn7W1KxPNlcm3sOK5vFa2UV5QIXmusPtXlMGnczHd8cbPg4skqgcMMk_Sja-as3OMLeZtbxwBVkaTGPh9RckXw-uK"
            if (token.isNotEmpty()) {
                viewModel.saveToken(token)

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
                    Toast.makeText(context, "Token saved!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_HomeFragment)
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
