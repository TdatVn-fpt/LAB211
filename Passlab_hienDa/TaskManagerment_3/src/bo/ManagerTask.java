package bo;

import entity.Task;
import entity.TaskType;

import java.util.ArrayList;
import java.util.Date;

public class ManagerTask {
    
    //đây là nơi để lưu toàn bộ task mỗi phần tử trong list là 1 đối tượng task
    private ArrayList<Task> list;

    public ManagerTask() {  // khởi tạo contrutor sinh ra cái này để tạo ra list là 1 mảng động rỗng
        list = new ArrayList<>();
    }

    public ArrayList<Task> getList() {   // trả về danh sách task hiện tại
        return list;
    }

    public void setList(ArrayList<Task> list) throws Exception {
        if (list == null) throw new Exception("List of tasks cannot be null.");
        this.list = list;
    }

    public boolean isTaskConflict(String assign, double planFrom, double planTo,Date date) {
        for (Task task : list) {
            if (task.getAssign().equalsIgnoreCase(assign) && task.getDate().compareTo(date) == 0) {
                if ((planFrom < task.getPlanTo()) && (planTo > task.getPlanFrom())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int add(Task task) throws Exception {

    // Kiểm tra xung đột thời gian
    if (isTaskConflict(task.getAssign(), task.getPlanFrom(), task.getPlanTo(), task.getDate())) {
        throw new Exception("The assignee already has a task in this time range!");
    }

    // Kiểm tra thứ tự task
    TaskType taskType = TaskType.getTaskTypeByID(task.getTaskTypeID());
    if (!isCorrectTaskOrder(task.getAssign(), taskType, task.getRequirmentName(),
            task.getPlanFrom(), task.getPlanTo())) {
        throw new Exception("Tasks must follow the correct order: Code → Test → Design → Review.");
    }
    task.assignID();
    if (list.add(task)) {
        return task.getId(); // trả về ID đã tạo
    }
    throw new Exception("Cannot add!");
}

    public boolean isCorrectTaskOrder(String assign, TaskType taskType, String requirementName, double planFrom, double planTo) {
        for (Task task : list) {
            if (task.getAssign().equalsIgnoreCase(assign) && task.getRequirmentName().equalsIgnoreCase(requirementName)) {
                TaskType currentTaskType = TaskType.getTaskTypeByID(task.getTaskTypeID());
                TaskType newTaskType = taskType;
                
                if (newTaskType.ordinal() - currentTaskType.ordinal() > 1) {
                    return false;
                }

                if (currentTaskType.ordinal() > newTaskType.ordinal()) return false;

                if (currentTaskType == TaskType.CODE && newTaskType == TaskType.TEST) {
                    if (task.getPlanTo() > planFrom) return false;
                }

                if (currentTaskType == TaskType.TEST && newTaskType == TaskType.DESIGN) {
                    if (task.getPlanTo() > planFrom) return false;
                }
                
                if (currentTaskType == TaskType.DESIGN && newTaskType == TaskType.REVIEW) {
                    if(task.getPlanTo() > planFrom) return false;
                }
            }
        }
        return true;
    }
// Tìm vị trí của task dựa theo danh sách
    private int getIndexByID(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;  // không tồn tại
    }

    public void deleteTaskByID(int id) throws Exception {  // gọi task vì nó sẽ trả về đối tượng vừa bị xóa
        int index = getIndexByID(id);
        if (index == -1) throw new Exception("Task ID does not exist!");
        list.remove(index);  // trả về phần tử vừa bị xóa
    }

    @Override
    public String toString() {
        if (list.isEmpty()) return null;
        String str = String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : list) str += task.toString();
        return str;
    }
}