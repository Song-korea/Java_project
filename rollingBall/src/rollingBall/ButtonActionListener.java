package rollingBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
	
	private Core core;
	
	public ButtonActionListener(Core core) {
		this.core = core;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			String actionCommand = e.getActionCommand();
		
			if(actionCommand == "play") 
				core.clickedPlay();	
			else if(actionCommand == "stop") 
				core.clickedStop();
			else if(actionCommand == "add") 
				core.clickedAdd();
			else if(actionCommand == "delete") 
				core.clickedDelete();
		
		}
	
	}
