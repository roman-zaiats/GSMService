package sms.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.com.model.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
}