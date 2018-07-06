package java.webdev.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.webdev.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
