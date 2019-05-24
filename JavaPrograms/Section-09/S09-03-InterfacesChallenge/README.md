## Section 9, Interfaces Challenge

### Challenge

- Create a simple interface (tip: name it Saveable or ISaveable)

- That interface allows an object to be saved to some sort of storage medium. (tip: use arraylist)

- The exact type of medium is not known to the interface (nor to the classes that implement it).

- The interface will just specify two methods, one to return an ArrayList of values to be saved and the other to populate the object's fields from an ArrayList (parameter).

- Create a few sample classes that implement your Saveable interface (we've used the idea of a game, with Players and Monsters, but you can create any type of classes that you want).

- Override the toString() method for each of your classes so that they can be easily printed to enable the program to be tested easier.

- In Main, write a method that takes an object that implements the interface as a parameter and "saves" the values e.g. calls the method defined in the interface.

- We haven't covered I/O yet, so your method should just print the values to the screen.

- Also in the Main class, write a method that restores the values to a Saveable object
  e.g. calls the method from the interface for populating fields (see above).

- Again, we are not going to use Java file I/O; instead use the readValues() method below to
  simulate getting values from a file – this allows you to type as many values as your class
  requires, and returns an ArrayList.

- There is a whole Java I/O section later in the course where you will get to use files, etc.

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");
        
        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;




### Result

Went fully overboard on this challenge, the trigger word was 'game', because I recently had an assignment involving a NodeJS 'Connect Four' game API .

Took a week off course to create and perfect custom classes, custom TDD environment, etc. At some times creating (sometimes trivial) helpers took much more time than the actual application. But helpers are there forever, applications come and go.

I created a fully working application with TDD Tests, with a fully working Connect-n game interface (Tic Tac Toe, Connect Four/Five, Connect Flex (design your own) ), both Tic Tac Toe style (row placement) as Connect Four style (drop from top).

Created several classes and dozens of class methods with TDD suites for each class.

Some functionality I created may turn out to be already embedded in Java, I just don't know about yet. I'll find out when I learn more. Some code is just short circuiting and enhancing standard stuff.

But other code, I am sure, are my personal enhancements :-). Though I might have been re-inventing the wheel, as many co-coders  have created libraries doing similar stuff, I 'm sure.

Loads of code that I am really proud of now, but I will probably look at wearily weeks from now :-)

The application I created for this challenge will be saved as a project and will be further developed over the coming months, using new ways to interact.

2019-02-11 : Week well spent, learned a lot. Time to 'get back on course'.

My game is totally different than the teacher created, as it turns out.

