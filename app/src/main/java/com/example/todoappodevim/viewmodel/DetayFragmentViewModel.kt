package com.example.todoappodevim.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoappodevim.repo.YapilacaklarRepository

class DetayFragmentViewModel(application: Application) : AndroidViewModel(application){

    val yrepo = YapilacaklarRepository(application)

    fun guncelle(yapilacak_id:Int, yapilacak_is:String){
        yrepo.yapilacakGuncelle(yapilacak_id,yapilacak_is)
    }
}