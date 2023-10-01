public class Dog {
    String name;
    int age;

    enum Breed {
        Labrador, BullDog, Husky, Beagle, Dalmatian
    }

    Dog(String name, int age, Breed breed) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("Tyzik", 5, Breed.BullDog);
        Dog dog2 = new Dog("Bobik", 7, Breed.Beagle);
        Dog dog3 = new Dog("Zhyk", 10, Breed.Dalmatian);
        if (dog1.name.equals(dog2.name)) {
            System.out.println("Одинаковые имена у 1 и 2 собаки.");
        } else if (dog1.name.equals(dog3.name)) {
            System.out.println("Одинаковые имена у 1 и 3 собаки.");
        } else if (dog2.name.equals(dog3.name)) {
            System.out.println("Одинаковые имена у 2 и 3 собаки.");
        }
        if (dog1.age > dog2.age && dog1.age > dog3.age) {
            System.out.println("Самая старая собака " + dog1.name);
        } else if (dog2.age > dog1.age && dog2.age > dog3.age) {
            System.out.println("Самая старая собака " + dog2.name);
        } else {
            System.out.println("Самая старая собака " + dog3.name);
        }
    }
}

