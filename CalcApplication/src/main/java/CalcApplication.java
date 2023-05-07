import com.calculator.ejb.CalculatorImplementationSessionBean;
import com.logger.ejb.LoggerImplementationSessionBean;
import com.logger.ejb.LoggerSessionBeanRemote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcApplication extends JFrame implements ActionListener {

    private static final String PUNCTUATION_MARK_EMPTY_STRING = "";

    //create the text field
    private static JTextField textField;
    //create the frame
    private static JFrame frame;
    private static JPanel panel;
    // Store the operands
    private String firstOperand, secondOperand, storeVal;
    //Store the operators
    private String operator;
    private static JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private static JButton buttonAdd, buttonSub, buttonMultiply,buttonDivide, buttonMod;
    private static JButton buttonClear, buttonEqual, buttonDecimal;
    private static LoggerSessionBeanRemote implementation;
    String calculationHisory = "";

    public CalcApplication() {
        operator = PUNCTUATION_MARK_EMPTY_STRING;
        firstOperand = PUNCTUATION_MARK_EMPTY_STRING;
        secondOperand = PUNCTUATION_MARK_EMPTY_STRING;
        storeVal = PUNCTUATION_MARK_EMPTY_STRING;
        implementation = new LoggerImplementationSessionBean("History.txt");
    }

    private static void init() {
        Font font = new Font("Arial", Font.PLAIN, 30);
        textField = new JTextField(14);
        textField.setMinimumSize( new Dimension( 150, 70 ) );
        textField.setMaximumSize( new Dimension( 150, 70 ) );
        textField.setPreferredSize( new Dimension( 150, 70 ) );
        textField.setFont(font);
        textField.setEditable(false);

        //create buttons that perform operations with the required dimensions
        buttonMultiply = new JButton("*");
        buttonMultiply.setMinimumSize( new Dimension( 150, 70 ) );
        buttonMultiply.setMaximumSize( new Dimension( 150, 70 ) );
        buttonMultiply.setPreferredSize( new Dimension( 150, 70 ) );
        setFontAndAlignment(buttonMultiply,font);

        buttonDivide = new JButton("/");
        buttonDivide.setMinimumSize( new Dimension( 150, 70 ) );
        buttonDivide.setMaximumSize( new Dimension( 150, 70 ) );
        buttonDivide.setPreferredSize( new Dimension( 150, 70 ) );
        setFontAndAlignment(buttonDivide,font);

        buttonAdd = new JButton("+");
        buttonAdd.setMinimumSize( new Dimension( 150, 70 ) );
        buttonAdd.setMaximumSize( new Dimension( 150, 70 ) );
        buttonAdd.setPreferredSize( new Dimension( 150, 70 ) );
        setFontAndAlignment(buttonAdd,font);

        buttonSub = new JButton("-");
        buttonSub.setMinimumSize( new Dimension( 150, 70 ) );
        buttonSub.setMaximumSize( new Dimension( 150, 70 ) );
        buttonSub.setPreferredSize( new Dimension( 150, 70 ) );
        setFontAndAlignment(buttonSub,font);

        buttonMod = new JButton("MOD");
        buttonMod.setMinimumSize( new Dimension( 122, 70 ) );
        buttonMod.setMaximumSize( new Dimension( 122, 70 ) );
        buttonMod.setPreferredSize( new Dimension( 122, 70 ) );
        setFontAndAlignment(buttonMod,font);

        buttonClear = new JButton("C");
        buttonClear.setMinimumSize( new Dimension( 122, 70 ) );
        buttonClear.setMaximumSize( new Dimension( 122, 70 ) );
        buttonClear.setPreferredSize( new Dimension( 122, 70 ) );
        setFontAndAlignment(buttonClear,font);

        buttonEqual = new JButton("=");
        buttonEqual.setMinimumSize( new Dimension( 120, 70 ) );
        buttonEqual.setMaximumSize( new Dimension( 120, 70 ) );
        buttonEqual.setPreferredSize( new Dimension( 120, 70 ) );
        setFontAndAlignment(buttonEqual,font);

        //create the buttons for numbers with the required dimensions
        button0 = new JButton("0");
        button0.setMinimumSize( new Dimension( 145, 70 ) );
        button0.setMaximumSize( new Dimension( 145, 70 ) );
        button0.setPreferredSize( new Dimension( 145, 70 ) );
        setFontAndAlignment(button0,font);

        button1 = new JButton("1");
        button1.setMinimumSize( new Dimension( 70, 70 ) );
        button1.setMaximumSize( new Dimension( 70, 70 ) );
        button1.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button1,font);

        button2 = new JButton("2");
        button2.setMinimumSize( new Dimension( 70, 70 ) );
        button2.setMaximumSize( new Dimension( 70, 70 ) );
        button2.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button2,font);

        button3 = new JButton("3");
        button3.setMinimumSize( new Dimension( 70, 70 ) );
        button3.setMaximumSize( new Dimension( 70, 70 ) );
        button3.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button3,font);

        button4 = new JButton("4");
        button4.setMinimumSize( new Dimension( 70, 70 ) );
        button4.setMaximumSize( new Dimension( 70, 70 ) );
        button4.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button4,font);

        button5 = new JButton("5");
        button5.setMinimumSize( new Dimension( 70, 70 ) );
        button5.setMaximumSize( new Dimension( 70, 70 ) );
        button5.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button5,font);

        button6 = new JButton("6");
        button6.setMinimumSize( new Dimension( 70, 70 ) );
        button6.setMaximumSize( new Dimension( 70, 70 ) );
        button6.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button6,font);

        button7 = new JButton("7");
        button7.setMinimumSize( new Dimension( 70, 70 ) );
        button7.setMaximumSize( new Dimension( 70, 70 ) );
        button7.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button7,font);

        button8 = new JButton("8");
        button8.setMinimumSize( new Dimension( 70, 70 ) );
        button8.setMaximumSize( new Dimension( 70, 70 ) );
        button8.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button8,font);

        button9 = new JButton("9");
        button9.setMinimumSize( new Dimension( 70, 70 ) );
        button9.setMaximumSize( new Dimension( 70, 70 ) );
        button9.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(button9,font);

        //create button for decimal point with the required dimensions
        buttonDecimal = new JButton(".");
        buttonDecimal.setMinimumSize( new Dimension( 70, 70 ) );
        buttonDecimal.setMaximumSize( new Dimension( 70, 70 ) );
        buttonDecimal.setPreferredSize( new Dimension( 70, 70 ) );
        setFontAndAlignment(buttonDecimal,font);
    }

    //set the alignments and the fonts needed for a button
    private static void setFontAndAlignment(JButton button, Font font) {
        button.setFont(font);
        button.setHorizontalAlignment(AbstractButton.CENTER);
        button.setVerticalAlignment(AbstractButton.CENTER);
    }

    //add action listeners for the buttons
    private static void addActionListeners(){
        CalcApplication application = new CalcApplication();
        buttonMultiply.addActionListener(application);
        buttonDivide.addActionListener(application);
        buttonAdd.addActionListener(application);
        buttonSub.addActionListener(application);
        buttonMod.addActionListener(application);
        buttonClear.addActionListener(application);
        buttonEqual.addActionListener(application);
        buttonDecimal.addActionListener(application);
        button0.addActionListener(application);
        button1.addActionListener(application);
        button2.addActionListener(application);
        button3.addActionListener(application);
        button4.addActionListener(application);
        button5.addActionListener(application);
        button6.addActionListener(application);
        button7.addActionListener(application);
        button8.addActionListener(application);
        button9.addActionListener(application);
    }

    //add the buttons to the panel
    private static void addToPanel(JPanel panel){
        panel.add(textField);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonMultiply);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonDivide);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonAdd);
        panel.add(button0);
        panel.add(buttonDecimal);
        panel.add(buttonSub);
        panel.add(buttonMod);
        panel.add(buttonEqual);
        panel.add(buttonClear);
        panel.setBackground(Color.LIGHT_GRAY);
    }

    //perform the calculations by using the calculator component
    private double performCalculation(CalculatorImplementationSessionBean calculator){
        double result = 0;
        if(firstOperand.equals(".")){
            firstOperand = "0.0";
        }
        if(secondOperand.equals(".")){
            secondOperand = "0.0";
        }
        if (operator.equals("+")) {
            result = calculator.addNumbers(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        } else if (operator.equals("-")) {
            result = calculator.subtractNumbers(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        } else if (operator.equals("*")) {
            result = calculator.multiplyNumbers(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        } else if (operator.equals("/")) {
            result = calculator.divideNumbers(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        } else if (operator.equalsIgnoreCase("MOD")) {
            result = calculator.getModOfNumbers(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        CalculatorImplementationSessionBean calculator = new CalculatorImplementationSessionBean();
        if (action.equals("C")) {
            // clear data
            operator = PUNCTUATION_MARK_EMPTY_STRING;
            firstOperand = PUNCTUATION_MARK_EMPTY_STRING;
            secondOperand = PUNCTUATION_MARK_EMPTY_STRING;
            storeVal = PUNCTUATION_MARK_EMPTY_STRING;

            textField.setText(PUNCTUATION_MARK_EMPTY_STRING);
        }
        else if ((action.charAt(0) <= '9' && action.charAt(0) >= '0') || action.charAt(0) == '.') {
            if (operator.equals(PUNCTUATION_MARK_EMPTY_STRING)){
                if(action.charAt(0) != '.'){
                    firstOperand = firstOperand + action;
                }
                else{
                    if(!firstOperand.contains(".")){
                        firstOperand = firstOperand + action;
                    }
                }
            }
            else{
                if(action.charAt(0) != '.'){
                    secondOperand = secondOperand + action;
                }
                else{
                    if(!secondOperand.contains(".")){
                        secondOperand = secondOperand + action;
                    }
                }
            }
            // set the value of the text field
            textField.setText(firstOperand + operator + secondOperand);
        } else if (action.equals("=")) {
            if(!firstOperand.isEmpty() && !secondOperand.isEmpty()) {
                double result = 0;
                try {
                    result = performCalculation(calculator);
                    textField.setText(firstOperand + operator + secondOperand + " = " + result);
                    //Use the logger component to record the operations (use the file to record the history)
                    implementation.logMessageToFile(firstOperand + PUNCTUATION_MARK_EMPTY_STRING + operator + PUNCTUATION_MARK_EMPTY_STRING + secondOperand + " = " + result);
                    firstOperand = Double.toString(result);
                    operator = PUNCTUATION_MARK_EMPTY_STRING;
                    secondOperand = PUNCTUATION_MARK_EMPTY_STRING;
                    storeVal = firstOperand;
                    firstOperand = PUNCTUATION_MARK_EMPTY_STRING;
                } catch (Exception ex) {
                    //Use the logger component to log the error
                    implementation.logErrorMessage("Error when performing calculation : " + ex.getMessage());
                    textField.setText("Error");
                    operator = PUNCTUATION_MARK_EMPTY_STRING;
                    secondOperand = PUNCTUATION_MARK_EMPTY_STRING;
                    firstOperand = PUNCTUATION_MARK_EMPTY_STRING;
                }
            }
        }else{
            if(operator.equals(PUNCTUATION_MARK_EMPTY_STRING) || secondOperand.equals(PUNCTUATION_MARK_EMPTY_STRING)){
                if(!firstOperand.isEmpty()){
                    operator = action;
                    textField.setText(firstOperand + operator + secondOperand);
                }
                else if(!storeVal.isEmpty()){
                    operator = action;
                    textField.setText(storeVal + operator + secondOperand);
                    firstOperand = storeVal;
                }
            }else{
                double result = 0;
                try {
                    result = performCalculation(calculator);
                } catch (Exception ex) {
                    //Use the logger component to log the error
                    implementation.logErrorMessage("Error when performing calculation : " + ex.getMessage());
                    textField.setText("Error");
                }
                //Use the logger component to record the operations (use the file to record the history)
                implementation.logMessageToFile(firstOperand + PUNCTUATION_MARK_EMPTY_STRING + operator + PUNCTUATION_MARK_EMPTY_STRING + secondOperand + " = " + result);
                firstOperand = Double.toString(result);
                secondOperand = PUNCTUATION_MARK_EMPTY_STRING;
                operator = action;
                textField.setText(firstOperand + operator + secondOperand);
            }
        }
    }


    public static void main(String[] args) {

        frame = new JFrame("Calculator");
        panel = new JPanel();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            implementation.logErrorMessage(e.getMessage());
        }

        init();
        addActionListeners();
        addToPanel(panel);
        frame.add(panel);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
