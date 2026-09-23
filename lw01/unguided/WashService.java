public abstract class WashService implements Billable{
    private String id;
    private int days;

    protected WashService(String id_wash, int days_wash){
        if (days_wash <= 0) throw new IllegalArgumentException("Jumlah hari tidak boleh 0 atau negatif!");
        this.id = id_wash;
        this.days = days_wash;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if (units <= 0) throw new IllegalArgumentException("Jumlah unit tidak boleh 0 atau negatif!");
        return units * calculateCharge();
    };

    public String label(){
        return "Service";
    }

    public String Summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}