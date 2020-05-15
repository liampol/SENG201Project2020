package supportClasses;
/*
 * The "Days" Class is used to keep track of the operations of the days that are initialised using the "PaddockParadiseManager"
 * 
 */
public class Days {
	
	private int days;
	
	public void setDay(int day) {
		days = day;
	}
	
	public void nextDay() {
		days =- 1;
		if (days == 0) {
			//endGame();
		}
	}
	
	public int getDay() {
		return days;
	}
}