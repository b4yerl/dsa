package com.github.b4yerl.dsa.structure;

import com.github.b4yerl.dsa.structure.node.SinglyNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {
    @Test
    public void shouldCreateEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldEnqueueElementsToTheTail() {
        Queue<Integer> queue = new Queue<>();
        for(int i = 0; i < 5; i++) queue.enqueue(new SinglyNode<>(i));
        SinglyNode<Integer> node = queue.peek();
        while(node.getNextNode() != null) node = (SinglyNode<Integer>) node.getNextNode();
        Assertions.assertEquals(4, node.getContent());
    }

    @Test
    public void shouldDequeueFirstElement() {
        Queue<Integer> queue = new Queue<>();
        for(int i = 0; i < 5; i++) queue.enqueue(new SinglyNode<>(i));
        Assertions.assertEquals(0, queue.dequeue().getContent());
        Assertions.assertEquals(1, queue.peek().getContent());
    }
}
