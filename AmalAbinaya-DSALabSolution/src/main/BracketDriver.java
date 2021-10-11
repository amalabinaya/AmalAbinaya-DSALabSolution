package main;

import java.util.*;
public class BracketDriver {
	static Boolean Balancecheck(String str){
		Deque<Character> st = new ArrayDeque<Character>();

		for (int i = 0; i < str.length(); i++)
		{
			char x = str.charAt(i);
			if (x == '(' || x == '[' || x == '{'){
				st.push(x);
				continue;
			}

			if (st.isEmpty())
				return false;

			char check;
			switch (x) {
			case ')':
				check = st.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = st.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = st.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (st.isEmpty());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Brackets String :");
		String str = sc.next();
		if (Balancecheck(str))
			System.out.println("Balanced Brackets");
		else
			System.out.println("Brackets are not balance");
	}



}
