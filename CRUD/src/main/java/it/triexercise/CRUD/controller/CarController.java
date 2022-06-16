package it.triexercise.CRUD.controller;

import it.triexercise.CRUD.entity.Car;
import it.triexercise.CRUD.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;


    @PostMapping
    public void createCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable int id) {

        if (!carRepository.existsById(id)) {
            Car car = new Car();
            return Optional.of(car);
        }
        return carRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Car editCarTypeById(@PathVariable int id, @RequestParam String type) {
        Car car = new Car();
        if (!carRepository.existsById(id))
            return car;
        car = carRepository.getReferenceById(id); // used getReferenceById() as getById() is deprecated
        car.setType(type);
        return carRepository.saveAndFlush(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable int id, HttpServletResponse response) {
        if (!carRepository.existsById(id))
            response.setStatus(409);
        carRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

}
