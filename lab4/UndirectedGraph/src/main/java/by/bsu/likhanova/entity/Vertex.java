package by.bsu.likhanova.entity;

public class Vertex {
    private int number;
    private boolean isMarked;

    public Vertex(final int newNumber){
        this.number = newNumber;
    }

    public int getNumber() {
        return number;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked() {
        isMarked = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return number == vertex.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
