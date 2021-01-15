package com.example.softuser.model

import java.io.Serializable

data class LoginValidation (
        var username : String? = null,
        var password : String? = null
): Serializable{

}

