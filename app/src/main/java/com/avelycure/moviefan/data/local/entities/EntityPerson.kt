package com.avelycure.moviefan.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.avelycure.moviefan.data.local.type_converters.ConverterListString

@Entity(tableName = "persons")
data class EntityPerson(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val adult: Boolean,
    val gender: Int,
    val personId: Int,
    val knownForDepartment: String,
    val name: String,
    val popularity: Float,
    val profilePath: String?,
    @TypeConverters(ConverterListString::class)
    val knownForMovie: List<String>,
    @TypeConverters(ConverterListString::class)
    val knownForTv: List<String>
)