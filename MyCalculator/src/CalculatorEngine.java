import java.awt.event.*;
import javax.swing.*;


public class CalculatorEngine implements ActionListener{
	
	String st = "St";
	
	Calculator parent; //Calculator link
	
	char selectedAction = ' '; // +, -, /, C , or *
	
	double currentResult = 0;
	
	// The constructor saves a link to the calculator window in the class variable "parent"
	
	CalculatorEngine(Calculator parent){
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Get the event source
		JButton clickedButton = (JButton) e.getSource();
		
		String dispFieldText = parent.displayField.getText();
		
		double displayValue = 0;
		
		// Get the number from the calculator display if not empty.
		// The exclamation point is a negation operator
		
		if (!"".equals(dispFieldText)) {
			displayValue = Double.parseDouble(dispFieldText);
		}
		// For each arithmetic button, remember it: +, -, /, C, or *, 
		// store the current number in the currentResult variable,
		// and clear the display to enter a new number
		Object src = e.getSource();
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonClear){
			selectedAction = 'C';
			parent.displayField.setText("");
			
		} else if (src == parent.buttonMinus){
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonDivide){
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonMultiply){
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonEqual) {
			
			// Perform arithmetic operation, depending on
			// from selectedAction, update the currentResult variable
			// and show the result on the display
			
			if (selectedAction == '+') {
				currentResult += displayValue;
			// Convert the result to a string by adding it
			// to an empty line and show it	
			parent.displayField.setText(""+currentResult);
			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction == '/') {
				//Division by zero test
				if (displayValue == 0) {
					JOptionPane.showConfirmDialog(null,"You cannot divide by zero",
							"Exceptions", JOptionPane.PLAIN_MESSAGE);
					
				}
				currentResult /= displayValue;
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction == '*') {
				currentResult *= displayValue;
				parent.displayField.setText(""+currentResult);
			}
		} else {
			// For all numeric buttons, attach the label to
			// button to the label in the display
			
			String clickedButtonLabel = clickedButton.getText();
			
			//Check more than one point 
			if ( clickedButtonLabel.indexOf('.') == 0 && dispFieldText.indexOf('.') > 0) {
				JOptionPane.showConfirmDialog(null,"You cannot enter more than one point",
						"Exceptions", JOptionPane.PLAIN_MESSAGE);
				parent.displayField.setText(dispFieldText);
				} 	else {
					parent.displayField.setText(dispFieldText + clickedButtonLabel);
				}

			
			
		}
			
	}

}
