public class ColourPrint extends PrintJob{
    public ColourPrint(String id_colour, int pages_colour){
        super(id_colour, pages_colour);
        if(pages_colour <= 0) throw new IllegalArgumentException("Jumlah halaman tidak boleh 0 atau negatif!");
    }

    @Override 
    public int calculateCharge(){
        return (Math.min(getPages(), 10) * 1500) + (Math.max(getPages() - 10, 0) * 1000) + 2000; 
    }

    @Override
    public String label(){
        return "Colour";
    }
}
