package search.entity;

public class Person {

    private final String name;
    private final String lastName;
    private final String email;

    public Person(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (name != null) {
            sb.append(name);
        }
        if (lastName != null) {
            sb.append(" ").append(lastName);
        }
        if (email != null) {
            sb.append(" ").append(email);
        }

        return sb.toString();
    }
}
