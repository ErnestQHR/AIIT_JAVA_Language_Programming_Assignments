public class Administrator extends Person {
    private int adminLevel; // 1: junior, 2: senior, 3: super admin

    public Administrator(int id, String name, String contact, int adminLevel) {
        super(id, name, contact);
        this.adminLevel = adminLevel;
    }

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    public void addUser(Library library, User user) {
        library.addUser(user);
        System.out.println("Admin " + getName() + " added user: " + user.getName());
    }

    public void removeUser(Library library, User user) {
        library.removeUser(user);
        System.out.println("Admin " + getName() + " removed user: " + user.getName());
    }

    @Override
    public void displayInfo() {
        System.out.println("Administrator: " + super.toString());
        System.out.println("Admin Level: " + adminLevel);
    }
}