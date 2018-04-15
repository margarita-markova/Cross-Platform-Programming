package com.marksuree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * DayOfWeekCalculator includes methods for creation GUI, program logic and user working with View.
 */
public class DayOfWeekCalculator extends JFrame {

    private JButton checkButton;
    private JButton clearButton;
    private JLabel[] arrayLabel;
    private JTextField textFieldYear;
    private JTextField textFieldDay;

    /**
     * This method gets user input year from textFieldYear and converts it to int..
     * @return int This returns input year's value.
     */
    private int getYear()
    {
            return Integer.parseInt(textFieldYear.getText());
    }

    /**
     * This method gets user input day from dayFieldYear and converts it to int.
     * @return int This returns input day's value.
     */
    private int getDay() {
        return Integer.parseInt(textFieldDay.getText());
    }

    private void clearAll()
    {
        textFieldDay.setText("");
        textFieldDay.setEnabled(true);
        textFieldYear.setText("");
        textFieldYear.setEnabled(true);
    }

    /**
     * This method clear all textfields and result label, make objects enabled again.
     */
    public void restartApp() {
        clearAll();
        checkButton.setText("Проверить");
        checkButton.setEnabled(true);
        clearButton.setEnabled(true);
        arrayLabel[0].setVisible(false);
    }

    /**
     * This method provide logic of program. It sets Calendar lenient and allow input [1...366]
     * or [1...365] number of days. It determines result value of day of week.
     * @return result This parameter is string, which store day of week.
     */
    private String checkResult() {
        String result = "Error. Try again";
        try {
            int day = getDay();
            int year = getYear();

            if (isLeapYear(year) && year>0) {
                if (day <= 0 || day > 366) {
                    arrayLabel[0].setForeground(Color.RED);
                    result = "Ошибка. Диапазон дней от 1 до 366";
                    return result;
                }
            } else if ((day < 0 || day > 365) && year>0) {
                arrayLabel[0].setForeground(Color.RED);
                result = "Ошибка. Диапазон дней от 1 до 366";
                return result;
            } else if(year>0) {
                Locale locale = Locale.getDefault(); //for russian language
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.ERA, GregorianCalendar.AD);
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, 0); //set January
                cal.set(Calendar.DATE, day);
                result = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
                return result;
            }
            else
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            restartApp();
            result = "TextField error";
        }
        return result;
    }

    /**
     * This method create all GUI, works with layouts and define default text on labels and button.
     * Here we override listener method for button. If button was pressed, this method starts work
     * and call checkResult() method.
     */
    public void createGraphicalUserInterface() {
        JFrame mainFrame = createJFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setVisible(true);
        mainFrame.add(mainPanel, BorderLayout.NORTH);


        arrayLabel = new JLabel[4];
        for (int i = 0; i < arrayLabel.length; i++)
            arrayLabel[i] = new JLabel();

        arrayLabel[1].setText("Год: ");
        arrayLabel[2].setText("День: ");
        arrayLabel[3].setText("День недели: ");
        arrayLabel[0].setText("Default");
        arrayLabel[0].setVisible(false);

        textFieldYear = new JTextField();
        textFieldYear.setEnabled(true);
        textFieldDay = new JTextField();
        textFieldDay.setEnabled(true);

        checkButton = new JButton("Проверить");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkButton.setText("Проверено");
                checkButton.setEnabled(false);
                clearButton.setEnabled(false);
                textFieldYear.setEnabled(false);
                textFieldDay.setEnabled(false);
                arrayLabel[0].setText(checkResult());
                arrayLabel[0].setVisible(true);
            }
        });

        clearButton = new JButton("Очистить");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });

       mainPanel.setLayout(new GridBagLayout());

        mainPanel.add(arrayLabel[1], new GridBagConstraints(0, 0, 1, 1,
                1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(textFieldYear, new GridBagConstraints(1, 0, 4, 1,
                8, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 50, 0));
        mainPanel.add(arrayLabel[2], new GridBagConstraints(0, 1, 1, 1,
                1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(textFieldDay, new GridBagConstraints(1, 1, 4, 1,
                8, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(arrayLabel[3], new GridBagConstraints(0, 2, 1, 1,
                1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(arrayLabel[0], new GridBagConstraints(1, 2, 1, 1,
                1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        mainFrame.add(mainPanel);


        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomLeftPanel.add(checkButton);
        bottomLeftPanel.add(clearButton);

        mainFrame.add(bottomLeftPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    /**
     * This method creates JFrame.
     * @return newFrame This is object of class JFrame, which we stylized in this method.
     */
    private JFrame createJFrame() {
        JFrame newFrame = new JFrame() {
        };
        newFrame.setDefaultCloseOperation(newFrame.EXIT_ON_CLOSE);
        newFrame.setTitle("Day of week Calculation");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        newFrame.setBounds((screen.width / 2) - 200, (screen.height / 2) - 75, 400, 150);
        return newFrame;
    }

    /**
     * This method determines input year, is it the leap or not.
     * @param year This paramenter stores value of user input year.
     * @return boolean This boolean returns, when the year is leap.
     */
    private boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
