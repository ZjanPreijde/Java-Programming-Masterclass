## Java Programming Masterclass for Software Developers

Udemy Course :
https://www.udemy.com/java-the-complete-java-developer-course/learn/v4/overview

*14-01-2019 - ...*										[Go to Bottom](#bottom)	<a name="top"></a>

| Section    | Description                                                | Finished   |
| ---------- | ---------------------------------------------------------- | ---------- |
| [Section 1](#section-01) | Course Introduction                                        | 14-01-2019 |
| [Section 2](#section-02)  | Setup and First Steps                                      | 14-01-2019 |
| [Section 3](#section-03)  | Variables, Datatypes and Operators                         | 16-01-2019 |
| [Section 4](#section-04)  | Expressions, Statements, Code blocks, Methods and more     | 17-01-2019 |
| [Section 5](#section-05)  | Control Flow Statements                                    | 24-01-2019 |
| [Section 6](#section-06)  | OOP Part 1 - Classes, Constructors and Inheritance         | 25-01-2019 |
| [Section 7](#section-07) | OOP Part 2 - Composition, Encapsulation, and Polymorphism  | 28-01-2019 |
| [Section 8](#section-08) | Arrays, Java inbuilt Lists, Autoboxing and Unboxing        | 31-01-2019 |
| Section 9  | Inner and Abstract Classes & Interfaces                    |            |
| Section 10 | Java Generics                                              |            |
| Section 11 | Naming Conventions and Packages. static and final keywords |            |
| Section 12 | Java Collections                                           |            |
| Section 13 | JavaFX                                                     |            |
| Section 14 | Basic Input & Output including java.util                   |            |
| Section 15 | Concurrency in Java                                        |            |
| Section 16 | Lambda Expressions                                         |            |
| Section 17 | Regular Expressions                                        |            |
| Section 18 | Debugging and Unit Testing                                 |            |
| Section 19 | Databases                                                  |            |
| Section 20 | Java Networking Programming                                |            |
| Section 21 | Java 9 Module System                                       |            |
| Section 22 | Migrating Java Projects to Java 9                          |            |
| Section 23 | Archived Videos                                            |            |
| Section 24 | Bonus Material                                             |            |

<a class="page-break" name="section-01"></a>

### Section 1, Course Introduction

*14-01-2019, finished 14-01-2019*											[Go to Top](#top)	[Go to Bottom](#bottom) 

<a name="section-02"></a>

### Section 2, Setup and First Steps

*14-01-2019, finished 14-01-2019*											[Go to Top](#top)	[Go to Bottom](#bottom) 

We'll be using JDK11, and IntelliJ IDEA as IDE (Integrated Development Environment).

He says he recorded this video in October 2019 :-)

JDK (Java Development Kit) helps you write and compile Java programs, run programs with JVM (Java Virtual Machine, with JRE (Java Runtime Edition).

JDK is needed to write Java programs.

Which version? Oracle has started to charge for Java. There is something called open(-source) JDK, so you don't need to pay to use Oracle JDK. Oracle JDK is business orientated, they charge businesses. Just use the Oracle version.

Blog Java 11 : https://learnprogramming.academy/programming/java-11-has-arrived-is-it-time-to-panic/

#### Installing JDK 11 on a Linux Machine

Oracle website : https://www.oracle.com/technetwork/java/index.html

Download JDK from : https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html

```bash
$ cd /Downloads/Jdk11
$ tar -xvf jdk-11.0.1_linux-x64_bin.tar.gz
$ sudo mkdir -p /usr/lib/jvm/jdk-11
$ sudo mv jdk-11.0.1/* /usr/lib/jvm/jdk-11
$ sudo update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-11/bin/java" 1010
$ sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-11/bin/javac" 1010
```

I already had Java8 installed, so had to do some `update-alternatives`-magic to activate Java11.

#### Installing and Configuring IntelliJ IDEA on a Linux Machine

Jetbrains website  : https://jetbrains.com

Download from : https://www.jetbrains.com/idea/download/#section=linux

Open file explorer, go to Downloads/IntelliJ, right click *ideaIC-2018.3.3.tar.gz*, choose *Extract here*.

Move the folder *idea-IC-183.5153.38* anywhere you want it, into */Software* in my case.

Open terminal 

```bash
$ cd /Software/idea-IC-183.5153.38/bin
$ ./idea.sh &
```

This starts IntelliJ IDEA installation wizard

- first window press OK
- then Accept
- then Usage Statistics
- then choose Theme
- then check *Create a desktop entry*
- then check *Create a script for opening files and projects* from the command line, leave *path* as is
- then leave Default plugins as is
- then choose Featured plugins, I chose *Scala* and *IDE Features trainer*
- then enter system password
- IntelliJ IDEA starts.

Tim gives lots of configuration tips, click *Configure* in bottom Welcome screen.

*Project Defaults - Project Structure*

- Project SDK : 11
- Project language level : 11

*Settings - Editor - General - Auto Import*

- check *Add unambiguous ...*  and  *Optimize imports ...*

*Settings - Editor - General - Code folding*

- uncheck *imports* , *One-line methods*, *Closures* and *Generic constructors ...*



Convention is Java class names start with capital.

Created first HelloWorld Java class, it runs in IntelliJ and in terminal in ./out/production/S02-HelloWorld

```java
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
  }
}
```

`$ java Hello` returns : `Hello World!`

`$ java Hello.class` returns an error!  It will try to run a function wrapped in Hello (?)

`main(String[] args)` means that any given arguments are strings,. When you run `$ java myProgram multiply 2 3`, `args[0] == "multiply"`, `args[1] == "2"` and `args[2] == "3"`.

<a class="page-break" name="section-03"></a>

### Section 3, Variables, Datatypes and Operators

*15-01-2019, finished 16-01-2019*											[Go to Top](#top)	[Go to Bottom](#bottom) 

IntelliJ has shortcuts to templates, if you type `sout + <Tab>`, it expands to `System.out.println()`

#### Variables (Lecture 16)

Variable names are case sensitive!

When declaring a variable for the first time, you start with the data type. When reassigning a value, the data type does not need to be given again.

There are 8 primitive data types (byte, short, int, long, float, double, char, boolean), `char` is not same as `String`, there is no primitive data type for a string.

`String` is a Java class with special support. Normally you would have to write `String myString = new String("myString")`, but `new String()` can be left out.

Oracle says :

> `String` objects are *immutable*, which means that once created, their values cannot be changed.

but also says :

> **Note:** The `String` class is immutable, so that once it is created a `String` object cannot be changed. The `String` class has a number of methods, some of which will be discussed below, that appear to modify strings. Since strings are immutable, what these methods really do is create and return a new string that contains the result of the operation.

so reassigning a value is no problem.

Declare a variabale : `<datatype> <varName> = <value> ;`

Some types have extra character after value to indicate type

- `L`, `long`, `long myLong = 0L;`
- `f`, `float`, `float myFloat = 0f;`
- `d`, `double`, `double myDouble = 0d;`

Declare multiple variables of same type: `int one = 1, two = 2;`

Declare multiple variables of different types in one statement is not possible.

Reassigning a value : `<varName> = <anotherValue> ;`

- char myChar = "a" ; myChar = "b";
- int myInteger = 5 + 7 - (3 * 2) ; myInteger = "10;
- String myString = "abcdefg" ; myString = "hijklmnop";
- boolean myBoolean = false ; myBoolean = true ;
- double myDouble = 3.1415d ; myDouble = (double) (10 / 3) ; 



#### Primitive Data Types - The Byte, Short, Int and Long (Lecture 17)

For integers, you would usually use `int` as data type (32-bit). Because of memory concerns or if `int` is not big enough, you can also use other primitive types.

- `byte`, default `0`, value -2⁸ to 2⁷ - 1, -128 to 127 (inclusive)
- `short`, default `0`, value -2¹⁶ to 2¹⁶ - 1, -32,768 to 32,777 (inclusive)
- `int`, default `0`, value  -2³¹ to 2³¹ - 1, -2,147,483,648 to 2,147,483,647 (inclusive)
- `long`, default `0L`, value -2⁶³ to 2⁶³ - 1, -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (inclusive)
- long is assigned a value with l or L behind number, use L for readability. `long myLong = 100L;`

In Java, you can use underscores as seperators to make large numbers better readable. Seperator can not be placed at beginning, or end, or before or after a decimal point.

```java
int  myLargeNumber  = 2_147_483_647 ;
int  mySocialNumber = 1234_56_789 ;
long myCreditCardNr = 1234_5678_1234_5678L ;
```

**Value wrapping :** If you give an integer the maximum value and add 1, the result is its min value. And vice versa with subtracting 1 from minimum value. So if an integer exceeds the boundaries, it will wrap to the opposite.

<a name="casting"></a>**Casting:**  Java converts results of calculations with all integers to `int`, to make sure the result fits in `byte` and `short` use `(datatype)` just before calculation : 

```java
byte myByteValue = 100 ;
// No problem, int goes in to int
int myIntvalue = myByteValue / 2 ;
// int maybe does not fit into byte, cast with (byte), 
//  tells Java to cast result to type byte
// When casting, put expressions between parentheses
byte myByteCalc = (byte) (myByteValue / 2) ;
short myShortCalc = (short) (100000 + 50 * (myByteValue / 2)) ;
// Not needed for long, because int fits easily into long
long  myLongCalc = 100000L + 50L * (myByteValue / 2) ;
```

That's also a reason why just using `int` is easier.

#### Primitive Data Types - The Float and Double (Lecture 18)

Two data types to deal with numbers that decimals, `float` and `double`. `double` has double the precision that `float` has.

- `float`, 32-bit precision floating point, default `0f`
- `double`, 64-bit precision floating point, default `0d`, takes up twice the space in memory

`float` is less precise than `double`, the conversion cannot be performed implicitly.

like `long`, `float` and `double` have a symbol behind the number when assigning a literal.

When using a decimal point in a number or calculation, Java treats the number or result as `double`.

```java
int    myIntValue     = 5;
float  myFloatValue1  = 5f;
float  myFloatValue2  = 5.25f;
float  myFloatValue3  = (float) (5.25); // Decimal point -> double, cast to float
float  myFloatValue4  = (10f / 3f);     // No decimal point -> int, cast to float
double myDoubleValue1 = 5d ;
double myDoubleValue2 = (double) (5)
double myDoubleValue3 = 5.25 ;          // Decimal point -> double
double myDoubleValue4 = (10d / 3d);
double myDoubleValue5 = 10.0d / 3d;     // Decimal point -> double
```

`double` is often faster on newer computers.

`double` is used in internal Math methods (cos(), sin(), ...).

`double` is far more precise.

So, use `double`s :-)

#### Primitive Data Types - The Char and Boolean (Lecture 19)

- `char`, 16-bit, default `'\u0000'`, 1 character or Unicode code character

- value assigned with single quotes!

  - ```java
    char myChar1 = 'a';
    char myChar2 = '\u00A9'; // (c)
    char myChar3 = '\u00AE'; // (tm)
    char myChar4 = '\u20AC'; // euro sign 
    ```

- `boolean`, 1-bit, default `false`, `true` or `false`

Unicode-table:

https://unicode-table.com/en

Unicode is extended (24-bit?), now holds more than 16-bit `char` can hold, so `char` can not represent all Unicode characters.



#### Strings and Finish up Primitives (Lecture 20)

`String` is not a primitive data type, it is a `class`. But it is so strongly integrated in Java language that it is used like a primitive. You can declare a `String` type variable the same way as primitives.

- all primitives have a corresponding default value

- as String is an object (instance of class String), it's default value is `null`

- value assigned with double quotes! 

- char and String are surprisingly incompatible

  - ```java
    char a = 'a'; char b = 'b'; 
    String ab = a + b;      // -> Error
    String ab = "" + a + b; // -> Works fine
    ```

```java
String myString1 = "This is a string";
System.out.println("myString : " + myString1);
myString1 += ", it has one or more characters";
System.out.println("myString1 : " + myString1);
// Other primitives concatenated and transformed to String by Java
int myInt = 50
myString2 = "The price is \u20AC " + myInt;
boolean myBoolean = false;
myString3 = "My dog is " + myBoolean;
```



#### Operators  and Operator Precedence in Java (Lecture 21/22)

- value assignment, `=`, `int sum = 1; String string = "";`
- concatenate, `+`, `String result = "res" + "ult";`
  - concatenating String with primitive will cause primitive to be stringified.
  - int + false + String + double will also be converted to String.
- arythmic, `+-*/%`, `%` is modulus (remainder), `int sum = 10; int rem = sum % 4; // rem = 2`
- quick add 1, `++`, `int myIndex = 10; myIndex++; // now 11`
- quick subtract 1, `--`, `int myIndex = 10; myIndex--; // now 9`
- quick concatenate, `+=`, `String result = "res"; result += "ult"; // now "result"`
- quick add/subtract n, `+=`, `-=`, `int myIndex; myIndex += 7; myIndex -= 5; // now 2`
- quick multiply/divide/remainder n, `*=`, `/=`, `%=`
- logical not, `!`, `!(<comparison>)`, `boolean isDone = false; isDone = !isDone; // now true`
- logical and/or, `&&,` `||`
- is equal, is not equal, `==`, `!=`   (learned later: to compare object values use `.equals()`)
- Java does <u>not</u> know  is not equal `<>` 
- is greater than/is greater than or equal to, `>`, `>=`
- is less than/less than or equal to, `<`, `<=`
- when comparing expressions, put expressions between parentheses ( = round brackets)
- as `=` assigns a value, make sure you use `==` in comparisons
  - `boolean isCar = false; if (isCar = true) ...;`
  - will set `isCar`  to `true` and expression evaluates to `true`
  - `int balance = 100000; if (balance = 0) ...;`
  - will set `balance` to `0` and expression evaluates to `true`
- ternary operator, `<expression> ? <value-if-true> : <value-if-false>;`
- precedence, `int result = 50 + 50 * 50;` value is 2550, `int result = (50 + 50) * 50;` value is 5000

Summary of operators : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html

Java Operator Precedence Table : http://cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

<a class="page-break" name="section-04"></a>

### Section 4, Java Tutorial: Expressions, Statements, Code blocks, Methods and more.

*16-01-2019, finished 17-01-2019*										[Go to Top](#top)	[Go to Bottom](#bottom) 

#### Keywords and Expressions (Lecture 24)

Java keywords : https://en.wikipedia.org/wiki/List_of_Java_keywords

> In the Java programming language, a keyword is one of 61 reserved words that have a predefined meaning in the language; because of this, programmers cannot use keywords as names for variables, methods, classes, or as any other identifier.

`const` is reserved, but is not used and has not function, for defining constants use `final`.

`goto` is reserved, but is not used and has not function.

`void`, was wondering about that. It is used to declare that a method does not return any value.

- `double kms = (100 * 1.609344);` : `kms = (100 * 1.609344)` is an expression
- `int miles = 100;` : `miles = 100` is an expression, `100` is a literal
- `String myString = "This is a literal";` : `myString = "This is a literal"` is an expression, `"This is a literal"` is a literal
- `System.out.println("This is an expression");` : `"This is an expression"` is an expression, because it's an argument in a method call.
- `if (score > 99) {...}` : `score > 99` is an expression

#### Statements, Whitespace and Indentation (Code organisation) (Lecture 25)

`int myInt = 50;` is a statement, `myInt = 50` is an expression, `50` is a literal.

Semi-colon is used to end Java statement.

- you can use multi-line statements and end with a semi-colon
- you can put multiple statements on one  line as long as you end each one with a semi-colon.

`if (<expression>); <do something>;` `if` statement will check nothing, it has finalized.

Whitespace is needed between keywords and identifiers. Many times extra whitespace makes code more readable. Unnecessary whitespace is ignored by Java, use as much as you want.

Identation also helps making code readable, Java does not need it. Do it as much as you like

#### Code Blocks And The If Then Else Control Statements (Lecture 26/27)

With one-line statements after an if statement, you can just finish with a colon.

```java
int  myInt = 500;
if (myInt > 450) System.out.println("Jeez, your Int is high!");
```

When multiple statements follow the if statement, you make a code block with { }.

```java
int myInt = 500;
if (myInt > 450) {
  System.out.println("Jeez, your Int is high!" + " I will give you a bonus");
  int myIntNow = myInt + 100;
  System.out.println("Your Int was " myInt + ". It is now " + myIntNow);   
}
```

Recommended is to use code blocks always, also when 1 statement after `if` test.

```java
if (<logical-expression1>) {
    // <logical-expression1> evaluates to true
	; // Statement
} else if (<logical-expression2>) {
    // <logical-expression1> evaluates to false
    // <logical-expression2> evaluates to true
	; // Statement
} else if (<logical-expression3>) {
    // <logical-expression1/2> evaluate to false
    // <logical-expression3> evaluates to true
	; // Statement
	; // Statement
} else {
    // <logical-expression1/2/3> evaluate to false
	; // Statement
}
```

After one of the code blocks is executed, code jumps to first line after last curly brace (`}`).

Within the code block variables declared outside the code block are accessible.

Variables declared inside code block are not accessible outside the code block, *scope* is limited to code block.

#### Methods in Java (Lecture 28/29/30)

Repeating code can be put in an other method, so it can be called multiple times (DRY = Don't Repeat Yourself). Also for readability it is useful to put blocks of code in an other method. Methods need meaningful names, so code blocks they are called from remain readable without too many comments.

Methods can receive arguments

```java
public static void myMethod1(boolean myBoolean, int myInt, String myString) {
  // Code goes here
}
```

`public static void`, void means no result send back from method.

In stead of `void`, you can specify what data-type is returned, so you do need `return` in code block.

```java
public static boolean higherThan5( int intArg ) { return intArg > 5; }
boolean higher = higherThan4(8);
public static int sumInts(int intOne, int intTwo) { return intOne + intTwo; }
int sum = sumInts(1, 2);
```

According to the teacher, in programming terms, return -1; is conventially used to indicate an error, and in searching algorithms, -1 indicates `invailid value` or `value not found`. Hmmm, OK.

*Procedure* as a term can also be used to indicate a method that returns nothing (`void`).

In general, *function* as a term can also be used to indicated a method.

#### DiffMerge Tool Introduction/Installation/Usage (Lecture 31/32/33)

> DiffMerge is a program that will help you to visually compare and merge files on any operating system.
>
> It can be very helpful with programming as well.
>
> Some other tools like code repositories use similar merge operations, so this will also help you in the future when you start working with code repositories

It is easy to make a typo when coding, and get stuck. This is where DiffMerge can help.

By downloading the teachers code, and comparing it to own code with DiffMerge, it is easier to find errors/typos. You can compare a single file, or a whole folder.

Website : https://sourcegear.com/diffmerge

Download from : https://sourcegear.com/diffmerge/downloads.php

Does not seem to be really maintained any more, download for *Ubuntu **12.04** LTS*, *copyright site **2017***.

At download location in Terminal :

```bash
$ sudo dpkg -i diffmerge_4.2.0.*.deb
```

When loading files/folders to compare in DiffMerge, load the troublesome code in the right window, DiffMerge only allows for applying changes Left-to-Right. When starting DiffMerge and choosing folders, DiffMerge remembers the last chosen folders, and has a button *Swap*.

Once code is loaded, and through other program code has changed, DiffMerge will notice and ask whether Reload is desired.

Some files and folders should be excluded from DiffMerge, some can not even be read by DiffMerge (e.g. `.class`)

Start DiffMerge, go to Tools - Options, select Folder Windows - Folder Filters. 

- Make sure *Use Filename Filters* is checked, add `*.class` to field under *Use Filename Filters.*
  - and/or (`out` until now has only had `.class` files in it, maybe more later?)
- Make sure *Use Sub-folder Filters* is checked, add `out` to field under *Use Sub-folder Filters*
- Make sure *Use Sub-folder Filters* is checked, add `.idea` to field under *Use Sub-folder Filters*

#### Coding exercises (Lecture 34)

Udemy feature, enter your code in Udemy exercise, have your solution checked right away with click on a button.

While coding in IntelliJ we will need a *main* method for testing, when copying to exercise, leave this one out.

All exercises went well, result in *JavaPrograms/Section-04/S04-05-Exercises*.

#### Method Overloading (Lecture 35/36/37/38)

> Method Overloading is a feature that allows a class to have more than one method having the same name, if their argument lists are different. It is similar to constructor overloading in Java, that allows a class to have more than one constructor having different argument lists.

Using the method with the same name, but with a different number of parameters. Just specifying a  method with the same name and a different number of parameters, is overloading the method. Java looks for a method with the given name and the given number of arguments.

```java
public static void main(String[] args) {
	myMethod(1, " = one")
	myMethod(1, 1, " = two") }
public static void myMethod(int iOne, String sOne) {
	System.out.println(iOne + iOne) }
public static void myMethod(int iOne, int iTwo, String sOne) {
	System.out.println((iOne + iTwo) + iOne) }
```

Java will check whether given arguments are of the right data type. IntelliJ will also try and give an error indication when clearly wrong.

Unique method signature is method name and number and type of arguments.

Method overloading is commonly used in Java.

- Improves code readability and re-usability
- Is asier to remember one method name instead of multiple names.
- Achieves consistency in method naming.
- Gives programmers the flexibility to call a similar methods with different types of data

Constants in class, use `final`. More on this later.

```java
public class Main {
  private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
  public static void main(Strings[] args) {
  /* write your code here, or not, whatever */   } } // end class
```



<a class="page-break" name="section-05"></a>

### Section 5, Control Flow Statements

*17-01-2019, finished 24-01-2019*										[Go to Top](#top)	[Go to Bottom](#bottom) 

CFS's dealt with  here :

```java
switch ( <value> ) { case <value>: <code> break; default: <code> } //  (break;)
for    ( <exp> )   { <code> }      //  (break; - continue;)
while  ( <exp> )   { <code> }      //  (break; - continue;)
do     { <code> }  while ( <exp> ) //  (break; - continue;)
```

#### Switch Statement (Lecture 40/41)

Can replace `if () {} else if() {} else if() {} else {}` statement, if same value is compared to specific single values in each expression.

```java
switch (<checkValue>) {
  case <value1>:
    // code for checkValue == value1
    break;
  case <value2>:case <value3>:
    //code for checkValue == value2/value3
    break;
  case <value4>:
  case <value5>:
    //code for checkValue == value4/value5
    break;
  default:
    // code if none of above conditions is met
    break; /* Not really necessary, but recommended to do it anyway*/ } // end switch
```

#### For Loop (Lecture 42/43/44)

Enables executing a code block (0-n) times.

```java
for ( <init> ; boolean <loop-while-expression> ; <increment-by> ) { /* code */ }
// Repeat 10 times
for ( int i = 0; i < 10; i++ ) { /* code */ }
// Increment by 2, repeat 5 times, int = 0, 2, 4, 6, 8
for ( int i = 0; i < 10; i+=2 ) { /* code */ }
for ( int i = 0; i < 10; i++ ) {
  if (i == 3) continue; // jump to end loop, code below not executed
  /* code, not executed if i == 3 */
  if (i == 7) break;    // jump to end loop and exit loop
  /* code, not executed if i == 3 or i == 7 */  } // end for
```

The `<init>` will be incremented with `<increment-by>` each time the loop reaches the end of the code block. Then the loop returns to the top and validates the `<loop-while-expression`. When it evaluates to `false`, the loop is exited.

- `continue;` jumps to the end of the loop, continues loop if `<loop-while-expression>` is still met after incrementing.
- `break;` exits the loop immediately.

Look out for Endless Loops.

There is als `forEach`, will be dealt with later.

#### While - Do While Loop (Lecture 45/46/47)

In stead of looping a maximum defined number of loops, you might want to loop until a condition is met.

```java
// First checks, then executes
while (<loop-while-expression>) { /* code */ }
// First executes (at least once!) then checks
do { /*code */ } while (<loop-while-expression); // !! semi-colon !!
// Apparently often used :
while (true) { if (<loop-end-condition>) break; /* code */ }
```

No initialization or incrementation as `for() {}`-loop has, if needed must be done by code.

Look out for Endless Loops.

- `continue;` jumps to the end of the loop, continues loop if `<loop-while-expression>` is still met.
- `break;` exits the loop immediately.

`do { /* code */ } while (<loop-while-condition>);` **executes at least once**, then checks loop condition!

#### Parsing Values from a String (Lecture 48)

Data type classes have methods to convert one type into another. Class names start with a capital.

Converting a String into some other data type.

- e.g. from user input from console or user interface.

Convert into primitive data type

- `int number = Integer.parseInt("2019");`  -> number == 2019
  - invalid content of argument will throw exception `NumberFormatException:`
- `double number = Double.parseDouble("2018.125");` -> number == 2018.125


Some very difficult exercises, but did them (S05-07-Exercises).



#### :-( Computer broke down

While upgrading Ubuntu to 18.04 LTS I botched it mid-install. I should not do this in the middle of the night. Took me days to try to fix it. All data salvaged, clean new install over the crashed one, data restored. Lets move on :-)



#### Aside :  running from the shell prompt

Not (yet) in course :

IntelliJ stores a compiled class in `out/production/<ProjectName>`. To run a class from the shell prompt :

- if no package was used : `java <ClassName>` 
  - `$ java Helloworld`
- if a package was used : `java package.path.<ClassName>`
  - `$ java com.masterclass.Main` 




#### Reading User Input (Lecture 49/50/51/52)

Class called *Scanner*, simple text scanner, that can parse primitive types and strings.

It uses methods like `.parseInt()` internally. Method `.next()` returns result.

We've been outputting to screen with `System.out`, now will pass  `System.in` to the class Scanner, and let and Scanner parse the input from the screen.

```java
// Create an instance of class Scanner
Scanner scanner = new Scanner(System.in);
System.out.println(" Enter your name : ");
String name = scanner.nextLine();
scanner.close();
System.out.println("Your name is " + name);
```

`.nextLine()` returns the input as a string

It also has methods to handle other data types :

```java
// In stead of 
System.out.println(" Enter your year of birth : ");
int yearOfBirth = Integer.parseInt(scanner.nextLine());
// you can 
System.out.println(" Enter your month of birth : ");
int monthOfBirth = scanner.nextInt();
scanner.nextLine();
```

! After using `.nextInt()` to retrieve an integer, there is still a *next line character* in the buffer, from pressing `<Enter>` confirming the input. We must clear the buffer by just calling `scanner.nextLine()`.

Entering text when being asked for input through `.nextInt()` will result in an error.

```java
boolean hasNextInt = scanner.hasNextInt();
if (hasNextInt) { int number = scanner.nextInt(); scanner.nextLine(); }
```

```java
int min = Integer.MIN_VALUE;
int max = Integer.MAX_VALUE;
```

Scanner can only be instantiated once!!

```java
package com.masterclass;
import java.util.Scanner;
public class Main {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    calcMinMax(scanner); /* runs fine */
    calcMinMax(scanner); /* runs fine as well */
    scanner.close();  }
  private static void calcMinMax(Scanner scanner) { /* code ... */  }  } // end class
```

<a class="page-break" name="section-06"></a>

### Section 6, OOP Part 1 - Classes, Constructors and Inheritance

*24-01-2019, finished 25-01-2019*										[Go to Top](#top)	[Go to Bottom](#bottom) 

#### Classes (Lecture 54/55)

OOP, Object Oriented Programming, Classes, Objects, Constructors, Inheritance.

Real world objects have state and behavior.

Objects have fields(/properties) and methods.

In IntelliJ in project explorer, click on *src*, then right click on *package.name*, choose *New*, choose Java *class*, enter name (first letter capital). Now new `<Name>.java` is created along the original `Main.java`.

```java
// Car.java
package com.masterclass;
public class Car {
  // State, encapsulated, not accessible
  private String brand, model; // defaults null, null
  private int doors, wheels;   // defaults 0, 0
  // State, accessible
  public  String description;  // default null

  public void   setModel(String model) { this.model = model; } /* setter */
  public String getModel()             { return this.model;  } /* getter */ } //<-class
```

`public` is an *access modifier*, what access do we allow others to this class.

- `public class`, unrestricted access.
- `private class`, no other class can access this method/variable.
- `protected class`, allows classes in same *package* access

*Encapsulation*, only allow object to access its fields `private int doors;`.

Java automatically adds extra functionality to created classes,  because the new class automatically is sub-classed from class *Object* and gets all the functionality class *Object* has.

For *encapsulated* fields, you need setters to set a value and getters to get a value. Public fields can be directly set and gotten.

Set-methods are a good place to do validation (and manipulate other encapsulated data).

Now the *Car* class is available.

```java
// Main.java
package com.masterclass;
public class Main {
  public static void main(String[] args) {
    Car porsche = new Car();
    porsche.setModel("Carrera");               /* needs a 'setter'    */
    String myModel = porsche.getModel();       /* needs a 'getter'    */
    porsche.description = " This a nice car";  /* directly accessible */
    String myDescription = porsche.description /* directly accessible */ } } //<- class
```

#### Constructors (Lecture 56/57)

With a constructor you can set fields immediately when creating the object or initialize fields with default values.

Constructor method is `public`, does not need a return data type/`void` or `static` and has exactly the same name as the class, case-sensitive.

Constructor methods can also be *overloaded*, and can call other constructors through `this()`.

Calling another constructor **must** be the first statement in the constructor code block.

```java
// Main.java
	// ...
	Car porsche = new Car("Porsche", "911", 4, 3); // "Porsche", "911", 4, 3
	Car lincoln = new Car("Lincoln", "Town Car");  // "Lincoln", "Town Car", 4, 4
	Car other   = new Car()                        // "Brand", "Model", 4, 4
```

```java
// Car.java
	// ...
	private String brand, model; // defaults null, null
    private int doors, wheels;   // defaults 0, 0
	public Car() { /* Empty constructor called*/ 
    this(4, 4); } /* calls constructor with params */
	public Car(int doors, int wheels) {
    this("Brand", "Model", doors, wheels); }
  public Car(String brand, String model, int doors, int wheels) {
    this.brand = brand; this.model  = model;
    this.doors = doors; this.wheels = wheels; }
```

In the constructors the setter methods `setValue(value);` can be used. There is discussion in the community about what should be used. There are scenario's where setter methods do not work. By setting the value directly using `this.value = value;`, that will not be a problem.

#### Inheritance (Lecture 58/59)

Objects often share common characteristics (state and/or behavior). By creating an umbrella class for them you only have to code for the common characteristics once, and then code for the  characteristics of the specific object.

To use the constructor of the parent class in the sub class, we use `super()`.

> If your method overrides one of its superclass's methods, you can invoke the overridden method through the use of the keyword `super`.
>
> Invocation of a superclass constructor must be the first line in the subclass constructor.

If you want to execute a method in the superclass, you use `super.methodName()`. Both methods can **not** be `static`.


```java
public class Person { 
  private String name; private int age; private String occupation;
  public Person(String name, int age, String occupation) {
    this.name = name; this.age = age; this.occupation = occupation; }
  public void printData() {
    System.out.println(occupation + " " + name + " is " + age + " years old."); }
} // end class
public class Student extends Person {
  private String studies;
  public Student(String name, int age, String studies) {
    super(name, age, "Student");   /* sets name, age, occupation */
    this.studies = studies;	} 
  public void printData() {
    super.printData();             /* prints occupation, name, age */
    System.out.println(name + " studies " + studies) }
} // end class
public class Teacher extends Person { 
  private String teaches; 
  public Teacher(String name, int age, String teaches) {
    super(name, age, "Teacher");   /* sets name, age, occupation */
    this.teaches = teaches;	}
  public void printData() {
    super.printData();     /* prints occupation, name, age */
    System.out.println(name + " teaches " + teaches) }
  public void printDataReverse() {
    System.out.println(name + " teaches " + teaches) 
    super.printData();     /* prints name, age, occupation */  }
} // end class
```

You can call any method in the superclass with `super.`. If a method is defined in the superclass, but not in the subclass, you don't have to use `super.`.

And if you would like to alter the functionality, you can just create a method with the same name in the subclass and that will automatically be called in stead of the method in the superclass (where ofcourse you can call `super.methodName()` ).

#### Reference vs Object vs Instance vs Class (Lecture 60)

A *class* is a blueprint, using this blueprint we can make as many *objects* as we want based on that *class*.

An *object* is built based on a *class* (*instantiated* using the `new` operator), also known as an *instance* of that *class*.

Each object has a location (in memory), this is known as a *reference*.

*References* can be copied, they will still point to the same *object*.

*References* can be passed as *parameters* to *constructors* and *methods*.

```java
  Object myObj1 = new Object();
  Object myObj2 = myObj1;  // myObj1 and myObj2 reference to the same object
```

#### this vs super (Lecture 60)

Keyword `super` is used to access/call parent class members (variables/fields and methods).

In a *constructor* `super()` is called to call the superclass *constructor*, it **must** the first statement.

Anywhere else the syntax is `super.someField` / `super.someMethod()`

Keyword `this` is used to access/call current class members. `this` is required when we have a parameter with the same name as an instance variable (field). (not a great explanation.)

! Both can be used anywhere in a class, **except `static`** areas (the static block or a static method). More on `static` later.

`this` commonly used in *constructors* and *setters*, optionally in *getters*.

`this()` is used to call a *constructor* from another overloaded *constructor* in the same *class*, can only be used in a *constructor* and  **must** be the first statement.

The Java compiler puts a default call to `super()` (no arguments) if we don't add it.

Even *abstract classes* have *constructors*, but can not be *instantiated* using the `new` keyword.

An *abstract class* is still a *super class*, so its *constructors* run when someone makes an *instance* of a *concrete subclass*.

! A *constructor* can have a call to `super()` or `this()`, but never both.

*Constructor chaining*, the last constructor has the *responsibility* to initialize the fields. No matter with how many arguments we *instantiate* the *class*, the last *constructor* will do the initialization.

```java
class  ClassName {
  private int a, b;
  public ClassName()             { this(0); }
  public ClassName(int a)        { this(a, 0): }
  public ClassName(int a, int b) { this.a = a; this.b = b; } }
```

```java
class Shape { 
  private int x, y; 
  public Shape(int x, int y) { this.x = x; this.y = y; } } // end class
class Rectangle {
  private int width, height;
  public Rectangle(int width, int height) { this(width, height, 0, 0); }
  public Rectangle(int width, int height, int x, int y) {
    super(x, y);
    this.width = width; this.height = height; } } // end class
```

#### Method Overloading vs Overriding Recap (Lecture 61)

Method Overloading

- providing multiple methods with same name but different arguments (type/count)
- return type may be different, allows for reuse of the same method name
- very handy, reduces duplicated code, no need to remember different method names
- nothing to do with *polymorphism*, but often referred to as *Compile Time Polymorphism*
- compiler decides which method to be called, based on method name, return type and arguments
- `static` and *instance methods* can be overloaded. More on `static` / *instance method* later
- happens usually inside a single *class*, but a method can also be treated as *overloaded* in the *subclass* of that *class*, because *subclass* *inherits* one version of the method from the *superclass* and can then have another *overloaded* version of the *method*
- overloaded methods **must**
  - have same name
  - have different arguments (type/count)
- overloading methods **may**
  - have different return types
  - have different access modifiers (`private` / `protected` / `default` / `public`)
  - throw different checked or unchecked exceptions (more on this later)

Method overriding

- by extending the superclass, the subclass gets all the superclass'  methods (these are called derived methods)
- defining a method in a subclass that already exists in the superclass, with the same *signature* (name, arguments type/count)
- also known as *Runtime Polymorphism* and *Dynamic Method Dispatch*, because method to be called is decided at runtime by the *JVM* (Java Virtual Machine)
- recommended to put `@Override` immediately above method definition. Annotation read by compiler, will show us if overriding rules are not followed correctly
- `static` methods can **not** be overwritten, only *instance* methods
- overriding methods **must**
  - override an *inherited* method
  - override a method that is **not** a *constructor*, `private` method or `final` method
  - have same or higher  *access modifier* (`public` etc)
  - have same *signature* (name, arguments type/count)
  - have same *return type* or *subclass* thereof
- overriding methods **may**
  - use `super.methodName()` to call the *superclass* version of the overridden method

Example of *subclass thereof*, covariant return type :

```java
class Burger {} /* ... */ }
class HealthyBurger {} /* ... */ }
class BurgerFactory {
  public Burger createBurger() { return new Burger();  }  } // end class
class HealthyBurgerFactory {
  @Override
  public HealthyBurger createBurger() { return new HealthyBurger();  }  } // end class
```

#### Static vs Instance methods (Lecture 63)

Static methods

- are declared using a `static` modifier
- can not access *instance methods* and *instance fields* directly
- are usually used for operations that don't require any data from an instance of the class (`this`, current *instance* of the *class*)
- have no access to `this` keyword

Whenever there is a method that does not use *instance fields*, that method should be declared `static`. Example : `main` is `static` method, called by the *JVM* when it starts an application.

`static` methods are called as `methodName()` when in the same class, ClassName is inferred by JVM. Otherwise call as  `ClassName.methodName()`.

```java
class Calculator { public static int sum(int a, int b) { return a + b; } }
public class Main {
  public static void main(String[] args) {
    printResult("4 + 5", Calculator.sum(4,5)); /* short for Main.printResult */ }
  public static void printResult(String arguments, int result) {
    System.out.println(arguments + " = " + result) } } // end class
```

`static` methods do not need an *instance* of it's class to be called.

Instance methods

- belong to an *instance* of a *class* (an *object*), usually created by `new` keyword
- can only be used if that *instance* exists
- can access *instance methods* and *instance fields* directly
- can access `static` methods and `static` fields directly

Does a method use fields or instance methods? Yes -> *instance method*. No -> `static`.

#### Static variables vs Instance variables (fields) (Lecture 64)

Static variables

- declared by keyword `static`
- also known as *static member variables*
- shared by every *instance* of that *class*
- changed by one *instance* also changes for other *instances*


- not used very often, but can be very useful
- e.g. when reading user input using *Scanner*, we declare scanner as a `static` variable, so `static` methods can access it directly

```java
class Person {
  private static String name;  /* static */
  public Person(String name) { Person.name = name; }
  public String getName()    { return name; }  } // end class
public class Main {
  public static void main {
    Person frank = new Person("Frank"); /* frank.getName() => "Frank" */
    Person bob   = new Person("Bob");   /* frank.getName() => "Bob"   */ } } // <-class
```

Instance variables (fields)

- every *instance* has it's own copy of an *instance variable*, so it can have a different value (*state*) for each instance
- represent the *state* of an *instance*

```java
class Person {
  private String name;  /* non-static */
  public Person(String name) { this.name = name; }
  public String getName()    { return name; }  } // end class
public class Main {
  public static void main {
    Person frank = new Person("Frank"); /* frank.getName() => "Frank" */
    Person bob   = new Person("Bob");   /* frank.getName() => "Frank" */ } } // <-class
```

<a class="page-break" name="section-07"></a>

### Section 7, OOP Part 2 - Composition, Encapsulation, and Polymorphism

*28-01-2019, finished 28-01-2019*										[Go to Top](#top)	[Go to Bottom](#bottom) 

#### Composition Part 1 (Lecture 68/69)

Inheritance deals with a *Is-a relationship*.

```java
public class Car extends Vehicle { /* Car IS a Vehicle */ } 
```

Composition deals with a *Has-a relationship*.

```java
public class Engine {
  private int capacity; }
public class Car extends Vehicle { /* Car IS a Vehicle */
  private Engine engine;           /* Car HAS an Engine */ }
```

`private` / `public`

If you declare the *engine* private, you will have to access the monitor with a getter

- `myCar.getEngine().capacity` 

If you declare the *engine* public, you can access it as a field

- `myCar.engine.capacity`

#### Encapsulation (Lecture 70/71)

Mechanism that allows for restricting external access to certain components in the objects.

> **Encapsulation:**
>
> The whole idea behind encapsulation is to hide the implementation details from users. If a data member is private it means it can only be accessed within the same class. No outside class can access a private data member (variable/method) of another class. However if we setup public getter and setter methods to read and set/update, then an outside class can access those private data fields via public methods. This way data can only be accessed by public methods thus making the private fields and their implementation hidden for outside classes. That’s why encapsulation is known as **data hiding.**
>
> **Advantages of encapsulation:**
>
> 1. It improves maintainability and flexibility and re-usability: implementation code of *setters* and *getters* can be changed at any point in time. Since the implementation is purely hidden for outside classes they would still be accessing private fields using the same public methods. Hence the code can be maintained at any point of time without breaking the classes that uses the code. This improves the re-usability of the underlying class.
> 2. The fields can be made read-only (If we don’t define setter methods in the class) or write-only (If we don’t define the getter methods in the class). For e.g. If we have a field which doesn't need to change at any cost then we simply define the variable as private and instead of set and get both we just need to define the get method for that variable. Since the set method is not present there is no way an outside class can modify the value of that field.
> 3. User would not be knowing what is going on behind the scene. They would only be knowing that to update a field call `set method` and to read a field call `get method` but what these set and get methods are doing is purely hidden from them.
>
> Encapsulation is also known as “**data Hiding**”.
>
> 1. Objects encapsulate data and implementation details. To the outside world, an object is a black box that exhibits a certain behavior.
> 2. The behavior of this object is what which is useful for the external world or other objects.
> 3. An object exposes its behavior by means of public methods or functions.
> 4. The set of functions an object exposes to other objects or external world acts as the interface of the object.

```java
public class Player { public String name; public int health; }
Player player = new Player;
player.name = "Frank";  // fields directly accessible, .health is not set
```

- If code uses directly accessible fields, it makes it too easy to manipulate those values.
- And if the class definition changes (e.g. name -> fullName), any code directly setting that value must be updated.
- Possibility to forget to initialize fields.

By declaring the fields `private` it is impossible to access them directly, use *constructors* and *setters* and *getters*.

```java
public class Player {
  private String name; private int health;
  public Player(name, health) { this.name = name; this.health = health; }
  public getName() { return this.name; }
  public setName(String name) { this.name = name; } } // end class
```

If a field name is changed, the *get* method name can stay the same, so calling code does not have to be changed. 

We only have to make changes in the class where we refer to `this.<oldFieldName> `/`<oldFieldName> `

```java
public class Player {
  private String fullName; private int health;
  public Player(name, health) { this.fullName = name; this.health = health; }
  public String getName() { return this.fullName; }
  public String setName(String name) { this.fullName = name; } } // end class
```

Internally we could keep the original *get* method and make it point to the right *get* method.

```java
public String getName() { return getFullName(); }
public String getFullName { return this.fullName; }
```

#### Polymorphism (Lecture 72/73)

> **Polymorphism:**
>
> Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.
>
> Any Java object that can pass more than one IS-A test is considered to be polymorphic. In Java, all Java objects are polymorphic since any object will pass the IS-A test for their own type and for the class Object.
>
> It is important to know that the only possible way to access an object is through a reference variable. A reference variable can be of only one type. Once declared, the type of a reference variable cannot be changed.
>
> The reference variable can be reassigned to other objects provided that it is not declared final. The type of the reference variable would determine the methods that it can invoke on the object.
>
> A reference variable can refer to any object of its declared type or any subtype of its declared type. A reference variable can be declared as a class or interface type.

> Teacher : Mechanism that allows actions to act differently based on the actual object that the action is being performed on.

```java
class SuperClass                   { public String myCur() { return "$"; } }
class SubClass1 extends SuperClass { public String myCur() { return "€"; } }
class SubClass2 extends SuperClass { /* no myCur() */ }
SuperClass class;
class = new SuperClass(); class.myCur(); /* from SuperClass -> "$"  */
class = new SubClass1() ; class.myCur(); /* from SubClass1  -> "€"  */
class = new SubClass2() ; class.myCur(); /* from SuperClass -> "$"  */
/* You can define the return type of a function as the type of the superclass
   and return a subclass of it ( IS-A relationship ) */
public SuperClass getAClass() { return new SubClass1(); }
class = getAClass()     ; class.myCur(); /* from SubClass1  -> "€"  */
```

> Teacher: It will automatically, if you're inheriting from another class, and you've got a method, and you overwrite that method, that's what polymorphism is, it's giving unique functionality, for the class that has inherited from a base class. It is incredibly usefull, and really enables writing quite generic code.

Huh? 

*Overriding is a type of polymorphism* was mentioned in an answer somewhere.

It is not explained very well, or rather, I don't yet understand it very well. But lots of knowledge on the internet to be found. 

- https://www.tutorialspoint.com/java/java_polymorphism.htm
- https://www.quora.com/What-are-encapsulation-inheritance-polymorphism-and-abstraction
- https://www.javatpoint.com/java-oops-concepts

#### Final OOP Master Challenge (Lecture 74/75)

*Challenge to use all to principles of OOP  learned so far.*

Thing I found out when I got stuck for a while :

```java
class Burger { /* ... */ }
class DeluxeBurger extends Burger { /* ... */ }
Burger burger = DeluxeBurger();
/* Now, to access a method in DeluxeBurger : */
((DeluxeBurger) burger).<methodName()>;
```

It is ofcourse good old [*casting*](#casting). We *cast* the *object* `burger` to the *class* `DeluxeBurger`.



<a class="page-break" name="section-08"></a>

### Section 8, Arrays, Java inbuilt Lists, Autoboxing and Unboxing

*29-01-2019, finished 31-01-2019*										[Go to Top](#top)	[Go to Bottom](#bottom) 

#### Arrays (Lecture 76/77/78)

Arrays can hold multiple values of the same type. Arrays are *zero indexed*, start at 0.

```java
/* Initialize integer array with 10 elements */
int[] myInts;  myInts = new int[10];
double[] myDoubles = new double[10];
/* Elements are initialized with there default values, null for String objects!
   myIntArray[0] == 0, myDoubleArray[1] == 0.0d */
/* Assign a value */
myInts[5] = (5 + 1); /*  arrays start at [0], 5 is in position 6 */
/* Assign values with loop */
for ( int i = 0; i < 10; i++ ) { myInts[i] = i * 100; }
/* or better : use Array.length */
for ( int i = 0; i < myInts.length; i++ ) { myInts[i] = (i + 1) * 50; }
/* Method overloading, argument type determines which method is called */
public static void printArray(int[] array) 
	{ for (int i = 0; i < array.length; i++) { /* ... */ } } // end method
public static void printArray(String[] array) 
	{ for (int i = 0; i < array.length; i++) { /* ... */ } } // end method
```

An array can be initialized by using an array initializer block `{ , , }`, also known as an anonymous array.

```java
/* Initialize array and assign multiple values in 1 go, 
   only allowed when initializing, length will be nr of elements provided */
String[] myStrings = new String[] { "A", "B", "C", "D", "E" };
```

Aside : when dividing 2 integers, make sure at least one of the actors is cast to `double`. Which one does not matter, both is also fine.

```java
public static double averageArray(int[] array) {
	return sumArray(array) / (double) array.length ;  } // end method
```

3 methods to clone an array , all as fast as the other. `clone()` needs no argument ,but always does full copy :

```java
int[] copy = array.clone();
int[] copy = Array.copyOf(array);
int[] copy = System.arrayCopy(array);
```

#### Reference Types vs Value types (Lecture 79)

Primitive data types are Value Types, they hold a value.

Array and String are Reference Types, the reference to a place in memory.

```java
int a = 0; int b = a; a = 1; // -> a == 1, b == 0
```

Though Strings are objects, the behave the same as primitive data types

```java
String a = "a"; String b = a; a = "z"; // a == "z", b == "a"
```

Arrays are Reference Type objects, assigning an array the reference of another array, they both point to the same place in memory

```java
int[] myInts1 = new int[] {1,2}; int myInts2 = ints1; myInts[0] = 9;
	// ints1[0] == 9, ints2[0] == 9
```

`new int[]`, `array.clone()`, `Arrays.copyOf(array)`, `System.arrayCopy(array)` create new references.

`Arrays.toString( array )` concatenates content of array into a `String`, separated by a comma and space.

When an array is passed into a method, a new temporary reference is made in memory.  Reinitializing the array in the method will have no effect on the original array.

```java
int[] myInts1 = new int[2]; // ints[0] == 0
myInts1 = add1To0(myInts);  // ints[0] == 1
public static void add1To0(int[] array) { 
	/* All references are updated */
  array[0]++;
  /* Temporary argument-reference is reinitialized to new reference,
      no change to original */
  array = new int[] {5,5,5,5};  } // end method
```

#### List and ArrayList (Lecture 82-88)

Resize an array

```java
private static int[] myInts = new int[5];
resizeArray(10)
private static void resizeArray(int newLength) {
  int[] orgInts = myInts;
  myInts = new int[length];
  for (int i = 0; i < orgInts; i++) { myInts[i] = myOrgs[i] }  }
```

Quite a silly example, as you can not pass the array, so array has to be called `myInts`. This is better :

```java
private static int[] myInts = new int[5]; // -> [0,0,0,0,0]
myInts = resizeArray(myInts, 10);         // -> [0,0,0,0,0,0,0,0,0,0]
private static int[] resizeArray(int[] array, int newLength) {
  int[] orgInts = array;
  array = new int[newLength];
  for (int i = 0; i < orgInts.length; i++) { array[i] = myOrgs[i]; }
  return array;  } // end for
```

Lists, another way of looking at arrays as an array is a list, a sequence of values/references.

> Oracle : https://docs.oracle.com/javase/8/docs/api/java/util/List.html
>
> public interface `List<E>`  (E - the type of elements in this list)
>
> extends `Collection<E>`
>
> An ordered collection (also known as a *sequence*). The user of the List interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.

Very much like arrays.

`Class ArrayList<ElementType>`  is  a resizable array. `ElementType` is the data type you want to store, can be a Java *class* or own *class*, <u>not</u> a *primitive datatype*!.

*Wrapper classes* can be coded, but Java already provides these for each *primitive datatype*, e.g. `int` -> `Integer`.

`ArrayList<String> myList = new ArrayList<String>();`  to initialize a List interface of type String. The `()` calls the constructor of the `class ArrayList`. (The last `<String>` can be omitted these days)

 The class takes care of the sizing etc all by it self.

- `myList.add( <ObjectType> <object> );` adds an element to the list with given value
- `myList.add( <index>, <ObjectType> <object> );` inserts an element to the list in given position with given value
- `myList.addAll( <otherListOfSameType> )` to copy all elements from one list into another
- `myList.get( <index> )` to retrieve the value
- `myList.set( <index>, <newValue> )` to modify a value
- `myList.remove( <index> )` to remove an element
- `myList.size()` for length
- `myList.isEmpty()`, for ... :-)
- `myList.indexOf( <object> )` to return `<index>` of `<object>` in myList, returns `-1` if not found

`ArrayList<String> myList = new ArrayList<String>( <otherListOfSameType> );`  will initialize a List interface of type string and initialize the contents with the contents of `<otherListOfSameType>`

List to array :

```java
// Assuming class for myList object has a getter getList()
String[] myArray = new String[myList.size()];
myArray = myList.getList().toArray(myArray); // myArray mentioned twice?
```

When you compare values between objects, always use  `<object>.equals()`  / `!<object>.equals()` in stead of `==` /  `!=`

Overloading again is very useful.

```java
public Contact findContact(Contact contact) { /* Can use .indexOf() */ }
public Contact findContact(String name) { /* More elaborate search loop, .equals() */ }
```

Once the element type is established, no need to mention it again when initializing it

```java
ArrayList<Contact> contactList, contactList2;
contactList  = new ArrayList<Contact>(); /* Contact is not needed */
contactList2 = new ArrayList<>();
```

#### Autoboxing and Unboxing (Lecture 89-92)

- *Autoboxing*,  casting *primitive datatype* to corresponding *datatype  class*
- *Unboxing*,  casting *datatype  class* to corresponding *primitive datatype*
- Java can do some of the  Autoboxing and Unboxing for us at compile time for proprietary *primitives* and *datatype classes* at compile time, Java adds appropriate code.
- This way code can be much  concise and readable.

```java
// No Autoboxing, Unboxing
// deprecated since J9 : Integer myInteger = new Integer(54); 
Integer myInteger = 54;  int myPrimitiveInt = myInteger.intValue();
// deprecated since J9 : Double  myDouble  = new Double(3.14);
Double myDouble = 3.14;  double myPrimitiveDouble = myDouble.doubleValue();
ArrayList<Integer> integerAList = new ArrayList<Integer>();
for (int i = 0; i < 10; i++) {  integerAList.add( Integer.valueOf(i) );  }
for (int i = 0; i < integerAList.size(); i++) {
  System.out.println( i + " => " + integerAList.get( i ).intValue() ); } // end for
```

```java
// Autoboxing, Unboxing
Integer myInteger = 54;  int myInt = myInteger;
Double myDouble = 3.14;  double myPrimitiveDouble = myDouble;
ArrayList<Integer> integerAList = new ArrayList<Integer>();
for (int i = 0; i < 10; i++) {  integerAList.add( i );  }
for (int i = 0; i < integerAList.size(); i++) {
  System.out.println( i + " => " + integerAList.get( i ) );  } // end for
```


Java compiles declarations at compile time if it can, e.g. if an `int` is assigned to an `Integer` :

```java
Integer myInteger = 56;  // Java compiles it to : Integer myInt = Integer.valueOf(56);
Integer myInteger = 5.5; // Can not compile, incompatible types Integer <-> double
```

Very elaborate challenge : banks, branches, customers, transactions. Took me all day :

```
	/JavaPrograms/Section-08/S08-08-AutoboxUnboxChallenge
```

#### LinkedList (Lecture 93-99)

`Array[]` and `ArrayList<E>` have value/object 1 on position 0, value/object 2 on position 1, etc (*zero-indexed*).

`<LinkedList>` is another type of list, it adds an *address* to the list.

| Index | Address | Value |
| ----- | ------- | ----- |
| 0     | 100     | 34    |
| 1     | 104     | 18    |
| 2     | 108     | 91    |
| 3     | 112     | 453   |

Internally Java calculates this *Address* by `Address = baseAddress + ( Index * 4 )` where `baseAddress = 100`. So for *Index 3* that would evaluate to 112.

It has to do with memory allocation/memory address or something, not so sure whether that is useful info right now, but let's see.

A technical talk about internals, how references point to memory addresses, and how this different for variable length values (Strings, Objects) and how Java handles that internally, and more things we don't have to worry about.

```java
Customer frank = new Customer("Frank"), simon = frank;
simon.setName("Simon"); //-> frank.name : "Simon", simon.name : " Simon"
// simon and frank reference the same object
```

```java
ArrayList<Integer> iList = new ArrayList<>;
iList.add(1); iList.add(3); iList.add(4);
iList.add(1, 2); // Inserts 2 at position 1
```

When inserting a value in an `ArrayList<E>`,  for all elements following from that position downwards Java has to reassign a memory address. For large arrays that can be time/resource consuming.

`LinkedList<>` is an alternative that accommodates this. One element points to the next through links. In stead of inserting a value, it changes the links of the elements, so the element after which it is inserted links to the new element, and the new element links to the element that held that position before it was inserted.

- list = [a, c, d], links = [a->c, c->d]
- insert **b** at (zero-based) position 1
- list = [a, c, d, **b**], links = [a->**b**, c->d, **b**->c], 1 link us updated, 1 link is added
- remove **c** at (zero-based) position 3
- list = [a, d, b], links = [a->b, b->d], 1 link is updated, 1 link is removed.
- so in the actual lists, it is just added at the end, the links define what position they hold.
- I wonder what the costs in time/resource consumption are removing an element in the list would be

To be able to iterate through a LinkedList<> we need an ... Iterator :-) It uses `.hasnext()`, `.next()`

```java
private static void printLLString(LinkedList<String> linkedList) {
    Iterator<String> i = linkedList.iterator();
    while (i.hasNext()) {
        System.out.println("Value " + i.next());
    }
    System.out.println("------------");  } // end method
```

Each Iterator has `.hasNext()`, `.next()`, `remove()` `(, .forEachRemaining( ...)` ).

`ListIterator<E>`  also has `.hasPrevious()`, `.previous()`, `.nextIndex()`, `.previousIndex()` and more.

`.hasNext()` and `.hasPrevious()` tell us whether there is another element, `.next()` and `.previous()` go there.

It uses the `LinkedList<E>.listIterator()` , not `LinkedList<E>.iterator()`. Example of use :

```java
// Add string in alphabetical order in LinkedList<String> linkedList
private static boolean addInOrderLLString(
      LinkedList<String> linkedList, String newString, boolean allowDoubles) {
  ListIterator<String> listIterator = linkedList.listIterator();
  while (listIterator.hasNext()) {
    int comparison = listIterator.next().compareTo(newString);
    if ( comparison == 0 ) {
      // Already exists
      if ( !allowDoubles ) {
        // No doubles
        return false;
      }
      // Double allowed, insert here
      listIterator.add( newString );
      return true;
    } 
    if ( comparison > 0  {
      // Should be inserted before this one, hasNext already has us on this element,
      //  so we have to go back one before inserting it.
      listIterator.previous();
      listIterator.add( newString );
      return true;
    }
  }
  // Not added yet, add it now to the end
  listIterator.add( newString );
  return true;
} // end method
```

Java has implemented the LinkedList as a *double link list*, links have pointers to both *next* and *previous* item.

Because of the nature of `LinkedList`s there is no  real pointer to where it is (or something, having to do with avoiding infinite loops), anyway, to make `.next()` and `.previous()` work like you would expect, there is a little more work to determine which way we are going. Check `boolean goingforward` and extra `.next()/.previous()` in *Section-08/S08-09-LinkedLists*.

Something  like this (check well for `true`, `false` and `!`)  :

```java
boolean quit = false, goingForward = true;
ListIterator<String> listIterator = collection.listIterator();
while (!quit) {
  String direction = getDirection());
  switch(action) {
    case "quit":
      quit = true;
      break;
    case "next":
      if (!goingForward) {
        if (listIterator.hasNext())     { listIterator.next(); }
        goingForward = true;
      }
      if (listIterator.hasNext())       { /*OK use .next() */ }
        else                            { /* End */ goingForward = false; }
      break;
    case "previous":
      if (goingForward) {
        if (listIterator.hasPrevious()) { listIterator.previous(); }
        goingForward = false;
      }
      if (listIterator.hasPrevious())   { /* OK, use .previous() */ }
        else                            { /*Begin */ goingForward = true; }
      break;
    default:
      break;
} } // end while
```

Alternative loop

```java
for (<MyClass> checkedObject: this.objects) {
  if (checkedObject.getField().equals(<someValue>)) { /* do something */ }
    else { /* do domething else */ }  } // end for
```



<a class="page-break" name="section-09"></a>

### Section 9, Arrays, Inner and Abstract Classes & Interfaces

*01-02-2019, finished ..-..-....*										[Go to Top](#top)	[Go to Bottom](#bottom) 

#### Interfaces (Lecture 100-104)

An *interface* specifies *methods* that a particular *class*, that implements the *interface*, <u>must</u> implement.

The *interface* itself is *abstract*. There is no code for any of the *methods*, you only supply the *method* names and their *arguments*. The code goes into the *class* that implements the *interface*.

The idea is to standardize behavior for all *classes* implementing the same *interface*.

Creating an *interface* is a commitment that the *interface*'s *methods* and *constant variables* will not change. This prevents code breaking in other *class*es using this *interface* by changes made to the code.

It's good practice to start *Interface* names with a capital I and then the rest also starting with a capital. It makes it clear it is an *interface.*

In IntelliJ, select *New - Java Class*, in the dialogue *Create New Class* select *Interface*. A new *interface* will be created.

All *methods* with their *signatures* (return type, arguments count/type) are defined, but no code added.

```java
package <packagePath>;
public interface IMyInterface {
  public void methodOne()); // public is redundant
  String methodTwo(int intValue);
  boolean methodThree(String stringValue));
}
```

The *access-modifier* keyword is useless here,  because the *interface* is implemented in a *class*. In the *class* the *access-modifier* can be specified.

In the *class* implementing the *interface*, all of the *methods* from the *interface* have to be implemented and *access-modifiers* can be added. Even methods are not used or coded for, they <u>must</u> be implemented.

```java
package <packagePath>;
public class MyClass implements IMyInterFace { 
  public IMyClass () { /* constructor*/ }
  @Override
  public void methodOne()                          { /* not used */ }
  @Override
  public String methodTwo(int intValue)            { 
    /* code goes here */
    return intValue + " = " + intValue; }
  @Override
  private boolean methodThree(String stringValue)) { 
    /* code goes here */
    return stringValue.equalsIgnoreCase( "masterclass" ); }  } // end class
```

Several ways to *instantiate* an *object*, using a *class* implementing the *interface*, or using the interface *directly*.

```java
IMyInterface myObject;      // specify myObject as object of type <interface>
myObject = new MyClass();   // create  myObject with class implementing <interface>
// or ...
MyClass myObject = new MyClass();
```

This is not valid, it does work, but defeats the purpose of *interfaces*.


```java
IMyInterFace myObject = new IMyInterface() {
public void methodOne()                          { /* ... */ }
  @Override
  public String methodTwo(int intValue)            { return null; }
  @Override
  private boolean methodThree(String stringValue)) { return false; }
}
```

(As IntelliJ inserts all the methods when you do it like above, maybe nice to do a quick *Implement Methods* )

```java
IMyInterface myObject;
myObject = new MyClass1(); // MyClass1 implements IMyInterface, OK
myObject = new MyClass2(); // MyClass2 implements IMyInterface, OK
myObject = new MyClass3(); // MyClass3 does NOT implement IMyInterface, ERROR!
```



Java libraries make extensive use of *interfaces*, we could change `LinkedList<MyClass>`, `ArrayList<MyClass`, etc into `List<MyClass>` without any problem, because  they implement the `List<>` *interface*.

It can sometimes be hard to decide to implement an *interface* or inherit from a base *class*. The way to decide that generally is to consider the relationship of the final *class* to the *object* it is extending or implementing.

A *class* in Java can only inherit from one super *class*, but you can *implement* from many *interfaces*. Multiple inheritance is only possible by implementing several *interfaces*.

E.g. a dog (`class Animal`) would implement `interface IWalk`, a bird (`class Animal`) would implement both `interface IWalk` and `interface IFly`.

 *JavaPrograms//Section-09/S09-03-InterfacesChallenge* :

Went fully overboard with a challenge, created a fully functioning ConnectFour game, with TDD and fully working interface. Took lot of time, but learned a lot.













<a name="bottom"></a>							[Go to Top](#top)


### Bottom anchor