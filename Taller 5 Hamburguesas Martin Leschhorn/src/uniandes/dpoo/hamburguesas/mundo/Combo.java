package uniandes.dpoo.hamburguesas.mundo;

import java.util.ArrayList;

/**
 * La clase utilizada para organizar la información de un combo
 */
public class Combo implements Producto
{
    /**
     * Los productos que hacen parte del combo
     */
    private ArrayList<ProductoMenu> itemsCombo;

    /**
     * El descuento que incluye el combo. Es un número entre 0 y 1, donde 0 corresponde a que no hay descuento y 1 corresponde al 100% de descuento
     */
    private double descuento;

    /**
     * El nombre del combo
     */
    private String nombreCombo;

    /**
     * Construye un nuevo combo
     * @param nombre El nombre del combo
     * @param descuento El descuento sobre el valor normal de los productos en el combo
     * @param items Los productos que hacen parte del combo
     */
    public Combo( String nombre, double descuento, ArrayList<ProductoMenu> items )
    {
        this.itemsCombo = new ArrayList<>( items );
        this.nombreCombo = nombre;
        this.descuento = descuento;
    }

    @Override
    public String getNombre( )
    {
        return nombreCombo;
    }

    /**
     * Retorna el precio del combo.
     * 
     * El precio está basado en aplicarle el descuento del combo al valor de cada uno de los productos.
     */
    @Override
    public int getPrecio() {
        int precioSinDescuento = 0;
        for (ProductoMenu producto : itemsCombo) {
            precioSinDescuento += producto.getPrecio();
        }
        int precioConDescuento = (int) (precioSinDescuento * (1 - descuento));
        return precioConDescuento;
    }

    /**
     * Genera el texto que debe aparecer en la factura.
     * 
     * El texto incluye el nombre del combo, su costo y el valor del descuento
     */
    @Override
    public String generarTextoFactura() {
        StringBuffer sb = new StringBuffer();
        sb.append("Combo " + nombreCombo + "\nDescuento: " + descuento + "\n");

        for (ProductoMenu producto : itemsCombo) {
            sb.append("    " + producto.getNombre() + "\n");
        }

        sb.append("            " + getPrecio() + "\n");

        return sb.toString();
    }

}
