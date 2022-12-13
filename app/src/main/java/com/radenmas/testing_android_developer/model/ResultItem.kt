package com.radenmas.testing_android_developer.model

import com.google.gson.annotations.SerializedName

 data class ResultItem(

	@field:SerializedName("icon_url")
	val iconUrl: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("categories")
	val categories: List<String>,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("value")
	val value: String,

	@field:SerializedName("url")
	val url: String
)