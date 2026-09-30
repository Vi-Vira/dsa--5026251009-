public class MotorcycleWash extends  WashService{
    public MotorcycleWash(String id_motorcycle, int days_motorcycle, int units_motorcycle){
        super(id_motorcycle, days_motorcycle, units_motorcycle);
        if (days_motorcycle <= 0) throw new IllegalArgumentException("Jumlah hari tidak boleh 0 atau negatif!");
        if (units_motorcycle <= 0) throw new IllegalArgumentException("Jumlah unit tidak boleh 0 atau negatif!");
    }

    @Override 
    public int calculateCharge(){
        return (getDays() * 15000) + 5000;
    }

    @Override 
    public String label(){
        return "Motorcycle";
    }
}
