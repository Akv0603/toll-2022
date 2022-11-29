package server.repo;

import org.springframework.data.repository.CrudRepository;
import server.dao.Users;
//Репозиторий для Users
public interface UsersRepository extends CrudRepository<Users, Integer> {
}
