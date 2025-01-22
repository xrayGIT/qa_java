package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;


    @Test
    public void testGetSound() {
        Cat cat =  new Cat(feline);
        Assert.assertEquals("Ожидаем звук 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_useEatMeatMethod() throws Exception {
        Cat cat =  new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals("Список подходящей еды должен быть: Животные, Птицы, Рыба", List.of("Животные", "Птицы", "Рыба") ,cat.getFood());
        //Exception exception = assertThrows(Exception.class, () -> cat.getFood());
        //assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());


    }
}