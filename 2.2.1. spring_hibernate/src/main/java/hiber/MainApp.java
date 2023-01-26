package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      //Создаем 4 автомобиля с указанием марки и серийного номера
      Car car1 = new Car("Chevrolet", 324543);
      Car car2 = new Car("Toyota", 632715);
      Car car3 = new Car("Lada", 923152);
      Car car4 = new Car("BELAZ", 654987);

      //Сохраняем их в бд для авто
      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      //Заполняем бд для User. Каждому User прописываем свой авто
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car3));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car4));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car1));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car2));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar()); //Добавил вывод на экран инфо об автомобиле User
         System.out.println();
      }

      //Медот для поиска пользователя по марке и серийному номеру автомобиля getUser()
      System.out.println("Автомобиль Toyota, с серийным номером: 632715 принадлежит: " + userService.getUser("Toyota", 632715).getFirstName());

      context.close();
   }
}
