public class Threads {
}
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
        // применить метод join(), чтобы ожидать завершения потоков исполнения
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
        //эта программа не синхронизирована
        class CallMe {
            void call(String msg) {
                System.out.println("[" + msg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Прервано");
                }
                System.out.println("]");
            }
        }
        class Caller implements Runnable {
            String msg;
            CallMe target;
            Thread t;
            public Caller(CallMe targ, String s) {
                target = targ;
                msg = s;
                t = new Thread(this);
                t.start();
            }
            public void run() {
                target.call(msg);
            }
        }
        class Synch {
            public static void main(String[] args) {
                CallMe target = new CallMe();
                Caller ob1 = new Caller(target, "Добро пожаловать");
                Caller ob2 = new Caller(target, "в синхронизированный");
                Caller ob3 = new Caller(target, "мир!");
        //ожидать завершения потока исполнения
                try {
                    ob1.t.join();
                    ob2.t.join();
                    ob3.t.join();
                } catch (InterruptedException e) {
                    System.out.println("Прервано");
                }
            }
        }

Thread example 7
        class CallMe {
            synchronized void call(String msg) {
                System.out.print("[" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Прервано");
                }
                System.out.println("]");
            }
        }
        class Caller implements Runnable {
            String msg;
            CallMe target;
            Thread t;
            public Caller(CallMe targ, String s) {
                target = targ;
                msg = s;
                t = new Thread(this);
                t.start();
            }
            public void run() {
                target.call(msg);
            }
        }
        class Synch {
            public static void main(String[] args) {
                CallMe target = new CallMe();
                Caller ob1 = new Caller(target, "Добро пожаловать");
                Caller ob2 = new Caller(target, "в синхронизированный мир!");
        //ожидать завершения потока исполнения
                try {
                    ob1.t.join();
                    ob2.t.join();
                } catch (InterruptedException e) {
                    System.out.println("Прервано");
                }
            }
        }

Thread example 8
        //в этой программе используется синхронизированный блок
        class CallMe {
            void call(String msg) {
                System.out.print("[" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Прервано");
                }
                System.out.println("]");
            }
        }
        class Caller implements Runnable {
            String msg;
            CallMe target;
            Thread t;
            public Caller(CallMe targ, String s) {
                target = targ;
                msg = s;
                t = new Thread(this);
                t.start();
            }
            //синхронизированные вызовы метода call()
            public void run() {
                synchronized (target) { //синхронизированный блок
                    target.call(msg);
                }
            }
        }
        class Synch {
            public static void main(String[] args) {
                CallMe target = new CallMe();
                Caller ob1 = new Caller(target, "Добро пожаловать");
                Caller ob2 = new Caller(target, "в синхронизированный мир!");
                //ожидать завершения потока исполнения
                try {
                    ob1.t.join();
                    ob2.t.join();
                } catch (InterruptedException e) {
                    System.out.println("Прервано");
                }
            }
        }

Thread example 9
        //неправильная реализация поставщика и потребителя
        class Q {
            int n;
            synchronized int get() {
                System.out.println("Получено: " + n);
                return n;
            }
            synchronized void put(int n) {
                this.n = n;
                System.out.println("Отправлено: " + n);
            }
        }
        class Producer implements Runnable {
            Q q;
            Producer(Q q) {
                this.q = q;
                new Thread(this, "Поставщик").start();
            }
            public void run(){
                int i = 0;
                while (true) {
                    q.put(i++);
                }
            }
        }
        class Consumer implements Runnable {
            Q q;
            Consumer(Q q) {
                this.q = q;
                new Thread(this, " Потребитель ").start();
            }
            public void run() {
                while (true) {
                    q.get();
                }
            }
        }
        class PC {
            public static void main(String[] args) {
                Q q = new Q();
                new Producer(q);
                new Consumer(q);
                System.out.println("Для остановки завершите программу");
            }
        }

Thread example 10
        //Правильная реализация поставщика и потребителя
        class Q {
            int n;
            boolean valueSet = false;
            synchronized int get() {
                while (!valueSet)
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Исключение типа InterruptedException перехвачено");
                    }
                System.out.println("Получено: " + n);
                valueSet = false;
                notify();
                return n;
            }
            synchronized void put(int n) {
                while (valueSet)
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Исключение типа InterruptedException перехвачено");
                    }
                this.n = n;
                valueSet = true;
                System.out.println("Отправлено: " + n);
                notify();
            }
        }
        class Producer implements Runnable {
            Q q;
            Producer(Q q) {
                this.q = q;
                new Thread(this, "Поставщик ").start();
            }
            public void run(){
                int i = 0;
                while (true) {
                    q.put(i++);
                }
            }
        }
        class Consumer implements Runnable {
            Q q;
            Consumer(Q q) {
                this.q = q;
                new Thread(this, "Потребитель ").start();
            }
            public void run() {
                while (true) {
                    q.get();
                }
            }
        }
        class PCFixed {
            public static void main(String[] args) {
                Q q = new Q();
                new Producer(q);
                new Consumer(q);
                System.out.println("Для остановки завершите программу");
            }
        }

Thread example 11
        //Пример взаимной блокировки
        class A {
            synchronized void foo(B b) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " вошёл в метод А.foo()");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Класс А прерван");
                }
                System.out.println(name + " пытается вызвать метод B.last()");
                b.last();
            }
            synchronized void last() {
                System.out.println("В методе А.last()");
            }
        }
        class B {
            synchronized void bar(A a) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " вошёл в метод B.bar()");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Класс B прерван");
                }
                System.out.println(name + " пытается вызвать метод A.last()");
                a.last();
            }
            synchronized void last() {
                System.out.println("В методе B.last()");
            }
        }
        class DeadLock implements Runnable {
            A a = new A();
            B b = new B();
            DeadLock() {
                Thread.currentThread().setName("Главный поток");
                Thread t = new Thread(this, "Соперничающий поток");
                t.start();
                a.foo(b); //получить блокировку для объекта а
        //в этом потоке исполнения
                System.out.println("Назад в главный поток");
            }
            public void run() {
                b.bar(a); //получить блокировку для объекта b
        //в другом потоке исполнения
                System.out.println("Назад в другой поток");
            }
            public static void main(String[] args) {
                new DeadLock();
            }
        }

Thread example 12
        //Приостановка и возобновление исполнения потока
        class NewThread implements Runnable {
            String name; //имя потока исполнения
            Thread t;
            boolean suspendFlag;
            NewThread(String threadname) {
                name = threadname;
                t = new Thread(this, name);
                System.out.println("Новый поток: " + t);
                suspendFlag = false;
                t.start(); //запустить поток исполнения
            }
            //точка входа в поток исполнения
            public void run() {
                try {
                    for (int i = 15; i > 0; i--) {
                        System.out.println(name + ": " + i);
                        Thread.sleep(200);
                        synchronized (this) {
                            while (suspendFlag) {
                                wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(name + " прерван.");
                }
                System.out.println(name + " завершен.");
            }
            synchronized void mySuspend() {
                suspendFlag = true;
            }
            synchronized void myResume() {
                suspendFlag = false;
                notify();
            }
        }
        class SuspendResume {
            public static void main(String[] args) {
                NewThread ob1 = new NewThread("Один");
                NewThread ob2 = new NewThread("Два");
                try {
                    Thread.sleep(1000);
                    ob1.mySuspend();
                    System.out.println("Приостановка потока Один");
                    Thread.sleep(1000);
                    ob1.myResume();
                    System.out.println("Возобновление потока Один");
                    ob2.mySuspend();
                    System.out.println("Приостановка потока Два");
                    Thread.sleep(1000);
                    ob2.myResume();
                    System.out.println("Возобновление потока Два");
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван");
                }
        //ожидать завершения потоков исполнения
                try {
                    System.out.println("Ожидание завершения потоков");
                    ob1.t.join();
                    ob2.t.join();
                } catch (InterruptedException e) {
                    System.out.println("Главный поток прерван");
                }
                System.out.println("Главный поток завершен");
            }
        }

Thread example 13
        class ThreadNew {
            public static void main(String[] args) {
                Thread t = Thread.currentThread();
                System.out.println("Текущий поток исполнения: " + t);
                t.setName("MyThread");
                System.out.println("После изменения имени потока: " + t);
                System.out.println("Статус: " + t.getState());
            }
        }

Enum example 1
        enum Apple {
            Jonathan, GoldenDel, RedDel, Winesap, Cartland
        }

Enum example 2
        //перечисление сортов яблок
        enum Apple {
            Jonathan, GoldenDel, RedDel, Winesap, Cartland
        }
        class EnumDemo {
            public static void main(String[] args) {
                Apple ap;
                ap = Apple.RedDel;
        //вывести значение перечисленного типа
                System.out.println("Значение ap: " + ap);
                System.out.println();
                ap = Apple.GoldenDel;
        //сравнить два значения перечисленного типа
                if (ap == Apple.GoldenDel)
                    System.out.println("Переменная ap содержит GoldenDel.\n");
        //применить перечисление для управления оператором switch
                switch (ap) {
                    case Jonathan:
                        System.out.println("Сорт Jonathan красный.");
                        break;
                    case GoldenDel:
                        System.out.println("Сорт GoldenDel желтый.");
                        break;
                    case RedDel:
                        System.out.println("Сорт RedDel красный.");
                        break;
                    case Winesap:
                        System.out.println("Сорт Winesap красный.");
                        break;
                    case Cartland:
                        System.out.println("Сорт Cartland красный.");
                        break;
                }
            }
        }

Enum example 3
        enum Apple {
            Jonathan, GoldenDel, RedDel, Winesap, Cartland
        }
        class EnumDemo2 {
            public static void main(String[] args) {
                Apple ap;
                System.out.println("Константы перечислимого типа Apple: ");
        //применить метод values()
                Apple[] allApples = Apple.values();
                for (Apple a : allApples) {
                    System.out.println(a);
                }
                System.out.println();
        //применить метод valuesOf()
                ap = Apple.valueOf("Winesap");
                System.out.println("Переменная ap содержит " + ap);
            }
        }

Enum example 4
        //Использовать конструктор, переменную экзeмпляра и метод в перечислении
        enum Apple {
            Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cartland(8);
            private int price; //цена яблока каждогосорта
            //Конструктор
            Apple(int p) {
                price = p;
            }
            int getPrice() {
                return price;
            }
        }
        class EnumDemo3 {
            public static void main(String[] args) {
                Apple ap;
        //Вывести цену на яблоко сорта Winesap
                System.out.println("Яблоко сорта Winesap стоит " +
                        Apple.Winesap.getPrice() +
                        " центов. \n");
        //Вывести цены на все сорта яблок
                System.out.println("Цены на все сорта яблок:");
                for (Apple a : Apple.values()) {
                    System.out.println(a + " стоит " + a.getPrice() + " центов.");
                }
            }
        }

Enum example 5
        //Продемонстрировать применение методов original(), compareTo() и equals()
        //Перечисление сортов яблок
        enum Apple {
            Jonathan, GoldenDel, RedDel, Winesap, Cartland
        }
        class EnumDemo4 {
            public static void main(String[] args) {
                Apple ap, ap2, ap3;
        //получить все порядковые значения с помощью метода original()
                System.out.println("Все константы сортов яблок " +
                         " и их порядковые значения");
                for (Apple a : Apple.values())
                    System.out.println(a + " " + a.ordinal());
                ap = Apple.RedDel;
                ap2 = Apple.GoldenDel;
                ap3 = Apple.RedDel;
                System.out.println();
        //продемонстрировать применение методов compareTo() и equals()
                if (ap.compareTo(ap2) < 0) System.out.println(ap + " предшествует " + ap2);
                if (ap.compareTo(ap2) > 0) System.out.println(ap2 + " предшествует " + ap);
                if (ap.compareTo(ap3) == 0) System.out.println(ap + " равно " + ap3);
                System.out.println();
                if(ap.equals(ap2)) System.out.println("Ошибка");
                if(ap.equals(ap3)) System.out.println(ap + " равно " + ap3);
                if(ap == ap3) System.out.println(ap + " == " + ap3);
            }
        }
*/
