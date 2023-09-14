package com.github.b4yerl.dsa.structure;

import com.github.b4yerl.dsa.structure.node.SinglyNode;
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
        SinglyNode<Integer> node = new SinglyNode<>();
        node.setContent(10);

        LinkedList<Integer> list = new LinkedList<>(node);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void shouldGetTheRightElement() {
        SinglyNode<Integer> node = new SinglyNode<>();
        node.setContent(10);

        LinkedList<Integer> list = new LinkedList<>(node);
        list.addToLastPosition(new SinglyNode<>(5));

        SinglyNode<Integer> target = new SinglyNode<>(61);
        list.addToLastPosition(target);

        list.addToLastPosition(new SinglyNode<>(85));
        Assertions.assertSame(target, list.get(2));
    }

    @Test
    public void shouldThrowIndexOutOfBoundsException() {
        LinkedList<Integer> list = new LinkedList<>(new SinglyNode<>(69));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-5));
    }

    @Test
    public void shouldAddNewEntryPoint() {
        LinkedList<Double> list = new LinkedList<>(new SinglyNode<>(6.9));
        SinglyNode<Double> target = new SinglyNode<>(6.1);
        list.addNewEntryPoint(target);

        Assertions.assertEquals(target, list.get(0));
    }

    @Test
    public void shouldAddNewLastElement() {
        LinkedList<Double> list = new LinkedList<>(new SinglyNode<>(6.9));
        SinglyNode<Double> target = new SinglyNode<>(6.1);
        list.addToLastPosition(target);

        Assertions.assertEquals(target, list.get(list.size() - 1));
    }

    @Test
    public void shouldAddElementToGivenIndex() {
        SinglyNode<Integer> node = new SinglyNode<>();
        node.setContent(10);

        LinkedList<Integer> list = new LinkedList<>(node);
        list.addToLastPosition(new SinglyNode<>(5));

        SinglyNode<Integer> target = new SinglyNode<>(61);
        list.add(target, 1);

        list.addToLastPosition(new SinglyNode<>(85));

        Assertions.assertSame(target, list.get(1));
    }

    @Test
    public void shouldRemoveEntryPoint() {
        LinkedList<Double> list = new LinkedList<>(new SinglyNode<>(6.9));

        SinglyNode<Double> target = new SinglyNode<>(6.1);
        list.addToLastPosition(target);
        list.removeEntryPoint();

        Assertions.assertSame(target, list.get(0));
    }

    @Test
    public void shouldRemoveLastElement() {
        LinkedList<Double> list = new LinkedList<>(new SinglyNode<>(6.9));

        SinglyNode<Double> target = new SinglyNode<>(6.1);
        list.addNewEntryPoint(target);
        list.removeLastPosition();

        Assertions.assertEquals(1, list.size());
        Assertions.assertSame(target, list.get(list.size() - 1));
    }

    @Test
    public void shouldRemoveElementOnGivenIndex() {
        LinkedList<Integer> list = new LinkedList<>(new SinglyNode<>(10));
        list.addToLastPosition(new SinglyNode<>(5));

        SinglyNode<Integer> target = new SinglyNode<>(61);
        list.addToLastPosition(target);

        list.addToLastPosition(new SinglyNode<>(85));

        list.remove(1);

        Assertions.assertSame(target, list.get(1));
    }
}

