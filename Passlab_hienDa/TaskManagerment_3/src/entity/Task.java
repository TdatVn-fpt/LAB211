package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private static int autoID = 0;  // ID tự động tăng

    private int id;
    private int taskTypeID;
    private String requirmentName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;



    // Constructor đầy đủ tham số
    public Task(int taskTypeID, String requirmentName, Date date, double planFrom,
                double planTo, String assign, String reviewer) {
        this.id = ++autoID;  // ID tự tăng
        this.taskTypeID = taskTypeID;
        this.requirmentName = requirmentName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) throws IllegalArgumentException {
        if(taskTypeID <= 0){
            throw new IllegalArgumentException("Task type ID must be positive number");
        }
        this.taskTypeID = taskTypeID;
    }

    public String getRequirmentName() {
        return requirmentName;
    }

    public void setRequirmentName(String requirmentName) throws IllegalArgumentException{
        if(requirmentName == null || requirmentName.trim().isEmpty()){
            throw new IllegalArgumentException("Requirement cannot be null");
        }
        this.requirmentName = requirmentName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws IllegalArgumentException{
        if(date == null){
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) throws IllegalArgumentException{
       if(planFrom < 0){
           throw new IllegalArgumentException("PlanFrom positive number");
       }
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) throws IllegalArgumentException{
        if(planTo < 0 ){
            throw new IllegalArgumentException("PlanTo must be positive");
        }
        if(planTo < planFrom){
            throw new IllegalArgumentException("PlanTo must be after PlanFrom");
        }
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) throws IllegalArgumentException {
         if (assign == null || assign.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignee cannot be null or empty.");
        }
         this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) throws IllegalArgumentException{
         if (reviewer == null || reviewer.trim().isEmpty()) {
            throw new IllegalArgumentException("Reviewer cannot be null or empty.");
        }
        this.reviewer = reviewer;
    }

    @Override
    public String toString(){
        SimpleDateFormat simpleDateFomat = new SimpleDateFormat("dd-MM-yyyy");
        int fromHour = (int) planFrom;    // ép planFrom sang int lấy phần tử nguyên làm giờ ví dụ 8.5 sang 8 và 13.0 sáng 13
        int fromMinute = (int) ((planFrom - fromHour) * 60);

        int toHour = (int) planTo;
        int toMinute = (int) ((planTo - toHour) * 60);

        String fromTime = String.format("%02d:%02d", fromHour, fromMinute);
        String toTime = String.format("%02d:%02d", toHour, toMinute);

        return String.format("%-5d%-15s%-15s%-15s%-15s%-15s%-15s\n",
                getId(), getRequirmentName(),
                TaskType.getTaskTypeByID(taskTypeID).getName(),
                simpleDateFomat.format(date), fromTime + " - " + toTime,
                getAssign(), getReviewer());
    }
    public void assignID() {
        this.id = ++autoID;
    }

    public Task() {
    }
    
}