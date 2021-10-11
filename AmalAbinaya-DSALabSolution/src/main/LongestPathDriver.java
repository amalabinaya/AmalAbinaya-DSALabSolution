package main;

import java.io.*;
import java.util.ArrayList;

class LongestPathDriver{


	static class Node{
		Node leftnode;
		Node rightnode;
		int data;
	};


	static Node newNode(int data){
		Node temp = new Node();
		temp.data = data;
		temp.leftnode = null;
		temp.rightnode = null;
		return temp;
	}


	public static ArrayList<Integer> longestPath(Node root){


		if(root == null){
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		ArrayList<Integer> rightnode = longestPath(root.rightnode);
		ArrayList<Integer> leftnode = longestPath(root.leftnode);


		if(rightnode.size() < leftnode.size())
			leftnode.add(root.data);
		else
			rightnode.add(root.data);

		return (leftnode.size() > rightnode.size() ? leftnode :rightnode);
	}


	public static void main(String[] args)	{

		Node root = newNode(100);
		root.leftnode = newNode(20);
		root.rightnode = newNode(130);
		root.leftnode.leftnode = newNode(10);
		root.leftnode.rightnode = newNode(50);
		root.rightnode.leftnode = newNode(110);
		root.rightnode.rightnode = newNode(140);
		root.leftnode.leftnode.leftnode = newNode(5);
		System.out.print("Longest Path ");
		ArrayList<Integer> output = longestPath(root);
		int n = output.size();

		System.out.print(output.get(n - 1));
		for(int i = n - 2; i >= 0; i--)		{
			System.out.print(" -> " + output.get(i));
		}
	}
}
