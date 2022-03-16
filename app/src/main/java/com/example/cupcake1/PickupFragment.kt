package com.example.cupcake1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake1.databinding.FragmentPickupBinding
import com.example.cupcake1.model.OrderViewModel


class PickupFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()

    private var binding: FragmentPickupBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            //nextButton.setOnClickListener { goToNextScreen() }
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            pickupFragment = this@PickupFragment

        }
    }

    fun goToNextScreen() {
       // Toast.makeText(activity, "Next", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
    }
    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_pickupFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}