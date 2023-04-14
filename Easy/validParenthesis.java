import java.util.Stack;
public class validParenthesis {
    public static void main(String[] args) {
        String s1 = "({[]})";
        String s2 = "][]{}";
        System.out.println("S1 is valid Parenthesis:-"+isValid1(s1));
        System.out.println("S1 is valid Parenthesis:-"+isValid1(s2));
    }
    // Best Approach.
    private static boolean isValid1(String s)
    {
        Stack<Character> st = new Stack<>();
        // for each loop
        for(char c: s.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
               st.push(c);
            else if(c == ')' && !st.isEmpty() && st.peek()=='(')
                st.pop();
            else if(c == ']' && !st.isEmpty() && st.peek()=='[')
                st.pop();
            else if(c == '}' && !st.isEmpty() && st.peek()=='{')
                st.pop();
            else
                return false;
        }
        return st.isEmpty();
    }
    // Basic Approach.
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
        {
            return false;
        }
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            if(c == ')' || c == ']' || c == '}')
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char top = st.pop();
                if(c == ')' && top!='(' || c == ']' && top!='[' || c == '}' && top!='{')
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
