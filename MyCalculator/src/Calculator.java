import javax.swing.*;
import java.awt.*;

public class Calculator {
	 //Declaration of all calculator components.
	JPanel windowContent;
	JFormattedTextField displayField;
	JButton[] numButtons;
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonPlus;
	JButton buttonMinus;
	JButton buttonDivide;
	JButton buttonMultiply;
	JButton buttonClear;
	JPanel p1;
	JPanel p2;
	
	//Constructor creates the components in memory and adds the to the frame using combination of Borderlayout.
	Calculator() {

		windowContent = new JPanel();
		
	    // Set the layout manager for this panel
		
		BorderLayout b1 = new BorderLayout();
		windowContent.setLayout(b1);

		 //Create the display field and place it in the North area of the window
		displayField = new JFormattedTextField();
		displayField.setColumns(30);
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		windowContent.add("North", displayField);
		
		//Create the panel with the GridLayout that will contain 10 buttons - 10 numeric ones, and button with the points
	    //and the equal sign and button "dot".
		
		JPanel p1 = new JPanel();
		GridLayout gl = new GridLayout(4, 3);
		p1.setLayout(gl);
		
		//Create massive button field and place it in the North area of the window
		numButtons = new JButton[10];
		
		//Create massive button field in the North area of the window and add them to window controls panel "p1".
		for (int i = 0; i < numButtons.length; i++) {

			numButtons[i] = new JButton(String.valueOf(i));
			p1.add(numButtons[i]);

		}
		
		//Create button field and place it in the North area of the window
		buttonPoint = new JButton(".");
		buttonEqual = new JButton("=");
		//Add window controls to the panel pl.
		p1.add(buttonPoint);
		p1.add(buttonEqual);
		//Add the panel pl to the center area of the window
		windowContent.add("Center", p1);

		//Create the panel with the GridLayout that will contain 4 buttons.
		JPanel p2 = new JPanel();
		GridLayout gl2 = new GridLayout(4, 1);
		p2.setLayout(gl2);
		
		//Create button field and place it in the East area of the window
		
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		buttonDivide = new JButton("/");
		buttonMultiply = new JButton("*");
		buttonClear = new JButton("C");
		
		 //Add window controls to the panel pl.
		
		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonDivide);
		p2.add(buttonMultiply);
		p2.add(buttonClear);
		
		
		//Add the panel pl to the East area of the window
		
		windowContent.add("East", p2);

		//Create the frame and set its content pane
		JFrame frame = new JFrame("Calulator");
		frame.setContentPane(windowContent);
		//set the size of the window to be big enough to accomodate all controls.
		frame.pack();
		 //Finnaly, display the window
		frame.setVisible(true);
		
		// Create an instance of the event listener and
		// register it in each button
		
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		
		for (int i = 0; i < numButtons.length; i++) {
			numButtons[i].addActionListener(calcEngine); ;
		}
		buttonPoint.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);
	    buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine);
		buttonDivide.addActionListener(calcEngine);
		buttonMultiply.addActionListener(calcEngine);
		buttonClear.addActionListener(calcEngine);
		
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}
