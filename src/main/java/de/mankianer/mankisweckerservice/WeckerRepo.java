package de.mankianer.mankisweckerservice;

import de.mankianer.mankisweckerservice.models.Wecker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeckerRepo extends CrudRepository<Wecker, Integer> {

}
