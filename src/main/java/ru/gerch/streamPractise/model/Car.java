package ru.gerch.streamPractise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.gerch.streamPractise.utils.Condition;

import java.util.List;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private int age;
    private Condition condition;
    private List<Owner> owners;
}
