/*
BIG JAVA
*/

/*
CHAPTER 1: Introduction

* Computer Programs
    * Computers execute very basic instructions in rapid succession
    * Computer program: a sequence of instructions and decisions
    * Programming: the act of designing and implementing computer programs
* Anatomy of the Computer
    * The CPU: performs program control and data processing
    * There are two kinds of storage:
        * Primary storage also known as memory is made from electronic circuits that can store data, provided they are supplied with electric power
        * Secondary storage is a hard disk or a solid-state drive, provides slower and less expensive storage that persists without electricity
    * To interact with a human user, a computer requires peripheral devices. The computer transmits information (called output) to the user through a display screen,speakers, and printers. The user can enter information (called input) for the computerby using a keyboard or a pointing device such as a mouse.
    * Some computers are self-contained units, whereas others are interconnected through networks. Through the network cabling, the computer can read data and programs from central storage locations or send data to other computers. To the user of a networked computer, it may not even be obvious which data reside on the computer itself and which are transmitted through the network.
    * When a program is started, its instructions are brought into memory, where the CPU can read them. The CPU reads and executes one instruction at a time. As directed by these instructions, the CPU reads data, modifies it, and writes it back to memory or secondary storage.
* JAVA programming language
    * A computer program consists of a large number of simple CPU instructions, and it is tedious and error prone to specify them one by one.
    * A high level programming language: specify the actions that your program should carry out. A compiler translates the high-level instructions into the more detailed instructions (called machine code) required by the CPU
    *  Java has a rich library that makes it possible to write portable programs that can bypass proprietary operating systems—a feature that was eagerly sought by those who wanted to be independent of those proprietary systems and was bitterly fought by their vendors. Java was designed for the Internet, it has two attributes that make it very suitable for beginners: safety and portability.
    * In order to achieve portability, the Java compiler does not translate Java programs directly into CPU instructions.Instead, compiled Java programs contain instructions for the Java virtual machine; a program that simulates a real CPU.
* Programming environment
    * IDE to write programs
    * Java compiler translates source files into class files that contain instructions for JVM to execute
    * The JVM accesses a library of pre-written code necessary for the program’s output
    * Create folders to organize your work
* Analyzing Program
    * In Java, every source file can contain at most one public class, and the name of the public class must match the name of the file containing the class.
    * Classes are fundamental building block of programs
    * A method contains a collection of programming instructions that describe how to carry out a particular task. Every Java application must have a main method.
    * The main method contains one or more instructions called statements. Each statement ends in a semicolon (;). When a program runs, the statements in the main method are executed one by one.
* Errors
    * Syntax or compile time errors violate the JAVA language and they will not be translated to JVM
    * Logic or run-time errors are caused by logical flaws in program; it compiles but produces the wrong output
* Algorithms Pseudocode
    * An algorithm for solving a problem is a sequence of steps that is unambiguous, executable, and terminating.
    * Pseudocode is an informal description of a sequence of steps for solving a problem.
*/

//END OF CHAPTER 1


/*
CHAPTER 2: Using Objects

* When you write a computer program, you put it together from certain “building blocks”. In Java, you build programs from objects. Each object has a particular behavior, and you can manipulate it to achieve certain effects.
    * Using Objects
        * An object is an entity that you can manipulate by calling one or more of its methods. A method consists of a sequence of instructions that can access the internal data of an object.
        * In general, think of an object as an entity that can do work for you when you call its methods.
    * Classes
        * A class describes a set of objects with the same behavior
* Variables
    * Variable Declarations
        * A variable is a storage location with a name, type and value
        * Declare variables by initializing them
    * Types
        * There are several different types in JAVA
        * You use int for integers and double for floating point numbers; numbers can be combined using arithmetic operators
        * Types indicate what you can do with the variable
    * Names
        * Names start with letter or underscore
        * Can’t use symbols
        * Names are case sensitive and you can’t use reserved words
        * camelCase is common convention for variables and uppercase for classes
    *  Comments
        * Comments to add commentary and make code readable
    * Assignment
        * Use assignment operator to change the value of a variable
        * Variables must be initialized before you access them
* Calling Methods
    * Public Interface of Class
        * Use objects by calling its methods; objects of a given class share a common set of methods
        * The public interface of a class specifies what you can do with its objects
        * A class also has a private implementation describing the data inside its objects and the instructions for those methods which are hidden
    * Method Arguments
        * An argument is a value that is provided in a method call
    * Return Values
        * A return value of a method is result that method has computed
        * Not all methods have return values
    * Method Declarations
        * When a method is declared in a class, the declaration specifies the types of the arguments and the return value
        * For example, public int length() is a public class with int as return type with no arguments
        * An overloaded method is two methods with the same name but different arguments
* Constructing Objects
    * Use objects in a program by constructing them
    * To construct an object use the keyword new followed by the classname and arguments
    * For example, Rectangle box = new Rectangle(5, 10, 20, 30); creates an object box
* Accessor and Mutator Methods
    * An accessor method acesses an object and returns some information about it, without changing the object
    * A mutator method modifies the internal data of an object
    * For example, the length method of the String class is an accessor method. It returns information about a string, namely its length.
* API Documentation
    * The API documentation lists the classes and methods of a JAVA library
    * JAVA classes are grouped into packages and you use the import statement to use classes declared in other packages
* Object References
    * An object variable doesn’t hold an object; it just holds the memory location
    * Number variables store numbers and object variables store references
*/


//Sample program that constructs object and uses methods
import java.awt.Rectangle;

public class MoveTester{
  public static void main(String[] args) {
    Rectangle box = new Rectangle(5, 10, 20, 30);
    // Move the rectangle
    box.translate(15, 25);
    // Print information about the moved rectangle
    System.out.print("x: ");
    System.out.println(box.getX());
    System.out.println("Expected: 20");
    System.out.print("y: ");
    System.out.println(box.getY());
    System.out.println("Expected: 35");
  }
}

//END OF CHAPTER 2

/*
CHAPTER 3: Implementing Classes

* Instance Variables and Encapsulation
    * An object stores its data in instance variables. Each object has its own set of instance variables. It’s usually always private
    * Private instance variables can only be accessed by methods of the same class
    * Encapsulation is the process of hiding implementation which makes for simpler implementation; it allows us to use a class without knowing its implementation
* Public Interface of Class
    * To implement class understand its methods first
    * Constructors initialize objects and have no return type
    * Public classes and methods form public interface of a class
    * Provide documentation for each class, method and parameter
* Providing Class Implementation
    * Private implementation consists of instance variables and bodies of constructors and methods
    * Provide accessor or mutator methods
* Unit Testing
    * A unit test is a class that works in isolation to test the program
* Local Variables
    * A local variable is a variable that exists only in the body of a method
    * Instance variables are initialized by default but you must initialize local variables
* This Reference
    * An implicit parameter is the use of an instance variable name in a method
    * The this reference denotes an implicit parameter
*/


//Sample program to construct a bank account

public class BankAccount
{
  //instance variable
  private double balance;

  //object constructor
  public BankAccount() {
    balance = 0;
  }

  public BankAccount(double initialBalance) {
    balance = initialBalance;
  }

  public void deposit(double amount) {
    balance = balance + amount;
  }

  public void withdraw(double amount) {
    balance = balance - amount;
  }

  public double getBalance() {
    return balance;
  }

}

//initalizes bank account object and tests it

public class BankAccountTester{

  public static void main(String[] args) {
    BankAccount harrysChecking = new BankAccount();
    harrysChecking.deposit(2000);
    harrysChecking.withdraw(500);
    System.out.println(harrysChecking.getBalance());
    System.out.println("Expected: 1500");
  }

}

//END OF CHAPTER 3

/*
CHAPTER 4: Fundamental Data Types

* Numbers
    * In Java, every value belongs to one of 8 primitive types: int, byte, long, double, float, boolean, char, short
    * Overflow occurs when it falls outside number range
    * Constants are values that can’t be changed and are declared with the keyword final
* Arithmetic
    * Java allows arithmetics operations using operators
    * Use the ‘++' to increment and ‘--‘ to decrement
    * Java provides libraries for mathematical functions
    * Cast a number to convert it into a different type
* Reading Input
    * Use the scanner class to read input
    * Use the printf method to format output
* Strings
    * Strings are sequences of characters
    * The length method yields the number of characters in a string
    * Concatenate or combine strings using the ‘+’ operator
    * Use the substring method to extract parts of a string
*/

//Sample program that reads input for price and computes price per liter

public class Volume{

  public static void main(String[] args){

    // Read price per pack
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter the price for a six-pack: ");
    double packPrice = in.nextDouble();

    // Read price per bottle
    System.out.print("Please enter the price for a two-liter bottle: ");
    double bottlePrice = in.nextDouble();
    final double CANS_PER_PACK = 6;
    final double CAN_VOLUME = 0.355;

    // Compute and print price per liter
    double packPricePerLiter = packPrice / (CANS_PER_PACK * CAN_VOLUME);
    double bottlePricePerLiter = bottlePrice / BOTTLE_VOLUME;
    System.out.printf("Pack price per liter: %8.2f", packPricePerLiter);
    System.out.println();
    System.out.printf("Bottle price per liter: %8.2f", bottlePricePerLiter);
    System.out.println();
  }

}

//END OF CHAPTER 4

/*
Chapter 5: Decisions

* If Statement
    * The if statement allows a program to carry out different actions depending on the data processed
* Comparing Values
    * Use relational operators to compare values
    * Compare strings using .equals method
    * Object comparisons come two different ways as the ‘==‘ operator compares object reference while the .equals method compares values of the object
* Multiple Alternatives
    * Multiple if statements can be used to evaluate complex decisions
    * When using multiple if statements, test general conditions after more specific conditions
* Nested Branches
    * When a decision is contained within another, it is a nested branch
* Boolean Expressions
    * Boolean has 2 return values: true and false
    * Predicate methods return a boolean values
    * Form complex boolean operations with operators
*/

//Sample program with nested if statements

public class TaxReturn
{
  public static final int SINGLE = 1;
  public static final int MARRIED = 2;
  private static final double RATE1 = 0.10;
  private static final double RATE2 = 0.25;
  private static final double RATE1_SINGLE_LIMIT = 32000;
  private static final double RATE1_MARRIED_LIMIT = 64000;
  private double income;
  private int status;

  public TaxReturn(double anIncome, int aStatus) {
    income = anIncome;
    status = aStatus;
  }

  public double getTax() {

    double tax1 = 0;
    double tax2 = 0;

    if (status == SINGLE)
    {
      if (income <= RATE1_SINGLE_LIMIT)
      {
        tax1 = RATE1 * income;
      }
      else
      {
        tax1 = RATE1 * RATE1_SINGLE_LIMIT;
        tax2 = RATE2 * (income - RATE1_SINGLE_LIMIT);
      }
    }
    else
    {
      if (income <= RATE1_MARRIED_LIMIT)
      {
      tax1 = RATE1 * income;
      }
      else
      {
      tax1 = RATE1 * RATE1_MARRIED_LIMIT;
      tax2 = RATE2 * (income - RATE1_MARRIED_LIMIT);
      }
    }
    return tax1 + tax2;
  }

}

import java.util.Scanner;

public class TaxCalculator{

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.print("Please enter your income: ");
    double income = in.nextDouble();

    System.out.print("Are you married? (Y/N) ");
    String input = in.next();
    int status;

    if (input.equals("Y"))
    {
      status = TaxReturn.MARRIED;
    }
    else
    {
      status = TaxReturn.SINGLE;
    }
    TaxReturn aTaxReturn = new TaxReturn(income, status);
    System.out.println( "Tax: "+ aTaxReturn.getTax());
  }
}

//END OF CHAPTER 5


/*
CHAPTER 6: LOOPS

* While Loop
    * While statement repeatedly executes statement until condition is met
* For Loops
    * For loops run from starting condition to end with a constant increment or decrement
* Do Loop
    * Do while statement executes something at least once before rest
* Common Loop Algorithms
    * Common algorithms implemented as loops include: sum and average value, couting matches, finding first match, prompting until match, max and min, comparing adjacent values
* Nested loops
    * Body of loop contains another loop is a nested loop; typically used to print table with rows and columns
*/

//Algorithm to compute sum and average value

double total = 0;
int count = 0;

while (in.hasNextDouble()) {
    double input = in.nextDouble();
    total = total + input;
    count++;
  }
double average = 0;

if (count > 0){
  average = total / count;
}

//Algorithm to compute spaces

int spaces = 0;
for (int i = 0; i < str.length(); i++) {
  char ch = str.charAt(i);
  if (ch == ' ')
  {
    spaces++;
  }
}

//Algorithm to find first match

boolean found = false;
char ch = '?';
int position = 0;

while (!found && position < str.length()) {
  ch = str.charAt(position);
  if (ch == ' ')
  {
    found = true;
  }
  else
  {
    position++;
  }
}

//Algorithm to prompt until match is found

boolean valid = false;
double input = 0;

while (!valid){
  System.out.print("Please enter a positive value < 100: ");
  input = in.nextDouble();
  if (0 < input && input < 100) {
    valid = true;
  }
  else
  {
    System.out.println("Invalid input.");
  }
}

//Algorithm to find max

double largest = in.nextDouble();
while (in.hasNextDouble()){
  double input = in.nextDouble();
  if (input > largest)
  {
    largest = input;
  }
}

//Sample random generator with nested for loops

import java.util.Random;

public class Die{
  private Random generator;
  private int sides;

  public Die(int s) {
    sides = s;
    generator = new Random();
  }

  public int cast() {
    return 1 + generator.nextInt(sides);
  }
}

public class DieSimulator{

  public static void main(String[] args) {
    Die d = new Die(6);
    final int TRIES = 10;
    for (int i = 1; i <= TRIES; i++) {
      int n = d.cast();
      System.out.print(n + " ");
    }
    System.out.println();
  }
}

//END OF CHAPTER 6


/*
CHAPTER 7: ARRAYS and ARRAYLISTS

* Arrays
    * An array collects a sequence of values of the same type
    * Individual elements in an array are accessed by an integer index i using the array notation array[i]
    * Array elements can be used like a variable and be printed
    * Use array.length to find the number of elements in an array
    * An array reference specifies the location of an array; copying the reference yields a second reference to same array
    * Arrays can occur as method arguments and return values
* Common Array Algorithms
    * Some common algorithms for arrays include: filling, max/min, separators, search, removing, inserting and swapping elements
    * A linear search inspects elements in a sequence until a match is found
    * Algorithm for inserting elements in an order moves all elements to the end and inserts in position
    * Swap positions in an array by moving an element into temp value and swapping
    * Copying arrays copies the reference of the array; use copy method to actaully copy an array
* Two Dimensional Arrays
    * Use a 2 dimensional array to store tabular data
    * Access individual elements in a 2 dimensional array using 2 index values and to access all elements use nested loops
* Array lists
    * An array list stores a sequence of values whose size can change; array lists also have methods for common tasks
    * An array list is a generic class, which means you can change the type; the angle bracket around the type is the type parameter
    * You can't use primitive types as the type parameter; use wrapper classes
    * Array lists have a list of methods to manipulate it
    * Copy array list constructing a new list and passing the old one in the constructor
*/

//Algorithm to fill an array

for (int i = 0; i < values.length; i++) {
  values[i] = i * i;
}

//Algorithm to sum and average array values

double total = 0;

for (double element : values) {
  total = total + element;
}
double average = 0;
if (values.length > 0) {
  average = total / values.length;
}

//Algorithm for array max and min

double largest = values[0];

for (int i = 1; i < values.length; i++) {
  if (values[i] > largest) {
    largest = values[i];
  }
}

//Algorithm to separate array elements

for (int i = 0; i < values.length; i++) {
  if (i > 0) {
    System.out.print(" | ");
  }
  System.out.print(values[i]);
}

//Algorithm for array linear search

int searchedValue = 100;
int pos = 0;
boolean found = false;
while (pos < values.length && !found) {
  if (values[pos] == searchedValue) {
    found = true;
  }
  else {
    pos++;
  }
}

//Algorithm for array element removal

for (int i = pos + 1; i < currentSize; i++) {
  values[i - 1] = values[i];
}
currentSize--;

//Algorithm for inserting array element in order

if (currentSize < values.length) {
  currentSize++;
  for (int i = currentSize - 1; i > pos; i--){
    values[i] = values[i - 1];
  }
  values[pos] = newElement;
}

//Array to read sequence of values and print largest value

import java.util.Scanner;

public class LargestInArray{

  public static void main(String[] args) {

    final int LENGTH = 100;
    double[] values = new double[LENGTH];
    int currentSize = 0;

    //Read input
    System.out.println("Please enter values, Q to quit:");
    Scanner in = new Scanner(System.in);
    while (in.hasNextDouble() && currentSize < values.length) {
      values[currentSize] = in.nextDouble();
      currentSize++;
    }
    // Find the largest value
    double largest = values[0];
    for (int i = 1; i < currentSize; i++) {
      if (values[i] > largest)
      {
        largest = values[i];
      }
    }

    // Print all values, marking the largest
    for (int i = 0; i < currentSize; i++) {
      System.out.print(values[i]);
      if (values[i] == largest)
      {
        System.out.print(" <== largest value");
      }
        System.out.println();
    }
  }
}

//Copy an arraylist
ArrayList<String> newNames = new ArrayList<String>(names);

//END OF CHAPTER 7

/*
CHAPTER 8: DESIGNING CLASSES

* Discovering Classes
    * A class should represent a single concept from a problem domain such as business, science or math
    * One useful category of classes are actor classes which carry out certain tasks for you
    * Very occasionally, classes have no objects and are utility classes
    * If you can't tell from the class name what the object of the class is supposed to do, then you're on wrong track
* Designing good methods
    * A public interface of a class is cohesive if all its features related to the single concept the class represents
    * A class depends on another class if its methods use that class in any way
    * An accessor method asks an object to compute its state without changing the state while a mutator method changes the state of the object
    * Immutable classes only has accessor methods so its references can safely be shared since it won't change the object value
    * Immutability makes sense for classes that represent values
    * A method should not modify its parameter variables
    * A side effect of a method is any modification of data that is observable outside the method; minimize side effects
    * Call by value is when parameter variables are initialized with the values of the argument expressions and when the method exits, the parameter variables are removed. You can't change the contents of the variable that is passed as an argument; Java is strictly call by value so numbers and object reference are passed as values
    * In Java, a method can change the state of an object reference argument, but it cannot replace the object reference with another; it can't also change the contents of variables passed as an argument
* Patterns for Object data
    * There are a small set of recurring patterns that you can adapt when you design your own classes such as keeping a total, counting events, collecting values, managing object properties
    * For keeping a total, create instance variable and locate methods that use variable and update accordingly
    * For counter, create instance variable for counter and increment accordingly
    * An object may collect other objects in an array or arraylist
    * A property of an object is a value an object can get and set
    * If your object has several states, provide an instance variable for the current state
* Static variables and methods
    * A static variable belongs to a class and not to any object of the class
    * A static method is not invoked on an object
* Packages
    * A java package is a set of related classes
    * You can import a package to use it
*/


//Example class structure for keeping a total

private double purchase;


public void recordPurchase(double amount) {
  purchase = purchase + amount;
}

public void clear() {
  purchase = 0;
}

public double getAmountDue() {
  return purchase;
}

//Example class struct for counting events

private int itemCount;

public void recordPurchase(double amount) {
  purchase = purchase + amount;
  itemCount++;
}

public void clear() {
  purchase = 0;
  itemCount = 0;
}

//Example class to collect objects

public class Question {

  private ArrayList<String> choices;

  public Question(){
    choices = new ArrayList<String>();
  }

  public void add(String option){
    choices.add(option);
  }

}

//Example class for object property

public class Student {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    name = newName;
  }

}

//END OF CHAPTER 8

/*
CHAPTER 9: INHERITANCE

* Inheritance Hierarchies
    * In object-oriented design, inhertiance is the relationship between a superclass (general class) and a subclass (specialized class)
    * A subclass inherits data and behavior from the superclass
    * Use inheritance for code reuse as subclass inherits methods of superclass and you can use subclass object when superclass is expected
* Implementing Subclasses
    * A subclass inherits all the methods that it doesn't override; subclass objects automatically have instance variables declared in the superclass
    * Subclasses override a superclass method by providing new implementation for an inherited method
    * The keyword "extends" indicates that a class inherits from a superclass
    * Private instance variables of a superclass are inaccessbile by the subclass so you must use public interface to acess private data
* Overriding Methods
    * An overriding method can extend or replace the functionality of the superclass method.
    * Use the reserved word super to call a superclass method; allows you to access instance variables of superclass; it executes the superclass method
    * If overriding be sure to use the same parameters, otherwise you are overloading
* Polymorphism
    * You can use inheritance to process objects of different types in the same program; you can write a method to pass different object types
    * A subclass reference can be used where a superclass reference is expected; however it knows less about the object to which it refers to
    * When you substitute a subclass reference for a superclass, you can only use the superclass methods
    * In JAVA, method calls are always determined by the type of actual object, not the type of variable containing the object reference; this is dynamic method lookup
    * Dynamic method lookup allows us to treat different objects of different classes in a uniform way which is Polymorphism
    * An abstract method has no implementation. This forces the implementors of subclasses to specify concrete implementations of this method.
    * A class for which you cannot create objects is called an abstract class. A class for which you can create objects is sometimes called a concrete class.
    * When you declare a method as abstract, you force programmers to provide implementations in subclasses. This is better than coming up with a default that might be inherited accidentally.
    * Use the final keyword to prevent programmers from creating subclasses or from overriding certain methods
* Object: The Cosmic superclass
    * Every class that is declared without an explicit extends clause automatically extends the class Object.
    * Override the toString method to yield a string that describes the object’s state.
    * The equals method checks whether two objects have the same contents.
    * The instanceof operator tests whether an object belongs to a particular type.
*/

//Sample program to implement an inheritance hierarchy of questions

public class Question{

  private String text;
  private String answer;

  public Question() {
    text = "";
    answer = "";
  }

  public void setText(String questionText) {
    text = questionText;
  }

  public void setAnswer(String correctResponse) {
    answer = correctResponse;
  }

  public boolean checkAnswer(String response) {
    return response.equals(answer);
  }

  public void display() {
    System.out.println(text);
  }

}

//Subclass of Question
public class ChoiceQuestion extends Question{

  private ArrayList<String> choices;

  public void addChoice(String choice, boolean correct) {
    choices.add(choice);
    if (correct)
    {
      // Convert choices.size() to string
      String choiceString = "" + choices.size();
      setAnswer(choiceString);
    }
  }

  public void display() {
    // Display the question text
    super.display();
    // Display the answer choices
    for (int i = 0; i < choices.size(); i++) {
      int choiceNumber = i + 1;
      System.out.println(choiceNumber + ": " + choices.get(i));
    }
  }

}

//Demo to implement Question hierarchy

import java.util.Scanner;

public class QuestionDemo2{

  public static void main(String[] args) {
    ChoiceQuestion first = new ChoiceQuestion();
    first.setText("What was the original name of the Java language?");
    first.addChoice("*7", false);
    first.addChoice("Duke", false);
    first.addChoice("Oak", true);
    first.addChoice("Gosling", false);

    ChoiceQuestion second = new ChoiceQuestion();
    second.setText("In which country was the inventor of Java born?");
    second.addChoice("Australia", false);
    second.addChoice("Canada", true);
    second.addChoice("Denmark", false);
    second.addChoice("United States", false);
    presentQuestion(first);
    presentQuestion(second);
  }

  public static void presentQuestion(Question q) {
    q.display();
    System.out.print("Your answer: ");
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();
    System.out.println(q.checkAnswer(response));
  }
}

//Abstract class Pseudocode

public abstract class Account {
  public abstract void deductFees();
}

public class SavingsAccount extends Account // Not abstract
{
  public void deductFees() // Provides an implementation
  {

  }
}

//Bankaccount hierarchy

public class BankAccount {

  private double balance;

  public void deposit(double amount){
    balance = balance + amount;
  }
  public void withdraw(double amount){
    balance = balance - amount;
  }
  public double getBalance(){
    return balance;
  }
  public void monthEnd() {
  }

}

public class SavingsAccount extends BankAccount {

  private double interestRate;
  private double minBalance;

  public SavingsAccount() {}

  public void withdraw(double amount) {
    super.withdraw(amount);
    double balance = getBalance();
    if (balance < minBalance)
    {
      minBalance = balance;
    }
  }
  public void monthEnd() {
    double interest = minBalance * interestRate / 100;
    deposit(interest);
    minBalance = getBalance();
  }

}


public class CheckingAccount extends BankAccount {

  private int withdrawals;

  public CheckingAccount() {}

  public void withdraw(double amount) {
    final int FREE_WITHDRAWALS = 3;
    final int WITHDRAWAL_FEE = 1;
    super.withdraw(amount);
    withdrawals++;
    if (withdrawals > FREE_WITHDRAWALS)
    {
      super.withdraw(WITHDRAWAL_FEE);
    }
  }
  public void monthEnd() {
    withdrawals = 0;
  }

}

//END OF CHAPTER 9


/*
CHAPTER 10: INTERFACES

* Using interfaces for algorithm reuse
    * A Java interface type declares methods but does not provide their implementations so that code can be reused for multiple purposes
    * An interface type is similar to a class, but there are several important differences as an interface type does not have instance variables, all methods in an interface type are abstract, interface types are automatically public, and interface types have no constructor
* Implementing an interface type
    * A class implements an interface type if it declares the interface in an implements clause
    * Once a class declares the interface type, its objects are instances of the interface type
    * Use interface types to make code more reusable
    * Intefaces are different from inheritance in that it uses commonality between classes that are not related; a class can have multiple interfaces while it can only extend one superclass
    * An interface merely specifies the behavior that an implementing class should supply. It provides no implementation. In contrast, a superclass provides some implementation that a subclass inherits.
    * You can think of an interface as a class in which every method is abstract.
    * Interfaces cannot have instance variables, but it is legal to specify constants.
* Working with interface variables
    * You can convert from a class type to an interface type, provided the class implements the interface.
    * Method calls on an interface reference are polymorphic.  The Java virtual machine locates the correct method by first looking at the class of the actual object, and then calling the method with the given name in that class
    * Occasionally, it happens that you store an object in an interface reference and you need to convert its type back;You need a cast to convert from an interface type to a class type.
* The Comparable interface
    * Implement the Comparable interface so that objects of your class can be compared, for example, in a sort method.
    * The clone method must return a new object that has an identical state to the existing object; it creates a clone of the reference which is a shallow copy
* Using Interfaces for callbacks
    * A callback is a mechanism for specifying code that is executed at a later time. in JAVA you turn callbacks into objects
* Inner classes
    * When you have a class that serves a very limited purpose, such as this one, you can declare the class inside the method
    * Inner classes are commonly used for utility classes that should not be visible elsewhere in a program.
*/

//interface type example
public interface Measurable {
  double getMeasure();
}

//implementation of interface
public class BankAccount implements Measurable {
  public double getMeasure(){
    return balance;
  }
}

public class Data{
  public static double average(Measurable[] objects) {
    double sum = 0;
    for (Measurable obj : objects) {
      sum = sum + obj.getMeasure();
    }
    if (objects.length > 0) {
      return sum / objects.length;
    }
    else {
      return 0;
    }
  }
}

public class MeasurableTester{
  public static void main(String[] args) {
    Measurable[] accounts = new Measurable[3];
    accounts[0] = new BankAccount(0);
    accounts[1] = new BankAccount(10000);
    accounts[2] = new BankAccount(2000);

    double averageBalance = Data.average(accounts);
    System.out.println("Average balance: " + averageBalance);
    System.out.println("Expected: 4000");

    Measurable[] countries = new Measurable[3];
    countries[0] = new Country("Uruguay", 176220);
    countries[1] = new Country("Thailand", 513120);
    countries[2] = new Country("Belgium", 30510);

    double averageArea = Data.average(countries);
    System.out.println("Average area: " + averageArea);
    System.out.println("Expected: 239950");
  }
}

//Comparable interface
public interface Comparable {
  int compareTo(Object otherObject);
}

public class BankAccount implements Comparable {
  public int compareTo(Object otherObject) {
    BankAccount other = (BankAccount) otherObject;
    if (balance < other.balance) {
      return -1;
    }
    if (balance > other.balance) {
      return 1;
    }
    return 0;
  }
}

//creating a clone
BankAccount clonedAccount = (BankAccount) account.clone();


//Example of a callback

public interface Measurer{
  double measure(Object anObject);
}

import java.awt.Rectangle;

public class AreaMeasurer implements Measurer{
  public double measure(Object anObject) {
    Rectangle aRectangle = (Rectangle) anObject;
    double area = aRectangle.getWidth() * aRectangle.getHeight();
    return area;
  }
}

public class Data{
  public static double average(Object[] objects, Measurer meas) {
    double sum = 0;
    for (Object obj : objects) {
      sum = sum + meas.measure(obj);
    }
    if (objects.length > 0) {
      return sum / objects.length;
    }
    else {
      return 0;
    }
  }
}

import java.awt.Rectangle;

public class MeasurerTester{

  public static void main(String[] args) {
    Measurer areaMeas = new AreaMeasurer();
    Rectangle[] rects = new Rectangle[];
    double averageArea = Data.average(rects, areaMeas);
    System.out.println("Average area: " + averageArea);
    System.out.println("Expected: 625");
  }
}

//END OF CHAPTER 10

/*
CHAPTER 11: INPUT/OUTPUT AND EXCEPTION HANDLING

* Reading and writing text files
    * Use the Scanner class for reading text files.
    * When writing text files, use the PrintWriter class and the print/println/ printf methods.
    * Close all files when you are done processing them
* Text input and output
    * The next method reads a strung delimited by a white space which includes spaces, tabs, new line characters
    * To read one character at a time, use the delimiter method
    * The Character class has methods for classifying characters
    * The nextLine method reads an entire line
    * If a string contains the digits of a number, you use the Integer.parseInt or Double.parseDouble method to obtain the number value.
    * Regular expressions describe character patterns
* Command Line Arguments
    * Programs that start from the command line receive the command line arguments in the main method.
    * Command line is useful if you want to automate
* Exception HANDLING
    * There are two aspects to dealing with program errors: detection and handling; In Java, exception handling provides a flexible mechanism for passing control from the point of error detection to a handler that can deal with the error
    * To signal an exceptional condition, use the throw statement to throw an exception object.
    * When you throw an exception, processing continues in an exception handler.
    * Every exception should be handled somewhere in your program; You handle exceptions with the try/catch statement; Each catch clause contains the handler for an exception type
    * Checked exceptions are due to external circumstances that the programmer cannot prevent; The compiler checks that your program handles these exceptions.
    * Add a throws clause to a method that can throw a checked exception.
    * Once a try block is entered, the statements in a finally clause are guaranteed to be executed, whether or not an exception is thrown.
    * To describe an error condition, provide a subclass of an existing exception class.
* Application: Handling input errors
    * When designing a program, ask yourself what kinds of exceptions can occur.
    * For each exception, you need to decide which part of your program can competently handle it.
*/

//sample program to read and write numbers

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Total{
  public static void main(String[] args) throws FileNotFoundException {

  // Prompt for the input and output file names
  Scanner console = new Scanner(System.in);
  System.out.print("Input file: ");
  String inputFileName = console.next();
  System.out.print("Output file: ");
  String outputFileName = console.next();

  // Construct the Scanner and PrintWriter objects for reading and writing
  File inputFile = new File(inputFileName);
  Scanner in = new Scanner(inputFile);
  PrintWriter out = new PrintWriter(outputFileName);

  // Read the input and write the output
  double total = 0;

  while (in.hasNextDouble()) {
    double value = in.nextDouble();
    out.printf("%15.2f\n", value);
    total = total + value;
  }
  out.printf("Total: %8.2f\n", total);
  in.close();
  out.close();
 }
}


//parse string to get int
int populationValue = Integer.parseInt(population);


//sample program that describes value associated to country

public class CountryValue{

  private String country;
  private double value;

  public CountryValue(String line)
  {
  // Locate the start of the first digit
  int i = 0;

  while (!Character.isDigit(line.charAt(i))) { i++; }
  // Locate the end of the preceding word
  int j = i - 1;

  while (Character.isWhitespace(line.charAt(j))) { j--; }
  // Extract the country name
  country = line.substring(0, j + 1);
  // Extract the value
  value = Double.parseDouble(line.substring(i).trim());
  }

  public String getCountry() {
    return country;
  }

  public double getValue() {
    return value;
  }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class PopulationDensity{

  public static void main(String[] args) throws FileNotFoundException{
  // Open input files
  Scanner in1 = new Scanner(new File("worldpop.txt"));
  Scanner in2 = new Scanner(new File("worldarea.txt"));

  // Open output file
  PrintWriter out = new PrintWriter("world_pop_density.txt");

  // Read lines from each file
  while (in1.hasNextLine() && in2.hasNextLine()) {
    CountryValue population = new CountryValue(in1.nextLine());
    CountryValue area = new CountryValue(in2.nextLine());
  // Compute and print the population density
    double density = 0;
    if (area.getValue() != 0){
      density = population.getValue() / area.getValue();
    }
    out.printf("%-40s%15.2f\n", population.getCountry(), density);
  }
  in1.close();
  in2.close();
  out.close();
  }
}

//throw example
if (amount > balance) {
  throw new IllegalArgumentException("Amount exceeds balance");
}

//try catch example
try{
  String filename = . . .;
  Scanner in = new Scanner(new File(filename)); String input = in.next();
  int value = Integer.parseInt(input);
}
catch (IOException exception){
  exception.printStackTrace();
}
catch (NumberFormatException exception){
  System.out.println(exception.getMessage());
}

//finally clause example
PrintWriter out = new PrintWriter(filename);
try{
  writeData(out);
}
finally {
  out.close();
}

//END OF CHAPTER 11


/*
CHAPTER 12: OBJECT ORIENTED DESIGN

* Classes and their responsibilities
    * When you design a program, you work from a requirements specification; The designer’s task is to discover structures that make it possible to implement the requirements in a computer program
    * When you solve a problem using objects and classes, you need to determine the classes required for the implementation; To discover classes, look for nouns in the problem description
    * Once you have identified a set of classes, you define the behavior for each class; A simple rule for finding these methods is to look for verbs in the task description, then match the verbs to the appropriate objects
    * A CRC card describes a class,its responsibilities, and its collaborating classes.
    * For each responsibility, you record which other classes are needed to fulfill it. Those classes are the collaborators.
    * The CRC card is a high level method, informal on purpose, so that you can be creative and discover classes and their properties.
* Relationships between classes
    * When designing a program, it is useful to document the relationships between classes.
    * A class depends on another class if it uses objects of that class;If many classes of a program depend on each other, then we say that the coupling between classes is high
    * A class aggregates another if its objects contain objects of the other class.
    * Inheritance is a relationship between a more general class (the superclass) and a more specialized class (the subclass). This relationship is often described as the “is-a” relationship. Every truck is a vehicle.
    * Inheritance (the is-a relationship) is sometimes inappropriately used when the has-a relationship would be more appropriate.
    * Aggregation (the has-a relationship) denotes that objects of one class contain references to objects of another class.
    * Sometimes it is useful to indicate class attributes and methods in a class diagram. An attribute is an externally observable property that objects of a class have.
* Application: Printing an invoice
    * Start the development process by gathering and documenting program requirements.
    * Use CRC cards to find classes, responsibilities, and collaborators
    * Use UML diagrams to record class relationships.
    * The final step of the design phase is to write the documentation of the discovered classes and methods. Use javadoc comments (with the method bodies left blank) to record the behavior of classes.
    * After completing the design, implement your classes.
*/

//Implementation of printing an invoice

/**
This program demonstrates the invoice classes by printing a sample invoice.
*/

public class InvoicePrinter{
  public static void main(String[] args) {

    Address samsAddress = new Address("Sam’s Small Appliances","100 Main Street", "Anytown", "CA", "98765");
    Invoice samsInvoice = new Invoice(samsAddress);
    samsInvoice.add(new Product("Toaster", 29.95), 3);
    samsInvoice.add(new Product("Hair dryer", 24.95), 1);
    samsInvoice.add(new Product("Car vacuum", 19.99), 2);
    System.out.println(samsInvoice.format());

  }

}

/**
 Describes an invoice for a set of purchased products.
*/

import java.util.ArrayList;

public class Invoice{

  private Address billingAddress;
  private ArrayList<LineItem> items;

  //construct an invoice
  public Invoice(Address anAddress) {
    items = new ArrayList<LineItem>();
    billingAddress = anAddress;
  }

  //add a charge for a product
  public void add(Product aProduct, int quantity) {
    LineItem anItem = new LineItem(aProduct, quantity);
    items.add(anItem);
  }

  //format an invoice
  public String format() {
    String r=" INVOICE\n\n" + billingAddress.format() + String.format("\n\n%-30s%8s%5s%8s\n", "Description", "Price", "Qty", "Total");

    for (LineItem item : items) {
      r = r + item.format() + "\n";
    }

    r = r + String.format("\nAMOUNT DUE: $%8.2f", getAmountDue());
    return r;
  }

  //compute amount due
  private double getAmountDue() {
    double amountDue = 0;
    for (LineItem item : items) {
      amountDue = amountDue + item.getTotalPrice();
    }
    return amountDue;
  }

}



/**
Describes a quantity of an article to purchase.
*/

public class LineItem{

  private int quantity;
  private Product theProduct;

  //construct an item
  public LineItem(Product aProduct, int aQuantity) {
    theProduct = aProduct;
    quantity = aQuantity;
  }

  //compute total cost of LineItem
  public double getTotalPrice() {
    return theProduct.getPrice() * quantity;
  }

  //format item to return LineItem
  public String format() {
    return String.format("%-30s%8.2f%5d%8.2f", theProduct.getDescription(), theProduct.getPrice(), quantity, getTotalPrice());
  }

}

/**
Describes a product with a description and a price.
*/

public class Product{

  private String description;
  private double price;

  //construct a product
  public Product(String aDescription, double aPrice) {
    description = aDescription;
    price = aPrice;
  }

  //get product description
  public String getDescription() {
    return description;
  }

  //get price
  public double getPrice() {
    return price;
  }

}


/**
Describes a mailing address.
*/

public class Address{

  private String name;
  private String street;
  private String city;
  private String state;
  private String zip;

  //construct an Address
  public Address(String aName, String aStreet, String aCity, String aState, String aZip){
    name = aName;
    street = aStreet;
    city = aCity;
    state = aState;
    zip = aZip;
  }

  //format address to return
  public String format() {
    return name + "\n" + street + "\n" + city + ", " + state + " " + zip;
  }

}

//END OF CHAPTER 12


/*
CHAPTER 13: RECURSION

* Triangle numbers
    * A recursive computation solves a problem by using the solution to the same problem with simpler inputs.
    * For a recursion to terminate, there must be special cases for the simplest values.
* Recursive Helper Methods
    * Sometimes it is easier to find a recursive solution if you make a slight change to the original problem.
    * Testing whether a substring is a palindrome instead of a sentence is an example of a helper method.
* Efficiency of Recursion
    * Recursion can sometimes be inefficient; for a fibonacci algorithm, some calls are called multiple times
    * Occasionally, a recursive solution is much slower than its iterative counterpart. However, in most cases, the recursive solution is only slightly slower.
* Permutations
    * A permutation is simply a rearrangement of the letters in the string.
    * The permutations of a string can be obtained more naturally through recursion than with a loop.
* Mutual Recursion
    * In a mutual recursion, a set of cooperating methods calls each other repeatedly.
* Backtracking
    * Backtracking examines partial solutions, abandoning unsuitable ones and returning to consider other candidates.
    * Backtracking can be used to solve crossword puzzles, escape from mazes, or find solutions to systems that are constrained by rules.
    * In order to employ backtracking for a particular problem, we need two characteristic properties: A procedure to examine a partial solution and determine whether to accept, abandon or continue executing a solution
    * A procedure to extend a partial solution, generating one or more solutions that come closer to the goal.
*/

//example of a recursive class

public class Triangle{

  private int width;

  public Triangle(int aWidth) {
    width = aWidth;
  }

  public int getArea() {
    if (width <= 0) {
      return 0;
    }
    else if (width == 1) {
      return 1;
    } else{
      Triangle smallerTriangle = new Triangle(width - 1);
      int smallerArea = smallerTriangle.getArea();
      return smallerArea + width;
    }
  }

}

//fibonacci example

import java.util.Scanner;

public class RecursiveFib{

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = in.nextInt();

    for (int i = 1; i <= n; i++)
    {
      long f = fib(i);
      System.out.println("fib(" + i + ") = " + f);
    }
  }
  public static long fib(int n) {
    if (n <= 2) {
      return 1;
    }
    else {
      return fib(n - 1) + fib(n - 2);
    }
  }
}

//Permutation example

import java.util.ArrayList;

public class Permutations{

  public static void main(String[] args) {
    for (String s : permutations("eat"))
    {
        System.out.println(s);
    }
  }

  public static ArrayList<String> permutations(String word) {
    ArrayList<String> result = new ArrayList<String>();

    if (word.length() == 0){
      result.add(word);
      return result;
    }
    else{
      for (int i = 0; i < word.length(); i++)
      {
        String shorter = word.substring(0, i) + word.substring(i + 1);
        ArrayList<String> shorterPermutations = permutations(shorter);

        for (String s : shorterPermutations)
        {
          result.add(word.charAt(i) + s);
        }

      }
      return result;
    }
  }
}

//END OF CHAPTER 13

/*
CHAPTER 14: SORTING AND SEARCHING

* Selection Sort
    * A sorting algorithm rearranges the elements of a collection so that they are stored in sorted order.
    * In selection sort, pick the smallest element and swap it with the first one. Pick the smallest element of the remaining ones and swap it with the next one, and so on.
* Profiling the Selection sort algorithm
    * To measure the running time of a method, get the current time immediately before and after the method call.
* Analyzing the performance of a Selection sort algorithm
    * Computer scientists use the big-O notation to describe the growth rate of a function.
    * Selection sort is an O(n2) algorithm. Doubling the data set means a fourfold increase in processing time.
    * Algorithms can grow at a constant, logarithmic, linear, log-linear, quadratic, cubic, exponential and factorial rate
    * Insertion sort is another simple sorting algorithm; In this algorithm, we assume that the initial sequence of an array is already sorted, then we enlarge the initial sequence by inserting the next array element at the proper location until the end of the array where the process is complete.
    * Insertion sort is an O(n2) algorithm, but it is O(n) if the array is already sorted
* Merge Sort
    * The merge sort algorithm sorts an array by cutting the array in half, recursively sorting each half, and then merging the sorted halves.
    * If the computer keeps dividing the array into smaller and smaller subarrays, sorting each half and merging them back together carries out dramatically fewer steps than the selection sort requires.
* Analyzing the Merge Sort Algorithm
    * The Merge sort is an O(n log(n)) algorithm. The n log(n) function grows much more slowly than n2.
    * Quicksort is a commonly used algorithm that has the advantage over merge sort that no temporary arrays are required to sort and merge the partial results.
    * The quicksort algorithm, like merge sort, is based on the strategy of divide and conquer.  To sort a range a[from] . . . a[to] of the array a, first rearrange the elements in the range so that no element in the range a[from] . . . a[p] is larger than any element in the range a[p + 1] . . . a[to]. In the next step, sort each partition, by recursively applying the same algorithm to the two partitions.
    * On average, the quicksort algorithm is an O(n log(n)) algorithm. Its worst-case run-time behavior is O(n2).
* Searching
    * A linear search examines all values in an array until it finds a match or reaches the end.
    * When searching for a value, the search method returns the first index of the match, or -1 if the value does not occur in a.
    * A binary search locates a value in a sorted array by determining whether the value occurs in the first or second half, then repeating the search in one of the halves.
* Estimating the Running Time of an Algorithm
    * Being able to estimate the running times of other algorithms is an important skill
    * A loop with n iterations has O(n) running time if each step consists of a fixed number of actions.
    * A loop with n iterations has O(n2) running time if each step takes O(n) time.
    * The big-Oh running time for doing several steps in a row is the largest of the big-Oh times for each step.
    * A loop with n iterations has O(n2) running time if the ith step takes O(i) time.
    * An algorithm that cuts the size of work in half in each step runs in O(log(n)) time.
* Sorting and Searching in the JAVA library
    * The Arrays class implements a sorting method that you should use for your Java programs.
    * The Collections class contains a sort method that can sort array lists.
    * The Arrays and Collections classes contain static binarySearch methods with a useful enhancement. If a value is not found in the array, then the returned value is not –1, but –k – 1, where k is the position before which the element should be inserted.
    * The sort method of the Arrays class sorts objects of classes that implement the Comparable interface. You need to implement the interface and provide a compareTo method that would compare objects based on your choice of element
    *
*/

//Selection sort algorithm

public class SelectionSorter{

  public static void sort(int[] a) {
    for (int i = 0; i < a.length - 1; i++)
    {
      int minPos = minimumPosition(a, i);
      ArrayUtil.swap(a, minPos, i);
    }
  }

  private static int minimumPosition(int[] a, int from) {

    int minPos = from;
    for (int i = from + 1; i < a.length; i++)
    {
      if (a[i] < a[minPos]) {
        minPos = i;
      }
    }
    return minPos;
  }

}

import java.util.Arrays;

public class SelectionSortDemo{

  public static void main(String[] args) {
    int[] a = ArrayUtil.randomIntArray(20, 100);
    System.out.println(Arrays.toString(a));
    SelectionSorter.sort(a);
    System.out.println(Arrays.toString(a));
  }

}

import java.util.Random;

public class ArrayUtil{

  private static Random generator = new Random();

  public static int[] randomIntArray(int length, int n) {

    int[] a = new int[length];
    for (int i = 0; i < a.length; i++)
    {
      a[i] = generator.nextInt(n);
    }

    return a;

  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}

//Insertion Sort Algorithm

public class InsertionSorter {

  public static void sort(int[] a) {
    for (int i = 1; i < a.length; i++)
    {
      int next = a[i];
      int j = i;

      while (j > 0 && a[j - 1] > next) {
        a[j] = a[j - 1];
        j--;
      }
      //insert next element
      a[j] = next;
    }
  }
}

//Merge Sort Algorithm

public class MergeSorter{

  public static void sort(int[] a)
  {
    if (a.length <= 1) { return; }
    int[] first = new int[a.length / 2];
    int[] second = new int[a.length - first.length];

    // Copy the first half of a into first, the second half into second
    for (int i = 0; i < first.length; i++)
    {
      first[i] = a[i];
    }
    for(inti= 0; i < second.length; i++)
    {
      second[i] = a[first.length + i];
    }

    sort(first);
    sort(second);
    merge(first, second, a);
  }

  private static void merge(int[] first, int[] second, int[] a)
  {
    int iFirst = 0; // Next element to consider in the first array
    int iSecond = 0; // Next element to consider in the second array
    int j = 0; // Next open position in a


    while(iFirst < first.length && iSecond < second.length)
    {
      if(first[iFirst] < second[iSecond])
      {
        a[j] = first[iFirst];
        iFirst++;
      }
      else
      {
        a[j] = second[iSecond];
        iSecond++;
      }
      j++;
    }
    while (iFirst < first.length)
    {
      a[j] = first[iFirst];
      iFirst++; j++;
    }
    while (iSecond < second.length)
    {
      a[j] = second[iSecond];
      iSecond++;
      j++;
    }
  }
}

import java.util.Arrays;

public class MergeSortDemo{
  public static void main(String[] args) {
    int[] a = ArrayUtil.randomIntArray(20, 100);
    System.out.println(Arrays.toString(a));
    MergeSorter.sort(a);
    System.out.println(Arrays.toString(a));
  }
}

//Quicksort Algorithm

public class QuickSorter
{

   public static void sort(int[] a)
   {
      sort(a, 0, a.length - 1);
   }

   public static void sort(int[] a, int from, int to)
   {
      if (from >= to) { return; }
      int p = partition(a, from, to);
      sort(a, from, p);
      sort(a, p + 1, to);
   }

   private static int partition(int[] a, int from, int to)
   {
      int pivot = a[from];
      int i = from - 1;
      int j = to + 1;
      while (i < j)
      {
         i++; while (a[i] < pivot) { i++; }
         j--; while (a[j] > pivot) { j--; }
         if (i < j) { ArrayUtil.swap(a, i, j); }
      }
      return j;
   }
}

import java.util.Arrays;

public class QuickSortDemo
{
   public static void main(String[] args)
   {
      //Use arrayutil class from earlier
      int[] a = ArrayUtil.randomIntArray(20, 100);
      System.out.println(Arrays.toString(a));
      QuickSorter.sort(a);
      System.out.println(Arrays.toString(a));
   }
}

//Linear Search algorithm

public class LinearSearcher
{
   public static int search(int[] a, int value)
   {
      for (int i = 0; i < a.length; i++)
      {
         if (a[i] == value) {
           return i;
         }
      }
      return -1;
   }
}

public class LinearSearchDemo
{
   public static void main(String[] args)
   {
      int[] a = ArrayUtil.randomIntArray(20, 100);
      System.out.println(Arrays.toString(a));
      Scanner in = new Scanner(System.in);

      boolean done = false;
      while (!done)
      {
         System.out.print("Enter number to search for, -1 to quit: ");
         int n = in.nextInt();
         if (n == -1)
         {
            done = true;
         }
         else
         {
            int pos = LinearSearcher.search(a, n);
            System.out.println("Found in position " + pos);
         }
      }
   }
}

//Binary Search algorithm

public class BinarySearcher
{

   public static int search(int[] a, int low, int high, int value)
   {
      if (low <= high)
      {
         int mid = (low + high) / 2;

         if (a[mid] == value)
         {
            return mid;
         }
         else if (a[mid] < value )
         {
            return search(a, mid + 1, high, value);
         }
         else
         {
            return search(a, low, mid - 1, value);
         }
      }
      else
      {
         return -1;
      }
   }
}

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDemo
{
   public static void main(String[] args)
   {
      // Construct random array

      int[] a = ArrayUtil.randomIntArray(20, 100);
      Arrays.sort(a);
      System.out.println(Arrays.toString(a));
      Scanner in = new Scanner(System.in);

      boolean done = false;
      while (!done)
      {
         System.out.print
               ("Enter number to search for, -1 to quit: ");
         int n = in.nextInt();
         if (n == -1)
         {
            done = true;
         }
         else
         {
            int pos = BinarySearcher.search(a, 0, a.length - 1, n);
            System.out.println("Found in position " + pos);
         }
      }
   }
}


//END OF CHAPTER 14

/*
CHAPTER 15: THE JAVA COLLECTIONS FRAMEWORK

* Overview of the JAVA Collections Framework
    * The collections framework is a hierarchy of interface types and classes for collecting objects.
    * The List interface describes an important category of collections. In Java, a list is a collection that remembers the order of its elements.
    * A set is an unordered collection of unique elements. Because a set does not track the order of the elements, it can arrange the elements so that the operations of finding, adding, and removing elements become more efficient such as hash tables and binary search trees
    * A stack remembers the order of its elements, but it does not allow you to insert elements in every position. You can add and remove elements only at the top
    * In a queue, you add items to one end (the tail) and remove them from the other end (the head).
    * A map keeps associations between key and value objects.
* Linked Lists
    * A linked list is a data structure used for collecting a sequence of objects that allows efficient addition and removal of elements in the middle of the sequence.
    * A linked list consists of a number of nodes, each of which has a reference to the next node.
    * Adding and removing elements at a given location in a linked list is efficient.
    * Visiting the elements of a linked list in sequential order is efficient, but random access is not.
    * An iterator encapsulates a position anywhere inside the linked list. You use a list iterator to access elements inside a linked list.
    * The nodes of the LinkedList class store two links: one to the next element and one to the previous one. Such a list is called a doubly-linked list. You can use the previ- ous and hasPrevious methods of the ListIterator interface to move the iterator position backward.
* Sets
    * A set organizes its values in an order that is optimized for efficiency, which may not be the order in which you add elements.
    * A difference between collections and sets is that a set doesn't take duplicates
    * The HashSet and TreeSet classes both implement the Set interface. These two classes provide set implementations based on two different mechanisms, called hash tables and binary search trees. Both implementations arrange the set elements so that finding, adding, and removing elements is efficient, but they use different strategies.
    * The basic idea of a hash table is simple. Set elements are grouped into smaller collections of elements that share the same characteristic.In order to use a hash table, the elements must have a method to compute those integer values. This method is called hashCode. You can form hash sets holding objects of type String, Integer, Double, Point, Rectangle, or Color.
    * The TreeSet class uses a different strategy for arranging its elements. Elements are kept in sorted order. The elements are stored in nodes, as in a linked list. However, the nodes are not arranged in a linear sequence but in a tree shape.
    * You can form tree sets for any class that implements the Comparable interface, such as String or Integer.
    * As a rule of thumb, you should choose a TreeSet if you want to visit the set’s elements in sorted order. Otherwise choose a HashSet––as long as the hash function is well chosen, it is a bit more efficient.
    * Sets don’t have duplicates. Adding a duplicate of an element that is already present is ignored.
    * A set iterator visits the elements in the order in which the set implementation keeps them. When you visit elements of a tree set, they always appear in sorted order, even if you inserted them in a different order. You cannot add an element to a set at an iterator position.
* Maps
    * A map allows you to associate elements from a key set with elements from a value collection. You use a map when you want to look up objects by using a key.
    * Just as there are two kinds of set implementations, the Java library has two implementations for the Map interface: HashMap and TreeMap.
    * To find all keys and values in a map, iterate through the key set and find the values that correspond to the keys.
    * A hash function is a function that computes an integer value, the hash code, from an object in such a way that different objects are likely to yield different hash codes. A good hash function avoids collisions which are identical hash codes for different objects.
* Stacks, Queues and Priority Queues
    * A stack is a collection of elements with “last-in, first-out” retrieval. With stacks, the addi- tion and removal operations are called push and pop.
    * An important example is the run-time stack that a processor or virtual machine keeps to store the values of variables in nested methods. Whenever a new method is called, its parameter variables and local variables are pushed onto a stack. When the method exits, they are popped off again.
    * A queue is a collection of elements with “first-in, first-out” retrieval. The LinkedList class implements the Queue interface.
    * A priority queue collects elements, each of which has a priority. A typical example of a priority queue is a collection of work requests, some of which may be more urgent than others. Unlike a regular queue, the priority queue does not maintain a first-in, first-out discipline. Instead, elements are retrieved according to their priority. In other words, new items can be inserted in any order. But whenever an item is removed, it is the item with the most urgent priority.
* Stack and Queue Applications
    * A stack can be used to check whether parentheses in an expression are balanced.
    * Use a stack to evaluate expressions in reverse Polish notation.
    * Using two stacks, you can evaluate expressions in standard algebraic notation.
    * Use a stack to remember choices you haven’t yet made so that you can backtrack to them.
*/


//Example of a Linked list

import java.util.LinkedList;
import java.util.ListIterator;


public class ListDemo
{
   public static void main(String[] args)
   {
      LinkedList<String> staff = new LinkedList<String>();
      staff.addLast("Diana");
      staff.addLast("Harry");
      staff.addLast("Romeo");
      staff.addLast("Tom");

      ListIterator<String> iterator = staff.listIterator(); // |DHRT
      iterator.next(); // D|HRT
      iterator.next(); // DH|RT
      iterator.add("Juliet"); // DHJ|RT
      iterator.add("Nina"); // DHJN|RT
      iterator.next(); // DHJNR|T
      iterator.remove(); // DHJN|T
      System.out.println(staff);
      System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");
   }
}

//Example of a Set implementation

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
   This program checks which words in a file are not present in a dictionary.
*/
public class SpellCheck
{
   public static void main(String[] args)
      throws FileNotFoundException
   {
      // Read the dictionary and the document

      Set<String> dictionaryWords = readWords("words");
      Set<String> documentWords = readWords("alice30.txt");

      // Print all words that are in the document but not the dictionary

      for (String word : documentWords)
      {
         if (!dictionaryWords.contains(word))
         {
            System.out.println(word);
         }
      }
   }

   /**
      Reads all words from a file.
      @param filename the name of the file
      @return a set with all lowercased words in the file. Here, a
      word is a sequence of upper- and lowercase letters.
   */
   public static Set<String> readWords(String filename)
      throws FileNotFoundException
   {
      Set<String> words = new HashSet<String>();
      Scanner in = new Scanner(new File(filename));
      // Use any characters other than a-z or A-Z as delimiters
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext())
      {
         words.add(in.next().toLowerCase());
      }
      return words;
   }
}

//Example of a map function

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo
{
   public static void main(String[] args)
   {
      Map<String, Color> favoriteColors = new HashMap<String, Color>();
      favoriteColors.put("Juliet", Color.BLUE);
      favoriteColors.put("Romeo", Color.GREEN);
      favoriteColors.put("Adam", Color.RED);
      favoriteColors.put("Eve", Color.BLUE);

      // Print all keys and values in the map

      Set<String> keySet = favoriteColors.keySet();
      for (String key : keySet)
      {
         Color value = favoriteColors.get(key);
         System.out.println(key + " : " + value);
      }
   }
}

//END OF CHAPTER 15

/*
CHAPTER 16: BASIC DATA STRUCTURES

* Implementing Linked Lists
    * A linked list stores elements in a sequence of nodes. We need a class to represent the nodes. In a singly-linked list, a Node object stores an element and a reference to the next node.
    * Because the methods of both the linked list class and the iterator class have fre- quent access to the Node instance variables, we do not make the instance variables of the Node class private. Instead, we make Node a private inner class of the LinkedList class. An inner class is a class that is defined inside another class. The methods of the outer class can access the public features of the inner class. However, because the inner class is private, it cannot be accessed anywhere other than from the outer class.
    * When adding or removing the first element, the reference to the first node must be updated.
    * A list iterator object has a reference to the last visited node.
    * To advance an iterator, update the position and remember the old position for the remove method.
    * If the element to be removed is the first element, we just call removeFirst. Otherwise, an element in the middle of the list must be removed, and the node preceding it needs to have its next reference updated to skip the removed element. We also need to update the position reference so that a subsequent call to the next method skips over the element after the removed one.
    * The add method of the iterator inserts the new node after the last visited node. After adding the new element, we set the isAfterNext flag to false, in order to disallow a subsequent call to the remove or set method.
    * The set method changes the data stored in the previously visited element
    * In a doubly-linked list, accessing an element is an O(n) operation; adding and removing an element is O(1).
* Implementing Array Lists
    * An array list maintains a reference to an array of elements. The array is large enough to hold all elements in the collection—in fact, it is usually larger to allow for adding additional elements. To access array list elements, we provide get and set methods.Getting or setting an array list element is an O(1) operation.
    * When removing an element at position k, the elements with higher index values need to move. Inserting or removing an array list element is an O(n) operation
    * Before inserting an element into an internal array that is completely full, we must replace the array with a bigger one.  This new array is typically twice the size of the current array. The existing elements are then copied into the new array. Reallocation is an O(n) operation because all elements need to be copied to the new array.
* Implementing Stacks and Queues
    * Stacks and queues are examples of abstract data types. We only specify how the operations must behave, not how they are implemented.
    * A stack can be implemented as a linked list, adding and removing elements at the front.
    * When implementing a stack as an array list, add and remove elements at the back.
    * A queue can be implemented as a linked list, adding elements at the back and removing them at the front.
    * In a circular array implementation of a queue, element locations wrap from the end of the array to the beginning.
* Implementing a Hash table
    * The basic idea behind hashing is to place objects into an array, at a location that can be determined from the object itself. Each object has a hash code, an integer value that is computed from an object in such a way that different objects are likely to yield different hash codes.
    * A hash code is used as an array index into a hash table, an array that stores the set elements. In the simplest implementation of a hash table, you could make a very long array and insert each object at the location of its hash code
    * A hash table can be implemented as an array of buckets— sequences of nodes that hold elements with the same hash code.
    * If there are no or only a few collisions, then adding, locating, and removing hash table elements takes constant or O(1) time.
*/

//Linked List

import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
   private Node first;

   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;
   }

   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null) { throw new NoSuchElementException(); }
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null) { throw new NoSuchElementException(); }
      Object element = first.data;
      first = first.next;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   class Node
   {
      public Object data;
      public Node next;
   }

   class LinkedListIterator implements ListIterator
   {
      private Node position;
      private Node previous;
      private boolean isAfterNext;

      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
         isAfterNext = false;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext()) { throw new NoSuchElementException(); }
         previous = position; // Remember for remove
         isAfterNext = true;

         if (position == null)
         {
            position = first;
         }
         else
         {
            position = position.next;
         }

         return position.data;
      }

      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
      public boolean hasNext()
      {
         if (position == null)
         {
            return first != null;
         }
         else
         {
            return position.next != null;
         }
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }

         isAfterNext = false;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (!isAfterNext) { throw new IllegalStateException(); }

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
         isAfterNext = false;
      }

      /**
         Sets the last traversed element to a different value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (!isAfterNext) { throw new IllegalStateException(); }
         position.data = element;
      }
   }
}

/**
   A list iterator allows access of a position in a linked list.
   This interface contains a subset of the methods of the
   standard java.util.ListIterator interface. The methods for
   backward traversal are not included.
*/
public interface ListIterator
{
   /**
      Moves the iterator past the next element.
      @return the traversed element
   */
   Object next();

   /**
      Tests if there is an element after the iterator position.
      @return true if there is an element after the iterator position
   */
   boolean hasNext();

   /**
      Adds an element before the iterator position
      and moves the iterator past the inserted element.
      @param element the element to add
   */
   void add(Object element);

   /**
      Removes the last traversed element. This method may
      only be called after a call to the next() method.
   */
   void remove();

   /**
      Sets the last traversed element to a different value.
      @param element the element to set
   */
   void set(Object element);
}



//END OF CHAPTER 16


/*
CHAPTER 17: TREE STRUCTURES

* Basic Tree Concepts
    * A tree is composed of nodes, each of which can have child nodes.Trees are commonly used to represent hierarchical relationships.
    * The root is the node with no parent. A leaf is a node with no children.
    * A tree class uses a node class to represent nodes and has an instance variable for the root node.
    * Many tree properties are computed with recursive methods.
* Binary Trees
    * A binary tree consists of nodes, each of which has at most two child nodes.
    * A decision tree contains questions used to decide among a number of options.
    * Another example of a binary tree is a Huffman tree. In a Huffman tree, the leaves contain symbols that we want to encode. To encode a particular symbol, walk along the path from the root to the leaf containing the symbol, and produce a zero for every left turn and a one for every right turn.
    * An expression tree shows the order of evaluation in an arithmetic expression.
    * In a balanced tree, all paths from the root to the leaves have approximately the same length.
    * Every node in a binary tree has references to two children, a left child and a right child. Either one may be null. A node in which both children are null is a leaf
* Binary Search Trees
    * All nodes in a binary search tree fulfill the property that the descendants to the left have smaller data values than the node data value, and the descendants to the right have larger data values.
    * To insert a value into a binary search tree, keep comparing the value with the node data and follow the nodes to the left or right, until reaching a null node.
    * When removing a node with only one child from a binary search tree, the child replaces the node to be removed.When removing a node with two children from a binary search tree, replace it with the smallest node of the right subtree.
    * In a balanced tree, all paths from the root to the leaves have about the same length. If a binary search tree is balanced, then adding, locating, or removing an element takes O(log(n)) time.
* Tree Traversal
    * To visit all elements in a tree, visit the root and recursively visit the subtrees.
    * In preorder traversal, we visit the root before visiting the subtrees, and in postorder traversal, we visit the root after the subtrees.
    * Postorder traversal of an expression tree yields the instructions for evaluating the expression on a stack-based calculator.

*/




//END OF CHAPTER 17



/*
CHAPTER 18: GENERICS

* Generic Classes and Type Parameters
    * Generic programming is the creation of programming constructs that can be used with many different types.
    * In Java, generic programming can be achieved with inheritance or with type parameters.
    * A generic class has one or more type parameters. Type parameters can be instantiated with class or interface types.However, you cannot substitute any of the eight primitive types for a type parameter.
    * Type parameters make generic code safer and easier to read.e
* Implementing Generic Types
    * Type variables of a generic class follow the class name and are enclosed in angle brackets.
    * Use type parameters for the types of generic instance variables, method parameter variables, and return values. Some people find it simpler to start out with a regular class, choosing some actual types instead of the type parameters
* Generic Methods
    * A generic method is a method with a type parameter.Such a method can occur in a class that in itself is not generic. You can think of it as a template for a set of methods that differ only by one or more types.
    * Supply the type parameters of a generic method between the modifiers and the method return type.
    * When you call the generic method, you need not specify which type to use for the type parameter. (In this regard, generic methods differ from generic classes.) Simply call the method with appropriate arguments, and the compiler will match up the type parameters with the argument types.
* Constraining Type Parameters
    * Type parameters can be constrained with bounds.
* Type Erasure
    * Because generic types are a fairly recent addition to the Java language, the virtual machine that executes Java programs does not work with generic classes or methods. Instead, type parameters are “erased”, that is, they are replaced with ordinary Java types.
    * You cannot construct objects or arrays of a generic type.

*/

//Example of a Generic class

public class Pair<T, S>
{
   private T first;
   private S second;

   public Pair(T firstElement, S secondElement)
   {
      first = firstElement;
      second = secondElement;
   }

   public T getFirst() { return first; }

   public S getSecond() { return second; }

   public String toString() { return "(" + first + ", " + second + ")"; }
}

public class PairDemo
{
   public static void main(String[] args)
   {
      String[] names = { "Tom", "Diana", "Harry" };
      Pair<String, Integer> result = firstContaining(names, "a");
      System.out.println(result.getFirst());
      System.out.println("Expected: Diana");
      System.out.println(result.getSecond());
      System.out.println("Expected: 1");
   }

   public static Pair<String, Integer> firstContaining(String[] strings, String sub)
   {
      for (int i = 0; i < strings.length; i++)
      {
         if (strings[i].contains(sub))
         {
            return new Pair<String, Integer>(strings[i], i);
         }
      }
      return new Pair<String, Integer>(null, -1);
   }
}

//Example of a Generic method

//use a concrete example and then implement generic
public class ArrayUtil {
  public static void print(String[] a)
  {
    for (String e : a) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}

public static <E> void print(E[] a)
{
  for (E e : a) {
    System.out.print(e + " ");
  }
  System.out.println();
}

//END OF CHAPTER 18


/*
CHAPTER 20: MULTITHREADING

* Running Threads
    * A thread is a program unit that is executed independently of other parts of the program. The Java virtual machine executes each thread for a short amount of time and then switches to another thread. This gives the illusion of executing the threads in parallel to each other. Actually, if a computer has multiple central processing units (CPUs), then some of the threads can run in parallel, one on each processor.
    * Running a thread requires an implementation of the Runnable interface with a run method; create an object of the runnable subclass and use the thread object and call the start method to start the thread

*/
