package lt.vin.face;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter.ToIplImage;
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
		//Webcam.setDriver(RpiDriver.class);
		Webcam webcam = Webcam.getDefault();
		
		//webcam.setViewSize(new Dimension(3280, 2464));
		webcam.open();
		BufferedImage bim = webcam.getImage();
		ImageIO.write(bim, "PNG", new File("hello-world.png"));
		
		ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
	    Java2DFrameConverter java2dConverter = new Java2DFrameConverter();
	    IplImage iplImage = converter.convert(java2dConverter.convert(bim));

		
	}
}
