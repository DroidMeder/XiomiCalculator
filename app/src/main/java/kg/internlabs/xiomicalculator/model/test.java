package kg.internlabs.xiomicalculator.model;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Stack;

public class test {
    String s = "bjh:khk:tryu:0988";

    String[] strings = s.split(":");
    double i = Double.parseDouble(s);
    String st = "kbfjfj";

    public void tt(){
        for (int j = 0; j < st.length(); j++) {
            st.charAt(j);
        }
    }
}


    /*private String ToPostfix(String infixExpr)
    {
        //	Выходная строка, содержащая постфиксную запись
        String postfixExpr = "";
        //	Инициализация стека, содержащий операторы в виде символов
        Stack<Character> stack = new Stack<Character>();

        //	Перебираем строку
        for (int i = 0; i < infixExpr.length(); i++)
        {
            //	Текущий символ
            char c = infixExpr.charAt(i);

            //	Если симовол - цифра
            if (Character.isDigit(c))
            {
                //	Парсии его, передав строку и текущую позицию, и заносим в выходную строку
                postfixExpr += GetStringNumber(infixExpr, i) + " ";
            }
            //	Если открывающаяся скобка
            else if (c == '(')
            {
                //	Заносим её в стек
                stack.push(c);
            }
            //	Если закрывающая скобка
            else if (c == ')')
            {
                //	Заносим в выходную строку из стека всё вплоть до открывающей скобки
                while (stack.size() > 0 && stack.peek() != '(')
                    postfixExpr += stack.pop();
                //	Удаляем открывающуюся скобку из стека
                stack.pop();
            }
            //	Проверяем, содержится ли символ в списке операторов
            else if (operationPriority.containsKey(c))
            {
                //	Если да, то сначала проверяем
                char op = c;
                //	Является ли оператор унарным символом
                if (op == '-' && (i == 0 || (i > 1 && operationPriority.
                        .containsKey( infixExpr.charAt(i-1)))))
                    //	Если да - преобразуем его в тильду
                    op = '~';

                //	Заносим в выходную строку все операторы из стека, имеющие более высокий приоритет
                while (stack.size() > 0 && ( operationPriority.[stack.peek()] >= operationPriority[op]))
                    postfixExpr += stack.pop();
                //	Заносим в стек оператор
                stack.push(op);
            }
        }
        //	Заносим все оставшиеся операторы из стека в выходную строку
     *//*   foreach (char op in stack)
        postfixExpr += op;*//*

        //	Возвращаем выражение в постфиксной записи
        return postfixExpr;
    }*/

 /*   private Dictionary<Character, Integer> operationPriority =
            new Dictionary<Character, Integer>(') {
    } {
        {'(', 0},
        {'+', 1},
        {'-', 1},
        {'*', 2},
        {'/', 2},
        {'^', 3},
        {'~', 4}	//	Унарный минус
    };

}*/
