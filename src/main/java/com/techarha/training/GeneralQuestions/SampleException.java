package com.techarha.training.GeneralQuestions;


/**
 Exception Handling
 You are given a piece of Java code. You have to complete the code by writing down the handlers for exceptions thrown by the code. The exceptions the code may throw along with the handler message are listed below:

 Division by zero: Print "Invalid division".
 String parsed to a numeric variable : Print "Format mismatch".
 Accessing an invalid index in string : Print "Index is invalid".
 Accessing an invalid index in array : Print "Array index is invalid".

 MyException : This is a user defined Exception which you need to create. It takes a parameter
 p
 a
 r
 a
 m
 param. When an exception of this class is encountered, the handler should print "MyException[param]", here
 p
 a
 r
 a
 m
 param is the parameter passed to the exception class.

 Exceptions other than mentioned above : Any other exception except the above ones fall in this category. Print "Exception encountered".

 Finally, after the exception is handled, print "Exception Handling Completed".

 Example: For an exception of MyException class if the parameter value is 5, the message will look like
 MyException[5].

 Input Format:
 The code handles all the input itself.

 Output Format:
 If any exception is encountered in the code, print the respective handler code.
 The last line of output should be "Exception Handling Completed".

 Sample Input
 10
 10
 9
 8
 7
 6
 5
 4
 3
 2
 1
 exceptionhandlingtime
 Sample Output
 a
 MyException[117]
 Exception Handling Completed
 Explanation
 An exception is thrown of MyException type.

 First line of output is the
 10
 t
 h
 10th character of input string.
 Second line of output is the handler message: "MyException[117]". Here
 117
 117 is the parameter value.
 Last line of output is "Exception Handling Completed".

 If the string was "exception" instead of "exceptionhandlingtime", the output would look like:

 Index is invalid
 Exception Handling Completed

 Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 */
public class SampleException {

    public static void main(String[] args) {
        int[] data = new int[5];

        for( int d: data) {
            System.out.println(d);
        }
    }

}