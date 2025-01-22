package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LionTest {
    @Rule public MockitoRule rule = MockitoJUnit.rule();
    String sex;
    boolean hasMane;
    Lion lion;
    public LionTest(String sex, boolean hasMane) {
        this.hasMane = hasMane;
        this.sex = sex;
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void prereq() throws Exception {
        lion = new Lion(sex, feline);
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals("Ожидаем одного котенка", 1, lion.getKittens());
    }

    @Test
    public void doesHaveMane() {
        Assert.assertEquals("Проверка наличия гривы для " + sex, hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Список подходящей еды должен быть: Животные, Птицы, Рыба", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}