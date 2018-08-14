package lt.vin.face;

import java.util.Arrays;
import java.util.List;

import com.github.sarxos.webcam.WebcamDevice;
import com.github.sarxos.webcam.WebcamDriver;

public class RpiDriver implements WebcamDriver {

	private static final WebcamDevice webcam = new RpiWebcam();
	@Override
	public List<WebcamDevice> getDevices() {
		return Arrays.asList(webcam);
	}

	@Override
	public boolean isThreadSafe() {
		return false;
	}

}
