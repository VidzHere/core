package eight.core.collectors.collect.groupingBy;

import eight.data.Passenger;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class PassengerGroupingExample {

    /*
        static <T,K> Collector<T,?,Map<K,List<T>>>	groupingBy(Function<? super T,? extends K> classifier)
        Returns a Collector implementing a "group by" operation on input elements of type T,
        grouping elements according to a classification function,
        and returning the results in a Map.

        static <T,K,A,D> Collector<T,?,Map<K,D>>	groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        Returns a Collector implementing a cascaded "group by" operation on input elements of type T,
        grouping elements according to a classification function,
        and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

        static <T,K,D,A,M extends Map<K,D>>
        Collector<T,?,M>	groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
        Returns a Collector implementing a cascaded "group by" operation on input elements of type T,
        grouping elements according to a classification function,
        and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

        static <T,K> Collector<T,?,ConcurrentMap<K,List<T>>>	groupingByConcurrent(Function<? super T,? extends K> classifier)
        Returns a concurrent Collector implementing a "group by" operation on input elements of type T,
        grouping elements according to a classification function.

        static <T,K,A,D> Collector<T,?,ConcurrentMap<K,D>>	groupingByConcurrent(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        Returns a concurrent Collector implementing a cascaded "group by" operation on input elements of type T,
        grouping elements according to a classification function,
        and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

        static <T,K,A,D,M extends ConcurrentMap<K,D>>
        Collector<T,?,M>	groupingByConcurrent(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
        Returns a concurrent Collector implementing a cascaded "group by" operation on input elements of type T,
        grouping elements according to a classification function,
        and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.
    * */

    public static void main(String[] args) {

        List<Passenger> passengerList = Passenger.getPassengerList();
        getPassportNoList(passengerList);
        getBaggageCount(passengerList);
        getBaggageWeight(passengerList);
        destinationList(passengerList);
        getPassengerBaggageCount(passengerList);
        groupByDestination(passengerList);
        groupFirstNamesByDestination(passengerList);
        getPassengerCountByDestination(passengerList);
        getPassengerCountByDest(passengerList);
    }

    static void getPassportNoList(final List<Passenger> passengerList) {
        System.out.println(" Get passport nos of passengers :" + passengerList.stream()
                .map(Passenger::getPassportNo)
                .toList());
    }

    static void getBaggageCount(final List<Passenger> passengerList) {

        System.out.println(" Get total no of bags :" + passengerList.stream()
                .map(Passenger::getBaggageCount)
                .reduce(Integer::sum));
    }

    static void getBaggageWeight(final List<Passenger> passengerList) {

        System.out.println(" Get total no of bags :" + passengerList.stream()
                .map(Passenger::getBaggageWeight)
                .reduce(Double::sum));
    }

    static void getPassengerBaggageCount(final List<Passenger> passengerList) {

        Map<String, Long> psgrBaggageWeight = passengerList.stream()
                .collect(groupingBy(Passenger::getPassportNo
                        , summingLong(Passenger::getBaggageCount)));
        System.out.println(psgrBaggageWeight);
    }

    static void groupByDestination(final List<Passenger> passengerList) {

        Map<String, List<Passenger>> destinationMap = passengerList.stream()
                .collect(Collectors.groupingBy(Passenger::getDestination));  // .collect(Collectors.groupingBy(n->n.getDestination()));
        System.out.println(destinationMap);

    }

    /*{HKG=[Passenger(passportNo=G1110349, lastname=Zu, firstname=Ciana, startingpoint=SFO, destination=HKG, baggageCount=3, baggageWeight=72.0),
Passenger(passportNo=P212220, lastname=Di, firstname=Cia, startingpoint=SFO, destination=HKG, baggageCount=1, baggageWeight=15.0),
Passenger(passportNo=U190909, lastname=Sharma, firstname=Aditi, startingpoint=SFO, destination=HKG, baggageCount=3, baggageWeight=75.0)],

DEL=[Passenger(passportNo=Q378909, lastname=Gupta, firstname=Rakesh, startingpoint=SFO, destination=DEL, baggageCount=2, baggageWeight=52.0),
 Passenger(passportNo=H189189, lastname=Sharma, firstname=Sohan, startingpoint=SFO, destination=DEL, baggageCount=2, baggageWeight=14.0),
 Passenger(passportNo=R178909, lastname=Chattergee, firstname=Priyanshu, startingpoint=SFO, destination=DEL, baggageCount=2, baggageWeight=15.0)]}
  */


    static void groupFirstNamesByDestination(final List<Passenger> passengerList) {

        Map<String, List<String>> destinationMap = passengerList.stream()
                .collect(Collectors.groupingBy(Passenger::getDestination,
                        mapping(Passenger::getFirstname, toList())));
        System.out.println(destinationMap);

    }

    static void destinationList(final List<Passenger> passengerList) {
        Predicate<Passenger> des_hkg = p -> Objects.equals(p.getDestination(), "HKG");
        List<String> destination_hkg =
                passengerList
                        .stream()
                        .filter(des_hkg)
                        .map(Passenger::getFirstname).toList();
        System.out.println(destination_hkg);

    }

    static void getPassengerCountByDestination(final List<Passenger> passengerList) {
        Map<String, Long> destinationMap = passengerList.stream()
                .collect(Collectors.groupingBy(Passenger::getDestination, counting()));
        System.out.println(destinationMap);
    }

    static void getPassengerCountByDest(final List<Passenger> passengerList) {
        Map<String, Long> destinationMap = passengerList.stream()
                .collect(Collectors.groupingBy(Passenger::getDestination, counting()));
        System.out.println(destinationMap);
    }


}
