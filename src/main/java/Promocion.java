public class Promocion implements EstadoPrenda{

    private double valorFijo;

    Promocion(double _valorFijo){
        this.valorFijo = _valorFijo;
    }


    public void setValorFijo(double valor){
        valorFijo = valor;
    }

    public double precioFinal(double precioOriginal){
        return precioOriginal - valorFijo;
    }

}