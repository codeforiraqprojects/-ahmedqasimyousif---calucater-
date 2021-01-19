package application;

import javax.swing.JOptionPane;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private TextField t_Result;
	String a1 = "";
	String a2 = "";
	String operation = "";
	double first;
	double second;
	boolean bool = false;

	public void getNumber(Event e) {
		Button b = (Button) e.getSource();
		if (!bool) {
			a1 += b.getText();
			t_Result.setText(a1);
		} else {
			a2 += b.getText();
			t_Result.setText(a1 + operation + a2);

		}
	}

	public static class Operations {
		public static double addition(double i, double j) {
			return i + j;
		}

		public static double subtraction(double i, double j) {
			return i - j;
		}

		public static double multiplication(double i, double j) {
			return i * j;
		}

		public static double division(double i, double j) {

			return i / j;

		}

	}

	public void getOperation(Event e) {
		if (operation.equals(""))
			first = Double.parseDouble(t_Result.getText());
		Button b = (Button) e.getSource();
		operation = b.getText();
		t_Result.setText(a1 + operation);
		bool = true;
	}

	
	public void Result() {
		 
		a1 = "";
		 second = Double.parseDouble(a2); 
		
		a2 = "";
		bool = false;
		
		switch (operation) {
		case "+":
			t_Result.setText(Double.toString(Operations.addition(first, second)));
			first = Operations.addition(first, second);
			break;
		case "-":
			t_Result.setText(Double.toString(Operations.subtraction(first, second)));
			first = Operations.subtraction(first, second);
			break;
		case "*":
			t_Result.setText(Double.toString(Operations.multiplication(first, second)));
			first = Operations.multiplication(first, second);
			break;
		case "/":
			t_Result.setText(Double.toString(Operations.division(first, second)));
			first = Operations.division(first, second);
			break;
		}
	}
}
