package com.example.todo.addtasks.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.addtasks.ui.model.TaskModel
import javax.inject.Inject

class TasksViewModel @Inject constructor(): ViewModel() {
    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _tasks = mutableStateListOf<TaskModel>()
    val tasks: List<TaskModel> = _tasks

    fun dialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        Log.i("Tareka: ", task)
        _showDialog.value = false
        _tasks.add(TaskModel(task = task))
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckboxSelected(taskModel: TaskModel) {
        taskModel.selected = !taskModel.selected
    }
}