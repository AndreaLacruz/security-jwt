package ar.com.ada.sb.security.jwt.service;

import java.util.List;

public interface Services<T> {

    T save(T dto) throws Exception;
    List<T> findAll();
    void delete(Long id);
}
