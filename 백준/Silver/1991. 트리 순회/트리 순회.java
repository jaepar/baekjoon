import java.io.*;
import java.util.*;

public class Main
{
	static int N;
	static Node head = new Node('A', null, null);
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		char root;
		Node left, right;
		
		public Node (char root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, root, left, right);
		}
		
		preOrder(head);
		sb.append("\n");
		inOrder(head);
		sb.append("\n");
		postOrder(head);
		
		System.out.print(sb);
	}
	
	private static void insertNode(Node head, char root, char left, char right) {
		
		if (head.root == root) {
			head.left = (left == '.') ? null : new Node(left, null, null);
			head.right = (right == '.') ? null : new Node(right, null, null);
		}
		else {
			if (head.left != null)
				insertNode(head.left, root, left, right);
			if (head.right != null)
				insertNode(head.right, root, left, right);
		}
	}
	
	private static void preOrder(Node head) {
		if (head == null)
			return;
		sb.append(head.root);
		preOrder(head.left);
		preOrder(head.right);
	}
	
	private static void inOrder(Node head) {
		if (head == null)
			return;
		inOrder(head.left);
		sb.append(head.root);
		inOrder(head.right);
	}
	
	private static void postOrder(Node head) {
		if (head == null)
			return;
		postOrder(head.left);
		postOrder(head.right);
		sb.append(head.root);
	}
	
	
	
	
	

} 