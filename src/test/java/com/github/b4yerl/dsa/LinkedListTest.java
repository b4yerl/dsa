package com.github.b4yerl.dsa;

import com.github.b4yerl.dsa.structure.LinkedList;
import com.github.b4yerl.dsa.structure.node.SingleNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void shouldCreateEmptyList() {
        LinkedList list = new LinkedList();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldCreateListOfSize1() {
        SingleNode<Integer> node = new SingleNode<>();
        node.setContent(10);

        LinkedList list = new LinkedList(node);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void shouldGetTheRightElement() {
        SingleNode<Integer> node = new SingleNode<>();
        node.setContent(10);

        LinkedList list = new LinkedList(node);
        list.addToLastPosition(new SingleNode<>(5));

        SingleNode<Integer> target = new SingleNode<>(61);
        list.addToLastPosition(target);

        list.addToLastPosition(new SingleNode<>(85));
        Assertions.assertSame(target, list.getElementByIndex(2));
    }

    @Test
    public void shouldThrowIndexOutOfBoundsException() {
        LinkedList list = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getElementByIndex(5));
    }

    @Test
    public void shouldAddNewEntryPoint() {
        LinkedList list = new LinkedList(new SingleNode<>(6.9));
        SingleNode target = new SingleNode(6.1);
        list.addNewEntryPoint(target);

        Assertions.assertEquals(target, list.getElementByIndex(0));
    }

    @Test
    public void shouldAddNewLastElement() {
        LinkedList list = new LinkedList(new SingleNode<>(6.9));
        SingleNode target = new SingleNode(6.1);
        list.addToLastPosition(target);

        Assertions.assertEquals(target, list.getElementByIndex(list.size() - 1));
    }

    @Test
    public void shouldAddElementToGivenIndex() {
        SingleNode<Integer> node = new SingleNode<>();
        node.setContent(10);

        LinkedList list = new LinkedList(node);
        list.addToLastPosition(new SingleNode<>(5));

        SingleNode<Integer> target = new SingleNode<>(61);
        list.add(target, 1);

        list.addToLastPosition(new SingleNode<>(85));

        Assertions.assertSame(target, list.getElementByIndex(1));
    }

    @Test
    public void shouldRemoveEntryPoint() {
        LinkedList list = new LinkedList(new SingleNode<>(6.9));

        SingleNode<Double> target = new SingleNode<>(6.1);
        list.addToLastPosition(target);
        list.removeEntryPoint();

        Assertions.assertSame(target, list.getElementByIndex(0));
    }

    @Test
    public void shouldRemoveLastElement() {
        LinkedList list = new LinkedList(new SingleNode<>(6.9));

        SingleNode<Double> target = new SingleNode<>(6.1);
        list.addNewEntryPoint(target);
        list.removeLastPosition();

        Assertions.assertEquals(1, list.size());
        Assertions.assertSame(target, list.getElementByIndex(list.size() - 1));
    }

    @Test
    public void shouldRemoveElementOnGivenIndex() {
        LinkedList list = new LinkedList(new SingleNode(10));
        list.addToLastPosition(new SingleNode<>(5));

        SingleNode<Integer> target = new SingleNode<>(61);
        list.addToLastPosition(target);

        list.addToLastPosition(new SingleNode<>(85));

        list.remove(1);

        Assertions.assertSame(target, list.getElementByIndex(1));
    }
}

