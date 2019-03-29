import java.time.LocalDate;
import java.util.List;

public class Venta {
    public double total;
    public List<Item> items;
    public LocalDate fecha;

    Venta(List<Item> _items, LocalDate _fecha){
        this.items = _items;
        this.fecha = _fecha;
    }

    public double importe() {
        total = items.stream().mapToDouble(item -> item.importe()).sum();
        return total;
    }

    public Boolean esDeFecha(LocalDate unaFecha){
        if(fecha.isEqual(unaFecha)){
            return true;//fecha == unaFecha;
        }
        else{
            return false;
        }

    }
}


