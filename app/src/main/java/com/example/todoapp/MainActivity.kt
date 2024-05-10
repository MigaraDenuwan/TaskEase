package com.example.todoapp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.AddNewTask.Companion.newInstance
import com.example.todoapp.Model.ToDoModel
import com.example.todoapp.Utils.DatabaseHandler
import com.example.todoapp.adapter.ToDoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Collections
import java.util.Objects

class MainActivity : AppCompatActivity(), DialogCloseListener {
    private var db: DatabaseHandler? = null

    private var tasksRecyclerView: RecyclerView? = null
    private var tasksAdapter: ToDoAdapter? = null
    private var fab: FloatingActionButton? = null

    private var taskList: List<ToDoModel?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Objects.requireNonNull(supportActionBar)?.hide()

        db = DatabaseHandler(this)
        db!!.openDatabase()

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView)
        tasksRecyclerView?.setLayoutManager(LinearLayoutManager(this))
        tasksAdapter = ToDoAdapter(db!!, this@MainActivity)
        tasksRecyclerView?.setAdapter(tasksAdapter)

        val itemTouchHelper = ItemTouchHelper(RecyclerItemTouchHelper(tasksAdapter!!))
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView)

        fab = findViewById(R.id.fab)

        taskList = db!!.allTasks
        Collections.reverse(taskList)

        (taskList as MutableList<ToDoModel>?)?.let { tasksAdapter!!.setTasks(it) }

        fab?.setOnClickListener(View.OnClickListener {
            newInstance().show(
                supportFragmentManager, AddNewTask.TAG
            )
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun handleDialogClose(dialog: DialogInterface?) {
        taskList = db!!.allTasks
        Collections.reverse(taskList)
        (taskList as MutableList<ToDoModel>?)?.let { tasksAdapter!!.setTasks(it) }
        tasksAdapter!!.notifyDataSetChanged()
    }
}