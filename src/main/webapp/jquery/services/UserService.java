import models/user.model.service.java;

@RestController
public class UserService {
  @PostMapping("/register")
  public void register(User user){
    return "Hello from Register";
  }

}
