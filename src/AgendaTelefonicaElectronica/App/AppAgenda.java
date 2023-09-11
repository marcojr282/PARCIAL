package AgendaTelefonicaElectronica.App;

import AgendaTelefonicaElectronica.Dominio.AgendaTelefonica;

public class AppAgenda {
    public static void main(String[] args) {
        // Crear una instancia de la clase Agenda
        AgendaTelefonica Agenda = new AgendaTelefonica();

        // Crear varios contactos en la agenda
        Agenda.crearContacto("Palomo", "Palomo", 666);
        Agenda.crearContacto("Juan", "Garcia", 310);
        Agenda.crearContacto("Marco", "Zapata", 312);
        Agenda.crearContacto("Simon", "Cardenas", 311);
        Agenda.crearContacto("Ciro", "Ciro", 58);

        // Mostrar la lista de contactos en la agenda
        Agenda.mostrarlistaContacto(Agenda.getContactos());

        // Eliminar un contacto con el número de celular 444 (que no existe)
        Agenda.eliminarContacto(444);

        // Buscar contactos por nombre (buscar "Marco")
        Agenda.buscarPorNombre("Camilo");

        // Buscar contactos por apellido (buscar "Ciro")
        Agenda.buscarPorApellido("Ciro");

        // Buscar un contacto por número de celular (buscar 310)
        Agenda.buscarPorNumero(310);

        // Cambiar el número de celular de un contacto con el número de celular 58 a 500
        Agenda.cambiarNumero(58, 500);

        // Mostrar la lista de contactos después de los cambios
        Agenda.mostrarlistaContacto(Agenda.getContactos());

        System.out.println("");

        // Mostrar la lista de contactos ordenados alfabéticamente
        Agenda.mostrarlistaContacto(Agenda.ordenarAlfabeticamente());
    }
}