package com.avelycure.moviefan.domain.interactors.home

import com.avelycure.moviefan.common.ErrorCodes
import com.avelycure.moviefan.data.remote.mappers.toVideoInfo
import com.avelycure.moviefan.data.repository.MovieRepository
import com.avelycure.moviefan.domain.models.VideoInfo
import com.avelycure.moviefan.domain.state.DataState
import com.avelycure.moviefan.domain.state.ProgressBarState
import com.avelycure.moviefan.domain.state.UIComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrailerCode(
    private val repository: MovieRepository
) {
    fun execute(id: Int): Flow<DataState<VideoInfo>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            val result = repository.getTrailerCode(id)
            if (result.results.isNotEmpty())
                emit(DataState.Data(result.results[0].toVideoInfo()))
            else
                emit(DataState.Response<VideoInfo>(
                    uiComponent = UIComponent.Dialog(
                        description = ErrorCodes.ERROR_NO_TRAILER_AVAILABLE
                    )
                ))
        } catch (e: Exception) {
            emit(
                DataState.Response<VideoInfo>(
                    uiComponent = UIComponent.Dialog(
                        description = e.message ?: "Unknown error occurred"
                    )
                )
            )
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }

}