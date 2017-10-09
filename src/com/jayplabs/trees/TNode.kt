package com.jayplabs.trees

data class TNode<T>(var data: T, var left: TNode<T>? = null, var right: TNode<T>? = null)