package demo01;

public abstract class Machine {
    private int energy;
    public  Machine(int x){
        this.energy =x;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
