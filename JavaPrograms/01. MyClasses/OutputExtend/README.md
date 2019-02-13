## Class OutputExtend

v.2019.02.12

**Before testing, make sure the appropiate classes are copied into this folder**

Started out as shorthand for `System.out.println()`, `.print()`, now also outputs `Arrays`, `ArrayLists` and `LinkedLists`



### Uses

```java
// import standard Java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// import custom classes
import static com.masterclass.ArrayExtend.*;
```



### Methods

#### printString()

- Only method that actually does any output

```java
void printString( String text)
void printString( String text, String prefix)
void printString( String text, String prefix, String suffix)
void printString( String text, String prefix, String suffix
				, boolean inLine ) {
    // Only method that actually does output.
    if ( inLine ) {
        System.out.print( prefix + text + suffix );
    } else {
        System.out.println( prefix + text + suffix );
    }
}
```

#### stringFormat()

- `format`, currently only implements `"green"`, `"red"` and `"redbold"`

```java
String stringFormat(String string, String format )
```

#### stringBoxIt()

- uses `ArrayExtend.arrayTableBeautify()`

```java
String[] stringBoxIt( String string
    , String top, String bottom, String prefix, String suffix )
```

#### printHeader()

- `boxIt`, default true
- `top`, default "="
- `bottom`, default "-"
- `prefix`, default "", printed before each line of header
- `suffix`, default "", printed after header

```java
public static void printHeader( String header )
public static void printHeader( String header, boolean boxIt
    , String top, String bottom, String prefix, String suffix )
```

#### printResult()

- Prints text in either green or red

```java
void printResult( String text, boolean success)
void printResult( String text, boolean success, boolean debug)
```

#### printTestResult()

- Used for TDD tests
- Green `"Passed"` if `success == true`
- Red `"!!! FAILED !!!"` if `success == false`

```java
void printTestResult( String text, boolean success)
```

#### oln()

- shorthand for  `printString(), inline == true` 
- `boolean prefix`, if `true`, `prefix == "="`

```java
void oln( String text )
void oln( String text, boolean prefix )
void oln( String text, String prefix )
void oln( String text, String prefix, String suffix )
```

#### o()

* shorthand for `printString(), inline == true`
* `boolean prefix`, if `true`, `prefix == "-"`

```java
void o( String text, String prefix, String suffix )
void o( String text, boolean prefix )
void o( String text, String prefix )
void o( String text, String prefix, String suffix )
```

#### olr()

- shorthand for `printResult()`

```java
void olr(String text, boolean success)
void olr(String text, boolean success, boolean debug)
```

#### old()

- prints `"Debug: " + text` to console

```java
void old( String text )
void old( String text, boolean inLine )
```

#### olt()

- shorthand for `printTestResult()`

```java
void olt( String text, boolean success )
```

#### printAString()

- prints `String[]`

```java
void printAString( String[] array )
void printAString( String[] array, String prefix )
void printAString( String[] array, String prefix, String suffix )
void printAString( String[] array, String prefix, String suffix
		, boolean inLine )
```

#### printAInt()

- prints `int[]`

```java
void printAInt( int[] array )
void printAInt( int[] array, String prefix )
void printAInt( int[] array, String prefix, String suffix )
void printAInt( int[] array, String prefix, String suffix, boolean inLine )
```

#### printALInteger()

- prints `ArrayList<Integer>`

```java
void printALInteger( ArrayList<Integer> array )
void printALInteger( ArrayList<Integer> array, String prefix )
void printALInteger( ArrayList<Integer> array, String prefix
		, String suffix )
void printALInteger( ArrayList<Integer> array, String prefix
		, String suffix, boolean inLine )
```

#### printALString()

- prints `ArrayList<String>`

```java
void printALString( ArrayList<String> array )
void printALString( ArrayList<String> array, String prefix )
void printALString( ArrayList<String> array, String prefix, String suffix )
void printALString( ArrayList<String> array, String prefix, String suffix
		, boolean inLine )
```

#### printLLString()

- prints `LinkedList<String>`

```java
void printLLString( LinkedList<String> list )
void printLLString( LinkedList<String> list, String prefix )
void printLLString( LinkedList<String> list, String prefix, String suffix )
void printLLString( LinkedList<String> list, String prefix, String suffix
	, boolean inLine )
```



### Usage

```java
import static com.masterclass.OutputExtend.*;
// Check it out!
```



### Todo

* Print array elements with bullits or numbers?
  * use Objects for method arguments, cut down on overloading.
  * 
* 



### Examples

```java

```

