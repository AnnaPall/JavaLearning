public class StaticExamples {
/*
I
static is a non-access modifier in Java which is applicable for the following:

blocks
variables
methods
nested classes
To create a static member(block,variable,method,nested class), precede its declaration with the keyword static.
When a member is declared static, it can be accessed before any objects of its class are created,
and without reference to any object.
For example, in below java program, we are accessing static method m1() without creating any object of Test class.

Output
from m1


 */
    static void m1()
    {
        System.out.println("from m1");
    }

    public static void main(String[] args)
    {
        // calling m1 without creating
        // any object of class Test
        m1();
    }

}

/*II
        Static blocks

        If you need to do computation in order to initialize your static variables,
        you can declare a static block that gets executed exactly once, when the class is first loaded.
        Consider the following java program demonstrating use of static blocks.
*/

// Java program to demonstrate use of static blocks
class StaticExample2
{
    // static variable
    static int a = 10;
    static int b;

    // static block
    static {
        System.out.println("Static block initialized.");
        b = a * 4;
    }

    public static void main(String[] args)
    {
        System.out.println("from main");
        System.out.println("Value of a : "+a);
        System.out.println("Value of b : "+b);
    }
}
/*
Output:
        Static block initialized.
        from main
        Value of a : 10
        Value of b : 40
*/

/*III
        Satic variables

        When a variable is declared as static, then a single copy of variable is created and shared among all objects at class level. Static variables are, essentially, global variables. All instances of the class share the same static variable.

        Important points for static variables :-

        We can create static variables at class-level only. See here
static block and static variables are executed in order they are present in a program.
        Below is the java program to demonstrate that static block and static variables are executed in order they are present in a program.
*/

// java program to demonstrate execution
// of static blocks and variables
class StaticExample3
{
    // static variable
    static int a = m1();

    // static block
    static {
        System.out.println("Inside static block");
    }

    // static method
    static int m1() {
        System.out.println("from m1");
        return 20;
    }

    // static method(main !!)
    public static void main(String[] args)
    {
        System.out.println("Value of a : "+a);
        System.out.println("from main");
    }


}
//Output:
//        from m1
//        Inside static block
//        Value of a : 20
//        from main

/*
When a method is declared with static keyword, it is known as static method.
The most common example of a static method is main( ) method.As discussed above,
Any static member can be accessed before any objects of its class are created,
and without reference to any object.Methods declared as static have several restrictions:

They can only directly call other static methods.
They can only directly access static data.
They cannot refer to this or super in any way.
Below is the java program to demonstrate restrictions on static methods.
 */
// java program to demonstrate restriction on static methods
class StaticExample4
{
    // static variable
    static int a = 10;

    // instance variable
    int b = 20;

    // static method
    static void m1()
    {
        a = 20;
        System.out.println("from m1");

        // Cannot make a static reference to the non-static field b
//        b = 10; // compilation error

        // Cannot make a static reference to the
        // non-static method m2() from the type Test
//        m2(); // compilation error

        // Cannot use super in a static context
//        System.out.println(super.a); // compiler error
    }

    // instance method
    void m2()
    {
        System.out.println("from m2");
    }



    public static void main(String[] args)
    {
        // main method
    }
}
