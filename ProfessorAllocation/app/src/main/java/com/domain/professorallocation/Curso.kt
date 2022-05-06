package com.domain.professorallocation

data class Curso(
    var id: String,
    var name: String,
    @Transient var allocations: Any
)

data class CursoPutDTO(
    var name: String
)
