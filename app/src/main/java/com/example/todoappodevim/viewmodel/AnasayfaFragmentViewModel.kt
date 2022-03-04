package com.example.todoappodevim.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoappodevim.entity.Yapilacaklar
import com.example.todoappodevim.repo.YapilacaklarRepository

class AnasayfaFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()
    val yrepo = YapilacaklarRepository(application)

    init{
        yapilacaklariYukle()
        yapilacaklarListesi = yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        yrepo.yapilacakAra(aramaKelimesi)
    }

    fun sil(yapilacak_id:Int){
        yrepo.yapilacakSil(yapilacak_id)
    }

    fun yapilacaklariYukle(){
        yrepo.tumYapilacaklariGetir()
    }
}