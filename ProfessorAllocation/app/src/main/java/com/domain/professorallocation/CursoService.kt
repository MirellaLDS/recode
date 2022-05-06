package com.domain.professorallocation

import retrofit2.Call
import retrofit2.http.*

interface CursoService {

    @GET("courses")
    fun getAll(): Call<List<Curso>>

    @POST("courses")
    fun cadCurso(@Body curso: Curso): Call<Curso>

    @PUT("courses/{id}")
    fun alterCurso(@Path("id") cursoId: String, @Body curso: CursoPutDTO): Call<Curso>

    @DELETE("courses/{id}")
    fun deleteCurso(@Path("id") cursoId: Int)

}