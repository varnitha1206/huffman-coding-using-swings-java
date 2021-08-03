package project;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import swings_pack.*;
import Node.*;    
class huffmanproject
{
   static void write_file(char[] ch,HashMap m1)                                             //writing the compressed string to a file
   {
      HashMap<Character,String> map=m1;                                                               
      int i=0;
      try{
       FileWriter file = new FileWriter("output.txt");
       BufferedWriter bf = new BufferedWriter(file);
       int len = ch.length;
      while(i<len)
      {
         String s1 = (String)map.get(ch[i]);
         bf.write(s1);
         i++;
      }
      bf.newLine(); 
      System.out.println("File created. please check output.txt");
      bf.close();
      }
      catch(IOException e)
      {
         System.out.println("IOException occurred");
      }
   }   
   public static void main(String[] args)
   {
    swings_pack.Swings_class obj1 = new swings_pack.Swings_class();
    swings_pack.Swings_class obj2 = new swings_pack.Swings_class();
    HashMap<Character,String> map=new HashMap<Character,String>();
    String str;
    System.out.print("Enter the string : ");
    Scanner input = new Scanner(System.in);
    str = input.nextLine();
    char[] characters =  str.toCharArray();                                         //converting string to array of characters
    ArrayList<Character> array = new ArrayList<Character>();                        //creating array list for storing elements
    for(int i=0;i<characters.length;i++)
    {
      if(!(array.contains(characters[i])))
      {
         array.add(characters[i]);
      }
    }
    int n=array.size();
    int[] freq = new int[n];
    for(int i=0;i<n;i++)
    {
      freq[i]=0;
    }
    for(int i=0;i<n;i++)                                                                  //finding the frequencies of each character
    {
         char c = array.get(i);
         for(int j=0;j<characters.length;j++)
         {
            if(c==characters[j])
            {
               freq[i]++;
            }
         }
      }
    PriorityQueue<Node.node> huffman = new PriorityQueue<Node.node>();              //creating a priority queue    
    node root = null;                                                                 //creating root node
    for(int i=0;i<n;i++)
    {
      Node.node newnode = new Node.node(freq[i],array.get(i)); 
      huffman.add(newnode);
    }
    while(huffman.size()>1)                                                                   //building tree
    {
      Node.node n1 = huffman.poll();
      Node.node n2 = huffman.poll();
      Node.node parent = new Node.node();
      parent.freq = n1.freq+n2.freq;
      parent.left = n1;
      parent.right = n2;
      parent.c='-';
      root=parent;
      huffman.add(parent); 
    }
    Node.node.build_hash(map,root,"");
    huffmanproject.write_file(characters,map);
    final Node.node r=root;
    SwingUtilities.invokeLater(new Runnable()    
    {
      public void run()
      {                                                                  //Swing
        int yn=obj1.yes_no("Decode");
        if(yn==1)
        {
            obj1.decode(map);
        }
        yn=obj2.yes_no("Tree");
        if(yn==1)
        {
            obj2.Jtree(r);
        }
       }
     });
    } 
 }