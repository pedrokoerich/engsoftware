import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvert {

    public DataConvert() {
    }

    public String filtraData(String data, int mes, int ano) throws ParseException {
        // Realizar filtragem de data pelo String
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataObjeto = formatoData.parse(data);

        SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
        int mesData = Integer.parseInt(formatoMes.format(dataObjeto));

        SimpleDateFormat formatoAno = new SimpleDateFormat("yyyy");
        int anoData = Integer.parseInt(formatoAno.format(dataObjeto));

        if (mesData == mes && anoData == ano) {
            return data;
        } else {
            return "";
        }
    }

}
