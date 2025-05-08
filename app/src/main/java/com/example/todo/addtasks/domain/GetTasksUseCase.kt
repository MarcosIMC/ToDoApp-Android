package com.example.todo.addtasks.domain

import com.example.todo.addtasks.data.TaskRepository
import com.example.todo.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(): Flow<List<TaskModel>> {
        return taskRepository.tasks
    }
}