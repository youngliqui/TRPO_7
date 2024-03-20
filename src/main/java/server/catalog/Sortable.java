package server.catalog;

public interface Sortable<T> {
    void sortByAscendingPrice();
    void sortByDescendingPrice();
    void sortByName();
}
