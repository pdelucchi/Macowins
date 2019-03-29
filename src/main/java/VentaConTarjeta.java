import java.time.LocalDate;
import java.util.List;

public class VentaConTarjeta extends Venta {
    private float coeficienteTarjeta = 10;
    private float cantidadCuotas;

    VentaConTarjeta(List<Item> _items, LocalDate _fecha, float _cantidadCuotas) {
        super(_items, _fecha);
        cantidadCuotas = _cantidadCuotas;
    }

    public double importe() {
        total = super.importe() + 0.01 * super.importe() + (coeficienteTarjeta * cantidadCuotas) + 0.01;
        return total;
    }

}
