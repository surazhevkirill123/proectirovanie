package by.bsu.lab2.bisiness;
enum TourType { Relaxation, Excursion, Shopping }
enum IsBurning { Yes, No }
public class Tour {
    private TourType tourType;
    private IsBurning isBurning;
    private String tourOperator;
    private String Customer;
    private String tourStartLocation;
    private String tourFinishLocation;
    private int cost;
    private int tourStartTime;
    private int tourFinishTime;

    public Tour(TourType tourType, IsBurning isBurning, String tourOperator,String Customer,
                String tourStartLocation,String tourFinishLocation,int cost,int tourStartTime,int tourFinishTime) {
        this.tourType = tourType;
        this.isBurning = isBurning;
        this.tourOperator = tourOperator;
        this.Customer = Customer;
        this.tourStartLocation = tourStartLocation;
        this.tourFinishLocation = tourFinishLocation;
        this.cost = cost;
        this.tourStartTime = tourStartTime;
        this.tourFinishTime = tourFinishTime;
    }


    public TourType get_tourType() {
        return tourType;
    }
    public void set_tourType(TourType tourType) {
        this.tourType = tourType;
    }

    public IsBurning get_isBurning() {
        return isBurning;
    }
    public void set_isBurning(IsBurning isBurning) {
        this.isBurning = isBurning;
    }

    public String get_tourOperator() {
        return tourOperator;
    }
    public void set_tourOperator(String tourOperator) {
        this.tourOperator = tourOperator;
    }

    public String get_Customer() {
        return Customer;
    }
    public void set_Customer(String Customer) {
        this.Customer = Customer;
    }

    public String get_tourStartLocation() {
        return tourStartLocation;
    }
    public void set_tourStartLocation(String tourStartLocation) {
        this.tourStartLocation = tourStartLocation;
    }

    public String get_tourFinishLocation() {
        return tourFinishLocation;
    }
    public void set_tourFinishLocation(String tourFinishLocation) {
        this.tourFinishLocation = tourFinishLocation;
    }

    public int get_cost() {
        return cost;
    }
    public void set_cost(int cost) {
        this.cost = cost;
    }

    public int get_tourStartTime() {
        return tourStartTime;
    }
    public void set_tourStartTime(int tourStartTime) {
        this.tourStartTime = tourStartTime;
    }

    public int get_tourFinishTime() {
        return tourFinishTime;
    }
    public void set_tourFinishTime(int tourFinishTime) {
        this.tourFinishTime = tourFinishTime;
    }

    public void show()
    {
        System.out.println("Тип тура: " + this.tourType);
        System.out.println("Тур горящий: " + this.isBurning);
        System.out.println("Туроператор: " + this.tourOperator);

        System.out.println("Заказчик: " + this.Customer);
        System.out.println("Место начала тура: " + this.tourStartLocation);
        System.out.println("Место конца тура: " + this.tourFinishLocation);

        System.out.println("Стоимость: " + this.cost);
        System.out.println("Время начала тура: " + this.tourStartTime);
        System.out.println("Время конца тура: " + this.tourFinishTime);
    }

}
