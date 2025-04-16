package dominio;
import gui.Home;
import configDB.DatabaseInitializer;

public class Main {

	public static void main(String[] args) {
		DatabaseInitializer.inicializarBaseDeDatos();
		Home.main(args);
	}
}
