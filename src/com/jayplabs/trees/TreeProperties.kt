package com.jayplabs.trees

fun maxDepth(root: TNode<Int>?): Int = if (root == null) 0
else {
    val lDepth = maxDepth(root.left)
    val rDepth = maxDepth(root.right)
    (1 + Math.max(lDepth, rDepth))
}

fun main(args: Array<String>) {
    val root = TNode(1)
    root.left = TNode(2)
    root.right = TNode(3)
    root.left!!.left = TNode(4)
    root.left!!.right = TNode(5)
    print("Height of tree is ${maxDepth(root)}")
}