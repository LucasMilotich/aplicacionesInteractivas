package com.applicacionesInteractivas.modelo;

public class Asiento {

	private int posx;
	private int posY;

    public Asiento(int posx, int posY) {
		super();
		this.posx = posx;
		this.posY = posY;
	}


	public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
