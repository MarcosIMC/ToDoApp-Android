package com.example.todo.addtasks.data

import com.example.todo.addtasks.ui.model.TaskModel
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> =
        taskDao.getTasks().map { items -> items.map { TaskModel(it.id, it.task, it.selected) } }

    suspend fun add(taskModel: TaskModel) {
        taskDao.addTask(TaskEntity(taskModel.id, taskModel.task, taskModel.selected))
    }
}