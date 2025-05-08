package com.example.todo.addtasks.domain

import com.example.todo.addtasks.data.TaskRepository
import com.example.todo.addtasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val takeRepository: TaskRepository
) {
    suspend operator fun invoke(taskModel: TaskModel) {
        takeRepository.update(taskModel)
    }
}