package com.example.todoappodevim.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoappodevim.R
import com.example.todoappodevim.databinding.FragmentDetayBinding
import com.example.todoappodevim.viewmodel.DetayFragmentViewModel
import com.example.todoappodevim.viewmodel.DetayVMF

class DetayFragment : Fragment() {

    private lateinit var tasarim : FragmentDetayBinding
    private lateinit var viewModel: DetayFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container,false)

        tasarim.detayFragment = this

        tasarim.yapilacakDetayToolbarBaslik = "Yapılacak İş Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val gelenIs = bundle.yapilacak

        tasarim.yapilacakNesnesi = gelenIs

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayFragmentViewModel by viewModels(){
            DetayVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun btnGuncelleTikla(yapilacak_id:Int, yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)
    }

}