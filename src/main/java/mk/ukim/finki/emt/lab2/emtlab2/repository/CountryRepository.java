package mk.ukim.finki.emt.lab2.emtlab2.repository;

import mk.ukim.finki.emt.lab2.emtlab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
