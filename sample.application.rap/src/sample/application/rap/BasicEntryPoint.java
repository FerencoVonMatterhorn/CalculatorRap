package sample.application.rap;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.rap.rwt.application.EntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BasicEntryPoint implements EntryPoint {

	static Text dieEingabe0;
	static Text dieEingabe1;
	static Text dieAusgabe;

	@Override
	public int createUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display, SWT.SHELL_TRIM);
		shell.setBounds(700, 200, 550, 200);
		shell.setLayout(new GridLayout(1, true));
		createLayer(shell);
		shell.open();
		shell.layout();

		return 0;
	}

	private Composite createLayer(Composite parent) {

		Composite layer0 = new Composite(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(layer0);
		
		Composite layer1 = new Composite(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(layer1);
		
		Composite layer2 = new Composite(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(layer2);

		RowLayout rowLayout = new RowLayout();
		rowLayout.justify = true;

		
		
		layer0.setLayout(rowLayout);
		layer1.setLayout(rowLayout);
		layer2.setLayout(rowLayout);

		dieAusgabe = new Text(layer0, SWT.FILL | SWT.BORDER);
		dieAusgabe.setEditable(false);

		erstelleButtons(layer1);

		dieEingabe0 = new Text(layer2, SWT.FILL | SWT.BORDER);
		dieEingabe1 = new Text(layer2, SWT.FILL | SWT.BORDER);

		parent.layout();
		return parent;
	}

	private void erstelleButtons(Composite layer1) {
		Button derbutton = new Button(layer1, SWT.BORDER);
		Button derbutton1 = new Button(layer1, SWT.BORDER);
		Button derbutton2 = new Button(layer1, SWT.BORDER);
		Button derbutton3 = new Button(layer1, SWT.BORDER);
		derbutton.setText("Addieren");
		derbutton1.setText("Subtrahieren");
		derbutton2.setText("Multiplizieren");
		derbutton3.setText("Dividieren");
		addlistenerbtn0(derbutton);
		addlistenerbtn1(derbutton1);
		addlistenerbtn2(derbutton2);
		addlistenerbtn3(derbutton3);
	}

	private void addlistenerbtn0(Button derbutton) {
		derbutton.addListener(SWT.Selection, (event) -> {
			try {
				double a = Double.parseDouble(dieEingabe0.getText());
				double b = Double.parseDouble(dieEingabe1.getText());
				MathOperations rechner = new MathOperations();
				rechner.add(a, b);
				dieAusgabe.setText("" + MathOperations.sum);
				System.out.println("pressed");
			} catch (NumberFormatException e) {
				System.out.println("keine Zahl eingegeben!!!111eineinseins!!!11");
			}

		});
	}

	private void addlistenerbtn1(Button derbutton1) {
		derbutton1.addListener(SWT.Selection, (event) -> {

			try {
				double a = Double.parseDouble(dieEingabe0.getText());
				double b = Double.parseDouble(dieEingabe1.getText());
				MathOperations rechner = new MathOperations();
				rechner.sub(a, b);
				dieAusgabe.setText("" + MathOperations.sum);
				System.out.println("pressed");

			} catch (Exception e) {
				System.out.println("keine Zahl eingegeben!!!111eineinseins!!!11");
			}
		});
	}

	private void addlistenerbtn2(Button derbutton2) {
		derbutton2.addListener(SWT.Selection, (event) -> {

			try {
				double a = Double.parseDouble(dieEingabe0.getText());
				double b = Double.parseDouble(dieEingabe1.getText());
				MathOperations rechner = new MathOperations();
				rechner.mul(a, b);
				dieAusgabe.setText("" + MathOperations.sum);
				System.out.println("pressed");

			} catch (Exception e) {
				System.out.println("keine Zahl eingegeben!!!111eineinseins!!!11");
			}
		});
	}

	private void addlistenerbtn3(Button derbutton3) {
		derbutton3.addListener(SWT.Selection, (event) -> {

			try {
				double a = Integer.parseInt(dieEingabe0.getText());
				double b = Integer.parseInt(dieEingabe1.getText());
				MathOperations rechner = new MathOperations();
				rechner.div(a, b);
				dieAusgabe.setText("" + MathOperations.sum);

			} catch (Exception e) {
				System.out.println("Keine Zahl eingegeben!");
			}
		});
	}

}



