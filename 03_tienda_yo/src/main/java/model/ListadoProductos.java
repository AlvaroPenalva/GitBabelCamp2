package model;

import java.util.ArrayList;
import java.util.List;

public class ListadoProductos {

	static ArrayList<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentaci�n",8.4,25),
			new Producto("leche","alimentaci�n",1.2,70),
			new Producto("cable usb","inform�tica",5.6,30),
			new Producto("arroz","alimentaci�n",3.1,16),
			new Producto("silla","hogar",30.6,10),
			new Producto("monitor","inform�tica",125.0,5),
			new Producto("escritorio","hogar",230,4)
			));

}