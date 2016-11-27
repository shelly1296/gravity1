package org.shelbourne.adam.gravity1;

/**
 * Hello world!
 *
 */
public class GravityApp 
{
    public static void main( String[] args )
    {
      GravityScanner gs = new GravityScanner();
      ScannerDto scannerDto = gs.getFromScanner(false);
    }
}
