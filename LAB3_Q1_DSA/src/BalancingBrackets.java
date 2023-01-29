import java.util.*;

public class BalancingBrackets {

	static boolean BracketsBalanced(String exp) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char ch = exp.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {

				stack.push(ch);
				continue;
			}

			if (stack.isEmpty())
				return false;

			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		String exp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression: ");
		exp = sc.nextLine();

		if (exp.isEmpty()) {

			System.out.println("Please enter any expression");

		}

		else if (BracketsBalanced(exp))
			System.out.println("The entered String has Balanced Brackets");

		else
			System.out.println("The entered String do not contain Balanced Brackets");
	}
}
