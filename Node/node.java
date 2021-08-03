package Node;
import java.util.*;
import java.io.*;
public class node implements Comparable<node>
{
   public int freq;
   public char c;
   public node left;
   public node right;
   public node(){
      freq=0;
      c='X';
      this.left=null;
      this.right=null;
   }
   public node(int a, char b)
   {
      freq=a;
      c=b;
      this.left=null;
      this.right=null;
   }
   static public void build_hash(HashMap m,node root,String s)  //building the hash map from the tree
   {
      if(root.left==null&&root.right==null)
      {
         if(root.c!='-')
         {
             m.put(root.c,s);     //key, value
         }
      }
      else
      {
         build_hash(m,root.left,s+"0");
         build_hash(m,root.right,s+"1");
      }
   }
   public int compareTo(node o1)
   {
      if(this.freq>o1.freq)
         return 1;
      else if(this.freq<o1.freq)
         return -1;
      else
      {
         if(this.c>o1.c)
         {
            return 1;
         }
         return -1;
      }
    }
     
}