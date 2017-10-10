package com.jayplabs.trees

import java.util.*


fun withStack(root: TNode<Int>?) {
    if (root == null) return
    var stack = Stack<TNode<Int>>()
    var node: TNode<Int>? = root
    while (node != null) {
        stack.push(node)
        node = node.left
    }

    while(!stack.empty()) {
        node = stack.pop()
        print("${node.data} ")
        if (node.right != null) {
            node = node.right
            while (node != null) {
                stack.push(node)
                node = node.left
            }
        }
    }

}

fun main(args: Array<String>) {
    var root =  TNode(1)
    root.left = TNode(2)
    root.right = TNode(3)
    root.left!!.left = TNode(4)
    root.left!!.right = TNode(5);
    root.left!!.left!!.right = TNode(6)
    withStack(root)
}
