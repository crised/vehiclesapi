package cl.crised.eurekaclient.repository;

import cl.crised.eurekaclient.entity.Price;
import org.springframework.data.repository.CrudRepository;

public interface PricingRepository extends CrudRepository<Price,Long> {
}
