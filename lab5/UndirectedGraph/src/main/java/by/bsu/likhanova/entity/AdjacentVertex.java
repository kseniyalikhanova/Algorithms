package by.bsu.likhanova.entity;

import java.util.Objects;

public class AdjacentVertex implements Comparable<AdjacentVertex> {
    private Integer vertex;
    private Integer weight;

    public AdjacentVertex(){
        this.vertex = -1;
        this.weight = -1;
    }

    public AdjacentVertex(final Integer newVertex, final Integer newWeight){
        this.vertex = newVertex;
        this.weight = newWeight;
    }

    public Integer getVertex() {
        return vertex;
    }

    public void setVertex(final Integer newVertex) {
        this.vertex = newVertex;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(final Integer newWeight) {
        this.weight = newWeight;
    }

    public void setAdjacentVertex(final Integer newVertex, final Integer newWeight){
        this.vertex = newVertex;
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
        AdjacentVertex adjacentVertex = (AdjacentVertex) o;
        return vertex.equals(adjacentVertex.vertex)
                && weight.equals(adjacentVertex.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex, weight);
    }

    @Override
    public int compareTo(AdjacentVertex other) {
        int result;
        result = Integer.compare(this.weight, other.weight);
        if (result == 0) {
            result = Integer.compare(this.vertex, other.vertex);
        }
        return result;
    }

    @Override
    public String toString() {
        return "(" + vertex +
                ", weight = " + weight +
                ")";
    }
}
