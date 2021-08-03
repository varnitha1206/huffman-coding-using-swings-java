package swings_pack;
import Node.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Swings_class
{
   JFrame name;
   public int yes_no(String s)
   {
      name=new JFrame();
      name.setSize(200,100);
      int res = JOptionPane.showOptionDialog(name,"Do you want to check "+s,"continue",JOptionPane.YES_NO_OPTION,
                  JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Yes","No"},JOptionPane.YES_OPTION);
      if (res == JOptionPane.YES_OPTION)
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
   public void Jtree(Node.node root)
   {
      name= new JFrame("Huffman Tree");
      name.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      name.setSize(400,400);
      char m=root.c;
      DefaultMutableTreeNode top= new DefaultMutableTreeNode(m);
      call(top,root.left);
      call(top,root.right);
      JTree tree=new JTree(top);
      name.add(tree);
      name.setVisible(true);
   }
   void call(DefaultMutableTreeNode top,Node.node root)
   {
      char o=root.c;
      DefaultMutableTreeNode a= new DefaultMutableTreeNode(o);
      top.add(a);
      if(root.left!=null)
      {
         call(a,root.left);
      }
      if(root.right!=null)
      {
         call(a,root.right);
      }
   }
   public void decode(HashMap m)
   {
      HashMap<Character,String> map = m;
      name= new JFrame("Decoding");
      name.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      name.setSize(400,200);
      JLabel text1 = new JLabel();
      text1.setText("Enter input to decode here");
      JTextField field=new JTextField(20);
      JLabel text2 = new JLabel();
      text2.setText("Code represents");
      JButton b1 = new JButton("Decode");
      JTextField output=new JTextField(20);
      output.setEditable(false); 
      JPanel panel = new JPanel(new GridLayout(3,2));
      b1.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent ae)
         {
            String result=field.getText();
            if(result!=null && map.containsValue(result))
            {
               for(Map.Entry m :map.entrySet())
               {
                  if(result.equals(m.getValue()))
                  {
                     output.setText(" "+m.getKey()); 
                     break;
                  }
               }         
            }
            else
            {
               output.setText("Invalid input");
            }
         }
      });
      panel.add(text1);
      panel.add(field);
      panel.add(text2);
      panel.add(output);
      panel.add(b1);
      name.add(panel);
      name.setVisible(true);
   }
} 

