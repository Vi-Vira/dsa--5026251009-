public abstract class PrintJob implements Chargeable{
    private String id;
    private int pages;

    protected PrintJob (String id_print, int pages_print){
        if(pages_print <= 0) throw new IllegalArgumentException("Jumlah halaman tidak boleh 0 atau negatif!");
        this.id = id_print;
        this.pages = pages_print;
    }

    public String getId(){
        return id;
    }
    
    public int getPages(){
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies){
        if(copies <= 0) throw new IllegalArgumentException("Jumlah copies tidak boleh 0 atau negatif!");
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}