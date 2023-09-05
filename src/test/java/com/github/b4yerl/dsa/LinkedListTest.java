package com.github.b4yerl.dsa;

import com.github.b4yerl.dsa.structure.LinkedList;
import com.github.b4yerl.dsa.structure.node.SingleNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void shouldCreateEmptyList() {
        LinkedList<Object> list = new LinkedList<>();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldCreateListOfSize1() {
        SingleNode<Integer> node = new SingleNode<>();
        node.setContent(10);

        LinkedList<Integer> list = new LinkedList<>(node);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void shouldGetTheRightElement() {
        SingleNode<Integer> node = new SingleNode<>();
        node.setContent(10);

        LinkedList<Integer> list = new LinkedList<>(node);
        list.addToLastPosition(new SingleNode<>(5));

        SingleNode<Integer> target = new SingleNode<>(61);
        list.addToLastPosition(target);

        list.addToLastPosition(new SingleNode<>(85));
        Assertions.assertSame(target, list.get(2));
    }

    @Test
    public void shouldThrowIndexOutOfBoundsException() {
        LinkedList<Integer> list = new LinkedList<>(new SingleNode<>(69));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-5));
    }

    @Test
    public void shouldAddNewEntryPoint() {
        LinkedList<Double> list = new LinkedList<>(new SingleNode<>(6.9));
        SingleNode<Double> target = new SingleNode<>(6.1);
        list.addNewEntryPoint(target);

        Assertions.assertEquals(target, list.get(0));
    }

    @Test
    public void shouldAddNewLastElement() {
        LinkedList<Double> list = new LinkedList<>(new SingleNode<>(6.9));
        SingleNode<Double> target = new SingleNode<>(6.1);
        list.addToLastPosition(target);

        Assertions.assertEquals(target, list.get(list.size() - 1));
    }

    @Test
    public void shouldAddElementToGivenIndex() {
        SingleNode<Integer> node = new SingleNode<>();
        node.setContent(10);

        LinkedList<Integer> list = new LinkedList<>(node);
        list.addToLastPosition(new SingleNode<>(5));

        SingleNode<Integer> target = new SingleNode<>(61);
        list.add(target, 1);

        list.addToLastPosition(new SingleNode<>(85));

        Assertions.assertSame(target, list.get(1));
    }

    @Test
    public void shouldRemoveEntryPoint() {
        LinkedList<Double> list = new LinkedList<>(new SingleNode<>(6.9));

        SingleNode<Double> target = new SingleNode<>(6.1);
        list.addToLastPosition(target);
        list.removeEntryPoint();

        Assertions.assertSame(target, list.get(0));
    }

    @Test
    public void shouldRemoveLastElement() {
        LinkedList<Double> list = new LinkedList<>(new SingleNode<>(6.9));

        SingleNode<Double> target = new SingleNode<>(6.1);
        list.addNewEntryPoint(target);
        list.removeLastPosition();

        Assertions.assertEquals(1, list.size());
        Assertions.assertSame(target, list.get(list.size() - 1));
    }

    @Test
    public void shouldRemoveElementOnGivenIndex() {
        LinkedList<Integer> list = new LinkedList<>(new SingleNode<>(10));
        list.addToLastPosition(new SingleNode<>(5));

        SingleNode<Integer> target = new SingleNode<>(61);
        list.addToLastPosition(target);

        list.addToLastPosition(new SingleNode<>(85));

        list.remove(1);

        Assertions.assertSame(target, list.get(1));
    }
}

