package com.houseravenstudios.domain.usecase

import com.houseravenstudios.common.result.ApiResult
import com.houseravenstudios.data.classes.model.ClassList
import com.houseravenstudios.data.classes.repo.ClassesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClassListUseCase @Inject constructor(
    private val classesRepo: ClassesRepo
) {
    fun fetchClasses(): Flow<ApiResult<ClassList>> = classesRepo.fetch()
}