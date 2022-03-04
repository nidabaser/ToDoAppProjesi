package com.example.todoappodevim.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoappodevim.repo.YapilacaklarRepository

class KayitFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val yrepo = YapilacaklarRepository(application)

    fun kayit(yapilacak_is:String){
        yrepo.yapilacakKayit(yapilacak_is)
    }

}