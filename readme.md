#### Test Cases   
*========== Story 1 ==========*   
should_return_capacity_10_when_parking_lot_is_created_given_no_capacity   
**GIVEN** parking lot   
**WHEN** created   
**THEN** capacity = 10   
   
should_return_capacity_5_when_parking_lot_is_created_given_capacity_5   
**GIVEN** parking lot, capacity 5   
**WHEN** created   
**THEN** capacity 5   
   
PB should_return_parking_lot_when_parking_boy_is_created_given_parking_lot   
**GIVEN** parking lot   
**WHEN** parking boy is created   
**THEN** parking boy has parking lot   
   
should_return_two_when_parking_lot_get_number_of_parked_cars_given_two_parked_cars   
**GIVEN** two parked cars   
**WHEN** parking lot get number of parked cars   
**THEN** return 2 parked cars.   
   
should_return_parking_ticket_when_parking_boy_park_a_car_given_parking_boy_and_a_car   
**GIVEN** parking boy a car   
**WHEN** parking boy parked a car   
**THEN** parking ticket is returned   
   
should_return_parking_lot_with_remaining_capacity_9_when_parking_boy_parked_a_car_given_parking_lot_with_capacity_10   
**GIVEN** parking lot , parked car   
**WHEN** parking boy parked a car   
**THEN** capacity = 9   
   
should_return_right_car_when_parking_boy_fetch_a_car_given_parking_ticket   
**GIVEN** a parking ticket   
**WHEN** fetch the car   
**THEN** the right car is fetched   
   
should_return_cars_when_parking_boy_fetch_given_two_tickets_from_two_parked_cars   
**GIVEN** parking boy parked two cars and parked them   
**WHEN** fetch the two cars with corresponding tickets   
**THEN** two cars are fetched   
   
should_return_no_car_when_fetch_car_given_wrong_ticket   
**GIVEN** wrong ticket   
**WHEN** fetch a car   
**THEN** no car is fetched   
   
should_return_no_Car_when_fetch_given_no_ticket   
**GIVEN** no ticket   
**WHEN** fetch a car   
**THEN** no car is fetched   
   
should_return_no_car_when_fetched_two_times_given_a_ticket   
**GIVEN** a parking ticket been used   
**WHEN** fetch a car with that ticket   
**THEN** no car is fetched   
   
should_return_no_ticket_when_parking_boy_parked_a_car_given_parking_lot_with_1_capacity.   
**GIVEN** parking lot capacity is 1 and has parked a car   
**WHEN** park a car   
**THEN** park car failed and no ticket is returned.   
   
*========== Story 2 ==========*
should_throw_InvalidParkingTicket_with_message_Unrecognized_parking_ticket_when_parking_boy_parks_a_car_given_wrong_ticket   
**GIVEN** wrong or used ticket   
**WHEN** parking boy parks a car   
**THEN** throw InvalidParkingTicket exception with message "Unrecognized parking ticket"   
   
should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking ticket_when_parking_boy_fetch_a_car_given_wrong_ticket   
**GIVEN** wrong or used ticket   
**WHEN** parking boy fetch a car   
**THEN** throw InvalidParkingTicket exception with message "Please provide your parking ticket"   
   
should_throw_NotEnoughPosition_with_message_Not_enough_position_when_parking_boy_parked_a_car_given_parking_lot_with_one_capacity_and_a_parked_car   
**GIVEN** Parkingboy parked a car in Parking lot with 1 capacity   
**WHEN** parking boy parked a car   
**THEN** throw NotEnoughPosition exception with message "Not enough position"   
   
   
*========== Story 3 ==========*   
should_return_two_parking_lots_when_parking_boy_get_parking_lots_given_two_parking_lots   
**GIVEN** parking boy with 2 parking lots.   
**WHEN** parking boy get parking lot   
**THEN** return 2 parking lots.   
   
should_first_parking_lot_return_parking_ticket_when_parking_boy_parked_two_cars_given_two_parking_lot_where_first_parking_lot_capacity_is_two   
**GIVEN** a car and a parking boy with 2 parking lot where   
- first parking lot (2 capacity)   
- second parking lot (1 capacity),   

**WHEN** parking boy park a car   
**THEN** first parking lot return a ticket, capacity of first parking lot is 2, second parking lot is 0.   
   
should_second_parking_lot_return_parking_ticket_when_parking_boy_parked_a_car_given_two_parking_lot_where_first_parking_lot_is_full   
**GIVEN** a car and a parking boy with 2 parking lot where   
- first parking lot is full (1 capacity)   
- second parking lot (1 capacity) is not,   

**WHEN** parking boy park a car   
**THEN** parking lot 2 return a ticket and available space is 0.   
   
should_third_parking_lot_return_parking_ticket_when_parking_boy_parked_a_car_given_first_and_second_is_full_and_third_parking_lot_is_not   
**GIVEN** a car and a parking boy with 3 parking lot where   
- first parking lot is full (1 capacity)   
- second parking lot is full (1 capacity)   
- third parking lot is not full (1 capacity)   

**WHEN** parking boy park a car   
**THEN** parking lot 3 return a ticket.   
   
should_throw_NotEnoughPosition_with_message_Not_enough_position_when_parking_boy_parked_a_car_given_parking_boy_with_two_full_parking_lot   
**GIVEN** a car and a parking boy with 2 full capacity parking lot   
**WHEN** parking boy park a car   
**THEN** throw NotEnoughPosition exception with message "Not enough position"   
   
should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_parking_boy_parked_a_car_given_two_parking_lots   
**GIVEN** used or wrong ticket and 2 parking lots   
**WHEN** parking boy fetch a car   
**THEN** throw InvalidParkingTicket exception with message "Please provide your parking ticket"   
   
should_fetch_two_right_cars_when_parking_boy_fetch_given_two_parked_cars_and_parking_tickets   
**GIVEN** - 2 parked cars   
**WHEN** a parking boy fetch both cars   
**THEN** return 2 correct cars based on Parking tickets.   
   
*========= Story 4 ==========*
should_return_parking_ticket_when_smart_parking_boy_parks_a_car_given_parking_lot_with_1_capacity   
**GIVEN** Smart Parking boy (Service Manager) with a parking lot with 1 capacity   
**WHEN** super smart parking boy parks the car   
**THEN** first parking lot should have, 1 parked car, and returns a parking ticket   
   
should_return_two_right_car_when_smart_parking_boy_fetch_given_two_parking_lot_with_5_capacity   
**GIVEN**   
 - first parking lot should have, 1 parked car, and returns a parking ticket   
 - second parking lot should have, 1 parked car, and returns a parking ticket   

**WHEN** super smart parking boy parks the car   
**THEN** fetched car 1 and car 2 should not be null   
   
should_throw_NotEnoughPosition_with_message_Not_enough_position_when_smart_parking_boy_parked_a_car_given_parking_boy_with_two_full_parking_lot   
**GIVEN** Super Smart Parking boy (Service Manager) with   
     - a 2 parking lot with 1 capacity and 2 parked car   
**WHEN** super smart parking boy parks the car   
**THEN** throw NotEnoughPosition exception with message "Not enough position"   
   
should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_smart_parking_boy_parked_a_car_given_two_parking_lots_and_null_parking_ticket   
**GIVEN** Super Smart Parking boy (Service Manager) with   
      - used or wrong ticket and 2 parking lots   
      
**WHEN** parking boy fetch a car   
**THEN** throw InvalidParkingTicket exception with message "Please provide your parking ticket"   
   
should_first_parking_lot_have_one_parked_car_when_smart_parking_boy_park_a_car_given_two_parking_lots_with_no_parked_cars   
**GIVEN**   
- Super SmartParking boy with   
     - a parking lot with capacity of 5 with no cars parked   
    - a parking lot with capacity of 5 with no cars parked   
    
**WHEN** smart parking boy parks the car   
**THEN** first parking lot should have, 1 parked car, and returns a parking ticket   
   
should_first_parking_lot_have_two_parked_car_when_smart_parking_boy_park_a_car_given_two_parking_lot_with_five_capacity_and_one_parked_car   
**GIVEN**   
- Super Smart Parking boy with   
     - a parking lot with capacity of 5 with 1 cars parked   
    - a parking lot with capacity of 5 with 1 cars parked   

**WHEN** smart parking boy parks the car   
**THEN** first parking lot should have, 2 parked car, and returns a parking ticket   
   
should_second_parking_have_one_parked_car_when_smart_parking_boy_parks_a_car_given_two_parking_lot_where_first_parking_lot_has_more_parked_car   
**GIVEN**   
- Super Smart Parking boy with   
     - a parking lot with capacity of 5 with 2 cars parked   
    - a parking lot with capacity of 5 with 1 cars parked   
    
**WHEN** smart parking boy parks the car   
**THEN** second parking lot should have, 1 parked car, and returns a parking ticket   

should_throw_InvalidParkingTicket_with_message_Unrecognized_parking_ticket_when_smart_parking_boy_fetched_a_car_given_wrong_parking_ticket   
**GIVEN** Service manager with   
- wrong ticket   
- 1 Parking Boys, with one parking lot with 1 parked car

**WHEN** smart parking boy fetched a car   
**THEN** throw InvalidParkingTicket exception with message "Unrecognized parking ticket"   

*========== Story 5 ==========*   
should_return_parking_ticket_when_super_smart_parking_boy_parks_a_car_given_parking_lot_with_1_capacity   
**GIVEN**   
- Smart Parking boy (Service Manager) with   
     - a parking lot with 1 capacity   
     
**WHEN** super smart parking boy parks the car   
**THEN** first parking lot should have, 1 parked car, and returns a parking ticket   
   
should_throw_NotEnoughPosition_with_message_Not_enough_position_when_super_smart_parking_boy_parked_a_car_given_parking_boy_with_two_full_parking_lot   
**GIVEN** Super Smart Parking boy (Service Manager) with 2 parking lot with 1 capacity and 2 parked car   
**WHEN** super smart parking boy parks the car   
**THEN** throw NotEnoughPosition exception with message "Not enough position"   
   
should_throw_InvalidParkingTicket_with_message_Please_provide_your_parking_ticket_when_super_smart_parking_boy_parked_a_car_given_two_parking_lots   
**GIVEN** Super Smart Parking boy (Service Manager) with   
       - used or wrong ticket and 2 parking lots   
       
**WHEN** parking boy fetch a car   
**THEN** throw InvalidParkingTicket exception with message "Please provide your parking ticket"   
   
should_first_parking_lot_have_11_parked_car_and_return_ticket_when_super_smart_parking_boy_parked_a_car_given_first_parking_lot_with_15_capacity_and_10_car_and_second_parking_lot_with_20_capacity_and_18_parked_car   
**GIVEN** Super Smart Parking boy (Service Manager) with   
    - a first parking lot with capacity of 15 with 10 cars parked (5 available pos) = 0.33   
    - a second parking lot with capacity of 20 with 18 cars parked (2 available pos) = .1   
    
**WHEN** super smart parking boy parks the car   
**THEN**   
 - first parking lot should have, 12 parked car,   
 - second parking lot should have, 16 parked cars   
   
should_first_parking_lot_have_5_parked_car_and_second_parking_lot_have_10_parked_cars_when_super_smart_parking_boy_parked_a_car_given_first_parking_lot_with_10_capacity_and_5_car_and_second_parking_lot_with_20_capacity_and_10_parked_car   
**GIVEN**   
- Super Smart Parking boy (Service Manager) with   
    - a first parking lot with capacity of 10 with 5 cars parked (5 available pos) = 0.5   
    - a second parking lot with capacity of 20 with 10 cars parked (2 available pos) = 0.5   
    
**WHEN** super smart parking boy parks the car   
**THEN**   
 - first parking lot should have, 5 parked car,   
 - second parking lot should have, 10 parked cars   
   
should_first_parking_lot_have_16_parked_car_and_second_parking_lot_have_12_parked_cars__when_super_smart_parking_boy_parked_a_car_given_second_parking_lot_with_15_capacity_and_10_car_and_first_parking_lot_with_20_capacity_and_18_parked_car   
**GIVEN**   
- Super Smart Parking boy (Service Manager) with   
    - a first parking lot with capacity of 20 with 18 cars parked (2 available pos) = .1   
    - a second parking lot with capacity of 15 with 10 cars parked (5 available pos) = 0.33   
    
**WHEN** super smart parking boy parks the car   
**THEN**   
 - first parking lot should have, 16 parked car,   
 - second parking lot should have, 12 parked cars   
   
should_parking_lot_have_15_11_2_parked_cars_when_super_smart_parking_boy_parked_a_car_given_three_parking_lot_with_capacity_20_15_2_and_28_parked_cars   
**GIVEN**   
- Super Smart Parking boy (Service Manager) with   
    - a first parking lot with capacity of 20 with 18 cars parked (2 available pos) = .1   
    - a second parking lot with capacity of 15 with 10 cars parked (5 available pos) = 0.33   
   -  a third parking lot with capacity of 2 with no cars parked (2 available pos) = 1   
   
**WHEN** super smart parking boy parks the car   
**THEN**   
 - first parking lot should have, 15 parked car,   
 - second parking lot should have, 11 parked cars   
 - third parking lot should have, 2 parked cars   

should_throw_InvalidParkingTicket_with_message_Unrecognized_parking_ticket_when_super_smart_parking_boy_fetched_a_car_given_wrong_parking_ticket
**GIVEN** Service manager with   
- wrong ticket   
- 1 Super Smart Parking Boy, with one parking lot with 1 parked car

**WHEN** super smart parking boy fetched a car   
**THEN** throw InvalidParkingTicket exception with message "Unrecognized parking ticket"   
   
*========== Story 6 ==========*   
should_return_cars_when_manager_parking_boy_fetch_given_two_tickets_from_two_parked_cars   
**GIVEN** parking boy parked two cars and parked them   
**WHEN** fetch the two cars with corresponding tickets   
**THEN** two cars are fetched   
   
should_fetch_two_right_cars_when_manager_parking_boy_fetch_given_two_parked_cars_two_parking_lot_and_parking_tickets   
**GIVEN** - 2 parked cars   
**WHEN** a manager parking boy fetch both cars   
**THEN** return 2 correct cars based on Parking tickets.   
   
should_return_three_parking_boys_when_manager_get_list_of_parking_boy_given_3_different_parking_boys_with_parking_lots_1_capacity   
**GIVEN** Service manager with   
      - 3 Parking Boys, and each one has a parking lot with 1 capacity.   
      
**WHEN** manager get list of parking boys   
**THEN** parking boys list has size of 3   
   
should_be_able_to_park_all_cars_in_different_parking_lot_when_manager_delegate_parking_a_car_given_3_different_parking_boys_with_parking_lots_1_capacity   
**GIVEN** Service manager with   
      - 3 Parking Boys, and each one has a parking lot with 1 capacity.   
    
**WHEN** manager delgate parking of car in a parking lot   
**THEN** all parking lots manage by different parking boy should have 1 parked car   
   
should_throw_NotEnoughPosition_with_message_Not_enough_position_when_service_manager_delegate_parking_boy_to_parked_a_car_given_parking_boy_with_two_full_parking_lot   
**GIVEN** Service manager with   
      - 3 Parking Boys, and each one has a full parking lot with 1 capacity.   
      
**WHEN** manager delegate parking of car to first parking lot   
**THEN** throw NotEnoughPosition exception with message "Not enough position"   
   
should_throw_InvalidParkingTicket_with_message_Please provide your parking ticket_when_service_manager_delegate_fetch_parking_boy_to_parked_a_car_given_invalid_parking_ticket   
**GIVEN** Service manager with   
      - no ticket   
      - 3 Parking Boys, and each one has a full parking lot with 1 capacity.  
      
**WHEN** manager delegate fetching of car   
**THEN** throw InvalidParkingTicket exception with message "Please provide your parking ticket"   
   
should_throw_InvalidParkingTicket_with_message_Unrecognized_parking_ticket_when_service_manager_delegate_fetch_parking_boy_to_parked_a_car_given_wrong_parking_ticket   
**GIVEN** Service manager with   
- wrong ticket   
- 3 Parking Boys, and each one has a full parking lot with 1 capacity.      

**WHEN** manager delegate fetching of car   
**THEN** throw InvalidParkingTicket exception with message "Unrecognized parking ticket"   