package eight.core.collectors.collect.groupingBy;

import eight.data.Passenger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PassengerNestedGroupingExample {

  public static void main(String[] args) {

    List<Passenger> passengerList = Passenger.getPassengerList();
    Map<String, Map<String, List<String>>> destinationMap = passengerList.stream()
            .collect(Collectors.groupingBy(Passenger::getDestination,
                    Collectors.groupingBy(Passenger::getLastname,
                            Collectors.mapping(Passenger::getFirstname, Collectors.toList()))
            ));
    System.out.println(destinationMap);
  }
}
