package lapr.project.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class PositionData implements Comparable<PositionData> {

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                  INFORMATION ABOUT THE POSITION
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * BaseDate Time of the Ship
     */
    private LocalDateTime baseDateTime;
    /**
     * Latitude of the Ship(Position)
     */
    private double latitude;
    /**
     * Longitude of the Ship(Position)
     */
    private double longitude;
    /**
     * Sog of the Ship(Position)
     */
    private double sog;
    /**
     * Cog of the Ship(Position)
     */
    private double cog;
    /**
     * Heading of the Ship(Position)
     */
    private double heading;
    /**
     * Position of the Ship(Position)
     */
    private String position;

    /**
     * Class to transceiver used when sending data
     */
    private String transceiver;

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                          CONSTRUCTOR
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * Contruct of the class PositionDate
     * @param baseDateTime BaseDate Time of the Ship
     * @param latitude Latitude of the Ship(Position)
     * @param longitude Longitude of the Ship(Position)
     * @param sog Sog of the Ship(Position)
     * @param cog Cog of the Ship(Position)
     * @param heading Heading of the Ship(Position)
     * @param position Position of the Ship(Position)
     */
    public PositionData(LocalDateTime baseDateTime, double latitude, double longitude, double sog, double cog, double heading, String position,String transceiver) {
        setBaseDateTime(baseDateTime);
        setLatitude(latitude);
        setLongitude(longitude);
        setSog(sog);
        setCog(cog);
        setHeading(heading);
        setPosition(position);
        setTransceiver(transceiver);
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                          GETS AND SETS
     * -------------------------------------------------------------------------------------------------------------
     */


    /**
     * Returns the baseDatTime of the Ship
     * @return baseDateTime
     */
    public LocalDateTime getBaseDateTime() {
        return baseDateTime;
    }

    /**
     * Set the baseDatTime of the Ship
     * @param baseDateTime
     */
    public void setBaseDateTime(LocalDateTime baseDateTime) {
        this.baseDateTime = baseDateTime;
    }

    /**
     * Returns the Latitude of the Ship
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the Latitude of the Ship
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the Longitude of the Ship
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the Longitude of the Ship
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns the Sog of the Ship
     * @return sog
     */
    public double getSog() {
        return sog;
    }

    /**
     * Sets the Sog of the Ship
     * @param sog
     */
    public void setSog(double sog) {
        this.sog = sog;
    }

    /**
     * Returns the Cog of the Ship
     * @return cog
     */
    public double getCog() {
        return cog;
    }

    /**
     * Sets the Cog of the Ship
     * @param cog
     */
    public void setCog(double cog) {
        this.cog = cog;
    }

    /**
     * Returns the Heading of the Ship
     * @return heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * Sets the Heading of the Ship
     * @param heading
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    /**
     * Returns the position of the Ship
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position of the Ship
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Sets the transceiver class
     * @param transceiver
     */
    public void setTransceiver(String transceiver) {
        this.transceiver = transceiver;
    }

    /**
     * Returns the transceiver class
     * @return transceiver
     */
    public String getTransceiver() {
        return transceiver;
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              EQUALS
     * -------------------------------------------------------------------------------------------------------------
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionData that = (PositionData) o;
        if(Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0  && Objects.equals(baseDateTime, that.baseDateTime)){
            return true;
        }
        return false;
    }


    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              TO STRING
     * -------------------------------------------------------------------------------------------------------------
     */

    @Override
    public String toString() {
        return "PositionData{" +
                "baseDateTime=" + baseDateTime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", sog=" + sog +
                ", cog=" + cog +
                ", heading=" + heading +
                ", position=" + position +
                '}';
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              COMPARE TO
     * -------------------------------------------------------------------------------------------------------------
     */

    @Override
    public int compareTo(PositionData positionData){
        if(this.baseDateTime.compareTo(positionData.baseDateTime) > 0)
            return 1;
        if(this.baseDateTime.compareTo(positionData.baseDateTime) < 0)
            return -1;
        return 0;
    }

}
