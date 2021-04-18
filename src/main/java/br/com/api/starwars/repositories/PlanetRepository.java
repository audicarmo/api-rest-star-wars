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
    public List<Planet> findAll(final Sort sort) {
        return null;
    }

    @Override
    public Page<Planet> findAll(final Pageable pageable) {
        return null;
    }

    @Override
    public List<Planet> findAllById(final Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(final Long aLong) {

    }

    @Override
    public void delete(final Planet planet) {

    }

    @Override
    public void deleteAll(final Iterable<? extends Planet> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Planet> S save(final S s) {
        return null;
    }

    @Override
    public <S extends Planet> List<S> saveAll(final Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Planet> findById(final Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(final Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Planet> S saveAndFlush(final S s) {
        return null;
    }

    @Override
    public void deleteInBatch(final Iterable<Planet> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Planet getOne(final Long aLong) {
        return null;
    }

    @Override
    public <S extends Planet> Optional<S> findOne(final Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Planet> List<S> findAll(final Example<S> example) {
        return null;
    }

    @Override
    public <S extends Planet> List<S> findAll(final Example<S> example, final Sort sort) {
        return null;
    }

    @Override
    public <S extends Planet> Page<S> findAll(final Example<S> example, final Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Planet> long count(final Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Planet> boolean exists(final Example<S> example) {
        return false;
    }
}
