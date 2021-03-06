package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Risk_Model;
import View.LoadMap_View;
import View.MapEdit_View;
import View.PlayerCount_View;
import View.RiskStart_View;

/**
 * This class maps the user's actions in the Risk View to the data and methods in the model.
 * @author yaomeng
 *
 */
public class StartViewController implements ActionListener {

	private RiskStart_View view;
	private Risk_Model model;
	private LoadMap_View LoadMapDialog;
	
	public StartViewController(Risk_Model model, RiskStart_View view) {
		
		System.out.println("Loaded Risk!");
		
		this.model = model;
		this.view = view;
		//Add this class' actionListener to risk start View's buttons
		view.addActionListeners(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String actionEvent = evt.getActionCommand();
		
		if (actionEvent.equals("newGameBtn")) {
		
			System.out.println("Loading PlayerCountDialog...");
			//Opens the playerCountDialog
			LoadMapDialog = new LoadMap_View(view, true);
			LoadMapDialog.addActionListeners(new LoadMapController(model, LoadMapDialog));
			LoadMapDialog.setVisible(true);
		
		}else if (actionEvent.equals("editMapBtn")) {
			MapEdit_View v= new MapEdit_View();
			v.setVisible(true);
			//a.setSize(500,500);
			v.setBounds(250, 250, 400,400);
		}else if (actionEvent.equals("quitBtn")) {
			model.quitGame();
		} else {
			System.out.println("Error: " + actionEvent + " actionEvent not found!");
		}
	}
}
