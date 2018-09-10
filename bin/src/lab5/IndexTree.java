package lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class IndexTree<E extends Comparable<E>>{

	// This is your root 
	private IndexNode root;
	private int size;
	// Make your constructor
	public IndexTree(){
		root = null;
		size = 0;
	}
	
	// complete the methods below
	
	// call your recursive add method
	public void add(String word, int lineNumber){
		this.root=add(root ,word,lineNumber);
	}
	
	
	
	//your recursive method for add
	// Think about how this works
	// When you add the word to the index, if it already exists, you want to 
	// add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
			return new IndexNode(word, lineNumber);
		}
		int compare = word.compareTo(root.word);
		if (compare == 0){
			root.occurences++;
			root.list.add(lineNumber);
			return root;
		}
		else if (compare < 0){
			root.left = add(root.left,word,lineNumber);
			return root;
		}
		else{
			root.right = add(root.right,word,lineNumber);
			//System.out.println("right");
			return root;
		}
		
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
		return contains(this.root,word);
	}
	
	private boolean contains(IndexNode root, String word) {
		if (root == null){
			return false;
		}
		int compare = word.compareTo(root.word);
		if (compare == 0){
			return true;
		}
		else if (compare < 0){
			return contains(root.left,word);
		}
		else{
			return contains(root.right,word);
		}
	}

	// call your recursive method
	public void delete(String word){
		this.root = delete(root, word);
		
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	private IndexNode delete(IndexNode root, String word){
		if(root == null){
			return null;
		}
		int compareVal = word.compareTo(root.word);
		if (compareVal < 0) {
			root.left = delete(root.left, word);
			return root;
		}
		else if( compareVal > 0){
			root.right = delete(root.right, word);
			return root;
		}
		else{
			if( root.left == null && root.right == null ){
				return null;
			}
			else if( root.left != null && root.right ==null){
				return root.left;
			}
			else if( root.left ==null && root.right != null){
				return root.right;
			}
			else{
				IndexNode current = root.right;
				while(current.left != null){
					current = current.left;
				}
				String temp =  root.word;
				root.word = current.word;
				current.word = temp;
				root.right = delete(root.right, word);
				return root;
				}
			}
		}
	
	
	
	// prints all the words in the index in inorder order
	public String toString(){
		StringBuilder sb  = new StringBuilder();
		printIndex(root, sb);
		return sb.toString();
	}
	public static void printIndex(IndexNode root,StringBuilder stringBuilder ){
		if(root == null){
			return ;
		}
		printIndex(root.left, stringBuilder);
		System.out.println(root.word);
		//getLine(root);
		System.out.print(root.occurences+" ");
		//stringBuilder.append(" "+root+" ");
		printIndex(root.right, stringBuilder);
		
	}
	public static void getLine(IndexNode root){
		for(int i = 0; i < root.list.size();i++){
			System.out.print(i+",");
		}
			
		
	}
	
	public static void main(String[] args){
		IndexTree index = new IndexTree();
		String fileName = "pg2240.txt";
		String line = null;
		int i = 0;
		BufferedReader bufferedReader;
		StringBuilder  stringBuilder = new StringBuilder();
		try {

			bufferedReader= new BufferedReader(new FileReader(fileName));

			while(bufferedReader.ready()) {
				i++;
				line = bufferedReader.readLine();
				
				//System.out.println(line);
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.replaceAll(":", "");
					word = word.replaceAll(",", " ");
					index.add(word, i);
					
				}
			}

			bufferedReader.close();         
		}
		catch(FileNotFoundException e) { 
			System.err.println("File not found");                
		}
		// catch any other exception
		catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(index.root.right.word);
		//printIndex(index.root,stringBuilder);
		

		printIndex(index.root,stringBuilder);
	}

		// add all the words to the tree
		
		// print out the index
		
		// test removing a word from the index


			
	}
