package bdoo;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploNeodatis {
	public static void main(String[] args) {
		Paises p1 = new Paises(1,"Adorra");
		Paises p2 = new Paises(2,"España");
		Jugadores j1 = new Jugadores("Maria", "voleibol",p1, "Madrid", 14); // Crear instancias para almacenar en BD
		Jugadores j2 = new Jugadores("Miguel", "tenis",p2, "Madrid", 15);
		Jugadores j3 = new Jugadores("Mario", "baloncesto",p1, "Guadalajara", 15);
		Jugadores j4 = new Jugadores("Alicia", "tenis",p2, "Madrid", 14);
		ODB odb = ODBFactory.open("equipos.db"); // Abrir BD
		odb.store(j1); // Almacenamos objetos
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		odb.store(p1);
		odb.store(p2);

		Objects<Jugadores> objects = odb.getObjects(Jugadores.class); //recuperamos todos los objetos
		System.out.printf("%d Jugadores: %n", objects.size());
		int i = 1;

		while (objects.hasNext()){ // visualizar los objetos
			Jugadores jug = objects.next();
			System.out.printf("%d: %s,%s, %s, %s, %d%n",
					i++, jug.getNombre(), jug.getDeporte(),jug.getPais().toString(),
					jug.getCiudad(), jug.getEdad());
		}
		odb.close(); // Cerrar BD
	}
}