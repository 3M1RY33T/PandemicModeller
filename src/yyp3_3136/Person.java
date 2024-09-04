package yyp3_3136;

import java.awt.Color;
import java.util.Random;

public class Person {
    private boolean isAlive;
    private boolean isInfected;
    private int immunityStatus;
    private Color color;
    private int xCoordinate;
    private int yCoordinate;
    private int xIncrementValue;
    private int yIncrementValue;
    private int cycleCounter;

    public Person(int immunityStatus, Color color) {
        this.isAlive = true;
        this.isInfected = false;
        this.immunityStatus = immunityStatus;
        this.color = color;
        Random rand = new Random();
        this.xCoordinate = rand.nextInt(800);
        this.yCoordinate = rand.nextInt(600);
        this.xIncrementValue = rand.nextInt(11) - 5;
        this.yIncrementValue = rand.nextInt(11) - 5;
        this.cycleCounter = 0;
    }

    public void move() {
        if (isAlive) {
            xCoordinate += xIncrementValue;
            yCoordinate += yIncrementValue;
            if (xCoordinate < 0 || xCoordinate > 800) xIncrementValue = -xIncrementValue;
            if (yCoordinate < 0 || yCoordinate > 600) yIncrementValue = -yIncrementValue;
        }
    }

    public void checkCollision(Person other) {
        int dx = this.xCoordinate - other.xCoordinate;
        int dy = this.yCoordinate - other.yCoordinate;
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance < 5) { 
            if (this.isInfected && !other.isInfected) {
                infect(other);
            } else if (!this.isInfected && other.isInfected) {
                other.infect(this);
            }
            
            this.xIncrementValue = new Random().nextInt(11) - 5;
            this.yIncrementValue = new Random().nextInt(11) - 5;
            other.xIncrementValue = new Random().nextInt(11) - 5;
            other.yIncrementValue = new Random().nextInt(11) - 5;
        }
    }

    private void infect(Person other) {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (other.immunityStatus == 1 && chance < 80) {
            other.setInfected(true);
            other.setColor(Color.RED);
        } else if (other.immunityStatus == 2 && chance < 60) {
            other.setInfected(true);
            other.setColor(Color.RED);
        } else if (other.immunityStatus == 3 && chance < 30) {
            other.setInfected(true);
            other.setColor(Color.RED);
        } else if (other.immunityStatus == 4 && chance < 10) {
            other.setInfected(true);
            other.setColor(Color.RED);
        } else if (other.immunityStatus == 5 && chance < 40) {
            other.setInfected(true);
            other.setColor(Color.RED);
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void setInfected(boolean isInfected) {
        this.isInfected = isInfected;
    }

    public int getImmunityStatus() {
        return immunityStatus;
    }

    public void setImmunityStatus(int immunityStatus) {
        this.immunityStatus = immunityStatus;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxIncrementValue() {
        return xIncrementValue;
    }

    public void setxIncrementValue(int xIncrementValue) {
        this.xIncrementValue = xIncrementValue;
    }

    public int getyIncrementValue() {
        return yIncrementValue;
    }

    public void setyIncrementValue(int yIncrementValue) {
        this.yIncrementValue = yIncrementValue;
    }

    public int getCycleCounter() {
        return cycleCounter;
    }

    public void setCycleCounter(int cycleCounter) {
        this.cycleCounter = cycleCounter;
    }
}
