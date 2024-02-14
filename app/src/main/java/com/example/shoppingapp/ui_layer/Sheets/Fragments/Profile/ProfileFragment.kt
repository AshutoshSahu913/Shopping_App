package com.example.shoppingapp.ui_layer.Sheets.Fragments.Profile

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Login.LoginActivity

import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentProfileBinding
import com.github.dhaval2404.imagepicker.ImagePicker

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
                Toast.makeText(requireContext(), "Login Successfully!", Toast.LENGTH_SHORT).show()
            }
            cancelBtn.setOnClickListener {
                dialog.dismiss()
            }
            // Show the dialog
            dialog.show()

        }

        binding.apply {
            inputFirstName.isEnabled = false
            inputLastName.isEnabled = false
            inputEmail.isEnabled = false
            inputAddress.isEnabled = false
            inputPhoneNo.isEnabled = false

            var isEnable = true
            editProfile.setOnClickListener {
                isEnable = !isEnable
                Toast.makeText(requireContext(), "Now you are in Edit Mode!", Toast.LENGTH_SHORT)
                    .show()

                inputFirstName.isEnabled = isEnable
                inputLastName.isEnabled = isEnable
                inputEmail.isEnabled = isEnable
                inputAddress.isEnabled = isEnable
                inputPhoneNo.isEnabled = isEnable

                if (isEnable) {
                    inputFirstName.requestFocus()
                }

            }

            profileImg.setOnClickListener {
                ImagePicker.with(requireActivity())
//                .compress(1)
                    .crop()
                    .createIntent { intent ->
                        startForProfileImageResult.launch(intent)
                    }
            }


            return binding.root
        }
    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                binding.profileImg.setImageURI(fileUri)

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

}