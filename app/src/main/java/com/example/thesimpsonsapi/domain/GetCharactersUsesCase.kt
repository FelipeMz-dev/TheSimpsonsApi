package com.example.thesimpsonsapi.domain

import com.example.thesimpsonsapi.data.Character
import com.example.thesimpsonsapi.data.DataRepository
import javax.inject.Inject

class GetCharactersUsesCase @Inject constructor(
    private val repository: DataRepository
) {
    suspend operator fun invoke(limit: Int): List<Character> = repository.getCharacters(limit)
}