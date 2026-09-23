public class CarWash extends WashService {
    public CarWash(String id_car, int days_car){
        super(id_car, days_car);
        if (days_car <= 0) throw new IllegalArgumentException("Jumlah hari tidak boleh 0 atau negatif!");
    }

    @Override 
    public int calculateCharge(){
        int days = getDays();
        int car_wash;
        if (days <= 3){
            car_wash = (days * 35000) + 15000;
        }
        else{
            car_wash = ((3 * 35000) + ((days - 3) * 25000)) + 15000;
        }
        return car_wash;
    }

    @Override 
    public String label(){
        return "Car";
    }
}
