package com.example.dreamhousevendor.Models;

public class TaskModel {
    String start, end,taskname, progress;
    public TaskModel(){

    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public TaskModel(String start,String taskname, String end,  String progress){
        this.start=start;
        this.end=end;
        this.progress=progress;
        this.taskname=taskname;

    }
}
