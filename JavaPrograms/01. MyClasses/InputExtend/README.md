## Class InputExtend

v.2019.02.12

**Before testing, make sure the appropiate classes are copied into this folder**

Started out as extending functionality for getting `int`/`String` user input using class `Scanner`

Now also shows menus and ask yes/no questions.

### Uses

```java
// import Standard Java
import java.util.ArrayList;
import java.util.Scanner;

// import custom classes
import static com.masterclass.OutputExtend.*;
import static com.masterclass.ArrayExtend.*;
```



### Methods

#### getInt()

- 

```java
int getInt()
int getInt( String prompt )
int getInt( String prompt, boolean minMax, int min, int max )
```

#### getString()

- 

```java
String getString()
String getString( String prompt )
String getString( String prompt
    , boolean caseInsensitive )
String getString( String prompt
    , boolean minMax, String min, String max )
String getString( String prompt
    , boolean minMax, String min, String max, boolean caseInsensitive )
```

#### getYesNo()

- 

```java
String getYesNo()
String getYesNo( String prompt )
String getYesNo( String prompt, String yes, String no )
```

#### getMenu()

- uses `getAmenu()`, same result type

```java
String[] getMenu( String header, ArrayList<String> menuOptions )
String[] getMenu( String header, ArrayList<String> menuOptions
    , ArrayList<String> menuChoices )
String[] getMenu( String header, ArrayList<String> menuOptions
		, ArrayList<String> menuCodes
		, ArrayList<String> menuChoices )
```

#### getAmenu()

- returns `String[] { "Menu Option", "menu-option", "1" }`

```java
String[] getAMenu( String header, ArrayList<String[]> menuOptions)
```





### Usage

```java
import static com.masterclass.InputExtend;
// Check it out!
```





### Todo

- change getYesNo() result type to boolean?
- 





### Examples

```java

```

