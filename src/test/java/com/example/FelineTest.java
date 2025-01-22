package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
            Assert.assertEquals("Список подходящей еды должен быть: Животные, Птицы, Рыба",List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
    @Test
    public void testGetFamily() {
        Assert.assertEquals("Семейство должно быть: Кошачьи","Кошачьи", feline.getFamily());
    }
    @Test
    public void testGetKittens() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
    @Test
    public void testTestGetKittens() {
        Assert.assertEquals("Ожидается котят: 2",2, feline.getKittens(2));
    }
}