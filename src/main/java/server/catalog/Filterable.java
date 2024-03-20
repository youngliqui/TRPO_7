package server.catalog;

import java.util.List;

public interface Filterable<T> {
    List<T> getByType(String type);
    List<T> getByName(String name);
    List<T> getByProducer(String producer);
    List<T> getByPurpose(String purpose);
}
