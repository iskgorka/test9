public class Threads {}
/*
Class Example 1
        interface MyInterface {
            int getNumber();
            default String getString() {
                return "Объект типа String";
            }
            static int getDefaultNumber() {
                System.out.println("Метод getDefaultNumber(), вызываемый со значением 0");
                return 0;
            }
        }

        class Client implements MyInterface {
            Client() {
                System.out.println("Конструктор Client");
            }
            public int getNumber() {
                System.out.println("Метод getNumber(), вызываемый со значением 10");
                return 10;
            }
            public void callBack(int p) { //2 10
                boolean isPrime;
                if (p < 2) isPrime = false;
                else isPrime = true; //true true
                for (int i = 2; i <= p / i; i++) { // 2<=1 2<=5
                    if ((p % i) == 0) { //10%2
                        isPrime = false; //false
                        break;
                    }
                }
                if (isPrime) System.out.println("Простое число");
                else System.out.println("Не простое число");
            }
        }

        class Demo {
            public static void main(String[] args) {
                Client ob = new Client();
                ob.getNumber();
                ob.getString();
                ob.callBack(19);

                //ob.getDefaultNumber();
                int defNum = MyInterface.getDefaultNumber();
                System.out.println(defNum);
            }
        }

Class Example 2
        class A {
            void callMe() {System.out.println("В методе callMe() из класса А");}
            void methA() {System.out.println("methA() из класса А");}
        }
        class B extends A {
            void callMe() {System.out.println("В методе callMe() из класса B");}
            void methB() {System.out.println("methB() из класса B");}
        }
        class C extends A {
            void callMe() {System.out.println("В методе callMe() из класса C");}
            void methC() {System.out.println("methC() из класса C");}
        }
        class Demo {
            public static void main(String[] args) {
                A a = new A(); //объект класса А
                B b = new B(); //объект класса B
                C c = new C(); //объект класса C
                A r; // объявили переменную r типа А
                r = a; // переменная r ссылается на объект а
                r.callMe();
                r.methA();
                //r.methB();
                //r.methC();
                r = b; // r - тип ссылки, b - тип объекта
                r.callMe();
                r.methA();
                //r.methB();
                //r.methC();
                r = c; // Если метод не переопределён то мы смотрим на тип ссылки, если метод переопределён то смотрим на тип объекта
                r.callMe();
                r.methA();
                //r.methB();
                //r.methC();
            }
        }

Thread example 1
        class CurrentThreadDemo {
            public static void main(String[] args) {
                Thread t = Thread.currentThread();
                System.out.println("Текущий поток исполнения: " + t);
        //изменить имя потока исполнения
                t.setName("My Thread");
                System.out.println("После изменения имени потока: " + t);
                try {
                    for (int n = 5; n > 0; n--) {
                        System.out.println(n);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Главный поток исполнения прерван");
                }
            }
        }

Thread example 2
        //Создать второй поток исполнения
        class NewThread implements Runnable {
            Thread t;
            NewThread() {
        //создать новый, второй поток исполнения
                t = new Thread(this,"Демонстрационный поток");
                System.out.println("Дочерний поток создан: " + t);
                t.start();//запустить поток исполнения
            }

            //точка входа во второй поток исполнения
            public void run() {
                try {
                    for (int i = 5; i > 0; i--) {
                        System.out.println("Дочерний поток: " + i);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Дочерний поток прерван.");
                }
                System.out.println("Дочерний поток завершен.");
            }
        }

        class ThreadDemo {
            public static void main(String[] args) {
                new NewThread(); //создать новый поток
                try {
                    for (int i = 5; i > 0; i--) {
                        System.out.println("Главный поток: " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван.");
                }
                System.out.println("Главный поток завершен.");
            }
        }

Thread example 3
        class NewThread extends Thread {
            NewThread() {
        //создать новый поток исполнения
                super("Демонстрационный поток");
                System.out.println("Дочерний поток: " + this);
                start();//запустить поток на исполнение
            }

            //точка входа во второй поток исполнения
            public void run() {
                try {
                    for (int i = 5; i > 0; i--) {
                        System.out.println("Дочерний поток: " + i);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Дочерний поток прерван.");
                }
                System.out.println("Дочерний поток завершен.");
            }
        }

        class ExtendThread {
            public static void main(String[] args) {
                new NewThread(); //создать новый поток исполнения
                try {
                    for (int i = 5; i > 0; i--) {
                        System.out.println("Главный поток: " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван.");
                }
                System.out.println("Главный поток завершен.");
            }
        }

Thread example 4
        //создать несколько потоков исполнени
        class NewThread implements Runnable {
            String name; //имя потока исполнения
            Thread t;

            NewThread(String threadName) {
                name = threadName;
                t = new Thread(this, name);
                System.out.println("Новый поток: " + t);
                t.start(); // запустить поток на исполнение
            }

            //точка входа во второй поток исполнения
            public void run() {
                try {
                    for (int i = 5; i > 0; i--) {
                        System.out.println(name + ": " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println(name + " прерван.");
                }
                System.out.println(name + " завершен.");
            }
        }
        class ExtendThread {
            public static void main(String[] args) {
                new NewThread("Один"); //запустить потоки на исполнение
                new NewThread("Два");
                new NewThread("Три");
                try {
                    // ожидать завершения других потоков исполнения
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван.");
                }
                System.out.println("Главный поток завершен.");
            }
        }

Thread example 5
        // применить метод join(), чтобы ожидать завершения потоков исполнения4
        class NewThread implements Runnable {
            String name; //имя потока исполнения
            Thread t;
            NewThread(String threadName) {
                name = threadName;
                t = new Thread(this, name);
                System.out.println("Новый поток: " + t);
                t.start(); // запустить поток на исполнение
            }
            //точка входа в поток исполнения
            public void run() {
                try {
                    for (int i = 5; i > 0; i--) {
                        System.out.println(name + ": " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println(name + " прерван.");
                }
                System.out.println(name + " завершен.");
            }
        }
        class DemoJoin {
            public static void main(String[] args) {
                NewThread ob1 = new NewThread("Один");
                NewThread ob2 = new NewThread("Два");
                NewThread ob3 = new NewThread("Три");
                System.out.println("Поток Один запущен: " + ob1.t.isAlive());
                System.out.println("Поток Два запущен: " + ob2.t.isAlive());
                System.out.println("Поток Три запущен: " + ob3.t.isAlive());
        //ожидать завершения потоков
                try {
                    System.out.println("Ожидание завершения потоков");
                    ob1.t.join();
                    ob2.t.join();
                    ob3.t.join();
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван.");
                }
                System.out.println("Поток Один запущен: " + ob1.t.isAlive());
                System.out.println("Поток Два запущен: " + ob2.t.isAlive());
                System.out.println("Поток Три запущен: " + ob3.t.isAlive());
                System.out.println("Главный поток завершен.");
            }
        }

Thread example 6

*/
