package com.example.popatiya.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.popatiya.entity.Job;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends JpaRepository<Job, Long> {

    // @Override
    // public Page<jobs> findAll(Pageable pageable) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public <S extends jobs> S save(S entity) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public Optional<jobs> findById(jobsid id) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public boolean existsById(jobsid id) {
    // // TODO Auto-generated method stub
    // return false;
    // }

    // @Override
    // public long count() {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // @Override
    // public void deleteById(jobsid id) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void delete(jobs entity) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void deleteAll(Iterable<? extends jobs> entities) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void deleteAll() {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public <S extends jobs> Optional<S> findOne(Example<S> example) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public <S extends jobs> Page<S> findAll(Example<S> example, Pageable
    // pageable) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public <S extends jobs> long count(Example<S> example) {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // @Override
    // public <S extends jobs> boolean exists(Example<S> example) {
    // // TODO Auto-generated method stub
    // return false;
    // }

    // @Override
    // public List<jobs> findAll() {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public List<jobs> findAll(Sort sort) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public List<jobs> findAllById(Iterable<jobsid> ids) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public <S extends jobs> List<S> saveAll(Iterable<S> entities) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public void flush() {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public <S extends jobs> S saveAndFlush(S entity) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public void deleteInBatch(Iterable<jobs> entities) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void deleteAllInBatch() {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public jobs getOne(jobsid id) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public <S extends jobs> List<S> findAll(Example<S> example) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public <S extends jobs> List<S> findAll(Example<S> example, Sort sort) {
    // // TODO Auto-generated method stub
    // return null;
    // }

}
