package com.example.shoppingapp.ui_layer.Sheets.Fragments.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.AnimationTypes
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.shoppingapp.Comman.Products
import com.example.shoppingapp.ui_layer.Adapter.CategoryAdapter
import com.example.shoppingapp.ui_layer.Adapter.ProductSaleAdapter
import com.example.shoppingapp.ui_layer.Models.CategoryModel
import com.example.shoppingapp.ui_layer.Sheets.Activitys.Notification.NotificationActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentHomeBinding
import com.example.shoppingapp.ui_layer.Sheets.Fragments.WishList.WishListFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var homeViewModel: HomeFragmentViewModel
    lateinit var productList: ArrayList<Products>
    lateinit var adapter: ProductSaleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val _homeViewModel by viewModels<HomeFragmentViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return HomeFragmentViewModel(requireActivity()) as T
                    }
                }
            }
        )
        homeViewModel = _homeViewModel
        homeViewModel
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setUpCategoryRecyclerView()
        setUpProductRecyclerView()
        imageSlider()

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

        setUpProductRecyclerView()
    }


    fun imageSlider() {

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
        productList = arrayListOf()
        adapter = ProductSaleAdapter(productList, requireContext())

        binding.rvProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvProduct.adapter = adapter

        homeViewModel.getTop5Data {
            adapter.updateProductList(it)
        }
    }


}