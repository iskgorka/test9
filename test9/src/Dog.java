public class Dog {
    String name;
    int age;
    Breed breed;

    Dog(String name, int age, Breed breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog: name ='" + name + "', breed = " + breed;
    }
}

