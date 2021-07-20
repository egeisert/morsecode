package mypackage;

import java.util.Scanner;

public class MorseCode {

	static BinarySearchTree tree = new BinarySearchTree(); //global tree

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Populating Morse Code BST");
		
		
		tree.insert('o', "---");
		tree.insert('k',"-.-");
		tree.insert('h',"....");
		tree.insert('w',".--");
		tree.insert('c',"-.-.");
		tree.insert('t',"-");
		tree.insert('z',"--..");
		tree.insert('l',".-..");
		tree.insert('e',".");
		tree.insert('a',".-");
		tree.insert('y',"-.--");
		tree.insert('r',".-.");
		tree.insert('q',"--.-");
		tree.insert('s',"...");
		tree.insert('b',"-...");
		tree.insert('n',"-.");
		tree.insert('m',"--");
		tree.insert('u',"..-");
		tree.insert('i',"..");
		tree.insert('g',"--.");
		tree.insert('v',"...-");
		tree.insert('x',"-..-");
		tree.insert('d',"-..");
		tree.insert('j',".---");
		tree.insert('f',"..-.");
		tree.insert('p',".--.");
		tree.insert(' ', " ");
		
		
		
		System.out.print("English to Morse (1) or Morse to English (2)? "); //Maybe I'll make this automatically detect E2M or M2E
		int choice = input.nextInt();
		input.nextLine();
		String userInput;
		switch(choice) 
		{
		case 1:
			System.out.print("Please enter string: ");
			userInput = input.nextLine();
			englishToMorse(userInput);
			break;
		case 2:
			System.out.print("Please enter string: ");
			userInput = input.nextLine();
			morseToEnglish(userInput);
			break;
		}
			input.close();
	}
	
	static public void englishToMorse(String s)
	{
		s = s.toLowerCase();
		
		System.out.println("Translating to Morse Code");
		
		System.out.print(tree.search(tree.root, s.charAt(0)).getCode());
		
		for (int i = 1; i < s.length(); i++)
		{
			System.out.print("/");
			System.out.print(tree.search(tree.root, s.charAt(i)).getCode());
		}
	}
	
	static public void morseToEnglish(String s)
	{
		System.out.println("Translating to English");
		char chars[] = s.toCharArray();
		String group = "";
		
		for (int i = 0; i < chars.length;i++)
		{
			if (chars[i] != '/' )
			{
				group = group + chars[i];
			}
			else
			{
				tree.translate(group);
				group = "";
			}
		}
		tree.translate(group);
	}
}
