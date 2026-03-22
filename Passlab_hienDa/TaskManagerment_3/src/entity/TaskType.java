package entity;
public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");
    private int id;
    private String name;
    
    private TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static TaskType getTaskTypeByID(int ID) {
        switch (ID) {
            case 1:
                return CODE;
            case 2:
                return TEST;
            case 3:
                return DESIGN;
            case 4:
                return REVIEW;
            default:
                throw new AssertionError();
        }
    }
     public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }  
}
