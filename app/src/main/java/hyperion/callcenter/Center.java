package hyperion.callcenter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by savaskoc on 18/09/2016.
 */
public class Center implements Serializable {
    public static final List<Center> LIST = Arrays.asList(
            new Center("https://assets.yapikredi.com.tr/WebSite/_assets/img/Yapikredi_logo.svg", "Yapı Kredi", "444 0 444", "info@yapikredi.com.tr"),
            new Center("https://pos.dogus.edu.tr/Images/Logo/DOGUSUNV.png", "Doğuş Üniversitesi", "444 79 97", "mhb@dogus.edu.tr")
    );

    public String image;
    public String name;
    public String phone;
    public String email;

    public Center(String image, String name, String phone, String email) {
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
