import java.util.ArrayList;
import java.util.List;

// 1. Класс Dish (Блюдо)
class Dish {
    private String name;
    private float price;
    private int quantity;

    // Конструктор
    public Dish(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Метод для вывода информации о блюде
    public void print() {
        System.out.printf("Блюдо: %s, Цена: %.2f, Количество порций: %d%n", name, price, quantity);
    }

    // Геттеры для доступа к приватным данным
    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}

// 2. Класс Menu (Меню)
class Menu {
    private List<Dish> dishes;

    // Конструктор
    public Menu() {
        dishes = new ArrayList<>();
    }

    // Метод для добавления блюда в меню
    public void addDish(Dish dish) {
        if (dishes.size() < 10) { // Аналог MAX_DISHES
            dishes.add(dish);
        } else {
            System.out.println("Меню переполнено!");
        }
    }

    // Метод для вывода меню
    public void print() {
        System.out.println("Меню:");
        for (Dish dish : dishes) {
            dish.print();
        }
        System.out.println();
    }

    // Получение блюда по индексу
    public Dish getDish(int index) {
        if (index >= 0 && index < dishes.size()) {
            return dishes.get(index);
        }
        return null;
    }
}

// 3. Класс Client (Клиент)
class Client {
    private String name;
    private String phone;

    // Конструктор
    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Метод для вывода информации о клиенте
    public void print() {
        System.out.printf("Клиент: %s, Телефон: %s%n", name, phone);
    }

    public String getName() {
        return name;
    }
}

// 4. Класс Employee (Сотрудник)
class Employee {
    private String name;
    private int id;

    // Конструктор
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Метод для вывода информации о сотруднике
    public void print() {
        System.out.printf("Официант: %s, ID: %d%n", name, id);
    }

    public String getName() {
        return name;
    }
}

// 5. Класс Order (Заказ)
class Order {
    private Client client;
    private Employee employee;
    private List<Dish> orderedDishes;
    private float totalPrice;

    // Конструктор
    public Order(Client client, Employee employee) {
        this.client = client;
        this.employee = employee;
        this.orderedDishes = new ArrayList<>();
        this.totalPrice = 0.0f;
    }

    // Метод для добавления блюда в заказ
    public void addDish(Dish dish) {
        if (orderedDishes.size() < 5) { // Аналог MAX_ORDERS
            orderedDishes.add(dish);
            totalPrice += dish.getPrice() * dish.getQuantity();
        } else {
            System.out.println("Заказ переполнен!");
        }
    }

    // Метод для вывода заказа
    public void print() {
        System.out.printf("Заказ клиента: %s%n", client.getName());
        System.out.printf("Обслуживает официант: %s%n", employee.getName());
        System.out.println("Блюда в заказе:");
        for (Dish dish : orderedDishes) {
            dish.print();
        }
        System.out.printf("Общая стоимость заказа: %.2f%n%n", totalPrice);
    }
}

// 6. Главный класс (Main)
public class Main {
    public static void main(String[] args) {
        // Создаём меню
        Menu menu = new Menu();
        Dish borsh = new Dish("Борщ", 250.0f, 1);
        Dish pelmeni = new Dish("Пельмени", 300.0f, 1);
        menu.addDish(borsh);
        menu.addDish(pelmeni);
        menu.print();

        // Создаём клиента и сотрудника
        Client client = new Client("Иван Иванов", "89005555555");
        Employee employee = new Employee("Сергей Петров", 101);

        // Создаём заказ
        Order order = new Order(client, employee);
        order.addDish(menu.getDish(0)); // Добавляем "Борщ"
        order.addDish(menu.getDish(1)); // Добавляем "Пельмени"
        order.print();

        // Работа с "динамическим" заказом (в Java это просто новый объект)
        Order dynamicOrder = new Order(client, employee);
        dynamicOrder.addDish(menu.getDish(0)); // Добавляем "Борщ"
        dynamicOrder.print();
    }
}
