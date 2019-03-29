import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacowinsTest {

    private Nueva nueva;

    private Promocion promocion;
    private Liquidacion liquidacion;
    private Prenda prenda1;
    private Prenda prenda2;
    private Prenda prenda3;
    private Prenda prenda4;
    private Prenda prenda5;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Venta venta1;
    private Venta venta2;
    private Venta venta3;
    private Venta venta4;
    private VentaConTarjeta venta5;
    private Negocio negocio;
    private Negocio negocio2;


    @Before
    public void initialize(){

        nueva = new Nueva();
        promocion = new Promocion(200);
        liquidacion = new Liquidacion();
        prenda1 = new Prenda("Saco", 1500, nueva);
        prenda2 = new Prenda("Pantalon", 1000, nueva);
        prenda3 = new Prenda("Camisa", 500, nueva);
        prenda4 = new Prenda("Pantalon", 1000, liquidacion);
        prenda5 = new Prenda("Pantalon", 1000, promocion);

        item1 = new Item(1, prenda1);
        item2 = new Item(2, prenda2);
        item3 = new Item(5, prenda4);
        item4 = new Item(10, prenda5);

        List<Item> listaItems1 = Arrays.asList(item1,item2);
        List<Item> listaItems2 = Arrays.asList(item1,item3);
        List<Item> listaItems3 = Arrays.asList(item1,item3,item4);


        venta1 = new Venta(listaItems1, LocalDate.of(2019,03,28));
        venta2 = new Venta(listaItems1, LocalDate.of(2018,03,14));
        venta3 = new Venta(listaItems2, LocalDate.of(2019,03,28));
        venta4 = new Venta(listaItems3, LocalDate.of(2019,03,28));
        venta5 = new VentaConTarjeta(listaItems1, LocalDate.of(2019,03,28), 3);

        List<Venta> listaVentas = Arrays.asList(venta1,venta2,venta3,venta4,venta5);
        List<Venta> listaVentasVieja = Arrays.asList(venta2);

        negocio = new Negocio(listaVentas);//LocalDate.of(2019,03,28));
        negocio2 = new Negocio(listaVentasVieja);




    }


    @Test
    public void prenda1DevuelveUnPrecioDe1500(){
        Assert.assertEquals(1500,prenda1.precio(),0);
    }

    @Test
    public void prenda4DevuelveUnPrecioDe500(){
        Assert.assertEquals(500,prenda4.precio(),0);
    }

    @Test
    public void prenda5DevuelveUnPrecioDe500(){
        Assert.assertEquals(800,prenda5.precio(),0);
    }

    @Test
    public void importeItem2EsDe2000(){
        Assert.assertEquals(2000,item2.importe(),0);
    }

    @Test
    public void importeItem4EsDe8000(){
        Assert.assertEquals(8000,item4.importe(),0);
    }

    @Test
    public void importeVenta1EsDe3500(){
        Assert.assertEquals(3500,venta1.importe(),0);
    }

    @Test
    public void importeVenta4EsDe10200(){
        Assert.assertEquals(12000,venta4.importe(),0);
    }

    @Test
    public void importeVenta5EsDe10200(){
        Assert.assertEquals(3565.01,venta5.importe(),0);
    }

    @Test
    public void gananciasDeNegocioElDia28Del03Del2019EsDe(){
        Assert.assertEquals(23065.01,negocio.gananciasDe(LocalDate.of(2019,03,28)),0.0001);
    }

    @Test
    public void gananciasTotalesDeNegocio(){
        Assert.assertEquals(26565.01,negocio.gananciasTotales(),0.0001);
    }


    /*
    @Test
    public void cuandoUnPajaroComeDeberiaTenerMasEnergia(){
        int energiaAntesDeComer = pichon.getEnergia();
        pichon.comer();
        Assert.assertTrue(energiaAntesDeComer < pichon.getEnergia());
    }*/
}