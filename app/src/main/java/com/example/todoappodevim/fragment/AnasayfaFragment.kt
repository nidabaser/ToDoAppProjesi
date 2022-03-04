package com.example.todoappodevim.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoappodevim.R
import com.example.todoappodevim.adapter.YapilacaklarAdapter
import com.example.todoappodevim.databinding.FragmentAnasayfaBinding
import com.example.todoappodevim.entity.Yapilacaklar
import com.example.todoappodevim.viewmodel.AnasayfaFragmentViewModel
import com.example.todoappodevim.viewmodel.AnasayfaVMF

class AnasayfaFragment : Fragment() , SearchView.OnQueryTextListener{

    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa , container, false)

        tasarim.anasayfaFragment = this

        tasarim.anasayfaToolbarBaslik = "Yapılacaklar"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner,{
            val adapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            tasarim.yapilacaklarAdapter = adapter
        })

        return tasarim.root
    }

    fun fabTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.isKayitGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnasayfaFragmentViewModel by viewModels(){
            AnasayfaVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)


        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)


        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_ara -> {Log.e("Arama ikonu","Seçildi")
            return true
            }else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }
}