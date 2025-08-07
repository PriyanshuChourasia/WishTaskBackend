package com.wish.WishTaskManagement.TaskManagement.dtos.CommentDTO;

public class CommentRequestDTO {
    private String text;

    private String userId;

    private String taskId;

    public String getText(){
        return this.text;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getTaskId(){
        return this.taskId;
    }

    public void setTaskId(String taskId){
        this.taskId = taskId;
    }
}
