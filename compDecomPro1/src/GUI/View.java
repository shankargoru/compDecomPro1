package GUI;

import codefiles.compressor;
import codefiles.decompresoor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class View extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton=new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);

        decompressButton=new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        this.add(compressButton);
        this.add(decompressButton);
        this.getContentPane().setBackground(Color.blue);

        this.setSize(500,200);
    }

    @Override
    public void actionPerformed(ActionEvent e){
     if(e.getSource()==compressButton){
         JFileChooser filechoser=new JFileChooser();
         int response=filechoser.showSaveDialog(null);
         if(response==JFileChooser.APPROVE_OPTION){
             File file=new File(filechoser.getSelectedFile().getAbsolutePath());
             try{
                 compressor.method(file);
             }
             catch(Exception exp){
                 JOptionPane.showMessageDialog(null,exp.toString());
             }
         }
     }
        if(e.getSource()==decompressButton){
            JFileChooser filechoser=new JFileChooser();
            int response=filechoser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechoser.getSelectedFile().getAbsolutePath());
                try{
                    decompresoor.method(file);
                }
                catch(Exception exp){
                    JOptionPane.showMessageDialog(null,exp.toString());
                }
            }
        }

    }

    public static void main(String[] args) {
        View view=new View();
        view.setVisible(true);
    }
}
