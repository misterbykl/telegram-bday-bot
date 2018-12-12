package misterbykl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Main.java
 * <p>
 * <b>created at</b> 12 Ara 2018 17 01
 *
 * @author misterbykl
 * @since 1.1.0
 */
@SpringBootApplication
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     *
     *             <b>created at</b> 12 Ara 2018 17 06
     * @author emreb
     * @since 1.1.0
     */
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    /**
     *             <b>created at</b> 12 Ara 2018 17 06
     * @author emreb
     * @since 1.1.0
     */
    @Bean
    public TelegramOperations telegramOperations() {
        return new TelegramOperations();
    }
}
