package Views;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{

    Controller controller = new Controller(this);

    private JButton staticAllocation;

    private JButton dynamicAllocation;

    private JButton staticAccess;

    private JButton dynamicAccess;

    private JButton threadCreation;

    private JButton threadSwitch;

    private JButton threadMigration;

    public View() {
        this.prepareFrame();
        this.setVisible(true);
    }

    private void addButtons(){
        staticAllocation = new JButton("Static allocation");
        staticAllocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
        staticAllocation.setBounds(60, 150, 200, 25);
        staticAllocation.setActionCommand("STATIC ALLOCATION");
        staticAllocation.addActionListener(this.controller);
        this.getContentPane().add(staticAllocation);

        dynamicAllocation = new JButton("Dynamic allocation");
        dynamicAllocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
        dynamicAllocation.setBounds(60, 225, 200, 25);
        dynamicAllocation.setActionCommand("DYNAMIC ALLOCATION");
        dynamicAllocation.addActionListener(this.controller);
        this.getContentPane().add(dynamicAllocation);

        staticAccess = new JButton("Access of static memory");
        staticAccess.setFont(new Font("Tahoma", Font.PLAIN, 12));
        staticAccess.setBounds(60, 300, 200, 25);
        staticAccess.setActionCommand("STATIC ACCESS");
        staticAccess.addActionListener(this.controller);
        this.getContentPane().add(staticAccess);

        dynamicAccess= new JButton("Access of dynamic memory");
        dynamicAccess.setFont(new Font("Tahoma", Font.PLAIN, 12));
        dynamicAccess.setBounds(60, 375, 200, 25);
        dynamicAccess.setActionCommand("DYNAMIC ACCESS");
        dynamicAccess.addActionListener(this.controller);
        this.getContentPane().add(dynamicAccess);

        threadCreation= new JButton("Thread creation");
        threadCreation.setFont(new Font("Tahoma", Font.PLAIN, 12));
        threadCreation.setBounds(320, 180, 200, 25);
        threadCreation.setActionCommand("THREAD CREATION");
        threadCreation.addActionListener(this.controller);
        this.getContentPane().add(threadCreation);

        threadSwitch= new JButton("Thread context switch");
        threadSwitch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        threadSwitch.setBounds(320, 255, 200, 25);
        threadSwitch.setActionCommand("THREAD SWITCH");
        threadSwitch.addActionListener(this.controller);
        this.getContentPane().add(threadSwitch);

        threadMigration= new JButton("Thread migration");
        threadMigration.setFont(new Font("Tahoma", Font.PLAIN, 12));
        threadMigration.setBounds(320, 330, 200, 25);
        threadMigration.setActionCommand("THREAD MIGRATION");
        threadMigration.addActionListener(this.controller);
        this.getContentPane().add(threadMigration);
    }

    public void prepareFrame() {
        this.getContentPane().removeAll();

        this.setBounds(100, 100, 600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xac, 0x86, 0xa8));
        this.getContentPane().setLayout(null);
        this.setResizable(false);

        JLabel titleLabel = new JLabel("Measuring execution time of");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        titleLabel.setBounds(150, 10, 350, 40);
        this.getContentPane().add(titleLabel);

        JLabel titleLabel1 = new JLabel("processes");
        titleLabel1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        titleLabel1.setBounds(240, 50, 350, 40);
        this.getContentPane().add(titleLabel1);

        JLabel note = new JLabel("For Thread Migration it's recommended to run the command at least 2 times for valid results");
        note.setFont(new Font("Tahoma", Font.PLAIN, 13));
        note.setBounds(30, 400, 560, 40);
        this.getContentPane().add(note);

        addButtons();

        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
