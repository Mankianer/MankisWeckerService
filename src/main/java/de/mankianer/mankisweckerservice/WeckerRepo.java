package de.mankianer.mankisweckerservice;

import de.mankianer.mankisweckerservice.models.Wecker;
import org.springframework.data.repository.CrudRepository;

public interface WeckerRepo extends CrudRepository<Wecker, Integer> {

}
