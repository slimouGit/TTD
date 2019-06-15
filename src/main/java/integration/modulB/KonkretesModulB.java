package integration.modulB;

import integration.modulA.DatenklasseA;
import integration.modulA.ModulB;

import java.io.*;

public class KonkretesModulB implements ModulB {

//	@Override
	public void save(DatenklasseA datenklasseA) {
		try {
			FileOutputStream fos = new FileOutputStream(createFile(datenklasseA.id));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(datenklasseA);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected File createFile(String fileName) {
		return new File(fileName + ".dat");
	}

//	@Override
	public DatenklasseA load(String id) {
		try {
			FileInputStream fis = new FileInputStream(createFile(id));
			ObjectInputStream ois = new ObjectInputStream(fis);
			DatenklasseA datenklasseA = (DatenklasseA) ois.readObject();
			ois.close();
			return datenklasseA;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

    
}