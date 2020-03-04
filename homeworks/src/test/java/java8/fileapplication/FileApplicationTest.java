package java8.fileapplication;

import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileApplicationTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void convertInputToOutput() throws IOException {

        final File tempFileInput = tempFolder.newFile("testInput.csv");
        try(PrintWriter printWriter = new PrintWriter(tempFileInput)){
            printWriter.write("Rogerio,Pittaway,17/07/1989\n" +
                    "Chickie,Gleder,24/05/1991\n" +
                    "Wilbur,Goodhall,30/08/1987\n" +
                    "Adriena,Skedge,06/12/1990\n" +
                    "Cosmo,Weson,08/11/1993\n" +
                    "Stearne,Grzeskowski,29/10/2002\n" +
                    "Reed,Mauvin,06/12/1987\n" +
                    "Desdemona,Hartfleet,22/03/2001\n" +
                    "Alis,Goodhew,27/06/1992\n" +
                    "Clemmy,Bilt,28/10/1995\n" +
                    "Ryon,Joddens,21/12/1993\n" +
                    "Meggi,Stilwell,18/11/1991\n" +
                    "Hersh,Derricoat,21/05/1997\n" +
                    "Webb,Gruszecki,18/01/1990\n" +
                    "Truman,Knolles-Green,24/12/2003\n" +
                    "Becki,Mably,23/01/1992\n" +
                    "Janek,Pluthero,21/03/1990\n" +
                    "Boonie,Heyworth,22/05/2000\n" +
                    "Ayn,Chasemoore,12/12/1993\n" +
                    "Meggi,Grenfell,11/06/1993\n" +
                    "Athena,McElmurray,02/05/2001\n" +
                    "Trudey,Rudsdell,06/11/2001\n" +
                    "Drugi,Farries,06/07/1997\n" +
                    "Paula,Keavy,18/02/1991\n" +
                    "Winnie,Paddeley,09/09/1988\n" +
                    "Gage,Hackinge,27/07/1995\n" +
                    "Jany,Hilbourne,15/02/1988\n" +
                    "Jsandye,Mycock,11/06/1998\n" +
                    "Stinky,Gamblin,25/02/1998\n" +
                    "Verine,Spurritt,21/10/1995\n");
        }

        final File tempFileOutput = tempFolder.newFile("testOutput.csv");
        final Reader reader = new FileReader(tempFileInput);
        final Writer writer = new FileWriter(tempFileOutput);

        FileApplication fileApplication = new FileApplication(reader,2,writer);
        fileApplication.convertInputToOutput();

        String output = new String(Files.readAllBytes(Paths.get(String.valueOf(tempFileOutput))));

        assertEquals("Jany,Hilbourne\n" +
                "Paula,Keavy\n" +
                "Stinky,Gamblin\n",output);
    }

}