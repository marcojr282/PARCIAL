package AgendaTelefonicaElectronica.Dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AgendaTelefonica {
    private List<Contacto> contactos;
    public static final int CAPACIDAD_AGENDA = 50;

    public AgendaTelefonica() {
        this.contactos = new ArrayList<>();
    }

    public void crearContacto(String nombre, String apellido, long numero){
        Contacto contac = (Contacto) this.buscarPorNumero(numero);
        if (this.contactos.size() < CAPACIDAD_AGENDA && contac == null){
            Contacto contactoAAgregar = new Contacto(nombre, apellido, numero);
            this.contactos.add(contactoAAgregar);

        }else{
            System.out.println("");
            System.out.println("El contacto no pudo ser creado");
        }
    }
    public boolean eliminarContacto(long numero){
        Contacto contactoExistente = (Contacto) this.buscarPorNumero(numero);
        if (contactoExistente != null){
            this.contactos.remove(contactoExistente);
            mostrarlistaContacto(contactos);
            return true;
        }
        System.out.println("");
        System.out.println("El contacto no existe");
        return false;

    }

    public List<Contacto> buscarPorNombre(String nombreABuscar){
        List<Contacto> contactosPorNombre = new ArrayList<>();
        for (Contacto contacto : this.contactos){
            if(contacto.getNombre().equalsIgnoreCase(nombreABuscar)){
                contactosPorNombre.add(contacto);
                System.out.println("");
                System.out.println("Contacto encontrado: ");
                mostrarlistaContacto(contactosPorNombre);

            }

        }
        return contactosPorNombre;
    }

    

    public List<Contacto> buscarPorApellido(String apellidoABuscar){
        List<Contacto> contactosPorApellido = new ArrayList<>();
        for (Contacto contacto : this.contactos) {
            if (contacto.getApellido().equalsIgnoreCase(apellidoABuscar)) {
                contactosPorApellido.add(contacto);
                System.out.println("");
                System.out.println("Contacto Encontrado");
                mostrarlistaContacto(contactosPorApellido);
            }

        }
        return contactosPorApellido;
    }
    public Contacto buscarPorNumero(long numeroABuscar) {
        List<Contacto> contactoNumeroABuscar = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getNumero() == numeroABuscar) {
                contactoNumeroABuscar.add(contacto);

                return contacto;
            }
        }
        mostrarlistaContacto(contactoNumeroABuscar); // Muestra los contactos encontrados (o no encontrados).
        return null;
    }
    public void cambiarNumero(long numeroActual, long nuevoNumero) {
        Contacto contactoExistente = this.buscarPorNumero(numeroActual);

        if (contactoExistente != null) {
            contactoExistente.numero = nuevoNumero; // Cambia el número de celular del contacto.
            System.out.println("");
            System.out.println("Numero cambiado con éxito ");
        }
    }


    public List<Contacto> ordenarAlfabeticamente( ){
        this.contactos.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        return this.contactos;

    }
    public void mostrarlistaContacto(List<Contacto> list) {
        for (Contacto c : list) {
            System.out.println("   Nombre: " + c.getNombre() + "  Apellido: " + c.getApellido() + "  Celular: " + c.getNumero());
        }
    }

    public List<Contacto> getContactos() {
        return contactos;
    }


}

