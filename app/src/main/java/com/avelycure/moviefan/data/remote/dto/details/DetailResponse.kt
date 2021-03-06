package com.avelycure.moviefan.data.remote.dto.details

import com.avelycure.moviefan.data.remote.dto.movie.MoviesResponse
import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: MovieCollection?,
    val budget: Int,
    val genres: List<MovieGenre>,
    val homepage: String?,
    val id: Int,
    val imdb_id: String?,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Float,
    val poster_path: String?,
    val production_companies: List<ProductionCompanies>,
    val production_countries: List<ProductionCountries>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int?,
    val spoken_languages: List<SpokenLanguages>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int,
    val credits: Credit,
    val images: MovieImages,
    val similar: MoviesResponse
)
