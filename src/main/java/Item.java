public class Item {
    private int cantidad;
    private Prenda prenda;

    Item(int _cantidad, Prenda _prenda){
        this.cantidad = _cantidad;
        this.prenda = _prenda;
    }

    public double importe(){
        return prenda.precio()*cantidad;
    }
}
