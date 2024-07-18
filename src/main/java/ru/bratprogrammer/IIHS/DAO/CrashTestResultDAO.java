package ru.bratprogrammer.IIHS.DAO;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;
import java.util.List;
import java.util.Optional;

@Repository
public class CrashTestResultDAO implements DAO<CrashTestResult> {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Optional<Double> getAverageTestResultByCarId(int id) {
        String jpql = """
                SELECT AVG(
                a.small_overlap_front,
                a.moderate_overlap_front,
                a.side,
                a.headlights,
                a.seat_belt_reminders,
                a.front_crash,
                a.LATCH_ease_of_use
                )
                FROM CrashTestResult a
                WHERE a.car_id = :id
                """;
        Optional<Double> average = entityManager.createQuery(jpql, Double.class)
                .setParameter("id", id)
                .getSingleResult().describeConstable();
        return average;
    }

    @Override
    @Transactional
    public void create(CrashTestResult crashTestResult) {
        entityManager.persist(crashTestResult);
    }

    @Override
    @Transactional
    public void update(CrashTestResult crashTestResult) {
        if (crashTestResult != null) {
            entityManager.merge(crashTestResult);
        }
    }

    @Override
    @Transactional
    public CrashTestResult getById(int id) {
        CrashTestResult crashTestResult = entityManager.find(CrashTestResult.class, id);
        entityManager.detach(crashTestResult);
        return crashTestResult;
    }

    @Override
    @Transactional
    public List<CrashTestResult> getAll() {
        List<CrashTestResult> list = entityManager.createQuery("SELECT * FROM crash_test_results", CrashTestResult.class).getResultList();
        list.forEach(entityManager::detach);
        return list;
    }

    @Override
    @Transactional
    public void delete(CrashTestResult crashTestResult) {
        if (crashTestResult != null) {
            entityManager.remove(crashTestResult);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        CrashTestResult crashTestResult = entityManager.find(CrashTestResult.class, id);
        if (crashTestResult != null) {
            entityManager.remove(crashTestResult);
        }
    }
}
