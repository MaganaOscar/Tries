package tries;
import java.util.Set;

public class Trie {
	public Node root;
	
	public Trie() {
		this.root = new Node();
	}
	
	public void insertWord(String word) {
		Node currentNode = this.root;
		
		for (int i = 0; i < word.length(); i++) {
			Character currentLetter = word.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			
			if(child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);				
			}
			
			currentNode = child;
		}
		
		currentNode.isCompleteWord = true;
	}
	
	public boolean isPrefixValid(String prefix) {
		Node currentNode = this.root;
		
		for (int i = 0; i < prefix.length(); i++) {
			Character currentLetter = prefix.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				return false;
			}
			currentNode = child;
		}
		
		return true;
	}
	
	public boolean isWordValid(String word) {
		return isPrefixValid(word);
	}
	
	public void printAllKeys() {
		Node currentNode = this.root;
		Set<Character> keys = currentNode.children.keySet();
		for(Character key : keys) {
			System.out.println(key);
			printAllKeys(currentNode.children.get(key));
		}
			
	}
	
	public void printAllKeys(Node child) {
		Set<Character> keys = child.children.keySet();
		for(Character key : keys) {
			System.out.println(key);
			printAllKeys(child.children.get(key));
		}
	}
}
