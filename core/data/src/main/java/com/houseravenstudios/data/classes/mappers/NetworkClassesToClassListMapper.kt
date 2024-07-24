package com.houseravenstudios.data.classes.mappers

import com.houseravenstudios.data.classes.model.ClassList
import com.houseravenstudios.data.classes.model.ClassListItem
import com.houseravenstudios.network.models.ClassResultsItem
import javax.inject.Inject
import com.houseravenstudios.network.models.ClassList as NetworkClassList

class NetworkClassesToClassListMapper @Inject constructor() {
    fun map(input: NetworkClassList): ClassList {
        return ClassList(
            count = input.count,
            results = mapClassResults(input.results)
        )
    }

    private fun mapClassResults(classList: List<ClassResultsItem>): List<ClassListItem> {
        return buildList {
            classList.forEach { classItem ->
                add(ClassListItem(
                    index = classItem.index,
                    name = classItem.name,
                    url = classItem.url
                ))
            }
        }
    }
}