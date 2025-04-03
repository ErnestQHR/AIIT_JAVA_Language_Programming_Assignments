public abstract class Person {
    private int id;
    private String name;
    private String contact;

    public Person(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Contact: " + contact;
    }

    // 抽象方法，由子类实现
    public abstract void displayInfo();
}