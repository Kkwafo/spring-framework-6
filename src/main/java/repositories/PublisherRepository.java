package repositories;

import org.springframework.data.repository.CrudRepository;

import domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
