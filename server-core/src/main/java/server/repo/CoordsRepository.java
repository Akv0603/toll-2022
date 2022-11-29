package server.repo;

import org.springframework.data.repository.CrudRepository;
import server.dao.Coords;

// Репозиторий для координат(Coords)
public interface CoordsRepository extends CrudRepository<Coords, Integer> {

}
