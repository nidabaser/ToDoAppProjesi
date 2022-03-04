package com.example.todoappodevim.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoappodevim.R
import com.example.todoappodevim.databinding.FragmentKayitBinding
import com.example.todoappodevim.viewmodel.KayitFragmentViewModel
import com.example.todoappodevim.viewmodel.KayitVMF

class KayitFragment : Fragment() {

    private lateinit var tasarim:FragmentKayitBinding
    private lateinit var viewModel:KayitFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false)

        tasarim.kayitFragment = this

        tasarim.yapilacakKayitToolbarBaslik = "Yapılacak İş Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitFragmentViewModel by viewModels(){
            KayitVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun btnKaydetTikla(yapilacak_is:String){
        viewModel.kayit(yapilacak_is)
    }
}