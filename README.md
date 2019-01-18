## Java Programming Masterclass for Software Developers

Udemy Course :
https://www.udemy.com/java-the-complete-java-developer-course/learn/v4/overview



*14-01-2019 - ...*

24 sections



### Section 1, Course Introduction

*14-01-2019, finished 14-01-2019*

### Section 2, Setup and First Steps

*14-01-2019, finished 14-01-2019*

We'll be using JDK11, and IntelliJ IDEA as IDE (Integrated Development Environment).

He says he recorded this video in October 2019 :-)

JDK (Java Development Kit) helps you write and compile Java programs, run programs with JVM (Java Virtual Machine, with JRE (Java Runtime Edition).

JDK is needed to write Java programs.

Which version? Oracle has started to charge for Java. There is something called open(-source) JDK, so you don't need to pay to use Oracle JDK. Oracle JDK is business orientated, they charge businesses. Just use the Oracle version.

Blog Java 11 : https://learnprogramming.academy/programming/java-11-has-arrived-is-it-time-to-panic/

##### Installing JDK 11 on a Linux Machine

Oracle website : https://www.oracle.com/technetwork/java/index.html

Download JDK from : https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html

```bash
$ cd /Downloads/Jdk11
$ tar -xvf jdk-11.0.1_linux-x64_bin.tar.gz
$ sudo mkdir -p /usr/lib/jvm/jdk-11
$ sudo mv jdk-11.0.1/* /usr/lib/jvm/jdk-11
$ sudo update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-11/bin/java"
$ sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-11/bin/javac"
```

I already had Java8 installed, so had to do some `update-alternatives`-magic to activate Java11.

##### Installing and Configuring IntelliJ IDEA on a Linux Machine

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



### Section 3, Variables, Datatypes and Operators

*15-01-2019, finished 16-01-2019*

IntelliJ has shortcuts to templates, if you type `sout + <Tab>`, it expands to `System.out.println()`

##### Variables (Lecture 16)

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



##### Primitive Data Types - The Byte, Short, Int and Long (Lecture 17)

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

**Casting:**  Java converts results of calculations with all integers to `int`, to make sure the result fits in `byte` and `short` use `(datatype)` just before calculation :

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



##### Primitive Data Types - The Float and Double (Lecture 18)

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

##### Primitive Data Types - The Char and Boolean (Lecture 19)

- `char`, 16-bit, default `'\u0000'`, 1 character or Unicode code character

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



##### Strings and Finish up Primitives (Lecture 20)

`String` is not a primitive data type, it is a `class`. But it is so strongly integrated in Java language that it is used like a primitive. You can declare a `String` type variable the same way as primitives.

All primitives have a default value. As String is an object (instance of class String), it's default value is `null`.

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



##### Operators  and Operator Precedence in Java (Lecture 21/22)

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
- is equal, is not equal, `==`, `!=`
- is greater than/is greater than or equal to, `>`, `>=`
- is less than/less than or equal to, `<`, `<=`

- when comparing expressions, put expressions between parentheses ( = brackets)
- as `=` assigns a value, make especially sure with booleans you use `==` in comparisons
  - `boolean isCar = false; if (isCar = true) ...;`
  - will make `isCar` `true` and expression evaluates to `true`
- ternary operator, `<expression> ? <value-if-true> : <value-if-false>;`
- precedence, `int result = 50 + 50 * 50;` value is 2550, `int result = (50 + 50) * 50;` value is 5000

Summary of operators : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html

Java Operator Precedence Table : http://cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html



### Section 4, Java Tutorial: Expressions, Statements, Code blocks, Methods and more.

*16-01-2019, finished 17-01-2019*

##### Keywords and Expressions (Lecture 24)

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

##### Statements, Whitespace and Indentation (Code organisation) (Lecture 25)

`int myInt = 50;` is a statement, `myInt = 50` is an expression, `50` is a literal.

Semi-colon is used to end Java statement.

- you can use multi-line statements and end with a semi-colon
- you can put multiple statements on one  line as long as you end each one with a semi-colon.

`if (<expression>); <do something>;` `if` statement will check nothing, it has finalized.

Whitespace is needed between keywords and identifiers. Many times extra whitespace makes code more readable. Unnecessary whitespace is ignored by Java, use as much as you want.

Identation also helps making code readable, Java does not need it. Do it as much as you like

##### Code Blocks And The If Then Else Control Statements (Lecture 26/27)

With one-line statements after an if statement, you can just finish with a colon.

```java
int  myInt = 500;
if (myInt > 450)
	System.out.println("Jeez, your Int is high!");
```

When multiple statements follow the if statement, you make a code block with { }.

```java
int myInt = 500;
if (myInt > 450) {
    System.out.println("Jeez, your Int is high!"
       + " I will give you a bonus");
    int myIntWas = myInt;
    myInt += 100;
    System.out.println("Your Int was " myIntWas + ". It is now " + myInt);   
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

##### Methods in Java (Lecture 28/29/30)

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

##### DiffMerge Tool Introduction/Installation/Usage (Lecture 31/32/33)

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

##### Coding exercises (Lecture 34)

Udemy feature, enter your code in Udemy exercise, have your solution checked right away with click on a button.

While coding in IntelliJ we will need a *main* method for testing, when copying to exercise, leave this one out.

All exercises went well, result in *JavaPrograms/Section-04/S04-05-Exercises*.

##### Method Overloading (Lecture 35/36/37/38)

> Method Overloading is a feature that allows a class to have more than one method having the same name, if their argument lists are different. It is similar to constructor overloading in Java, that allows a class to have more than one constructor having different argument lists.

Using the method with the same name, but with a different number of parameters. Just specifying a  method with the same name and a different number of parameters, is overloading the method. Java looks for a method with the given name and the given number of arguments.

```
public static void main(String[] args) {
	myMethod(1, " = one")
	myMethod(1, 1, " = two")
}
public static void myMethod(int iOne, String sOne) {
	System.out.println(iOne + iOne)
}
public static void myMethod(int iOne, int iTwo, String sOne) {
	System.out.println((iOne + iTwo) + iOne)
}
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
		// write your code here, or not, whatever
    }
}
```



