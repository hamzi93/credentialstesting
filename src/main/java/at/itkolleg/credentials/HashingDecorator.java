package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

    /**
     * Diese Klasse ist eine konkrete Decorator Klasse und erbt von AExportDecorator.
     * Exportiert das Passwort in einem Hash (sha256).
     *
     * @author (Armin Hamzic)
     * @version ()
     */
public class HashingDecorator extends AExportDecorator{

    /**
     * Erzeugung eines HashingDecorators
     *
     * @param exportCredentials erzeugt ein ExportCredential
     */

    public HashingDecorator(ExportCredentials exportCredentials) {
        super(exportCredentials);
    }

        /**
         * Diese Methode dient zum Hashen von Passwörtern in einer Credentials Liste.
         *
         * @param credentialsList enthält eine Liste an Credentials
         */

    @Override
    public void export(List<Credentials> credentialsList) {
        String sha256hex = "";
        for (Credentials credential: credentialsList) {
            sha256hex = Hashing.sha256()
                    .hashString(credential.getPwd(), StandardCharsets.UTF_8)
                    .toString();
            credential.setPwd(sha256hex);
        }
        super.export(credentialsList);
    }
}
