package bo;

import entity.Task;
import utils.Validator;

public class TaskInputer {

    public Task input() {
        Task task = new Task();  // ID tự tăng

        task.setRequirmentName(Validator.getString("Requirement Name: ",
                "Invalid", "[A-Za-z0-9\\s]+")); // chỉ chấp nhận chữ số và khoảng trắng
        task.setTaskTypeID(Validator.getInt("1. Code\n2. Test\n3. Design\n4. Review\nEnter your choice: ",
                 "just be 1 -> 4", "invalid", 1, 4));
        task.setDate(Validator.getDate("Enter Date: ", "Invalid! format: dd-MM-yyyy", "dd-MM-yyyy"));

        while (true) {
            task.setPlanFrom(Validator.getDouble("From: ", "Just be 8 -> 17", "Invalid", 8, 17));
            String from = task.getPlanFrom() + ""; // ép sang chuỗi để lấy thập phân ví dụ 8.0 sang "8.0"
            if (from.split("\\.")[1].equals("0") || from.split("\\.")[1].equals("5")) break;  // tách chuỗi theo dấu . ví ụ "8.0" tách ra "0" "8" có nghĩa là cho nhập x.0 x.5
            else System.out.println("must be x.0 or x.5");
        }

        while (true) {  // mục đích của planTo sao phải lớn hơn planFrom ít nhất 0.5
            task.setPlanTo(Validator.getDouble("To: ", "Just be " + (task.getPlanFrom() + 0.5) + " -> 17.5",
                     "Invalid", (task.getPlanFrom() + 0.5), 17.5));
            String to = task.getPlanTo() + "";
            if (to.split("\\.")[1].equals("0") || to.split("\\.")[1].equals("5")) break;
            else System.out.println("must be x.0 or x.5");
        }

        task.setAssign(Validator.getString("Assignee: ", "invalid", "[A-Za-z0-9\\s]+"));
        task.setReviewer(Validator.getString("Reviewer: ", "invalid", "[A-Za-z0-9\\s]+"));

        return task;  // sau khi nhập hợp vệ toàn bộ dữ liệu trả về Task 
    }
}