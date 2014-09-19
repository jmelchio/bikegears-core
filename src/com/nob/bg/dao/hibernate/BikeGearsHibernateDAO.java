package com.nob.bg.dao.hibernate;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nob.bg.dao.BikeGearsDAO;
import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeRide;
import com.nob.bg.model.BikeRideType;
import com.nob.bg.model.BikeRider;
import com.nob.bg.model.BikeType;
import com.nob.bg.model.Person;
import com.nob.bg.model.dto.LoginDTO;
import com.nob.bg.model.reports.DistToDate;
import com.nob.bg.model.reports.MonthlyStats;

public class BikeGearsHibernateDAO extends HibernateDaoSupport implements
        BikeGearsDAO {

    public BikeRider login(final LoginDTO login) {
        return (BikeRider) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        BikeRider rider = (BikeRider) session.createCriteria(
                                BikeRider.class).add(
                                Restrictions.eq("userName", login
                                        .getUserName())).add(
                                Restrictions
                                        .eq("password", login.getPassword()))
                                .uniqueResult();
                        return rider;
                    }
                });
    }

    public void changeBike(Bike bike) {
        getHibernateTemplate().update(bike);
    }

    public void changeBikeRide(BikeRide ride) {
        getHibernateTemplate().update(ride);
    }

    public void changeBikeRideType(BikeRideType rideType) {
        getHibernateTemplate().update(rideType);
    }

    public void changeBikeRider(BikeRider rider) {
        getHibernateTemplate().update(rider);
    }

    public void changeBikeType(BikeType bikeType) {
        getHibernateTemplate().update(bikeType);
    }

    public void changePerson(Person person) {
        getHibernateTemplate().update(person);
    }

    public Bike createBike(Bike bike) {
        getHibernateTemplate().save(bike);
        return null;
    }

    public BikeRide createBikeRide(BikeRide ride) {
        getHibernateTemplate().save(ride);
        return null;
    }

    public BikeRideType createBikeRideType(BikeRideType rideType) {
        getHibernateTemplate().save(rideType);
        return null;
    }

    public BikeRider createBikeRider(BikeRider rider) {
        getHibernateTemplate().save(rider);
        return null;
    }

    public BikeType createBikeType(BikeType bikeType) {
        getHibernateTemplate().save(bikeType);
        return null;
    }

    public Person createPerson(Person person) {
        getHibernateTemplate().save(person);
        return null;
    }

    public void deleteBike(Bike bike) {
        getHibernateTemplate().delete(bike);
    }

    public void deleteBikeById(Long id) {
        Bike bike = (Bike) getHibernateTemplate().get(Bike.class, id);
        deleteBike(bike);
    }

    public void deleteBikeRide(BikeRide ride) {
        getHibernateTemplate().delete(ride);
    }

    public void deleteBikeRideById(Long id) {
        BikeRide ride = (BikeRide) getHibernateTemplate().get(BikeRide.class,
                id);
        getHibernateTemplate().delete(ride);
    }

    public void deleteBikeRideType(BikeRideType rideType) {
        getHibernateTemplate().delete(rideType);
    }

    public void deleteBikeRideTypeById(Long id) {
        BikeRideType rideType = (BikeRideType) getHibernateTemplate().get(
                BikeRideType.class, id);
        getHibernateTemplate().delete(rideType);
    }

    public void deleteBikeRider(BikeRider rider) {
        getHibernateTemplate().delete(rider);
    }

    public void deleteBikeRiderById(Long id) {
        BikeRider rider = (BikeRider) getHibernateTemplate().get(
                BikeRider.class, id);
        getHibernateTemplate().delete(rider);
    }

    public void deleteBikeType(BikeType bikeType) {
        getHibernateTemplate().delete(bikeType);
    }

    public void deleteBikeTypeById(Long id) {
        BikeType bikeType = (BikeType) getHibernateTemplate().get(
                BikeType.class, id);
        getHibernateTemplate().delete(bikeType);
    }

    public void deletePerson(Person person) {
        getHibernateTemplate().delete(person);
    }

    public void deletePersonById(Long id) {
        Person person = (Person) getHibernateTemplate().get(Person.class, id);
        getHibernateTemplate().delete(person);
    }

    public Bike getBikeById(final Long id) {
        return (Bike) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Bike bike = (Bike) session.createCriteria(Bike.class).add(
                        Restrictions.idEq(id)).setFetchMode("bikeRider",
                        FetchMode.JOIN)
                        .setFetchMode("bikeType", FetchMode.JOIN)
                        .uniqueResult();
                return bike;
            }

        });
    }

    public BikeRide getBikeRideById(final Long id) {
        return (BikeRide) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        BikeRide ride = (BikeRide) session.createCriteria(
                                BikeRide.class).add(Restrictions.idEq(id))
                                .setFetchMode("bike", FetchMode.JOIN)
                                .setFetchMode("bikeRideType", FetchMode.JOIN)
                                .uniqueResult();
                        return ride;
                    }

                });
    }

    public BikeRideType getBikeRideTypeById(Long id) {
        return (BikeRideType) getHibernateTemplate()
                .get(BikeRideType.class, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<BikeRideType> getBikeRideTypes() {
        return getHibernateTemplate().find("from BikeRideType");
    }

    public BikeRider getBikeRiderById(Long id) {
        return (BikeRider) getHibernateTemplate().get(BikeRider.class, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<BikeRider> getBikeRiders() {
        return getHibernateTemplate().find("from BikeRider");
    }

    @SuppressWarnings("unchecked")
    public Collection<BikeRide> getBikeRides(final Integer rowLimit) {
        return (Collection<BikeRide>) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        Collection<BikeRide> rides = session.createCriteria(
                                BikeRide.class).addOrder(Order.desc("date"))
                                .setMaxResults(rowLimit).list();
                        return rides;
                    }

                });
    }

    @SuppressWarnings("unchecked")
    public Collection<BikeRide> getBikeRidesForRider(final BikeRider rider,
            final Integer rowLimit) {
        return (Collection<BikeRide>) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        Collection<BikeRide> rides = session.createCriteria(
                                BikeRide.class).add(
                                Restrictions.eq("bikeRider", rider)).addOrder(
                                Order.desc("date")).setMaxResults(rowLimit)
                                .list();
                        return rides;
                    }
                });
    }

    public Collection<BikeRide> getBikeRidesForRiderById(
            final Long bikeRiderId, final Integer rowLimit) {
        BikeRider rider = (BikeRider) getHibernateTemplate().get(
                BikeRider.class, bikeRiderId);
        return getBikeRidesForRider(rider, rowLimit);
    }

    public BikeType getBikeTypeById(Long id) {
        return (BikeType) getHibernateTemplate().get(BikeType.class, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<BikeType> getBikeTypes() {
        return getHibernateTemplate().find("from BikeType");
    }

    @SuppressWarnings("unchecked")
    public Collection<Bike> getBikes() {
        return getHibernateTemplate().find("from Bike");
    }

    @SuppressWarnings("unchecked")
    public Collection<Bike> getBikesForRider(final BikeRider rider) {
        return (Collection<Bike>) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        Collection<Bike> bikes = session.createCriteria(
                                Bike.class).add(
                                Restrictions.eq("bikeRider", rider)).list();
                        return bikes;
                    }

                });
    }

    public Collection<Bike> getBikesForRiderById(Long bikeRiderId) {
        BikeRider rider = (BikeRider) getHibernateTemplate().get(
                BikeRider.class, bikeRiderId);
        return getBikesForRider(rider);
    }

    public Collection<DistToDate> getDistToDateForPerson(Person person) {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<DistToDate> getDistToDateForPersonById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<MonthlyStats> getMonthComparisonForPerson(Person person) {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<MonthlyStats> getMonthComparisonForPersonById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<MonthlyStats> getMonthlyStatsForPerson(Person person) {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<MonthlyStats> getMonthlyStatsForPersonById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    public Collection<Person> getPeople() {
        return getHibernateTemplate().find("from Person");
    }

    public Person getPersonById(Long id) {
        return (Person) getHibernateTemplate().get(Person.class, id);
    }

    public Bike getBikeForRide(final BikeRide ride) {
        return (Bike) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                session.update(ride);
                Bike bike = ride.getBike();
                if (bike != null) {
                    bike.getBrand(); // make sure bikeride is fetched
                }
                return bike;
            }
        });
    }

    public BikeRideType getBikeRideTypeForRide(final BikeRide ride) {
        return (BikeRideType) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        BikeRideType rideType = (BikeRideType) session
                                .createCriteria(BikeRideType.class).add(
                                        Restrictions.idEq(ride
                                                .getBikeRideType().getId()))
                                .uniqueResult();
                        return rideType;
                    }
                });
    }

    public BikeType getBikeTypeForBike(final Bike bike) {
        return (BikeType) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        BikeType bikeType = (BikeType) session.createCriteria(
                                BikeType.class).add(
                                Restrictions.idEq(bike.getBikeType().getId()))
                                .uniqueResult();
                        return bikeType;
                    }
                });
    }

    public Person getPersonForBikeRider(final BikeRider rider) {
        return (Person) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Person person = (Person) session.createCriteria(Person.class)
                        .add(Restrictions.idEq(rider.getPerson().getId()))
                        .uniqueResult();
                return person;
            }
        });
    }

    public BikeRider getBikeRiderForBikeRide(final BikeRide ride) {
        return (BikeRider) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        BikeRider bikeRider = (BikeRider) session
                                .createCriteria(BikeRider.class).add(
                                        Restrictions.idEq(ride.getBikeRider()
                                                .getId())).uniqueResult();
                        return bikeRider;
                    }
                });
    }

}
/* That's All Folks !! */