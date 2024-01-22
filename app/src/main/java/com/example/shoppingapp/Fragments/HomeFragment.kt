package com.example.shoppingapp.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.AnimationTypes
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.shoppingapp.Adapter.CategoryAdapter
import com.example.shoppingapp.Adapter.ProductAdapter
import com.example.shoppingapp.AllProductActivity
import com.example.shoppingapp.Models.CategoryModel
import com.example.shoppingapp.Models.ProductModel
import com.example.shoppingapp.NotificationActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setUpCategoryRecyclerView()
        setUpProductRecyclerView()

        binding.notificationBtn.setOnClickListener {
            startActivity(Intent(requireContext(), NotificationActivity::class.java))
        }

        binding.seeMoreProduct.setOnClickListener {
//            startActivity(Intent(requireContext(), AllProductActivity::class.java))
            // Replace with the code to navigate to WishlistFragment
            val wishlistFragment = WishListFragment()
            val transaction: FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, wishlistFragment)
            transaction.addToBackStack(null)  // Optional: Add the transaction to the back stack
            transaction.commit()
        }

        binding.seeMoreCategory.setOnClickListener {
            Toast.makeText(context, "See all Category product", Toast.LENGTH_SHORT)
                .show()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //add imageSlider is here
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.sale1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sale4, ScaleTypes.FIT))


        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setUpCategoryRecyclerView() {
        val Categorylist = ArrayList<CategoryModel>()
        Categorylist.add(CategoryModel(R.drawable.trousers_bell_bottoms_svgrepo_com, "Trousers"))
        Categorylist.add(CategoryModel(R.drawable.jumpsuits, "Jumpsuits"))
        Categorylist.add(CategoryModel(R.drawable.tops, "Tops"))
        Categorylist.add(CategoryModel(R.drawable.wedding_dress_icon, "Dresses"))
        Categorylist.add(CategoryModel(R.drawable.trousers_bell_bottoms_svgrepo_com, "Trousers"))
        Categorylist.add(CategoryModel(R.drawable.jumpsuits, "Jumpsuits"))
        Categorylist.add(CategoryModel(R.drawable.tops, "Tops"))
        Categorylist.add(CategoryModel(R.drawable.wedding_dress_icon, "Dresses"))
        Categorylist.add(CategoryModel(R.drawable.trousers_bell_bottoms_svgrepo_com, "Trousers"))
        Categorylist.add(CategoryModel(R.drawable.jumpsuits, "Jumpsuits"))
        Categorylist.add(CategoryModel(R.drawable.tops, "Tops"))
        Categorylist.add(CategoryModel(R.drawable.wedding_dress_icon, "Dresses"))
        val adapter = CategoryAdapter(Categorylist, requireContext())
        binding.rvCategory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = adapter
    }


    private fun setUpProductRecyclerView() {

        val productModels = ArrayList<ProductModel>()
        productModels.add(
            ProductModel(
                "One Shoulder \n" + "Linen Dress",
                "5740",
                R.drawable.frock4,
                "GF1202",
                "7180",
                "10% off"
            )
        )

        productModels.add(
            ProductModel(
                "Puff Sleeve \n" + "Dress",
                "5270",
                R.drawable.frock2,
                "GF1047",
                "3000",
                "30% off"
            )
        )
        productModels.add(
            ProductModel(
                "Cross Stitch \n" +
                        "Top",
                "5740",
                R.drawable.blouse2,
                "GF1202",
                "7280",
                "25% off"
            )
        )
        productModels.add(
            ProductModel(
                "One S" +
                        "houlder \n" + "Linen Dress",
                "5740",
                R.drawable.frock4,
                "GF1202",
                "2580",
                "15% off"
            )
        )
        productModels.add(
            ProductModel(
                "One Shoulder \n" + "Linen Dress",
                "5740",
                R.drawable.frock4,
                "GF1202",
                "7180",
                "10% off"
            )
        )

        productModels.add(
            ProductModel(
                "Puff Sleeve \n" + "Dress",
                "5270",
                R.drawable.frock2,
                "GF1047",
                "3000",
                "30% off"
            )
        )
        productModels.add(
            ProductModel(
                "Cross Stitch \n" +
                        "Top",
                "5740",
                R.drawable.blouse2,
                "GF1223",
                "7280",
                "25% off"
            )
        )
        productModels.add(
            ProductModel(
                "One S" +
                        "houlder \n" + "Linen Dress",
                "5740",
                R.drawable.frock4,
                "GF1202",
                "2580",
                "15% off"
            )
        )


        val adapter = ProductAdapter(productModels, requireContext())
        binding.rvProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvProduct.adapter = adapter

    }


}