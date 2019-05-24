package com.example.access;

/**
 * Challenge
 * In the following interface declaration, what is the visibility of:
 * 1 the accessible interface
 * 2 SOME_CONSTANT
 * 3 methodA()
 * 4 methodB() and methodC()
 *
 * My answers
 * 1. package-private,
 * 2. package-private,
 * 3. package-private, public within package-private interface
 * 4. package-private
 *
 * I was mostly wrong, trick question.
 * 1. package-private
 * 2. all interface variables are implicitly public static final (constants)
 * 3. public
 * 4. public, all interface methods are implicitly public (and abstract)
 */
interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}
