package cat.itb.videogamegestion.repositories;

import cat.itb.videogamegestion.models.Videogame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameRepository extends CrudRepository<Videogame,String> {
}
