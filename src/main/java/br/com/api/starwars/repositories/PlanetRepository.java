package br.com.api.starwars.repositories;

import br.com.api.starwars.entities.Planet;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanetRepository implements JpaRepository<Planet, Long> {

    @Override
    public List<Planet> findAll() {
        return null;
    }

    @Override
    public List<Planet> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Planet> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Planet> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Planet planet) {

    }

    @Override
    public void deleteAll(Iterable<? extends Planet> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Planet> S save(S s) {
        return null;
    }

    @Override
    public <S extends Planet> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Planet> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Planet> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Planet> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Planet getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Planet> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Planet> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Planet> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Planet> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Planet> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Planet> boolean exists(Example<S> example) {
        return false;
    }
}
