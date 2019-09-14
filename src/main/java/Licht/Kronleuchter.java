package Licht;

public class Kronleuchter implements Licht{

    private boolean an = false;

	public boolean isAn() {
		return false;
	}

	public void schalteAus() {
        	this.an = false;
        	System.out.println("Der Kronleuchter geht aus.");
	}

	public void schalteAn() {
        	this.an = true;
        	System.out.println("Der Kronleuchter erstrahlt in güldenem Glanze!");
	}
}
