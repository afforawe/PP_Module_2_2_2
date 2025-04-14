package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final List<Car> cars = new ArrayList<>();
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;

        cars.add(new Car(1L, "Honda", 11));
        cars.add(new Car(2L, "Toyota", 12));
        cars.add(new Car(3L, "Mazda", 13));
        cars.add(new Car(4L, "BMW", 14));
        cars.add(new Car(5L, "Audi", 15));
    }

    @GetMapping(value = "/cars")
    String getAllCars(
            @RequestParam(value = "count", defaultValue = "5") int count,
            Model model) {
        List<Car> limitedCars = carService.getCars(cars, count);
        model.addAttribute("cars", limitedCars);
        return "car";
    }
}