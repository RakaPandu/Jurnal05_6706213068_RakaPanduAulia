package Tugas05;

/* Java implementation to convert
 infix expression to postfix*/
// Note that here we use Stack class for Stack operations

import java.util.Stack;

class Reverse
{

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    //Digunakan untuk men-scan dan memberikan return sesuai notasi penjumlahan, perkalian, pembagian dan
    //juga perpangkatan dari nostasi infix yang kita masukan

    // The main method that converts
    // given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)
    {
        // meninisialisasi String result yang kosong agar bisa kita gunakan nantinya
        String result = new String("");

        // meninisialisasi Stack baru yang kosong
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        //menjalankan rekursif sebanyak elemen yang ada pada string exp atau masukan inflix kita
        {
            char c = exp.charAt(i);
            //CharAt, men-return value dari sebuah indeks yang dimana jika indeksnya 0 maka
            //akan di return 1 dan seterusnya.

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
                //jika data yang dicari berupa angka maupun, disini kita menggunakan huruf
                //maka akan huruf tadi akan dimauskan ke result


                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);
                //nah jika kita menemukan sebuah kurung buka, maka akan kita pindahkan keatas stack

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
                //jika menemukan sebuah kurung tutup pada atas stack maka kita akan menjalankan perintah
                // yang ada, dimana perintah tersebut akan menghapus (mengubahnya menjadi null).
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            }
            else //jika oprator ditemukan, maka akan menjalankan while dibawah dan selanjutnya akan
            // melakukan push
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())){

                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        //menghapus semua oprator yang ada didalam stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    // Driver method
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        //untuk melihat input yang kita lakukan, maka saya akan menambahkan sebuah printout
        System.out.println(exp);

        //untuk saat ini saya matikan dahulu print out dari hasi program kita
        System.out.println(infixToPostfix(exp));
    }
}
//exp, merupakan masukan dari notasi inflix yang ingin kita proses


//Judul artikel/Author : Stack | Set 2 (Infix to Postfix) / GeeksforGeeks
//Sumber : https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
//tgl akses : 3/24/2022