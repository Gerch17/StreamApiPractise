package ru.gerch.streamPractise.service;

import ru.gerch.streamPractise.model.Car;
import ru.gerch.streamPractise.model.CarInfo;
import ru.gerch.streamPractise.model.Owner;
import ru.gerch.streamPractise.utils.Condition;

import java.util.List;

/**
 * Необходимо реализовать каждый метод
 *
 * Запрещено использовать if, for, foreach...
 * Все методы реализуются в одну строчку
 * Можно использовать только stream API
 *
 * Для проверки правильности выполнения необходимо запустить тесты.
 *
 * В помощь: https://habr.com/ru/company/luxoft/blog/270383/
 */
public class CarService {

    /**
     * Приходит список Car
     * Необходимо вернуть список строк из Condition
     */
    public List<String> getConditions(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть только те, у которых Condition - "NEW"
     */
    public List<Car> getNewCars(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть количество Car, у которых больше 2 Owners
     */
    public long countCarsOwners(List<Car> cars) {
        return 0;
    }

    /**
     * Приходит список Car
     * Необходимо каждому элементу списка в поле age прибавить 1
     */
    public List<Car> incrementCarAge(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть Car, у которого самое большое значение age
     */
    public Car getOldestCar(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть список имён всех владельцев
     * Имена не должны повторяться
     */
    public List<String> getOwnersCarsNames(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо преобразовать его в список CarInfo
     */
    public List<CarInfo> mapToCarInfo(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть не более двух машин, у которых Condition - BROKEN
     */
    public List<Car> getTwoBrokenCar(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть отсортированный по полю age список Car
     */
    public List<Car> getSortedCarsByAge(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо посчитать средний возраст всех машин
     */
    public double getAvgCarsAge(List<Car> cars) {
        return 0;
    }

    /**
     * Приходит список Car
     * Проверить, что все машины с Condition - "Broken" старше 10 лет
     */
    public Boolean checkBrokenCarsAge(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Проверить, что хотя бы одной у машины с Condition - "USED" был владелец по имени Adam
     */
    public Boolean checkCarOwnerName(List<Car> cars) {
        return null;
    }

    /**
     * Приходит список Car
     * Необходимо вернуть любого Owner старше 36 лет
     */
    public Owner getAnyOwner(List<Car> cars) {
        return null;
    }
}
