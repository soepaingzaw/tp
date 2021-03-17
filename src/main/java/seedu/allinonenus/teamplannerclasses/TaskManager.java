package seedu.allinonenus.teamplannerclasses;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList;
    private int taskCount = 0;

    public TaskManager() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        taskCount++;
    }

    public void deleteTask(int taskNum) {
        if (taskNum < taskCount && taskCount >= 0) {
            System.out.println(taskList.get(taskNum) + " has been removed");
            taskList.remove(taskNum);
            taskCount--;
        } else {
            System.out.println("Index out of range");
        }
    }

    public int getTaskCount() {
        return taskCount;
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public void clearTask() {
        taskList.clear();
    }

}
