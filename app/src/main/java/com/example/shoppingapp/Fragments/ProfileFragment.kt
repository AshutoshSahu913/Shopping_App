package com.example.shoppingapp.Fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.shoppingapp.LoginActivity

import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.logoutBtn.setOnClickListener {
            // Create a dialog
            val dialog = Dialog(requireContext())
            // Set the content view of the dialog
            dialog.setContentView(R.layout.logout_dailog)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            var btn = dialog.findViewById<AppCompatButton>(R.id.doneLogoutBtn)
            var cancelBtn = dialog.findViewById<AppCompatButton>(R.id.cancelBtn)
            btn.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), LoginActivity::class.java))
                Toast.makeText(requireContext(), "Login Successfully!", Toast.LENGTH_SHORT)
                    .show()
            }
            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }
            // Show the dialog
            dialog.show()

        }



        return binding.root
    }


}