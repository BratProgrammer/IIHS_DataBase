package ru.bratprogrammer.IIHS.DAO.Imples;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bratprogrammer.IIHS.DAO.CrashTestResultDAO;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;
import java.util.List;
import java.util.Optional;

@Repository
public class CrashTestResultDAOImpl implements CrashTestResultDAO {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Optional<Double> getAverageTestResultByCarId(int id) {
        String jpql = """
                SELECT AVG(
                a.smallOverlapFront,
                a.moderateOverlapFront,
                a.side,
                a.headlights,
                a.seatBeltReminders,
                a.frontCrash,
                a.LatchEaseOfUse
                )
                FROM CrashTestResult a
                WHERE a.carId = :id
                """;
        return entityManager.createQuery(jpql, Double.class)
                .setParameter("id", id)
                .getSingleResult().describeConstable();
    }

    @Override
    @Transactional
    public void create(CrashTestResult crashTestResult) {
        entityManager.persist(crashTestResult);
    }

    @Override
    @Transactional
    public void update(int id, CrashTestResult crashTestResult) {
        CrashTestResult forUpdate = entityManager.find(CrashTestResult.class, id);

        if (crashTestResult != null && forUpdate != null) {
            forUpdate.setFrontCrash(crashTestResult.getFrontCrash());
            forUpdate.setSide(crashTestResult.getSide());
            forUpdate.setSmallOverlapFront(crashTestResult.getSmallOverlapFront());
            forUpdate.setModerateOverlapFront(crashTestResult.getModerateOverlapFront());
            forUpdate.setHeadlights(crashTestResult.getHeadlights());
            forUpdate.setSeatBeltReminders(crashTestResult.getSeatBeltReminders());
            forUpdate.setLatchEaseOfUse(crashTestResult.getLatchEaseOfUse());
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
