## Class ArrayExtend

v.2019.02.12

**Before testing, make sure the appropiate classes are copied into this folder**

Checking for winners in a Connect Four game app, I got a little carried away.

#### Uses

```java
// import standard Java
import java.util.ArrayList;

// import custom classes
import static com.masterclass.OutputExtend.*;
```

Does not do any do any output to console.



#### Available methods

##### hasValue()

- `hasValue()`, does the array contain a value?
- `ignoreCase` optional, defaults to `false`

```java
boolean hasValue( String[] checkArray, String checkValue,
		, boolean ignoreCase )
boolean hasValue( int[]    checkArray, int    checkValue ) 
```

##### getValue()

- `getValue()`, returns value for position `at` in row `row`
- `defaultValue`  optional, defaults to " " for `String`, 0 for `int`
- `invalidValue` optional, defaults to � for `String`, -1 for `int`

```java
String getValue( String[] array, int row, int at,
		String defaultValue,
		String invalidValue
  )
int    getValue( int[]    array, int row,
  	int defaultValue,
  	int invalidValue
  )
```

##### maxRowLength()

- `rowLength`, optional, initial minimum value

```java
int maxRowLength( String[] array )
```

##### padArray()

- `rowLength`, pad all rows of given array to this length
- also truncates if content is longer

```java
String[] padArray ( String[] array, int rowLength )
```

##### arrayFlip()

- `arrayFlip()`, flips given array
- `int direction` ,
  -   180 (default), 90, -90, 45, -45
- `String direction`, 
  - "halfcircle" (default), "forward", "backward", "forward45", "backward45"

```java
String[] arrayFlip( String[] array, int    direction );
String[] arrayFlip( String[] array, String direction );
```

##### maxRowLength()

- `int maxRowLength()`, returns maximum row length of given row

##### list2Array()

- 

```java
String[] listToArray( ArrayList<String> list )
```

##### arrayTableBeautify()

- 

```java
String[] arrayTableBeautify( String[] table )
```


##### arrayCompare()

- `debug`, optional

```java
boolean arrayCompare(String[] array1, String[] array2 )
boolean arrayCompare(String[] array1, String[] array2, boolean debug )
```





#### Usage

```java
import static com.masterclass.ArrayExtend.*;
// Check it out!
```



#### Todo

- Create 'left side right' flip, reverse row contents?

- Create 'upside down' flip, reverse array order?

- Pad 45 flips with spaces for visual representation

  - ```java
    so 12 becomes   1
       34          3 2
                    4
    ```



#### Examples

```java
import static com.masterclass.ArrayExtend.*;
import static com.masterclass.OutputExtend.*;
class TestArrayExtend {
  public static String[] array, forwardwin;
    public static void main( String[] args ) {
	    array = new String[] {
            "A     B",
            "  O  X",
            "   OX",
            "   XO",
            "  X  O",
            "C      D" };
      printAString( arrayFlip ( array, 90 ), false, true );
    }  } // class TestArrayExtend
```



`arrayTableBeautify()` makes nice looking tables from `String[]`

```java
"====================="  --> "╒════╤═══════╤══════╕"
"|    |       |      |"      "│    │       │      │"
"---------------------"      "├────┼────┬──┴─┬────┤"
"|    |    |    |    |"      "│    │    │    │    │"
"---------------------"      "├────┼────┴──┬─┴────┤"
"|    |       |      |"      "│    │       │      │"  
"---------------------"      "├────┼────┬──┴──────┤"
"|    |    |         |"      "│    │    │         │"
"====================="      "╞════╪════╪════╤════╡"
"|    |    |    |    |"      "│    │    │    │    │"
"---------------------"      "└────┴────┴────┴────┘"
```

