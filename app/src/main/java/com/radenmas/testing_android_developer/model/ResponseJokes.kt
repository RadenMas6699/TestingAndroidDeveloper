package com.radenmas.testing_android_developer.model

import com.google.gson.annotations.SerializedName

data class ResponseJokes(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null,

	@field:SerializedName("total")
	val total: Int? = null
)