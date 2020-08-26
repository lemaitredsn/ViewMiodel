package ru.lemaitre.mythirdrecycleview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



sealed class Celebrity:Parcelable{

    @Parcelize
    data class Actor(
        val id:Long,
        val name:String,
        val avatarLink:String = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTo3hyVaxN_dxCQsAASKtL-kUuIKAi6bJTvtA&usqp=CAU",
        val career:String = "Актер",
        val salary:Int,
        val icon: Int = R.drawable.ic_actor
    ):Celebrity()
    @Parcelize
    data class Sportsman(
        val id:Long,
        val name:String,
        val avatarLink:String = "https://vk.com/images/gifts/256/494.jpg",
        val career:String = "спортсмен",
        val salary:Int,
        val icon: Int = R.drawable.ic_rowling
    ):Celebrity()

}