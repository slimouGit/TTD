package integration;



import integration.modulA.DatenklasseA;
import integration.modulA.ModulA;
import integration.modulB.KonkretesModulB;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    @Test
    public void machWasErzeugtDatei() throws IOException, ClassNotFoundException{
        TempModulB modulB = new TempModulB();
        ModulA modulA = new ModulA(modulB);
        DatenklasseA daten = new DatenklasseA("text", 0, true);

        modulA.machWas(daten);

        DatenklasseA gegeben = loadFile(modulB.tempFile);

        assertEquals(daten.id, gegeben.id);
    }

    private DatenklasseA loadFile(File file) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		DatenklasseA datenklasseA = (DatenklasseA) ois.readObject();
		ois.close();
		return datenklasseA;
    }
    

    private class TempModulB extends KonkretesModulB {
        public File tempFile;

        protected File createFile(String fileName) {
            if(tempFile == null){
                try {
                    this.tempFile = File.createTempFile(fileName,"test");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
			return tempFile;
        }
    }
}