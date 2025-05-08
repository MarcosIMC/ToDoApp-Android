package com.example.todo.addtasks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.addtasks.domain.AddTaskUseCase
import com.example.todo.addtasks.domain.GetTasksUseCase
import com.example.todo.addtasks.ui.TasksUiState.Success
import com.example.todo.addtasks.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    getTasksUseCase: GetTasksUseCase
): ViewModel() {
    val uiState: StateFlow<TasksUiState> = getTasksUseCase().map( ::Success )
        .catch { TasksUiState.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TasksUiState.Loading)
    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

//    private val _tasks = mutableStateListOf<TaskModel>()
//    val tasks: List<TaskModel> = _tasks

    fun dialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false
        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckboxSelected(taskModel: TaskModel) {
        //Actualizar check
        /*val taskIndex = _tasks.indexOf(taskModel)
        _tasks[taskIndex] = _tasks[taskIndex].let {
            it.copy(selected = !it.selected)
        }*/
    }

    fun onItemRemove(taskModel: TaskModel) {
        //Borrar item
        /*val task = _tasks.find { it.id == taskModel.id }
        _tasks.remove(task)*/
    }
}