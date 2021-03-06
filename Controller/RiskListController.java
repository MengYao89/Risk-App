package Controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Risk_Model;
import View.Board_View;

/**
 * This class maps the user's actions in RiskList objects to the data and methods in the 
 * model.
 * @author yaomeng
 *
 */
public class RiskListController implements ListSelectionListener {

	private Risk_Model model;
	private Board_View view;
	
	public RiskListController(Risk_Model model, Board_View view) {
		this.model = model;
		this.view = view;
	}

	public void valueChanged(ListSelectionEvent evt) {
	
		if (evt.getValueIsAdjusting() == true) {
			
			if (view.getCountryAIndex() == -1) {
			
			} else {
				model.setCountryASelection(view.getCountryA().replaceAll("[0-9]", "").replaceAll("\\-", ""));
			}
		}
	}
}