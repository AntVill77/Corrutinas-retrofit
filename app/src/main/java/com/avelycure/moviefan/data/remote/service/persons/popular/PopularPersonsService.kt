package com.avelycure.moviefan.data.remote.service.persons.popular

import com.avelycure.moviefan.common.RequestConstants
import com.avelycure.moviefan.data.remote.dto.search_person.ResponseSearchPerson
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*

class PopularPersonsService(
    private val client: HttpClient
) : IPopularPersonsService {
    override suspend fun getPopularPerson(page: Int): ResponseSearchPerson {
        return try {
            client.get {
                with(RequestConstants) {
                    url("$BASE_URL/person/popular?api_key=$API_KEY&append_to_response=$PERSON_IMAGES&page=${page}")
                }
            }
        } catch (e: RedirectResponseException) {
            throw Exception("Further action needs to be taken in order to complete the request")
        } catch (e: ClientRequestException) {
            throw Exception("The request contains bad syntax or cannot be fulfilled")
        } catch (e: ServerResponseException) {
            throw Exception("The server failed to fulfil an apparently valid request")
        } catch (e: IOException) {
            throw IOException("No internet connection")
        } catch (e: Exception) {
            throw Exception(" Unknown error occurred")
        }
    }
}