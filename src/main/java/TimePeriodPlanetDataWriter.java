import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class TimePeriodPlanetDataWriter implements PlanetDataWriter {

	private Map<PlanetData, Long> pdLastWrittenMap;
	private long timePeriod;
	private String filename;

	public TimePeriodPlanetDataWriter(Long timePeriod, String filename) {
		this.timePeriod = timePeriod;
		this.filename = filename;
	}

	@Override
	public void print(CelestialBody celestialBody) {
		boolean writeLine = false;
		if (getLastWrittenMap().containsKey(celestialBody.getPlanetData())) {
			Long lastWritten = getLastWrittenMap().get(celestialBody.getPlanetData());
			if (celestialBody.getCurrentTime().getTimeInMillis() - lastWritten > timePeriod) {
				writeLine = true;
			}
		} else {
			writeLine = true;
		}

		if (writeLine) {
			writeLine(celestialBody);
			getLastWrittenMap().put(celestialBody.getPlanetData(), celestialBody.getCurrentTime().getTimeInMillis());
		}

	}

	private void writeLine(CelestialBody celestialBody) {
		Path filePath = getFilePath();
		try {	
			Files.write(filePath, createCelestialBodyLine(celestialBody), StandardOpenOption.APPEND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private byte[] createCelestialBodyLine(CelestialBody cb) throws UnsupportedEncodingException {
		String retStr = cb.toString() + "\n";
		return retStr.getBytes("UTF8");
	}
		
	private Path getFilePath() {
		Path filePath = Paths.get(filename);
		if (!Files.exists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return filePath;
	}

	private Map<PlanetData, Long> getLastWrittenMap() {
		if (pdLastWrittenMap == null) {
			pdLastWrittenMap = new HashMap<>();
		}

		return pdLastWrittenMap;
	}

}
