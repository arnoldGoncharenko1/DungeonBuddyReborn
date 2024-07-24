package com.houseravenstudios.data.classes.repo

import com.houseravenstudios.common.result.ApiResult
import com.houseravenstudios.data.classes.mappers.NetworkClassesToClassListMapper
import com.houseravenstudios.data.classes.model.ClassList
import com.houseravenstudios.network.service.ClassesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ClassesRepo @Inject constructor(
    private val classesApiService: ClassesApiService,
    private val mapper: NetworkClassesToClassListMapper
) {
    fun fetch(id: String): Flow<ApiResult<ClassList>> {
        return flow<ApiResult<ClassList>> {
            val result = classesApiService.getClasses()
            emit(ApiResult.Success(data = mapper.map(result)))
        }.catch {
            emit(ApiResult.Error(it))
        }
    }
}