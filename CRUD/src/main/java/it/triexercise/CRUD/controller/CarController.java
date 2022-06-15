package it.triexercise.CRUD.controller;

import it.triexercise.CRUD.entity.Car;
import it.triexercise.CRUD.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/{id}")
//    public Optional<Car> getCarById(@PathVariable int id) {
//        if (!carRepository.existsById(id)) {
//            return null;
//        }
//    }

//    @PutMapping("/{id}")
//    public void editCarById(@PathVariable int id, @RequestParam Car car) {
//
//    }
//
//    @DeleteMapping
}
