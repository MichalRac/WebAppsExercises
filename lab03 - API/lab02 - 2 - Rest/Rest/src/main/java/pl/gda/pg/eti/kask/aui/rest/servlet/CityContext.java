package pl.gda.pg.eti.kask.aui.rest.servlet;

import pl.gda.pg.eti.kask.aui.rest.entities.City;

import java.io.Serializable;
import java.util.*;

public class CityContext implements Serializable {
    private final SortedMap<Integer, City> cities;

    public List<City> findAllCities() { return new ArrayList<>(cities.values()); }

    public CityContext() {
        cities = Collections.synchronizedSortedMap(new TreeMap<Integer, City>());

        cities.put(1, new City(1, "Gdansk", 54.372158f, 18.638306f));
        cities.put(2, new City(2, "Warszawa", 52.237049f, 21.017532f));
        cities.put(3, new City(3, "Wroclaw", 51.107883f, 17.038538f));
    }

    public City findCity(Integer id) { return cities.get(id); }

}
