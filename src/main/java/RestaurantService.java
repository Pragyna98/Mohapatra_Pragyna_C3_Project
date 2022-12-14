import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        for (Restaurant res : restaurants) {

            boolean checkRestaurantName = res.getName().equals(restaurantName);

            if (checkRestaurantName) {
                return res;
            }

        }
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {

        return restaurants;
    }


    public  int calculateOrder(String restaurantName,List<String> orderedItems) throws restaurantNotFoundException{
            Restaurant res=findRestaurantByName(restaurantName);
            int orderValue=0;
            for(Item item : res.getMenu())
            {
                if(orderedItems.contains(item.getName())) {
                    orderValue += item.getPrice();
                }
            }
            return orderValue;
        }

}
