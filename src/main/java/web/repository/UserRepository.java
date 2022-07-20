package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User getUserById(long id);
}
