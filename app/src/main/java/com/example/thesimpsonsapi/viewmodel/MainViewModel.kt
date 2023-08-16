package com.example.thesimpsonsapi.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesimpsonsapi.data.ApiClient
import com.example.thesimpsonsapi.data.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel : ViewModel() {
    val items: MutableStateFlow<List<Character>> = MutableStateFlow(listOf())

    fun fetchCharacters(context: Context) {
        viewModelScope.launch {
            try {
                val service = ApiClient().getService()
                val response = service?.
                getCharacters(650)
                if (response == null) {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                    return@launch
                }
                if (!response.isSuccessful) {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                    Log.e("Error", response.message())
                }
                val responseBody = response.body()?.string()
                loadLiveData(responseBody!!)
            }catch (t:Throwable){
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        }
    }

    private fun loadLiveData(responseString: String){
        val listCharacter: MutableList<Character> = mutableListOf()
        val jsonArray = JSONObject(responseString).getJSONArray("docs")
        jsonArray.iterator().forEachRemaining { jsonObject ->
            val name = jsonObject.getString("Nombre")
            val history = jsonObject.getString("Historia")
            val urlImage = jsonObject.getString("Imagen")
            listCharacter.add(Character(name, history, urlImage))
        }
        items.value = listCharacter
    }

    operator fun JSONArray.iterator(): Iterator<JSONObject>
            = (0 until length()).asSequence().map { get(it) as JSONObject }.iterator()

}