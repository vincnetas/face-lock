package lt.vin.face;

import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.sarxos.webcam.Webcam;

@SpringBootApplication
public class FaceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
	}
}
