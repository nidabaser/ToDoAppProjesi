package com.example.todoappodevim.room

import androidx.room.*
import com.example.todoappodevim.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar() : List<Yapilacaklar>

    @Insert
    suspend fun yapilacakEkle(yapilacak:Yapilacaklar)

    @Update
    suspend fun yapilacakGuncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun yapilacakSil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%'|| :aramaKelimesi ||'%'")
    suspend fun yapilacakArama(aramaKelimesi:String) : List<Yapilacaklar>
}