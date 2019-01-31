## Autobox / Unbox challenge

*Your job is to create a simple banking application.*

- *There should be a Bank class*
- *It should have an arraylist of Branches*
- *Each Branch should have an arraylist of Customers*
- *The Customer class should have an arraylist of Doubles (transactions)*
- *Customer:*
  - *Name, and the ArrayList of doubles.*
- *Branch:*
  - *Need to be able to add a new customer and initial transaction amount.*
  - *Also needs to add additional transactions for that customer/branch*
- *Bank:*
  - *Add a new branch*
  - *Add a customer to that branch with initial transaction*
  - *Add a transaction for an existing customer for that branch*
  - *Show a list of customers for a particular branch and optionally a list of their transactions*
- *Demonstration autoboxing and unboxing in your code*
- *Hint: Transactions*
- *Add data validation.*
  - *e.g. check if exists, or does not exist, etc.*
- *Think about where you are adding the code to perform certain actions*



I added a class for `<Result>`, it is used to build responses to requests, contains `boolean success` and `String message `(and others).

I designed the classes to be API-like black boxes, they have no output on screen, they receive requests and return responses in a `<Result>` class object. 

I added a class for `<Transaction>`, the customer has an `ArrayList<Transaction`>, class `<Transaction>` is responsible for it's own add, validation, `.toString()`.

The `<Main>` class implements several methods to talk to the *'API'* and display results when necessary/requested. They are responsible for dealing with the responses.

Many of the methods in `<Main>` are overloaded. Maybe a bit too much :-)

There's not much Autoboxing, Unboxing happening. `<Transaction>` receives a `double` and stores it as a `Double` and vice versa.

A loop with user input would have been nice, but this took so long already.

Let's move on.