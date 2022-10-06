import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] argv) {
    TreeBuilder obj = new TreeBuilder();
    String[] s = {"100","200","+","2","/","5","*","7","+"};
    Node expTree = obj.buildTree(s);
    int ans = expTree.evaluate();
    System.out.println(ans);
  }
  
  static class TreeBuilder {
    Node buildTree(String[] postfix) {
      Stack<Node> stack = new Stack<>();
      for (String s : postfix) {
        if (Character.isDigit(s.charAt(0))) {
          stack.push(new Node(s));
        } else {
          Node right = stack.pop(), left = stack.pop();
          stack.push(new Node(s, left, right));
        }
      }
      return stack.pop();
    }
  }
  
  static class Node{
    String val;
    Node left, right;
    Node(String val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
    Node(String val) {
      this.val = val;
    }
    
    int evaluate() {
      if (Character.isDigit(this.val.charAt(0))) {
        return Integer.parseInt(this.val);
      }
      switch(this.val) {
        case "+": return this.left.evaluate() + this.right.evaluate();
        case "-": return this.left.evaluate() - this.right.evaluate();
        case "*": return this.left.evaluate() * this.right.evaluate();
        case "/": return this.left.evaluate() / this.right.evaluate();
      }
      return -10;
    }
  }
  
}
