package com.github.b4yerl.dsa.structure;

import com.github.b4yerl.dsa.structure.node.SingleNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void shouldCreateEmptyStack() {
        Stack<Object> emptyStack = new Stack<>();
        Assertions.assertTrue(emptyStack.isEmpty());
    }

    @Test
    public void shouldReturnCorrectSize() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(new SingleNode<>(1));
        testStack.push(new SingleNode<>(2));
        testStack.push(new SingleNode<>(3));
        testStack.push(new SingleNode<>(4));
        testStack.push(new SingleNode<>(5));

        Assertions.assertEquals(5, testStack.size());
    }

    @Test
    public void shouldPushElementsToTheTopOnly() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(new SingleNode<>(1));
        testStack.push(new SingleNode<>(2));

        Assertions.assertEquals(2, testStack.peek().getContent());
    }

    @Test
    public void shouldPopElementsOff() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(new SingleNode<>(1));
        testStack.push(new SingleNode<>(2));
        testStack.pop();

        Assertions.assertEquals(1, testStack.peek().getContent());
    }
}
