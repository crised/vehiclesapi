package cl.crised.eurekaclient.repository;

import cl.crised.eurekaclient.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

//@RepositoryRestResource(collectionResourceRel = "price", path = "price")
////            http://localhost:8082/services/price/?vehicleId=1
public interface PricingRepository extends CrudRepository<Price,Long> {
}
