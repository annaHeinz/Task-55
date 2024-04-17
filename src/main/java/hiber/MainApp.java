package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1=new User("User1", "Lastname1", "user1@mail.ru");
      User user2=new User("User2", "Lastname2", "user2@mail.ru");
      User user3=new User("User3", "Lastname3", "user3@mail.ru");
      Car volvo = new Car("Volvo", 9);
      Car bmw = new Car("BMW", 325);
      Car suzuki = new Car("Sisuki", 4);

      userService.add(user1.setCar(volvo).setUser(user1));
      userService.add(user2.setCar(bmw).setUser(user2));
      userService.add(user3.setCar(suzuki).setUser(user3));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
         System.out.println(user + " " + user.getCar());
      }
      System.out.println(userService.getUserByCar("Volvo",9));

      context.close();
   }
}
