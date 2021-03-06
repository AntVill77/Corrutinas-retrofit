package com.avelycure.moviefan.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.avelycure.moviefan.data.local.entities.EntityMovieInfo

@Dao
interface CacheMovieInfoDao {
    @Insert
    suspend fun insertMovie(movieInfo: EntityMovieInfo)

    @Query("SELECT * FROM movies_info WHERE movieId = :movieId")
    suspend fun getMovieInfo(movieId: Int):EntityMovieInfo
}