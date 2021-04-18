package lv.lu.finalwork.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Long save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete (Long id);

}
