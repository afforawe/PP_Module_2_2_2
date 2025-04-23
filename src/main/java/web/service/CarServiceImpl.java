package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car(1L, "Honda", 11));
        cars.add(new Car(2L, "Toyota", 12));
        cars.add(new Car(3L, "Mazda", 13));
        cars.add(new Car(4L, "BMW", 14));
        cars.add(new Car(5L, "Audi", 15));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count > 0 && count < 5) {
            return cars.stream()
                    .limit(count)
                    .collect(Collectors.toList());
        } else return cars;
    }
}
