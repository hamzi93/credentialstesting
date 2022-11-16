package at.itkolleg.credentials;

import java.util.List;

/**
 * Diese abstrakte Klasse enthält ein ExportCredential und ist ein ExportCredential.
 * Sie ist ein Decorator Entwurfsmuster und dekoriert den Export einer Credential Liste.
 *
 * @author (Armin Hamzic)
 * @version (16.11.2022)
 */
public class AExportDecorator implements ExportCredentials{

    private ExportCredentials exportCredentials;

    /**
     * @param exportCredentials erzeugt ein ExportCredential
     */
    public AExportDecorator(ExportCredentials exportCredentials){
        this.exportCredentials = exportCredentials;
    }

    /**
     * Zur Weiterverarbeitung an eine konkrete Klasse gedacht und
     * ruft die export Methode eines ExportCredentials auf.
     *
     * @param credentialsList enthält eine Liste an Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        exportCredentials.export(credentialsList);
    }
}
