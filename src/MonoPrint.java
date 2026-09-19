public class MonoPrint extends PrintJob{
    public MonoPrint(String id_mono, int pages_mono){
        super(id_mono, pages_mono);
        if(pages_mono <= 0) throw new IllegalArgumentException("Jumlah halaman tidak boleh 0 atau negatif!");
    }

    @Override
    public int calculateCharge(){
        return getPages() * 500;
    }

    @Override
    public String label(){
        return "Mono";
    }
}
