package cat.itb.videogamegestion.repositories;

import cat.itb.videogamegestion.models.UserObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserObject,String> {
}
