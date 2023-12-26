package com.example.android3_hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3_hw6.databinding.FragmentCatsBinding
import retrofit2.Call
import retrofit2.Response

class CatsFragment : Fragment() {
    private lateinit var binding: FragmentCatsBinding
    private lateinit var adapter: CatsImagesAdapter
    private lateinit var catsImagesList :List<CatImage>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatsBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun loadData() {
        val call = ApiClient.apiService.getImages(10)
        call.enqueue(object: retrofit2.Callback<List<CatImage>> {
            override fun onResponse(
                call: Call<List<CatImage>>,
                response: Response<List<CatImage>>
            ) {
                if (response.isSuccessful) {
                    catsImagesList = response.body()!!
                    binding.rvCatsList.layoutManager = LinearLayoutManager(context)
                    adapter = CatsImagesAdapter(catsImagesList)
                    binding.rvCatsList.adapter = adapter
                }

            }

            override fun onFailure(call: Call<List<CatImage>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }
}