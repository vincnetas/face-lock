package lt.vin.face;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.github.sarxos.webcam.WebcamDevice;
import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

public class RpiWebcam implements WebcamDevice {

	private final RPiCamera piCamera;
			
	public RpiWebcam() {
		try {
			piCamera = new RPiCamera();
			piCamera.setWidth(640);
			piCamera.setHeight(480);
		} catch (FailedToRunRaspistillException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String getName() {
		return "rpi cam";
	}

	@Override
	public Dimension[] getResolutions() {
		return new Dimension[] {
				new Dimension(640, 480)
		};
	}

	@Override
	public Dimension getResolution() {
		return new Dimension(640, 480);
	}

	@Override
	public void setResolution(Dimension size) {
		// TODO Auto-generated method stub

	}

	@Override
	public BufferedImage getImage() {
		try {
			return piCamera.takeBufferedStill();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOpen() {
		return true;
	}

}
