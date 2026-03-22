package controller;
import bo.ManagerTask;
import bo.TaskInputer;
import entity.Task;
import utils.Validator;

public class Controller {
    private ManagerTask managerTask;  // hàm này dùng để quản lý các danh sách của task chưa các hàm như thêm xóa hiển thị
    private TaskInputer inputer;  // nhập dữ liệu từ bàn phím tạo ra 1 cái task hoàn chỉnh 

    public Controller() {
        managerTask = new ManagerTask();
    }

    public ManagerTask getManagerTask() {
        return managerTask;
    }

    public void setManagerTask(ManagerTask managerTask) {
        this.managerTask = managerTask;
    }

    public int add(Task task) throws Exception {
             return managerTask.add(task);
    }
    
    public void delete(int id) throws Exception{
         managerTask.deleteTaskByID(id);
    }
    
    public void show() throws Exception{
        String str= managerTask.toString();
        if(str==null){
            throw new Exception("This list is empty!");
        }
        System.out.println(str);
    }
}
