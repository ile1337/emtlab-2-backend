package mk.ukim.finki.emt.lab2.emtlab2.service.impl;

import mk.ukim.finki.emt.lab2.emtlab2.model.Country;
import mk.ukim.finki.emt.lab2.emtlab2.repository.CountryRepository;
import mk.ukim.finki.emt.lab2.emtlab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {


    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }
}
