package ru.gerch.streamPractise;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.gerch.streamPractise.model.Car;
import ru.gerch.streamPractise.model.CarInfo;
import ru.gerch.streamPractise.model.Owner;
import ru.gerch.streamPractise.service.CarService;
import ru.gerch.streamPractise.utils.Condition;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarServiceTest {

    private CarService carService;

    @BeforeTest
    void init() {
        carService = new CarService();
    }

    @Test
    public void carConditionTest() {
        List<String> conditions = carService.getConditions(getCarList());

        List<String> expected = getExpectedConditions();
        Assert.assertEquals(conditions, expected);
    }

    @Test
    public void newCarTest() {
        List<Car> newCars = carService.getNewCars(getCarList());

        List<Car> expected = getExpectedNewCar();
        Assert.assertEquals(newCars, expected);
    }

    @Test
    public void countNewCarTest() {
        long ownersAmount = carService.countCarsOwners(getCarList());

        Assert.assertEquals(ownersAmount, 5);
    }

    @Test
    public void incrementCarAge() {
        List<Car> incrementedCars = carService.incrementCarAge(getCarList());

        Assert.assertTrue(incrementedCars.stream().anyMatch(car -> car.equals(getIncrementedCar())));
    }

    @Test
    public void oldestCarTest() {
        Car oldestCar = carService.getOldestCar(getCarList());
        oldestCar.setOwners(null);
        Assert.assertEquals(oldestCar, getOldestCar());
    }

    @Test
    public void ownersCarsNames() {
        List<String> names = carService.getOwnersCarsNames(getCarList());

        Assert.assertEquals(names, getNames());
    }

    @Test
    public void toCarInfoTest() {
        List<CarInfo> carInfos = carService.mapToCarInfo(getCarList());

        Assert.assertTrue(carInfos.stream().anyMatch(carInfo -> carInfo.equals(getCarInfos())));
    }

    @Test
    public void twoBrokenCarsTest() {
        List<Car> brokenCars = carService.getTwoBrokenCar(getCarList());


        Assert.assertEquals(brokenCars.size(), 2);
        Assert.assertEquals(brokenCars, getTwoBrokenCars());
    }

    @Test
    public void sortedCarsTest() {
        List<Car> sortedCars = carService.getSortedCarsByAge(getCarList());

        Assert.assertEquals(sortedCars, getSorted());
    }

    @Test
    public void avgCarsAge() {
        double actualAvg = carService.getAvgCarsAge(getCarList());

        Assert.assertEquals(actualAvg, expectedAvg);
    }

    @Test
    public void checkBrokenCarTest() {
        Assert.assertTrue(carService.checkBrokenCarsAge(getCarList()));
    }

    @Test
    public void checkUsedCarOwnerName() {
        Assert.assertTrue(carService.checkCarOwnerName(getCarList()));
    }

    @Test
    public void anyOwner() {
        Owner actualOwner = carService.getAnyOwner(getCarList());

        Assert.assertTrue(getExpectedOwners().stream().anyMatch(owner -> owner.equals(actualOwner)));
    }

    private List<Car> getCarList() {
        List<Car> cars = new ArrayList<>();
        Owner bob = new Owner("Bob", 25, 5);
        Owner oleg = new Owner("Oleg", 35, 15);
        Owner tom = new Owner("Tom", 27, 15);
        Owner liza = new Owner("Liza", 22, 1);
        Owner egor = new Owner("Egor", 31, 6);
        Owner anton = new Owner("Anton", 50, 25);
        Owner sergey = new Owner("Sergey", 29, 7);
        Owner anna = new Owner("Anna", 44, 19);
        Owner adam = new Owner("Adam", 30, 10);

        cars.add(new Car("KIA", 2, Condition.USED, Collections.singletonList(bob)));
        cars.add(new Car("Opel", 0, Condition.NEW, Collections.singletonList(sergey)));
        cars.add(new Car("BMW", 15, Condition.BROKEN, List.of(anton, liza, egor)));
        cars.add(new Car("Toyota", 10, Condition.USED, List.of(oleg, liza)));
        cars.add(new Car("Mercedes", 0, Condition.NEW, List.of(tom)));
        cars.add(new Car("Peugeot", 14, Condition.BROKEN, List.of(sergey, oleg, bob, egor)));
        cars.add(new Car("Jeep", 5, Condition.USED, List.of(tom, bob)));
        cars.add(new Car("Volkswagen", 19, Condition.BROKEN, List.of(tom, anton, oleg, egor)));
        cars.add(new Car("Ford", 0, Condition.NEW, List.of(tom, anton, oleg, egor)));
        cars.add(new Car("Chevrolet", 0, Condition.NEW, List.of(anton)));
        cars.add(new Car("Audi", 4, Condition.USED, List.of(oleg, tom)));
        cars.add(new Car("Nissan", 20, Condition.BROKEN, List.of(bob, liza, anton, egor, sergey)));
        cars.add(new Car("Renault", 19, Condition.BROKEN, List.of(anna)));
        cars.add(new Car("Hyundai", 10, Condition.USED, List.of(adam)));

        return cars;
    }


    private List<String> getExpectedConditions() {
        return List.of("USED", "NEW", "BROKEN", "USED", "NEW", "BROKEN", "USED", "BROKEN", "NEW", "NEW", "USED", "BROKEN", "BROKEN", "USED");
    }

    private List<Car> getExpectedNewCar() {
        List<Car> cars = new ArrayList<>();
        Owner sergey = new Owner("Sergey", 29, 7);
        Owner tom = new Owner("Tom", 27, 15);
        Owner anton = new Owner("Anton", 50, 25);
        Owner oleg = new Owner("Oleg", 35, 15);
        Owner egor = new Owner("Egor", 31, 6);

        cars.add(new Car("Opel", 0, Condition.NEW, Collections.singletonList(sergey)));
        cars.add(new Car("Mercedes", 0, Condition.NEW, List.of(tom)));
        cars.add(new Car("Ford", 0, Condition.NEW, List.of(tom, anton, oleg, egor)));
        cars.add(new Car("Chevrolet", 0, Condition.NEW, List.of(anton)));
        return cars;
    }

    private Car getIncrementedCar() {
        Owner tom = new Owner("Tom", 27, 15);
        return new Car("Mercedes", 1, Condition.NEW, List.of(tom));
    }

    private Car getOldestCar() {
        return new Car("Nissan", 20, Condition.BROKEN, null);
    }

    private List<String> getNames() {
        return List.of("Bob", "Sergey", "Anton", "Liza", "Egor", "Oleg", "Tom", "Anna", "Adam");
    }

    private CarInfo getCarInfos() {
        return new CarInfo("Audi", 4, 2);
    }

    private List<Car> getTwoBrokenCars() {
        List<Car> cars = new ArrayList<>();
        Owner anton = new Owner("Anton", 50, 25);
        Owner liza = new Owner("Liza", 22, 1);
        Owner egor = new Owner("Egor", 31, 6);
        Owner bob = new Owner("Bob", 25, 5);
        Owner oleg = new Owner("Oleg", 35, 15);
        Owner sergey = new Owner("Sergey", 29, 7);
        cars.add(new Car("BMW", 15, Condition.BROKEN, List.of(anton, liza, egor)));
        cars.add(new Car("Peugeot", 14, Condition.BROKEN, List.of(sergey, oleg, bob, egor)));
        return cars;
    }

    private List<Car> getSorted() {
        List<Car> sorted = getCarList();
        sorted.sort(Comparator.comparing(Car::getAge).reversed());
        return sorted;
    }

    private List<Owner> getExpectedOwners() {
        List<Owner> owners = new ArrayList<>();
        owners.add(new Owner("Anna", 44, 19));
        owners.add(new Owner("Anton", 50, 25));
        return owners;
    }

    private double expectedAvg = 8.428571428571429;
}
