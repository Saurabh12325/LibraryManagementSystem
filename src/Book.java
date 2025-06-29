public class Book {
    private int id;
    private String name;
    private boolean isIssued;
    public Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;

    }
    public int getId() {
     return id;

    }

    public String getName() {
        return name;
    }

    public boolean isIssued() {
        return isIssued;
    }

}
