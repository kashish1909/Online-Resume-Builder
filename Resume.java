package com.itextpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class Resume {
    private JPanel resumePanel;
    private JTextField name;
    private JTextField contact;
    private JTextField email;
    private JTextField textField1;
    private JButton SELECTIMAGEButton;
    private JTextField location;
    private JLabel img;
    private JTextField skill1;
    private JTextField skill2;
    private JTextField skill3;
    private JTextField collegename;
    private JComboBox work;
    private JTextField qualiA;
    private JTextField qualiB;
    private JTextField skill4;
    private JButton GENERATERESUMEButton;
    private JTextField address;
    JFrame frame=new JFrame();
public Resume() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(resumePanel);
    frame.pack();
    frame.setLocationRelativeTo(null);

    frame.setVisible(true);
    SELECTIMAGEButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser=new JFileChooser();
            FileNameExtensionFilter filter=new FileNameExtensionFilter("*.IMAGE","jpg","png");
            fileChooser.addChoosableFileFilter(filter);
            int x=fileChooser.showSaveDialog(null);
            if(x==JFileChooser.APPROVE_OPTION)
            {
                File image=fileChooser.getSelectedFile();
                location.setText(image.getAbsolutePath());
                img.setIcon(resize(location.getText()));
            }
        }
    });
    GENERATERESUMEButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(name.getText()==null || contact.getText()==null || address.getText()==null || email.getText()==null)
            {
                JOptionPane.showMessageDialog(null,"PLEASE ENTER ALL DETAILS");
            }
            else {
                try
                {
                    String nameFile="D:\\RESUMEPDF\\my.pdf";
                    Document document=new Document();
                    PdfWriter.getInstance(document,new FileOutputStream(nameFile));
                    document.open();
                    com.itextpdf.text.Image img=com.itextpdf.text.Image.getInstance(location.getText());
                    img.setAbsolutePosition(473f,750f);
                    img.scaleAbsolute(80f,70f);
                    PdfPTable table=new PdfPTable(2);
                    document.add(img);
                    document.add(new Paragraph(name.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,32,com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_BOLD,9,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_BOLD,9,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("-----------------------------------------------------------------------------"));
                    document.add(new Paragraph("CONTACT DETAILS",FontFactory.getFont(FontFactory.TIMES_BOLD,9,com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(email.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(contact.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(address.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("-----------------------------------------------------------------------------"));
                    document.add(new Paragraph("SKILLS",FontFactory.getFont(FontFactory.TIMES_BOLD,9,com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY)));
                    table.setHeaderRows(1);
                    table.addCell(skill1.getText());
                    table.addCell(skill2.getText());
                    table.addCell(skill3.getText());
                    table.addCell(skill4.getText());
                    document.add(table);
                    document.add(new Paragraph("---------------------------------------------------------------------------"));
                    document.add(new Paragraph("QUALIFICATIONS",FontFactory.getFont(FontFactory.TIMES_BOLD,9,com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(collegename.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(qualiA.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(qualiB.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("----------------------------------------------------------------------------"));
                    document.add(new Paragraph("WORK EXPERIENCE",FontFactory.getFont(FontFactory.TIMES_BOLD,9,com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph(""+work.getSelectedItem(),FontFactory.getFont(FontFactory.TIMES_BOLD,7,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("---------------------------------------------------------------------------"));
                    document.add(new Paragraph("REFERENCES",FontFactory.getFont(FontFactory.TIMES_BOLD,9,com.itextpdf.text.Font.BOLD,BaseColor.DARK_GRAY)));
                    document.add(new Paragraph("Availabe upon request",FontFactory.getFont(FontFactory.TIMES_BOLD,6,BaseColor.DARK_GRAY)));
                    document.close();
                    JOptionPane.showMessageDialog(null,"Resume was successfully generated");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }
    });
}
public ImageIcon resize(String path)
{
    ImageIcon img1=new ImageIcon(path);
    Image img2=img1.getImage();
    Image newimg=img2.getScaledInstance(200,200,Image.SCALE_SMOOTH);
    ImageIcon finalimg=new ImageIcon(newimg);
    return finalimg;
}
}
