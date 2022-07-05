package ru.gerch.streamPractise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarInfo {
    // Название машины
    private String name;
    // Возраст машины
    private int age;
    // Количество владельцев
    private int owners;
}
