package com.jayplabs.trees

import java.util.*

fun inorder(root: TNode<Int>) {
    root.left?.let { inorder(it) }
    root.data?.let { print("$it ") }
    root.right?.let { inorder(it) }
}

fun preorder(root: TNode<Int>) {
    root.data?.let { print("$it ") }
    root.left?.let { preorder(it) }
    root.right?.let { preorder(it) }
}

fun postorder(root: TNode<Int>) {
    root.left?.let { postorder(it) }
    root.right?.let { postorder(it) }
    root.data?.let { print("$it ") }
}

fun levelOrder(root: TNode<Int>) {
    var queue = LinkedList<TNode<Int>>()
    root?.let { queue.add(it) }
    while (!queue.isEmpty()) {
        var node = queue.poll()
        node.data?.let { print("$it ") }
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
}

fun main(args: Array<String>) {
    var root = TNode(1)
    root.left = TNode(2)
    root.right = TNode(3)
    root.left!!.left = TNode(4)
    root.left!!.right = TNode(5);
    println("Inorder traversal of binary tree is")
    inorder(root)
    println("\nPreorder traversal of binary tree is")
    preorder(root)
    println("\nPostorder traversal of binary tree is")
    postorder(root)
    println("\nLevel Order traversal of binary tree is")
    levelOrder(root)
}