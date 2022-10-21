package com.example.pert6.entity

import com.google.gson.annotations.SerializedName

data class Student (

     @SerializedName("id")val id: String,
     @SerializedName("firstname")val firstname:String,
     @SerializedName("lastname")val lastname: String,
     @SerializedName("department")val department: String,
     @SerializedName("email")val email: String){

}