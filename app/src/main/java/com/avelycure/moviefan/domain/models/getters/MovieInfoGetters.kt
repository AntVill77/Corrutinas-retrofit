package com.avelycure.moviefan.domain.models.getters

import com.avelycure.moviefan.common.TemporaryConstants
import com.avelycure.moviefan.domain.models.MovieInfo

fun MovieInfo.getCompanies(): String {
    val companies = buildString {
        for (element in productionCompanies) {
            append(element.name + ", ")
        }
    }
    return if (companies.isNotBlank() && companies.isNotEmpty())
        return companies.substring(0, companies.length - 2)
    else
        ""
}

fun MovieInfo.getCountries(): String {
    val countries = buildString {
        for (element in productionCountries)
            append(element.name + ", ")
    }
    return if (countries.isNotBlank() && countries.isNotEmpty())
        countries.substring(0, countries.length - 2)
    else
        ""
}

fun MovieInfo.getGenres(): String {
    val genres = buildString {
        for (element in genres)
            append(TemporaryConstants.movieGenre[element.id] + ", ")
    }
    return if (genres.isNotBlank() && genres.isNotEmpty())
        return genres.substring(0, genres.length - 2)
    else
        ""
}

fun MovieInfo.getCast(): String {
    val cast = buildString {
        for (element in cast.take(5))
            append("$element, ")
    }
    return if (cast.isNotBlank() && cast.isNotEmpty())
        return cast.substring(0, cast.length - 2)
    else
        ""
}