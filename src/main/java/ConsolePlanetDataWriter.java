
public class ConsolePlanetDataWriter implements PlanetDataWriter {

	@Override
	public void print(CelestialBody celestialBody) {		
		System.out.println(celestialBody.toString());
	}	
}
