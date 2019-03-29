import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class Negocio{
    private double total;
    private List<Venta> ventas;
    private List<Venta> ventasFiltradas;
    private LocalDate fecha;

    Negocio(List<Venta> _ventas){ //LocalDate _fecha){
        this.ventas = _ventas;
        //this.fecha = _fecha;
    }

    public double gananciasDe(LocalDate unDia){
        ventasFiltradas = ventas.stream().filter(venta -> venta.esDeFecha(unDia)).collect(Collectors.toList());
        total = ventasFiltradas.stream().mapToDouble(venta -> venta.importe()).sum();
        return total;
    }

    public double gananciasTotales(){
        total = ventas.stream().mapToDouble(venta -> venta.importe()).sum();
        return total;
    }
}


