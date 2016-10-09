package DongyangJiang.gui;

import DongyangJiang.event.Event;

public class GUIManage {

	public GUIManage(Event event) {
		DetailGUI.startUI(event);
	}
	public GUIManage(String flag , Event event) {
		if("open".equals(flag)){
			ReportGUI.startUI(event);
		}
	}
	
}
