package by.bsu.likhanova.entity;

import java.util.Objects;

public class Edge implements Comparable<Edge>{
    private int firstVertex;
    private int secondVertex;
    private int weight;

    public Edge() {

    }

    public Edge(final int newFirstVertex,
                final int newSecondVertex,
                final int newWeight) {
        this.firstVertex = newFirstVertex;
        this.secondVertex = newSecondVertex;
        this.weight = newWeight;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(final int newFirstVertex) {
        this.firstVertex = newFirstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(final int newSecondVertex) {
        this.secondVertex = newSecondVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int newWeight) {
        this.weight = newWeight;
    }

    public void setEdge(final int newFirstVertex,
                        final int newSecondVertex,
                        final int newWeight) {
    this.firstVertex = newFirstVertex;
    this.secondVertex = newSecondVertex;
    this.weight = newWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        return firstVertex == edge.firstVertex &&
                secondVertex == edge.secondVertex &&
                weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVertex, secondVertex, weight);
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "(" + firstVertex +
                ", " + secondVertex +
                "), weight = " + weight +
                '}';
    }
}
