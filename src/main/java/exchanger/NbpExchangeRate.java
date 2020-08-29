package exchanger;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

public class NbpExchangeRate {

    private String no;
    private XMLGregorianCalendar effectiveDate;
    private BigDecimal mid;

    public String getNo() {
        return no;
    }

    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }
}
