public class Prenda {
    private String tipo;
    private double precioBase;
    private EstadoPrenda estado;

    Prenda(String _tipo, double _precioBase, EstadoPrenda _estado){
        this.tipo = _tipo;
        this.precioBase = _precioBase;
        this.estado = _estado;
    }

    public double precio(){
        return estado.precioFinal(precioBase);
    }
}
