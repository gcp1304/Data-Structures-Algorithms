package com.jayplabs.trees

import java.util.*

fun inorder(root: TNode<Int>) {
    root.left?.let { inorder(it) }
    root.data.let { print("$it ") }
    root.right?.let { inorder(it) }
}

fun preorder(root: TNode<Int>) {
    root.data.let { print("$it ") }
    root.left?.let { preorder(it) }
    root.right?.let { preorder(it) }
}

fun postorder(root: TNode<Int>) {
    root.left?.let { postorder(it) }
    root.right?.let { postorder(it) }
    root.data.let { print("$it ") }
}

fun levelOrder(root: TNode<Int>) {
    val queue = LinkedList<TNode<Int>>()
    root.let { queue.add(it) }
    while (!queue.isEmpty()) {
        val node = queue.poll()
        node.data.let { print("$it ") }
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
}

fun preorderIterative(root: TNode<Int>) {
    val stack = Stack<TNode<Int>>()
    root.let { stack.push(root) }
    while (!stack.isEmpty()) {
        val node = stack.pop()
        print("${node.data} ")
        node.right?.let { stack.push(it) }
        node.left?.let { stack.push(it) }
    }
}

fun inorderIterative(root: TNode<Int>?) {
    val stack = Stack<TNode<Int>>()
    var node = root
    while (node != null) {
        stack.push(node)
        node = node.left
    }

    while (!stack.isEmpty()) {
        var n = stack.pop()
        print("${n.data} ")
        if (n.right != null) {
            n = n.right
            while (n != null) {
                stack.push(n)
                n = n.left
            }
        }
    }
}


fun main(args: Array<String>) {
    val root = TNode(1)
    root.left = TNode(2)
    root.right = TNode(3)
    root.left!!.left = TNode(4)
    root.left!!.right = TNode(5)
    println("Recursive Inorder traversal of binary tree is")
    inorder(root)
    println("\n Iterative Inorder traversal of binary tree is")
    inorderIterative(root)
    println("\nRecursive Preorder traversal of binary tree is")
    preorder(root)
    println("\nIterative Preorder traversal of binary tree is")
    preorderIterative(root)
    println("\nRecursive Postorder traversal of binary tree is")
    postorder(root)
    println("\nLevel Order traversal of binary tree is")
    levelOrder(root)
}